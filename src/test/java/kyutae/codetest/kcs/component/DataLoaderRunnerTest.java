package kyutae.codetest.kcs.component;

import kyutae.codetest.kcs.component.loader.FileLoader;
import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
import kyutae.codetest.kcs.service.ImportTrdarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataLoaderRunnerTest {

    @Mock
    private ImportTrdarService importTrdarService;
    @Mock
    private FileLoader fileLoader;

    @InjectMocks
    private DataLoaderRunner dataLoaderRunner;

    @Test
    void executeTrdarFileLoader_ShouldLoadAndImportDataSuccessfully() throws Exception {
        // Given
        String dataPath = "classpath:data/trdar/*.csv";
        List<LoaderTrdarDto> records = new ArrayList<>();
        records.add(new LoaderTrdarDto());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(dataPath);

        when(fileLoader.loadFile(any(), eq(StandardCharsets.UTF_8), eq(LoaderTrdarDto.class))).thenReturn(records);

        // When
        dataLoaderRunner.executeTrdarFileLoader(dataPath, "utf-8");

        // Then
        verify(importTrdarService, times(resources.length)).importData(records);
    }

    @Test
    void executeTrdarFileLoader_NotExistedDirectory_ThrowsFileNotFoundException() throws Exception {
        // Given
        String dataPath = "classpath:data2/*.csv";
        List<Map<String, String>> records = new ArrayList<>();
        records.add(Map.of("key", "value"));

        // When Then
        assertThrows(FileNotFoundException.class, () -> dataLoaderRunner.executeTrdarFileLoader(dataPath, "utf-8"));
        verify(importTrdarService, never()).importData(any());
    }
}