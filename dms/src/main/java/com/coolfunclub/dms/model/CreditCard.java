package com.coolfunclub.dms.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CreditCard {
    @Id
    private Long creditCardNum;

    private String nameOnCard;
    private Date expDate;
    private int cvv;


    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "customer_DL",referencedColumnName ="driverLicenseID")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "manager_SSN",referencedColumnName ="ssn")
    private Manager managers;

    @ManyToOne
    @JoinColumn(name = "salesRep_SSN",referencedColumnName ="ssn")
    private SalesRep salesReps;


    public void setCustomer(Customer myCustomer) {
        this.customers = myCustomer;
    }

    public void setManager(Manager myManager) {
        this.managers = myManager;
    }

    public void setSalesRep(SalesRep mysalesRep) {
        this.salesReps = mysalesRep;
    }


    public CreditCard(){

    }

    public CreditCard(Long creditCardNum, String nameOnCard, Date expDate, int cvv) {
        this.creditCardNum = creditCardNum;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    //Getters and Setters
    public Long getCreditCardNum() {
        return creditCardNum;
    }
    public void setCreditCardNum(Long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }
    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
    public Date getExpDate() {
        return expDate;
    }
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}
