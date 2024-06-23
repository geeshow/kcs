package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarMst;
import kyutae.codetest.kcs.entity.TrdarSeMst;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import kyutae.codetest.kcs.repository.SvcIndutyMstRepository;
import kyutae.codetest.kcs.repository.TrdarMstRepository;
import kyutae.codetest.kcs.repository.TrdarSeMstRepository;
import kyutae.codetest.kcs.repository.TrdarStorDtlRepository;
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
class ImportTrdarServiceTest {

    @Mock
    private SvcIndutyMstRepository svcIndutyMstRepository;
    @Mock
    private TrdarMstRepository trdarMstRepository;
    @Mock
    private TrdarSeMstRepository trdarSeMstRepository;
    @Mock
    private TrdarStorDtlRepository trdarStorDtlRepository;

    @InjectMocks
    private ImportTrdarService importTrdarService;

    @Test
    void importData_ShouldSaveRecordsSuccessfully() {
        // Given
        List<LoaderTrdarDto> records = new ArrayList<>();
        LoaderTrdarDto record1 = new LoaderTrdarDto();
        record1.setStdrYyquCd("202301");
        record1.setTrdarSeCd("A");
        record1.setTrdarSeCdNm("상권구분코드명");
        record1.setTrdarCd("B");
        record1.setTrdarCdNm("상권코드명");
        record1.setSvcIndutyCd("C");
        record1.setSvcIndutyCdNm("서비스업종코드명");
        record1.setStorCo(100);
        record1.setSimilrIndutyStorCo(50);
        record1.setOpbizRt(10);
        record1.setOpbizStorCo(5);
        record1.setClsbizRt(20);
        record1.setClsbizStorCo(10);
        record1.setFrcStorCo(30);
        records.add(record1);
        LoaderTrdarDto record2 = new LoaderTrdarDto();
        record2.setStdrYyquCd("202301");
        record2.setTrdarSeCd("A2");
        record2.setTrdarSeCdNm("상권구분코드명2");
        record2.setTrdarCd("B2");
        record2.setTrdarCdNm("상권코드명2");
        record2.setSvcIndutyCd("C2");
        record2.setSvcIndutyCdNm("서비스업종코드명2");
        record2.setStorCo(200);
        record2.setSimilrIndutyStorCo(50);
        record2.setOpbizRt(30);
        record2.setOpbizStorCo(9);
        record2.setClsbizRt(20);
        record2.setClsbizStorCo(10);
        record2.setFrcStorCo(30);
        records.add(record2);

        when(trdarSeMstRepository.save(any(TrdarSeMst.class))).thenReturn(new TrdarSeMst());
        when(trdarMstRepository.save(any(TrdarMst.class))).thenReturn(new TrdarMst());
        when(svcIndutyMstRepository.save(any(SvcIndutyMst.class))).thenReturn(new SvcIndutyMst());

        // When
        importTrdarService.importData(records);

        // Then
        verify(trdarSeMstRepository, times(2)).save(any(TrdarSeMst.class));
        verify(trdarMstRepository, times(2)).save(any(TrdarMst.class));
        verify(svcIndutyMstRepository, times(2)).save(any(SvcIndutyMst.class));
        verify(trdarStorDtlRepository, times(2)).save(any(TrdarStorDtl.class));
    }
}