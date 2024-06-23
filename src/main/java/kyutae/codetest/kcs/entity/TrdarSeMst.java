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
@Table(name = "TRDAR_SE")
public class TrdarSeMst {
    @Id
    @Column(name = "TRDAR_SE_CD", length = 1)
    private String trdarSeCd;

    @Column(name = "TRDAR_SE_CD_NM", length = 50, nullable = false)
    private String trdarSeCdNm;
}