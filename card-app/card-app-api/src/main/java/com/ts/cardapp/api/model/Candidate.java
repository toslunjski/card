package com.ts.cardapp.api.model;


/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
public class Candidate
{
    private String name;

    private String surname;

    private long oib;

    private CardStatus cardStatus;

    private Candidate()
    {
    }

    private Candidate(final String name, final String surname, final long oib, final CardStatus cardStatus)
    {
        this.name = name;
        this.surname = surname;
        this.oib = oib;
        this.cardStatus = cardStatus;
    }

    public static Candidate from (final String name, final String surname, final long oib, final CardStatus cardStatus)
    {
        return new Candidate(name, surname, oib, cardStatus);
    }
}