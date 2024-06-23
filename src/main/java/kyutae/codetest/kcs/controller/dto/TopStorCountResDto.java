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
public class TopStorCountResDto {
    @Schema(description = "순위")
    private int rank;

    @Schema(description = "가장 많은 점포수를 가진 업종 리스트")
    private SvcIndutyDto topStorCount;
}