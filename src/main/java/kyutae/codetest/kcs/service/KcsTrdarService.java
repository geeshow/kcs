package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.controller.dto.TrdarRateReqDto;
import kyutae.codetest.kcs.controller.dto.TrdarRateResDto;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import kyutae.codetest.kcs.repository.querydsl.TrdarStorDtlQueryRepository;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.springframework.stereotype.Service;

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
}
