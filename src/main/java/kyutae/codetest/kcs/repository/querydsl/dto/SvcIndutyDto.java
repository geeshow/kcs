package kyutae.codetest.kcs.repository.querydsl.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SvcIndutyDto {
    @Schema(description = "업종코드")
    private String svcIndutyCd;
    @Schema(description = "업종명")
    private String svcIndutyNm;
}
