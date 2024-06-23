package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.component.loader.dto.LoaderSalesDto;
import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarMst;
import kyutae.codetest.kcs.entity.TrdarSalesDtl;
import kyutae.codetest.kcs.entity.TrdarSeMst;
import kyutae.codetest.kcs.repository.SvcIndutyMstRepository;
import kyutae.codetest.kcs.repository.TrdarMstRepository;
import kyutae.codetest.kcs.repository.TrdarSalesDtlRepository;
import kyutae.codetest.kcs.repository.TrdarSeMstRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImportSalesServiceTest {

    @Mock
    private TrdarSeMstRepository trdarSeMstRepository;
    @Mock
    private TrdarMstRepository trdarMstRepository;
    @Mock
    private SvcIndutyMstRepository svcIndutyMstRepository;
    @Mock
    private TrdarSalesDtlRepository trdarSalesDtlRepository;

    @InjectMocks
    private ImportSalesService importSalesService;

    @Test
    void importData_ShouldSaveRecordsSuccessfully() {
        // Given
        List<LoaderSalesDto> records = new ArrayList<>();
        LoaderSalesDto record1 = new LoaderSalesDto();
        record1.setStdrYyquCd("20221");
        record1.setTrdarSeCd("A");
        record1.setTrdarSeCdNm("골목상권");
        record1.setTrdarCd("3110389");
        record1.setTrdarCdNm("한일병원");
        record1.setSvcIndutyCd("CS200005");
        record1.setSvcIndutyCdNm("스포츠 강습");
        record1.setMthSaleAmt(8571429);
        record1.setMthSaleCnt(42);
        record1.setWeekdayAvgSaleAmt(8571429);
        record1.setHolidayAvgSaleAmt(0);
        record1.setMonSaleAmt(1018387);
        record1.setTueSaleAmt(2758134);
        record1.setWedSaleAmt(1527581);
        record1.setThuSaleAmt(1145686);
        record1.setFriSaleAmt(2121641);
        record1.setSatSaleAmt(0);
        record1.setSunSaleAmt(0);
        records.add(record1);

        LoaderSalesDto record2 = new LoaderSalesDto();
        record2.setStdrYyquCd("20221");
        record2.setTrdarSeCd("A");
        record2.setTrdarSeCdNm("골목상권");
        record2.setTrdarCd("3110535");
        record2.setTrdarCdNm("영천시장입구");
        record2.setSvcIndutyCd("CS200002");
        record2.setSvcIndutyCdNm("외국어학원");
        record2.setMthSaleAmt(6033530);
        record2.setMthSaleCnt(20);
        record2.setWeekdayAvgSaleAmt(6033530);
        record2.setHolidayAvgSaleAmt(0);
        record2.setMonSaleAmt(0);
        record2.setTueSaleAmt(3016765);
        record2.setWedSaleAmt(0);
        record2.setThuSaleAmt(0);
        record2.setFriSaleAmt(3016765);
        record2.setSatSaleAmt(0);
        record2.setSunSaleAmt(0);
        records.add(record2);

        when(trdarSeMstRepository.save(any(TrdarSeMst.class))).thenReturn(new TrdarSeMst());
        when(trdarMstRepository.save(any(TrdarMst.class))).thenReturn(new TrdarMst());
        when(svcIndutyMstRepository.save(any(SvcIndutyMst.class))).thenReturn(new SvcIndutyMst());

        // When
        importSalesService.importData(records);

        // Then
        verify(trdarSeMstRepository, times(1)).save(any(TrdarSeMst.class));
        verify(trdarMstRepository, times(2)).save(any(TrdarMst.class));
        verify(svcIndutyMstRepository, times(2)).save(any(SvcIndutyMst.class));
        verify(trdarSalesDtlRepository, times(2)).save(any(TrdarSalesDtl.class));
    }
}