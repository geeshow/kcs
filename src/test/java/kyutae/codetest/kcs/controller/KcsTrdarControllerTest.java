// KcsTrdarControllerTest.java
package kyutae.codetest.kcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kyutae.codetest.kcs.controller.dto.*;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import kyutae.codetest.kcs.service.KcsTrdarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(KcsTrdarController.class)
class KcsTrdarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KcsTrdarService kcsTrdarService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getTrdarRate_shouldReturnTrdarRateResDto() throws Exception {
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

        TrdarRateResDto trdarRateResDto = TrdarRateResDto.builder()
                .topOpenRate(maxOpbizRt)
                .topCloseRate(maxClsbizRt)
                .build();

        when(kcsTrdarService.getTrdarRate(any(TrdarRateReqDto.class))).thenReturn(trdarRateResDto);

        // when & then
        mockMvc.perform(post("/kcs/api/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(trdarRateReqDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.topOpenRate.svcIndutyCd").value("CS100001"))
                .andExpect(jsonPath("$.topOpenRate.svcIndutyNm").value("한식음식점"))
                .andExpect(jsonPath("$.topCloseRate.svcIndutyCd").value("CS100002"))
                .andExpect(jsonPath("$.topCloseRate.svcIndutyNm").value("중식음식점"));
    }

    @Test
    void getTopStorCount_shouldReturnTopStorCountResDtoList() throws Exception {
        // given
        TopStorCountReqDto reqDto = TopStorCountReqDto.builder()
                .stdrYyquCd("20231")
                .trdarCd("3001491")
                .topN(3)
                .build();

        List<TopStorCountResDto> resDtoList = Arrays.asList(
                TopStorCountResDto.builder().rank(1).topStorCount(SvcIndutyDto.builder().svcIndutyCd("CS100001").svcIndutyNm("한식음식점").build()).build(),
                TopStorCountResDto.builder().rank(2).topStorCount(SvcIndutyDto.builder().svcIndutyCd("CS100002").svcIndutyNm("중식음식점").build()).build(),
                TopStorCountResDto.builder().rank(3).topStorCount(SvcIndutyDto.builder().svcIndutyCd("CS100003").svcIndutyNm("일식음식점").build()).build()
        );

        when(kcsTrdarService.getTopStorCo(any(TopStorCountReqDto.class))).thenReturn(resDtoList);

        // when & then
        mockMvc.perform(post("/kcs/api/top-stor-count")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].rank").value(1))
                .andExpect(jsonPath("$[0].topStorCount.svcIndutyNm").value("한식음식점"))
                .andExpect(jsonPath("$[1].rank").value(2))
                .andExpect(jsonPath("$[1].topStorCount.svcIndutyNm").value("중식음식점"))
                .andExpect(jsonPath("$[2].rank").value(3))
                .andExpect(jsonPath("$[2].topStorCount.svcIndutyNm").value("일식음식점"));
    }

    @Test
    void getBestSales_shouldReturnBestSalesResDto() throws Exception {
        // given
        BestSalesReqDto reqDto = BestSalesReqDto.builder()
                .stdrYyquCd("20231")
                .svcIndutyCdNm("음식점")
                .build();

        BestSalesResDto resDto = BestSalesResDto.builder()
                .trdarCd("1")
                .build();

        when(kcsTrdarService.getBestSales(any(BestSalesReqDto.class))).thenReturn(resDto);

        // when & then
        mockMvc.perform(post("/kcs/api/best-sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.trdarCd").value("1"));
    }
}