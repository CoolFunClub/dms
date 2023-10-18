package com.coolfunclub.dms.model;

//import jakarta.persistence.PrimaryKeyJoinColumn;

import jakarta.persistence.Entity;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//@PrimaryKeyJoinColumn(name = "mPersonID")

@Entity
public class Customer extends Person{
   
    private String mDriverLicenseID;

   /* @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;  ------ To Be Deleted*/

    // Constructor

    public Customer(String firstName, String lastName, String dob, String gender,
                    String phone, String email, String address, String driverLicenseID) {
        super(firstName, lastName, dob, gender, phone, email, address);
        this.mDriverLicenseID = driverLicenseID;
    }


    // Getters and setters for driver license ID
    public String getDriverLicenseID() {
        return mDriverLicenseID;
    }

    public void setDriverLicenseID(String driverLicenseID) {
        this.mDriverLicenseID = driverLicenseID;
    }

    /* // Method to set customer information-**
    public void setCustomerInformation(String personID, String firstName, String lastName, String dob, String gender,
                                        String phone, String email, String address, String driverLicenseID) {
        //super.setSSN(personID);
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setDateBirth(dob);
        super.setGender(gender);
        super.setPhone(phone);
        super.setEmail(email);
        super.setAddress(address);
        this.mDriverLicenseID = driverLicenseID;
    } */
}
