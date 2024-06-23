// KcsTrdarServiceTest.java
package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.controller.dto.*;
import kyutae.codetest.kcs.repository.querydsl.TrdarSalesDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.TrdarStorDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.dto.BestSalesDto;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KcsTrdarServiceTest {
    @InjectMocks
    private KcsTrdarService kcsTrdarService;

    @Mock
    private TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;
    @Mock
    private TrdarSalesDtlQueryRepository trdarSalesDtlQueryRepository;
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

    @Test
    void getTopStorCo_shouldReturnTopStorCountResDtoList() {
        // given
        TopStorCountReqDto reqDto = TopStorCountReqDto.builder()
                .stdrYyquCd("20231")
                .trdarCd("3001491")
                .topN(3)
                .build();

        List<SvcIndutyDto> svcIndutyDtoList = Arrays.asList(
                SvcIndutyDto.builder().svcIndutyCd("CS100001").svcIndutyNm("한식음식점").build(),
                SvcIndutyDto.builder().svcIndutyCd("CS100002").svcIndutyNm("중식음식점").build(),
                SvcIndutyDto.builder().svcIndutyCd("CS100003").svcIndutyNm("일식음식점").build()
        );

        when(trdarStorDtlQueryRepository.findTopStorCoByStdrYyquCdAndTrdarCd(anyString(), anyString(), anyInt()))
                .thenReturn(svcIndutyDtoList);

        // when
        List<TopStorCountResDto> result = kcsTrdarService.getTopStorCo(reqDto);

        // then
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getRank()).isEqualTo(1);
        assertThat(result.get(0).getTopStorCount().getSvcIndutyNm()).isEqualTo("한식음식점");
        assertThat(result.get(1).getRank()).isEqualTo(2);
        assertThat(result.get(1).getTopStorCount().getSvcIndutyNm()).isEqualTo("중식음식점");
        assertThat(result.get(2).getRank()).isEqualTo(3);
        assertThat(result.get(2).getTopStorCount().getSvcIndutyNm()).isEqualTo("일식음식점");
    }

    @Test
    void getBestSales_shouldReturnBestSalesResDto() {
        // given
        BestSalesReqDto reqDto = BestSalesReqDto.builder()
                .stdrYyquCd("20231")
                .svcIndutyCdNm("음식점")
                .build();

        BestSalesDto bestSalesDto = BestSalesDto.builder()
                .trdarCd("1")
                .build();

        when(trdarSalesDtlQueryRepository.findBestSalesByStdrYyquCdAndSvcIndutyCdNm(anyString(), anyString()))
                .thenReturn(bestSalesDto);

        // when
        BestSalesResDto result = kcsTrdarService.getBestSales(reqDto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getTrdarCd()).isEqualTo("1");
    }
}