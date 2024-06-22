package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.TrdarStorDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrdarStorDtlRepository extends JpaRepository<TrdarStorDtl, Long> {
}