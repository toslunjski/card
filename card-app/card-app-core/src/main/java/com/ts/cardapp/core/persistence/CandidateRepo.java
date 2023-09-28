package com.ts.cardapp.core.persistence;

import com.ts.cardapp.core.persistence.entity.DbCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Repository
public interface CandidateRepo extends JpaRepository<DbCandidate, Long>
{
    DbCandidate findByOib(final long oib);

    void deleteByOib(final long oib);
}