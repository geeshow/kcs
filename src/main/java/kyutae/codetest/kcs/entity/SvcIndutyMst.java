package kyutae.codetest.kcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SVC_INDUTY_CD")
public class SvcIndutyMst {
    @Id
    @Column(name = "SVC_INDUTY_CD", length = 8, columnDefinition = "서비스 업종 코드")
    private String svcIndutyCd;

    @Column(name = "SVC_INDUTY_CD_NM", length = 100, nullable = false, columnDefinition = "서비스 업종 코드 명")
    private String svcIndutyCdNm;

    public SvcIndutyMst() {

    }

    public SvcIndutyMst(String svcIndutyCd, String svcIndutyCdNm) {
        this.svcIndutyCd = svcIndutyCd;
        this.svcIndutyCdNm = svcIndutyCdNm;
    }

}