package org.example.workshop2.models;

// Customer class to store customer info- name and phone number.
public class Customer {
    private String name;
    private String phoneNumber;

    // default constructor.
    public Customer(){ }

    // argument constructor.
    public Customer(String name, String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
