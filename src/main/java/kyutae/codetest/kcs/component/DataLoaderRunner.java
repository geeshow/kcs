package kyutae.codetest.kcs.component;

import kyutae.codetest.kcs.component.loader.FileLoader;
import kyutae.codetest.kcs.component.loader.dto.LoaderInterface;
import kyutae.codetest.kcs.component.loader.dto.LoaderSalesDto;
import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
import kyutae.codetest.kcs.service.ImportSalesService;
import kyutae.codetest.kcs.service.ImportTrdarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DataLoaderRunner {

    private final ImportTrdarService importTrdarService;
    private final ImportSalesService importSalesService;
    private final FileLoader fileLoader;
    private String trdarDataPath;
    private String trdarCharSet;
    private String saleDataPath;
    private String trselCharSet;
    private Boolean enable;

    public DataLoaderRunner(
            ImportTrdarService importTrdarService,
            ImportSalesService importSalesService,
            FileLoader fileLoader,
            @Value("${kcs.data.trdar.path}")String trdarDataPath,
            @Value("${kcs.data.trdar.charset}")String trdarCharSet,
            @Value("${kcs.data.trsel.path}")String saleDataPath,
            @Value("${kcs.data.trsel.charset}")String trselCharSet,
            @Value("${kcs.data.load-enabled}")Boolean enable
    ) {
        this.importTrdarService = importTrdarService;
        this.importSalesService = importSalesService;
        this.fileLoader = fileLoader;
        this.trdarDataPath = trdarDataPath;
        this.trdarCharSet = trdarCharSet;
        this.saleDataPath = saleDataPath;
        this.trselCharSet = trselCharSet;
        this.enable = enable;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void executeTrdarFileLoader() throws IOException {
        if (!enable) {
            System.out.println("Data load is disabled");
            return;
        }

        System.out.println("Data load를 시작합니다.");

        // 서울시 상권분석서비스(추정매출-상권배후지) 데이터 로드
        executeSalesFileLoader(saleDataPath, trselCharSet);

        // 서울시 상권분석서비스(점포-상권) 데이터 로드
        executeTrdarFileLoader(trdarDataPath, trdarCharSet);
    }

    public void executeTrdarFileLoader(String dataPath, String charSet) throws IOException {
        Stream<List<LoaderTrdarDto>> listOfResource = getListOfResource(dataPath, charSet, LoaderTrdarDto.class);
        listOfResource.forEach(importTrdarService::importData);
    }

    public void executeSalesFileLoader(String dataPath, String charSet) throws IOException {
        Stream<List<LoaderSalesDto>> listOfResource = getListOfResource(dataPath, charSet, LoaderSalesDto.class);
        listOfResource.forEach(importSalesService::importData);
    }

    private <T extends LoaderInterface> Stream<List<T>> getListOfResource(String dataPath, String charSet, Class<T> clazz) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(dataPath);

        return Arrays.stream(resources).map(resource -> {
            try {
                System.out.println(resource.getFilename()+ " 파일을 로드합니다.");
                return fileLoader.loadFile(
                        resource.getInputStream(),
                        Charset.forName(charSet),
                        clazz
                );
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}