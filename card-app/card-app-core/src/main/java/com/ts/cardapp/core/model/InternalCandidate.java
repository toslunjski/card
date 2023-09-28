package com.ts.cardapp.core.model;

import com.ts.cardapp.api.model.CardStatus;
import com.ts.cardapp.core.persistence.entity.DbCandidate;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class InternalCandidate
{
    private String name;
    private String surname;
    private long       oib;
    private CardStatus cardStatus;

    public InternalCandidate()
    {

    }

    private InternalCandidate(final String name, final String surname, final long oib, final CardStatus cardStatus)
    {
        this.name = name;
        this.surname = surname;
        this.oib = oib;
        this.cardStatus = cardStatus;
    }

    public static InternalCandidate from(final DbCandidate dbCandidate)
    {
        return new InternalCandidate(dbCandidate.getName(), dbCandidate.getSurname(), dbCandidate.getOib(), dbCandidate.getCardStatus());
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

    public CardStatus getCardStatus()
    {
        return cardStatus;
    }
}