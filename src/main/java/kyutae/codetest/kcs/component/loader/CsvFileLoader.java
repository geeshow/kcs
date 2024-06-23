package kyutae.codetest.kcs.component.loader;

import kyutae.codetest.kcs.component.loader.dto.LoaderInterface;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvFileLoader implements FileLoader {

    @Override
    public <T extends LoaderInterface> List<T> loadFile(InputStream inputStream, Class<T> clazz) throws Exception {
        return loadFile(inputStream, StandardCharsets.UTF_8, clazz);
    }
    @Override
    public <T extends LoaderInterface> List<T> loadFile(InputStream inputStream, Charset charset, Class<T> clazz) throws Exception {

        List<T> allRecords = new ArrayList<>();

        // try-with-resources 구문을 사용하여 자원을 자동으로 해제합니다.
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
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
        System.out.println("Total: " + allRecords.size() + " records.");
        return allRecords;
    }
}