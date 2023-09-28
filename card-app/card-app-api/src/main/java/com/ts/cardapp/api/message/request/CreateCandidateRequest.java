package com.ts.cardapp.api.message.request;

import com.ts.cardapp.api.message.response.CreateCandidateResponse;
import com.ts.cardapp.api.model.CardStatus;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class CreateCandidateRequest
{
    private String name;
    private String surname;
    private long oib;

    public CreateCandidateRequest()
    {
    }

    public CreateCandidateRequest(final String name, final String surname, final long oib)
    {
        this.name = name;
        this.surname = surname;
        this.oib = oib;
    }

    public static CreateCandidateRequest from(final String name, final String surname, final long oib)
    {
        return new CreateCandidateRequest(name, surname, oib);
    }
    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public long getOib()
    {
        return oib;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setSurname(final String surname)
    {
        this.surname = surname;
    }

    public void setOib(final long oib)
    {
        this.oib = oib;
    }
}