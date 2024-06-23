package kyutae.codetest.kcs.component.loader;

import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
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
        String csvContent = "\"기준_년분기_코드\",\"상권_구분_코드\",\"상권_구분_코드_명\",\"상권_코드\",\"상권_코드_명\",\"서비스_업종_코드\",\"서비스_업종_코드_명\",\"점포_수\",\"유사_업종_점포_수\",\"개업_율\",\"개업_점포_수\",\"폐업_률\",\"폐업_점포_수\",\"프랜차이즈_점포_수\"\n" +
                "\"20231\",\"U\",\"관광특구\",\"3001491\",\"이태원 관광특구\",\"CS100001\",\"한식음식점\",\"165\",\"171\",\"4\",\"6\",\"4\",\"7\",\"6\"\n" +
                "\"20231\",\"U\",\"관광특구\",\"3001491\",\"이태원 관광특구\",\"CS100002\",\"중식음식점\",\"18\",\"18\",\"6\",\"1\",\"6\",\"1\",\"0\"";
        File tempFile = createTempFile(csvContent);

        // When
        List<LoaderTrdarDto> records = csvFileLoader.loadFile(tempFile.getAbsolutePath(), LoaderTrdarDto.class);

        // Then
        assertEquals(2, records.size());
        assertEquals("20231", records.get(0).getStdrYyquCd());
        assertEquals("3001491", records.get(0).getTrdarCd());
        assertEquals("한식음식점", records.get(0).getSvcIndutyCdNm());

        assertEquals("20231", records.get(1).getStdrYyquCd());
        assertEquals("3001491", records.get(1).getTrdarCd());
        assertEquals("중식음식점", records.get(1).getSvcIndutyCdNm());
    }

    @Test
    void loadFile_WithSpecifiedCharset_ShouldLoadRecordsSuccessfully() throws Exception {
        // Given
        Charset euckr = Charset.forName("EUC-KR");
        String csvContent = "\"기준_년분기_코드\",\"상권_구분_코드\",\"상권_구분_코드_명\",\"상권_코드\",\"상권_코드_명\",\"서비스_업종_코드\",\"서비스_업종_코드_명\",\"점포_수\",\"유사_업종_점포_수\",\"개업_율\",\"개업_점포_수\",\"폐업_률\",\"폐업_점포_수\",\"프랜차이즈_점포_수\"\n" +
                "\"20231\",\"U\",\"관광특구\",\"3001491\",\"이태원 관광특구\",\"CS100001\",\"한식음식점\",\"165\",\"171\",\"4\",\"6\",\"4\",\"7\",\"6\"\n" +
                "\"20231\",\"U\",\"관광특구\",\"3001491\",\"이태원 관광특구\",\"CS100002\",\"중식음식점\",\"18\",\"18\",\"6\",\"1\",\"6\",\"1\",\"0\"";
        File tempFile = createTempFileAsEucKr(csvContent);

        // When
        List<LoaderTrdarDto> records = csvFileLoader.loadFile(tempFile.getAbsolutePath(), euckr, LoaderTrdarDto.class);

        // Then
        assertEquals(2, records.size());
        assertEquals("20231", records.get(0).getStdrYyquCd());
        assertEquals("3001491", records.get(0).getTrdarCd());
        assertEquals("한식음식점", records.get(0).getSvcIndutyCdNm());

        assertEquals("20231", records.get(1).getStdrYyquCd());
        assertEquals("3001491", records.get(1).getTrdarCd());
        assertEquals("중식음식점", records.get(1).getSvcIndutyCdNm());
    }

    @Test
    void loadFile_WithNonExistentFile_ShouldThrowException() {
        // Given
        String nonExistentFilePath = tempDir.resolve("nonexistent.csv").toString();

        // When & Then
        assertThrows(Exception.class, () -> csvFileLoader.loadFile(nonExistentFilePath, LoaderTrdarDto.class));
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