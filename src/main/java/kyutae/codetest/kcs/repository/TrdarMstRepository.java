package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.TrdarMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrdarMstRepository extends JpaRepository<TrdarMst, String> {
}