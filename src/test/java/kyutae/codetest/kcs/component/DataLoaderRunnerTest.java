package kyutae.codetest.kcs.component;

import kyutae.codetest.kcs.component.loader.FileLoader;
import kyutae.codetest.kcs.service.DataImportService;
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
    private DataImportService dataImportService;
    @Mock
    private FileLoader fileLoader;

    @InjectMocks
    private DataLoaderRunner dataLoaderRunner;

    @Test
    void executeFileLoader_ShouldLoadAndImportDataSuccessfully() throws Exception {
        // Given
        String dataPath = "classpath:data/*.csv";
        List<Map<String, String>> records = new ArrayList<>();
        records.add(Map.of("key", "value"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(dataPath);

        when(fileLoader.loadFile(any(), eq(StandardCharsets.UTF_8))).thenReturn(records);

        // When
        dataLoaderRunner.executeFileLoader(dataPath, "utf-8");

        // Then
        verify(dataImportService, times(resources.length)).importData(records);
    }

    @Test
    void executeFileLoader_NotExistedDirectory_ThrowsFileNotFoundException() throws Exception {
        // Given
        String dataPath = "classpath:data2/*.csv";
        List<Map<String, String>> records = new ArrayList<>();
        records.add(Map.of("key", "value"));

        // When Then
        assertThrows(FileNotFoundException.class, () -> dataLoaderRunner.executeFileLoader(dataPath, "utf-8"));
        verify(dataImportService, never()).importData(any());
    }
    @Test
    void executeFileLoader_NotExistedFile_ThrowsRuntimeException() throws Exception {
        // Given
        String dataPath = "classpath:data/*.txt";
        List<Map<String, String>> records = new ArrayList<>();
        records.add(Map.of("key", "value"));

        // When Then
        assertThrows(RuntimeException.class, () -> dataLoaderRunner.executeFileLoader(dataPath, "utf-8"));
        verify(dataImportService, never()).importData(any());
    }
}