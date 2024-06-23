// KcsTrdarServiceTest.java
package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.controller.dto.TrdarRateReqDto;
import kyutae.codetest.kcs.controller.dto.TrdarRateResDto;
import kyutae.codetest.kcs.repository.querydsl.TrdarStorDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KcsTrdarServiceTest {
    @InjectMocks
    private KcsTrdarService kcsTrdarService;

    @Mock
    private TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;

    @Test
    void getTrdarRate_shouldReturnTrdarRateResDto() {
        // given
        TrdarRateReqDto trdarRateReqDto = TrdarRateReqDto.builder()
                .stdrYyquCd("20231")
                .trdarCd("3001491")
                .build();

        SvcIndutyDto maxOpbizRt = SvcIndutyDto.builder()
                .svcIndutyCd("CS100001")
                .svcIndutyNm("한식음식점")
                .build();

        SvcIndutyDto maxClsbizRt = SvcIndutyDto.builder()
                .svcIndutyCd("CS100002")
                .svcIndutyNm("중식음식점")
                .build();

        when(trdarStorDtlQueryRepository.findMaxOpbizRtByStdrYyquCdAndTrdarCd(anyString(), anyString()))
                .thenReturn(maxOpbizRt);
        when(trdarStorDtlQueryRepository.findMaxClsbizRtByStdrYyquCdAndTrdarCd(anyString(), anyString()))
                .thenReturn(maxClsbizRt);

        // when
        TrdarRateResDto result = kcsTrdarService.getTrdarRate(trdarRateReqDto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getTopOpenRate()).isEqualTo(maxOpbizRt);
        assertThat(result.getTopCloseRate()).isEqualTo(maxClsbizRt);
    }
}