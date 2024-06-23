package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.controller.dto.TopStorCountReqDto;
import kyutae.codetest.kcs.controller.dto.TopStorCountResDto;
import kyutae.codetest.kcs.controller.dto.TrdarRateReqDto;
import kyutae.codetest.kcs.controller.dto.TrdarRateResDto;
import kyutae.codetest.kcs.repository.querydsl.TrdarStorDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KcsTrdarService {
    private final TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;
    public KcsTrdarService(TrdarStorDtlQueryRepository trdarStorDtlQueryRepository) {
        this.trdarStorDtlQueryRepository = trdarStorDtlQueryRepository;
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

        return TrdarRateResDto.builder()
                .topOpenRate(maxOpbizRtByStdrYyquCdAndTrdarCd)
                .topCloseRate(maxClsbizRtByStdrYyquCdAndTrdarCd)
                .build();
    }


    public List<TopStorCountResDto> getTopStorCo(TopStorCountReqDto topStorCoReqDto) {
        AtomicInteger rank = new AtomicInteger(1);

        return trdarStorDtlQueryRepository.findTopStorCoByStdrYyquCdAndTrdarCd(
                topStorCoReqDto.getStdrYyquCd(),
                topStorCoReqDto.getTrdarCd(),
                topStorCoReqDto.getTopN()
        ).stream()
                .map(svcIndutyDto -> TopStorCountResDto.builder()
                        .rank(rank.getAndIncrement())
                        .topStorCount(svcIndutyDto)
                        .build())
                .toList();
    }
}
