package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public class BestStorCountReqDto {
    @Size(min = 5, max = 5)
    @Schema(description = "기준년분기", example = "20231")
    private String stdrYyquCd;

    @Size(min = 7, max = 7)
    @Schema(description = "상권코드", example = "3001491")
    private String trdarCd;

    public BestStorCountReqDto() {
    }

    public BestStorCountReqDto(String stdrYyquCd, String trdarCd) {
        this.stdrYyquCd = stdrYyquCd;
        this.trdarCd = trdarCd;
    }

    public String getStdrYyquCd() {
        return stdrYyquCd;
    }

    public void setStdrYyquCd(String stdrYyquCd) {
        this.stdrYyquCd = stdrYyquCd;
    }

    public String getTrdarCd() {
        return trdarCd;
    }

    public void setTrdarCd(String trdarCd) {
        this.trdarCd = trdarCd;
    }
}
