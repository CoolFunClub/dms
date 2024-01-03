package com.coolfunclub.dms.model;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
 /* @Id

 /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long  mPersonID; //PK      */
    //@Id
    @Column(name = "firstName")
    protected String firstName;
    @Column(name = "lastName")
    protected String lastName;
    @Column(name = "dateBirth")
    protected String dateBirth;
    @Column(name = "gender")
    protected String gender;
    @Column(name = "phone")
    protected long phone;
    @Column(name = "email")
    protected String email;
    @Column(name = "address")
    protected String address;

/*
/*
    public void setId(Long mPersonID){
        this.mPersonID = mPersonID;
    }   */


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 /*   // Get methods
 /*   // Get methods
    public Long getpersonID() {
        return mPersonID;
    } */


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
