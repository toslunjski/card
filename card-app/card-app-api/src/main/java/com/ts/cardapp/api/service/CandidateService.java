package com.ts.cardapp.api.service;

import com.ts.cardapp.api.message.request.CreateCandidateRequest;
import com.ts.cardapp.api.message.response.CreateCandidateResponse;
import com.ts.cardapp.api.message.response.DeleteCandidateResponse;
import com.ts.cardapp.api.message.response.GetCandidateResponse;

public interface CandidateService
{
    CreateCandidateResponse createCandidate (final CreateCandidateRequest request);

    GetCandidateResponse getCandidate (final long oib);

    DeleteCandidateResponse deleteCandidate (final long oib);
}
