package kyutae.codetest.kcs.component;

import kyutae.codetest.kcs.component.loader.FileLoader;
import kyutae.codetest.kcs.service.DataImportService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class DataLoaderRunner {

    private final DataImportService dataImportService;
    private final FileLoader fileLoader;
    private String dataPath;
    private String charSet;
    private Boolean enable;

    public DataLoaderRunner(
            DataImportService dataImportService,
            FileLoader fileLoader,
            @Value("${kcs.data.path}")String dataPath,
            @Value("${kcs.data.charset}")String charSet,
            @Value("${kcs.data.load-enabled}")Boolean enable
    ) {
        this.dataImportService = dataImportService;
        this.fileLoader = fileLoader;
        this.dataPath = dataPath;
        this.charSet = charSet;
        this.enable = enable;
    }


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void executeFileLoader() throws IOException {
        if (enable)
            executeFileLoader(dataPath, charSet);
    }

    @Transactional
    public void executeFileLoader(String dataPath, String charSet) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(dataPath);
        Charset euckr = Charset.forName(charSet);

        if (resources.length == 0) {
            throw new RuntimeException("No files found in the data directory.");
        }

        for (Resource resource : resources) {
            try {
                var allRecords = fileLoader.loadFile(resource.getFile().getPath(), euckr);
                dataImportService.importData(allRecords);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error occurred while loading file: " + resource.getFilename());
            }
        }
    }
}