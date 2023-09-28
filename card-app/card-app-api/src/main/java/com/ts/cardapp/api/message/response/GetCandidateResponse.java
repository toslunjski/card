package com.ts.cardapp.api.message.response;

import com.ts.cardapp.api.model.Candidate;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class GetCandidateResponse
{
    private Candidate candidate;
    private int code;
    private String status;

    private GetCandidateResponse(final Candidate candidate, final int code, final String status)
    {
        this.candidate = candidate;
        this.code = code;
        this.status = status;
    }

    public static GetCandidateResponse from (final Candidate candidate, final int code, final String status)
    {
        return new GetCandidateResponse(candidate, code, status);
    }
}