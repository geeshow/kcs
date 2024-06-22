package kyutae.codetest.kcs.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {
    @PersistenceContext
    private EntityManager em;

    @Bean
    public JPAQueryFactory query(){
        return new JPAQueryFactory(em);
    }
}