package kyutae.codetest.kcs.component.loader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileLoaderTest {

    private CsvFileLoader csvFileLoader;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        csvFileLoader = new CsvFileLoader();
    }

    @Test
    void loadFile_WithDefaultCharset_ShouldLoadRecordsSuccessfully() throws Exception {
        // Given
        String csvContent = "header1,header2\nvalue1,value2\nvalue3,value4";
        File tempFile = createTempFile(csvContent);

        // When
        List<Map<String, String>> records = csvFileLoader.loadFile(tempFile.getAbsolutePath());

        // Then
        assertEquals(2, records.size());
        assertEquals("value1", records.get(0).get("header1"));
        assertEquals("value2", records.get(0).get("header2"));
        assertEquals("value3", records.get(1).get("header1"));
        assertEquals("value4", records.get(1).get("header2"));
    }

    @Test
    void loadFile_WithSpecifiedCharset_ShouldLoadRecordsSuccessfully() throws Exception {
        // Given
        Charset euckr = Charset.forName("EUC-KR");
        String csvContent = "헤더1,헤더2\n값1,값2\n값3,값4";
        File tempFile = createTempFileAsEucKr(csvContent);

        // When
        List<Map<String, String>> records = csvFileLoader.loadFile(tempFile.getAbsolutePath(), euckr);

        // Then
        assertEquals(2, records.size());
        assertEquals("값1", records.get(0).get("헤더1"));
        assertEquals("값2", records.get(0).get("헤더2"));
        assertEquals("값3", records.get(1).get("헤더1"));
        assertEquals("값4", records.get(1).get("헤더2"));
    }

    @Test
    void loadFile_WithNonExistentFile_ShouldThrowException() {
        // Given
        String nonExistentFilePath = tempDir.resolve("nonexistent.csv").toString();

        // When & Then
        assertThrows(Exception.class, () -> csvFileLoader.loadFile(nonExistentFilePath));
    }

    private File createTempFile(String content) throws IOException {
        File tempFile = File.createTempFile("test", ".csv", tempDir.toFile());
        Files.write(tempFile.toPath(), content.getBytes(StandardCharsets.UTF_8));
        return tempFile;
    }

    private File createTempFileAsEucKr(String content) throws IOException {
        Charset euckr = Charset.forName("EUC-KR");
        File tempFile = File.createTempFile("test", ".csv", tempDir.toFile());
        Files.write(tempFile.toPath(), content.getBytes(euckr));
        return tempFile;
    }
}