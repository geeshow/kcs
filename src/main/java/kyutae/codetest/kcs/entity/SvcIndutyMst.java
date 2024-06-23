package kyutae.codetest.kcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SVC_INDUTY_CD")
public class SvcIndutyMst {
    @Id
    @Column(name = "SVC_INDUTY_CD", length = 8)
    private String svcIndutyCd;

    @Column(name = "SVC_INDUTY_CD_NM", length = 100, nullable = false)
    private String svcIndutyCdNm;
}