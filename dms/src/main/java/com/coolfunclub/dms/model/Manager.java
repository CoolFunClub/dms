package com.coolfunclub.dms.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "managers")
public class Manager extends Person {
    @Column(name = "ssn")
    @Id
    private long ssn;
    @OneToOne(optional = true)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "managers", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    //Getters and Setters
    public long getSSN(){
        return this.ssn;
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
