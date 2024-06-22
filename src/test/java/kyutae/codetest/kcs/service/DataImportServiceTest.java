package kyutae.codetest.kcs.service;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataImportServiceTest {

    @Mock
    private SvcIndutyMstRepository svcIndutyMstRepository;
    @Mock
    private TrdarMstRepository trdarMstRepository;
    @Mock
    private TrdarSeMstRepository trdarSeMstRepository;
    @Mock
    private TrdarStorDtlRepository trdarStorDtlRepository;

    @InjectMocks
    private DataImportService dataImportService;

    @Test
    void importData_ShouldSaveRecordsSuccessfully() {
        // Given
        List<Map<String, String>> records = new ArrayList<>();
        Map<String, String> record1 = new HashMap<>();
        record1.put("상권_구분_코드", "A");
        record1.put("상권_구분_코드_명", "상권구분코드명");
        record1.put("상권_코드", "B");
        record1.put("상권_코드_명", "상권코드명");
        record1.put("서비스_업종_코드", "C");
        record1.put("서비스_업종_코드_명", "서비스업종코드명");
        record1.put("기준_년분기_코드", "202301");
        record1.put("점포_수", "100");
        record1.put("유사_업종_점포_수", "50");
        record1.put("개업_율", "10");
        record1.put("개업_점포_수", "5");
        record1.put("폐업_률", "20");
        record1.put("폐업_점포_수", "10");
        record1.put("프랜차이즈_점포_수", "30");
        records.add(record1);
        Map<String, String> record2 = new HashMap<>();
        record2.put("상권_구분_코드", "A");
        record2.put("상권_구분_코드_명", "상권구분코드명");
        record2.put("상권_코드", "B");
        record2.put("상권_코드_명", "상권코드명");
        record2.put("서비스_업종_코드", "C");
        record2.put("서비스_업종_코드_명", "서비스업종코드명");
        record2.put("기준_년분기_코드", "202301");
        record2.put("점포_수", "100");
        record2.put("유사_업종_점포_수", "50");
        record2.put("개업_율", "10");
        record2.put("개업_점포_수", "5");
        record2.put("폐업_률", "20");
        record2.put("폐업_점포_수", "10");
        record2.put("프랜차이즈_점포_수", "30");
        records.add(record2);
        when(trdarSeMstRepository.save(any(TrdarSeMst.class))).thenReturn(new TrdarSeMst());
        when(trdarMstRepository.save(any(TrdarMst.class))).thenReturn(new TrdarMst());
        when(svcIndutyMstRepository.save(any(SvcIndutyMst.class))).thenReturn(new SvcIndutyMst());

        // When
        dataImportService.importData(records);

        // Then
        verify(trdarSeMstRepository, times(1)).save(any(TrdarSeMst.class));
        verify(trdarMstRepository, times(1)).save(any(TrdarMst.class));
        verify(svcIndutyMstRepository, times(1)).save(any(SvcIndutyMst.class));
        verify(trdarStorDtlRepository, times(2)).save(any(TrdarStorDtl.class));
    }
}