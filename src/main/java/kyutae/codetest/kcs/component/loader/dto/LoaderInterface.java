package kyutae.codetest.kcs.component.loader.dto;

import org.apache.commons.csv.CSVRecord;

public interface LoaderInterface {
    void mapFromCsvRecord(CSVRecord record);
}