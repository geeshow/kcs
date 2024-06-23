package kyutae.codetest.kcs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRDAR_MST")
public class TrdarMst {
    @Id
    @Column(name = "TRDAR_CD", length = 7)
    private String trdarCd;

    @Column(name = "TRDAR_CD_NM", length = 100, nullable = false)
    private String trdarCdNm;

    @ManyToOne
    @JoinColumn(name = "TRDAR_SE_CD", nullable = false)
    private TrdarSeMst trdarSe;
}