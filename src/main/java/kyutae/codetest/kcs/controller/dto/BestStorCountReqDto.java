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
public class BestStorCountReqDto {
    @Size(min = 5, max = 5)
    @Schema(description = "기준년분기", example = "20231")
    private String stdrYyquCd;

    @Size(min = 7, max = 7)
    @Schema(description = "상권코드", example = "3001491")
    private String trdarCd;
}
