package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.TrdarSeMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrdarSeMstRepository extends JpaRepository<TrdarSeMst, String> {
}