package kyutae.codetest.kcs.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrdarRateResDto {
    @Schema(description = "개업률이 가장 높은 서비스 업종")
    private SvcIndutyDto topOpenRate;
    @Schema(description = "폐업률이 가장 높은 서비스 업종")
    private SvcIndutyDto topCloseRate;
}