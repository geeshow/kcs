package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class BestStorCountResDto {
    @Schema(description = "상권코드")
    private String trdarCd;
    @Schema(description = "상권명")
    private String trdarCdNm;

    public BestStorCountResDto(String trdarCd, String trdarCdNm) {
        this.trdarCd = trdarCd;
        this.trdarCdNm = trdarCdNm;
    }

    public String getTrdarCd() {
        return trdarCd;
    }

    public void setTrdarCd(String trdarCd) {
        this.trdarCd = trdarCd;
    }

    public String getTrdarCdNm() {
        return trdarCdNm;
    }

    public void setTrdarCdNm(String trdarCdNm) {
        this.trdarCdNm = trdarCdNm;
    }
}