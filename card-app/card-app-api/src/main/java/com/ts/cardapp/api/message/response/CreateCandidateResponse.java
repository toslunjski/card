package com.ts.cardapp.api.message.response;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class CreateCandidateResponse
{
    private int code;
    private String status;
    private CreateCandidateResponse(final int code, final String status)
    {
        this.code = code;
        this.status = status;
    }

    public static CreateCandidateResponse from(final int code, final String status)
    {
        return new CreateCandidateResponse(code, status);
    }
}