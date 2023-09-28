package com.ts.cardapp.core.service;

import com.ts.cardapp.core.model.InternalCandidate;
import com.ts.cardapp.core.persistence.CandidateRepo;
import com.ts.cardapp.core.persistence.entity.DbCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Service
public class InternalDbService implements DbService
{
    @Autowired
    private CandidateRepo candidateRepo;

    public InternalDbService()
    {
    }

    public boolean createCandidate(final DbCandidate dbCandidate)
    {
        candidateRepo.save(dbCandidate);
        return true;
    }
    public InternalCandidate checkCandidateExists(final long oib)
    {
        DbCandidate candidate = candidateRepo.findByOib(oib);
        if(candidate != null)
        {
            return InternalCandidate.from(candidate);
        }
        return null;
    }

    public boolean deleteCandidate(final long oib)
    {
        candidateRepo.delete(candidateRepo.findByOib(oib));
        return true;
    }

    @Override
    public DbCandidate findCandidateByOib(final long oib)
    {
        return candidateRepo.findByOib(oib);
    }

    @Override
    public void deleteCandidateByOib(final long oib)
    {
        candidateRepo.deleteByOib(oib);
    }
}