package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrdarRateResDto {
    @Schema(description = "상권코드")
    private String trdarCd;
    @Schema(description = "상권명")
    private String trdarCdNm;
}