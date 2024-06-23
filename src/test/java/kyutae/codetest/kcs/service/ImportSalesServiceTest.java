package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.component.loader.dto.LoaderSalesDto;
import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarSalesDtl;
import kyutae.codetest.kcs.repository.SvcIndutyMstRepository;
import kyutae.codetest.kcs.repository.TrdarSalesDtlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImportSalesServiceTest {

    @InjectMocks
    private ImportSalesService importSalesService;

    @Mock
    private SvcIndutyMstRepository svcIndutyMstRepository;

    @Mock
    private TrdarSalesDtlRepository trdarSalesDtlRepository;

    @Test
    void importData_shouldSaveSvcIndutyMstAndTrdarSalesDtl() {
        // given
        List<LoaderSalesDto> loaderSalesDtoList = Arrays.asList(
                createLoaderSalesDto("20231", "11", "서울시", "CS100004", "양식음식점"),
                createLoaderSalesDto("20231", "11", "서울시", "CS300020", "서적")
        );

        when(svcIndutyMstRepository.save(any(SvcIndutyMst.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        when(trdarSalesDtlRepository.save(any(TrdarSalesDtl.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        importSalesService.importData(loaderSalesDtoList);

        // then
        verify(svcIndutyMstRepository, times(2)).save(any(SvcIndutyMst.class));
        verify(trdarSalesDtlRepository, times(2)).save(any(TrdarSalesDtl.class));
    }

    private LoaderSalesDto createLoaderSalesDto(String stdrYyquCd, String seoulCd, String seoulCdNm,
                                                String svcIndutyCd, String svcIndutyCdNm) {
        LoaderSalesDto loaderSalesDto = new LoaderSalesDto();
        loaderSalesDto.setStdrYyquCd(stdrYyquCd);
        loaderSalesDto.setSeoulCd(seoulCd);
        loaderSalesDto.setSeoulCdNm(seoulCdNm);
        loaderSalesDto.setSvcIndutyCd(svcIndutyCd);
        loaderSalesDto.setSvcIndutyCdNm(svcIndutyCdNm);
        return loaderSalesDto;
    }
}