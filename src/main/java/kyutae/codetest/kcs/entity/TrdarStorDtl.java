package kyutae.codetest.kcs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRDAR_STOR_INFO")
public class TrdarStorDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STDR_YYQU_CD", length = 5, columnDefinition = "기준 년분기 코드")
    private String stdrYyquCd;

    @ManyToOne
    @JoinColumn(name = "TRDAR_CD", columnDefinition = "상권 코드")
    private TrdarMst trdar;

    @ManyToOne
    @JoinColumn(name = "SVC_INDUTY_CD", columnDefinition = "서비스 업종 코드")
    private SvcIndutyMst svcInduty;

    @Column(name = "STOR_CO", columnDefinition = "점포 수")
    private Integer storCo;

    @Column(name = "SIMILR_INDUTY_STOR_CO", columnDefinition = "유사 업종 점포 수")
    private Integer similrIndutyStorCo;

    @Column(name = "OPBIZ_RT", columnDefinition = "개업 율")
    private Integer opbizRt;

    @Column(name = "OPBIZ_STOR_CO", columnDefinition = "개업 점포 수")
    private Integer opbizStorCo;

    @Column(name = "CLSBIZ_RT", columnDefinition = "폐업 률")
    private Integer clsbizRt;

    @Column(name = "CLSBIZ_STOR_CO", columnDefinition = "폐업 점포 수")
    private Integer clsbizStorCo;

    @Column(name = "FRC_STOR_CO", columnDefinition = "프랜차이즈 점포 수")
    private Integer frcStorCo;

    public TrdarStorDtl() {

    }

    public TrdarStorDtl(Long id, String stdrYyquCd, TrdarMst trdar, SvcIndutyMst svcInduty, Integer storCo, Integer similrIndutyStorCo, Integer opbizRt, Integer opbizStorCo, Integer clsbizRt, Integer clsbizStorCo, Integer frcStorCo) {
        this.id = id;
        this.stdrYyquCd = stdrYyquCd;
        this.trdar = trdar;
        this.svcInduty = svcInduty;
        this.storCo = storCo;
        this.similrIndutyStorCo = similrIndutyStorCo;
        this.opbizRt = opbizRt;
        this.opbizStorCo = opbizStorCo;
        this.clsbizRt = clsbizRt;
        this.clsbizStorCo = clsbizStorCo;
        this.frcStorCo = frcStorCo;
    }
}