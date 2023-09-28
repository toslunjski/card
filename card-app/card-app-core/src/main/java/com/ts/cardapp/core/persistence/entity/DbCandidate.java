package com.ts.cardapp.core.persistence.entity;

import com.ts.cardapp.api.model.CardStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Entity
@Table (name = DbCandidate.TABLE_NAME)

@SequenceGenerator (name = DbCandidate.SEQUENCE_NAME,
                    sequenceName = DbCandidate.SEQUENCE_NAME)

public class DbCandidate
{
    public static final  String TABLE_NAME = "db_candidate";
    public static final  String SEQUENCE_NAME    = "s_candidate";
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column (name = "id",
             nullable = false)
    private Long id;

    @Column (name = "name",
             nullable = false)
    private String name;

    @Column (name = "surname",
             nullable = false)
    private String surname;

    @Column (name = "oib",
             nullable = false)
    private long oib;

    @Column (name = "card_status",
             nullable = false)
    @Enumerated (EnumType.STRING)
    private CardStatus cardStatus;

    public DbCandidate()
    {
    }

    private DbCandidate(final String name, final String surname, final long oib, final CardStatus cardStatus)
    {
        this.name = name;
        this.surname = surname;
        this.oib = oib;
        this.cardStatus = cardStatus;
    }

    public static DbCandidate from(final String name, final String surname, final long oib, final CardStatus cardStatus)
    {
        return new DbCandidate(name, surname, oib, cardStatus);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(final String surname)
    {
        this.surname = surname;
    }

    public long getOib()
    {
        return oib;
    }

    public void setOib(final long oib)
    {
        this.oib = oib;
    }

    public CardStatus getCardStatus()
    {
        return cardStatus;
    }

    public void setCardStatus(final CardStatus cardStatus)
    {
        this.cardStatus = cardStatus;
    }
}
