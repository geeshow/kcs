package kyutae.codetest.kcs.component.loader;

import kyutae.codetest.kcs.component.loader.dto.LoaderInterface;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvFileLoader implements FileLoader {

    @Override
    public <T extends LoaderInterface> List<T> loadFile(String filePath, Class<T> clazz) throws Exception {
        return loadFile(filePath, StandardCharsets.UTF_8, clazz);
    }
    @Override
    public <T extends LoaderInterface> List<T> loadFile(String filePath, Charset charset, Class<T> clazz) throws Exception {
        File file = new File(filePath);
        List<T> allRecords = new ArrayList<>();

        // try-with-resources 구문을 사용하여 자원을 자동으로 해제합니다.
        try (
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, charset));
            CSVParser csvParser = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build()
                .parse(reader)) {

            for (CSVRecord record : csvParser) {
                T dto = clazz.getDeclaredConstructor().newInstance();
                dto.mapFromCsvRecord(record);
                allRecords.add(dto);
            }
        }
        System.out.println("Importing file: " + filePath + " with " + allRecords.size() + " records.");
        return allRecords;
    }
}