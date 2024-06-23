package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.common.exception.KcsRuntimeException;
import kyutae.codetest.kcs.controller.dto.*;
import kyutae.codetest.kcs.repository.querydsl.TrdarSalesDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.TrdarStorDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.dto.BestSalesDto;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KcsTrdarService {
    private final TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;
    private final TrdarSalesDtlQueryRepository trdarSalesDtlQueryRepository;
    public KcsTrdarService(TrdarStorDtlQueryRepository trdarStorDtlQueryRepository, TrdarSalesDtlQueryRepository trdarSalesDtlQueryRepository) {
        this.trdarStorDtlQueryRepository = trdarStorDtlQueryRepository;
        this.trdarSalesDtlQueryRepository = trdarSalesDtlQueryRepository;
    }
    public TrdarRateResDto getTrdarRate(TrdarRateReqDto trdarRateReqDto) {
        SvcIndutyDto maxOpbizRtByStdrYyquCdAndTrdarCd = trdarStorDtlQueryRepository.findMaxOpbizRtByStdrYyquCdAndTrdarCd(
                trdarRateReqDto.getStdrYyquCd(),
                trdarRateReqDto.getTrdarCd()
        );
        SvcIndutyDto maxClsbizRtByStdrYyquCdAndTrdarCd = trdarStorDtlQueryRepository.findMaxClsbizRtByStdrYyquCdAndTrdarCd(
                trdarRateReqDto.getStdrYyquCd(),
                trdarRateReqDto.getTrdarCd()
        );

        if (maxOpbizRtByStdrYyquCdAndTrdarCd == null && maxClsbizRtByStdrYyquCdAndTrdarCd == null) {
            throw new KcsRuntimeException("해당하는 상권이 없습니다.");
        }

        return TrdarRateResDto.builder()
                .topOpenRate(maxOpbizRtByStdrYyquCdAndTrdarCd)
                .topCloseRate(maxClsbizRtByStdrYyquCdAndTrdarCd)
                .build();
    }


    public List<TopStorCountResDto> getTopStorCo(TopStorCountReqDto topStorCoReqDto) {
        AtomicInteger rank = new AtomicInteger(1);

        List<TopStorCountResDto> list = trdarStorDtlQueryRepository.findTopStorCoByStdrYyquCdAndTrdarCd(
                        topStorCoReqDto.getStdrYyquCd(),
                        topStorCoReqDto.getTrdarCd(),
                        topStorCoReqDto.getTopN()
                ).stream()
                .map(svcIndutyDto -> TopStorCountResDto.builder()
                        .rank(rank.getAndIncrement())
                        .topStorCount(svcIndutyDto)
                        .build())
                .toList();

        if (list.isEmpty()) {
            throw new KcsRuntimeException("해당하는 상권이 없습니다.");
        }

        return list;
    }

    public BestSalesResDto getBestSales(BestSalesReqDto bestSalesReqDto) {
        BestSalesDto bestSalesDto = trdarSalesDtlQueryRepository.findBestSalesByStdrYyquCdAndSvcIndutyCdNm(
                bestSalesReqDto.getStdrYyquCd(),
                bestSalesReqDto.getSvcIndutyCdNm()
        );

        if (bestSalesDto == null) {
            throw new KcsRuntimeException("해당하는 상권이 없습니다.");
        }

        return BestSalesResDto.builder()
                .trdarCd(bestSalesDto.getTrdarCd())
                .build();
    }
}
