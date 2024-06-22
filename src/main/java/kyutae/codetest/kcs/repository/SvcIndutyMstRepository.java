package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.SvcIndutyMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SvcIndutyMstRepository extends JpaRepository<SvcIndutyMst, String> {
}