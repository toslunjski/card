package com.ts.cardapp.core.service;

import com.ts.cardapp.core.persistence.entity.DbCandidate;

public interface DbService
{
    DbCandidate findCandidateByOib(final long oib);

    void deleteCandidateByOib(final long oib);
}
