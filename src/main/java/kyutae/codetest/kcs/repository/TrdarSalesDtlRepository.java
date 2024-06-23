package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.TrdarSalesDtl;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrdarSalesDtlRepository extends JpaRepository<TrdarSalesDtl, Long>, QuerydslPredicateExecutor<TrdarSalesDtl> {
}