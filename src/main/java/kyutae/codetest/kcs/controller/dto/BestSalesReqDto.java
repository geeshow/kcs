package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BestSalesReqDto {
    @Size(min = 5, max = 5)
    @Schema(description = "기준년분기", example = "20231")
    private String stdrYyquCd;

    @Size(min = 8, max = 8)
    @Schema(description = "서비스업종코드", example = "CS200017")
    private String svcIndutyCdNm;
}
