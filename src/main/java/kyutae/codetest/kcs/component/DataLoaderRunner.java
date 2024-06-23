package kyutae.codetest.kcs.component;

import kyutae.codetest.kcs.component.loader.FileLoader;
import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
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
    private String trdarDataPath;
    private String trdarCharSet;
    private String trselDataPath;
    private String trselCharSet;
    private Boolean enable;

    public DataLoaderRunner(
            DataImportService dataImportService,
            FileLoader fileLoader,
            @Value("${kcs.data.trdar.path}")String trdarDataPath,
            @Value("${kcs.data.trdar.charset}")String trdarCharSet,
            @Value("${kcs.data.trsel.path}")String trselDataPath,
            @Value("${kcs.data.trsel.charset}")String trselCharSet,
            @Value("${kcs.data.load-enabled}")Boolean enable
    ) {
        this.dataImportService = dataImportService;
        this.fileLoader = fileLoader;
        this.trdarDataPath = trdarDataPath;
        this.trdarCharSet = trdarCharSet;
        this.trselDataPath = trselDataPath;
        this.trselCharSet = trselCharSet;
        this.enable = enable;
    }


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void executeFileLoader() throws IOException {
        // 서울시 상권분석서비스(점포-상권) 데이터 로드
        if (enable)
            executeFileLoader(trdarDataPath, trdarCharSet);
        // 서울시 상권분석서비스(추정매출-서울시) 데이터 로드
        if (enable)
            executeFileLoader(trselDataPath, trselCharSet);
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
                var allRecords = fileLoader.loadFile(resource.getFile().getPath(), euckr, LoaderTrdarDto.class);
                dataImportService.importData(allRecords);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error occurred while loading file: " + resource.getFilename());
            }
        }
    }
}