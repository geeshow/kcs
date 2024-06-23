package kyutae.codetest.kcs.component.loader.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

@Getter
@Setter
public class LoaderTrdarDto implements LoaderInterface {
    private String stdrYyquCd; // 기준_년분기_코드
    private String trdarSeCd; // 상권_구분_코드
    private String trdarSeCdNm; // 상권_구분_코드_명
    private String trdarCd; // 상권_코드
    private String trdarCdNm; // 상권_코드_명
    private String svcIndutyCd; // 서비스_업종_코드
    private String svcIndutyCdNm; // 서비스_업종_코드_명
    private int storCo; // 점포_수
    private int similrIndutyStorCo; // 유사_업종_점포_수
    private int opbizRt; // 개업_율
    private int opbizStorCo; // 개업_점포_수
    private int clsbizRt; // 폐업_률
    private int clsbizStorCo; // 폐업_점포_수
    private int frcStorCo; // 프랜차이즈_점포_수

    @Override
    public void mapFromCsvRecord(CSVRecord record) {
        stdrYyquCd = record.get("기준_년분기_코드");
        trdarSeCd = record.get("상권_구분_코드");
        trdarSeCdNm = record.get("상권_구분_코드_명");
        trdarCd = record.get("상권_코드");
        trdarCdNm = record.get("상권_코드_명");
        svcIndutyCd = record.get("서비스_업종_코드");
        svcIndutyCdNm = record.get("서비스_업종_코드_명");
        storCo = Integer.parseInt(record.get("점포_수"));
        similrIndutyStorCo = Integer.parseInt(record.get("유사_업종_점포_수"));
        opbizRt = Integer.parseInt(record.get("개업_율"));
        opbizStorCo = Integer.parseInt(record.get("개업_점포_수"));
        clsbizRt = Integer.parseInt(record.get("폐업_률"));
        clsbizStorCo = Integer.parseInt(record.get("폐업_점포_수"));
        frcStorCo = Integer.parseInt(record.get("프랜차이즈_점포_수"));
    }
}