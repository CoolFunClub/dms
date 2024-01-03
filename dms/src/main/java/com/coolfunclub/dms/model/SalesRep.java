package com.coolfunclub.dms.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SalesRep extends Person {
    @Id
    @Column(name = "ssn")
    private long ssn;

    @OneToOne(optional = true)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "salesReps", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    //Getters and Setters
    public long getSSN(){
        return ssn;
    }

    public void setSSN(long ssn){
        this.ssn = ssn;
    }
    public void setAccount(Account account){
        this.account=account;
    }
    public Account getAccount(){
        return account;
    }
}
