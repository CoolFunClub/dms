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
import lombok.ToString;

@ToString
@Entity
@Table(name= "customers")
public class Customer extends Person{

    @Id
    @Column (name="driverLicenseID")
    private String driverLicenseID;
    @OneToOne(optional = true)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    // Getters and setters for driver license ID
    public String getDriverLicenseID() {
        return driverLicenseID;
    }

    public void setDriverLicenseID(String driverLicenseID) {
        this.driverLicenseID = driverLicenseID;
    }

    public void setAccount(Account account){
        this.account=account;
    }
    public Account getAccount(){
        return account;
    }


}
