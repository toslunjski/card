package com.ts.cardapp.core.service;

import com.ts.cardapp.api.message.request.CreateCandidateRequest;
import com.ts.cardapp.api.model.CardStatus;
import com.ts.cardapp.core.model.InternalCandidate;
import com.ts.cardapp.core.persistence.entity.DbCandidate;
import org.springframework.stereotype.Service;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Service
public class InternalCandidateService
{
    private final InternalDbService internalDbService;

    private final InternalFileService internalFileService;

    public InternalCandidateService(
        final InternalDbService internalDbService,
        final InternalFileService internalFileService)
    {
        this.internalDbService = internalDbService;
        this.internalFileService = internalFileService;
    }

    public boolean createCandidate(final CreateCandidateRequest request)
    {
        internalDbService.createCandidate(DbCandidate.from(request.getName(), request.getSurname(), request.getOib(), CardStatus.PENDING));
        return true;
    }

    public InternalCandidate getCandidate(final long oib)
    {
        InternalCandidate internalCandidate = internalDbService.checkCandidateExists(oib);

        if(internalCandidate != null)
        {
            internalFileService.createFile(internalCandidate);
        }

        return internalCandidate;
    }

    public boolean deleteCandidate(final long oib)
    {
        InternalCandidate internalCandidate = checkDeletePrerequisites(oib);
        if(internalCandidate!= null)
            {
                internalDbService.deleteCandidate(oib);
                internalFileService.deleteFile(oib);
            }
        return true;
    }

    private InternalCandidate checkDeletePrerequisites(final long oib)
    {
        InternalCandidate internalCandidate = internalDbService.checkCandidateExists(oib);
        internalFileService.checkFileExists(oib);
        return internalCandidate;
    }
}