package kyutae.codetest.kcs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRDAR_MST")
public class TrdarMst {
    @Id
    @Column(name = "TRDAR_CD", length = 7, columnDefinition = "상권 코드")
    private String trdarCd;

    @Column(name = "TRDAR_CD_NM", length = 100, nullable = false, columnDefinition = "상권 코드 명")
    private String trdarCdNm;

    @ManyToOne
    @JoinColumn(name = "TRDAR_SE_CD", nullable = false)
    private TrdarSeMst trdarSe;

    public TrdarMst() {
    }

    public TrdarMst(String trdarCd, String trdarCdNm, TrdarSeMst trdarSe) {
        this.trdarCd = trdarCd;
        this.trdarCdNm = trdarCdNm;
        this.trdarSe = trdarSe;
    }
}