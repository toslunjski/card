package com.ts.cardapp.core.peer;

import com.ts.cardapp.api.message.request.CreateCandidateRequest;
import com.ts.cardapp.api.message.response.CreateCandidateResponse;
import com.ts.cardapp.api.message.response.DeleteCandidateResponse;
import com.ts.cardapp.api.message.response.GetCandidateResponse;
import com.ts.cardapp.api.model.Candidate;
import com.ts.cardapp.api.service.CandidateService;
import com.ts.cardapp.core.model.InternalCandidate;
import com.ts.cardapp.core.persistence.entity.DbCandidate;
import com.ts.cardapp.core.service.InternalCandidateService;
import org.springframework.stereotype.Service;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Service
public class CandidatePeer implements CandidateService
{
    private final InternalCandidateService internalCandidateService;

    public CandidatePeer(final InternalCandidateService internalCandidateService)
    {
        this.internalCandidateService = internalCandidateService;
    }

    @Override
    public CreateCandidateResponse createCandidate(final CreateCandidateRequest request)
    {
        internalCandidateService.createCandidate(request);

        return  CreateCandidateResponse.from(200, "OK");
    }

    @Override
    public GetCandidateResponse getCandidate(final long oib)
    {
        InternalCandidate internalCandidate = internalCandidateService.getCandidate(oib);

        return GetCandidateResponse.from(
            Candidate.from(internalCandidate.getName(),
                internalCandidate.getSurname(),
                internalCandidate.getOib(),
                internalCandidate.getCardStatus()), 200, "OK");
    }

    @Override
    public DeleteCandidateResponse deleteCandidate(final long oib)
    {
        internalCandidateService.deleteCandidate(oib);

        return DeleteCandidateResponse.from(200, "OK");
    }
}