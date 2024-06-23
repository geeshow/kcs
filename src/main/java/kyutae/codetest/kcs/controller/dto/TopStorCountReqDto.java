package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopStorCountReqDto {
    @Size(min = 5, max = 5)
    @Schema(description = "기준년분기")
    private String stdrYyquCd;

    @Size(min = 7, max = 7)
    @Schema(description = "상권코드")
    private String trdarCd;

    @Max(100)
    @Schema(description = "조회할 상위 업종 수", defaultValue = "5")
    @Builder.Default
    private int topN = 5;
}