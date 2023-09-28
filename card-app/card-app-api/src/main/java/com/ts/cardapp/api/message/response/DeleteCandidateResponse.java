package com.ts.cardapp.api.message.response;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class DeleteCandidateResponse
{
    private int code;
    private String status;

    public DeleteCandidateResponse(final int code, final String status)
    {
        this.code = code;
        this.status = status;
    }

    public static DeleteCandidateResponse from(final int code, final String status)
    {
        return new DeleteCandidateResponse(code, status);
    }
}