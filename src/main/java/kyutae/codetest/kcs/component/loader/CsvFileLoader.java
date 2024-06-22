package kyutae.codetest.kcs.component.loader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsvFileLoader implements FileLoader {

    @Override
    public List<Map<String, String>> loadFile(String filePath) throws Exception {
        return loadFile(filePath, StandardCharsets.UTF_8);
    }
    @Override
    public List<Map<String, String>> loadFile(String filePath, Charset charset) throws Exception {
        File file = new File(filePath);

        List<Map<String, String>> allRecords = new ArrayList<>();

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
                allRecords.add(recordToMap(record));
            }
        }
        System.out.println("Loaded file: " + filePath + " with " + allRecords.size() + " records.");
        return allRecords;
    }

    private Map<String, String> recordToMap(CSVRecord record) {
        Map<String, String> map = new HashMap<>();
        for (String header : record.toMap().keySet()) {
            map.put(header, record.get(header));
        }
        return map;
    }
}