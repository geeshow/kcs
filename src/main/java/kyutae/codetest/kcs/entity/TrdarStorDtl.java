package kyutae.codetest.kcs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRDAR_STOR_DTL")
public class TrdarStorDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STDR_YYQU_CD", length = 5)
    private String stdrYyquCd;

    @ManyToOne
    @JoinColumn(name = "TRDAR_CD")
    private TrdarMst trdar;

    @ManyToOne
    @JoinColumn(name = "SVC_INDUTY_CD")
    private SvcIndutyMst svcInduty;

    @Column(name = "STOR_CO")
    private Integer storCo;

    @Column(name = "SIMILR_INDUTY_STOR_CO")
    private Integer similrIndutyStorCo;

    @Column(name = "OPBIZ_RT")
    private Integer opbizRt;

    @Column(name = "OPBIZ_STOR_CO")
    private Integer opbizStorCo;

    @Column(name = "CLSBIZ_RT")
    private Integer clsbizRt;

    @Column(name = "CLSBIZ_STOR_CO")
    private Integer clsbizStorCo;

    @Column(name = "FRC_STOR_CO")
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