package kyutae.codetest.kcs.repository;

import kyutae.codetest.kcs.entity.TrdarStorDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrdarStorDtlRepository extends JpaRepository<TrdarStorDtl, Long>, QuerydslPredicateExecutor<TrdarStorDtl> {
}