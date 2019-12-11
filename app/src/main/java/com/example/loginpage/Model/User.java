package com.example.loginpage.Model;

public class User {
    private String Contact;
    private String Name;



 public User() {
    }
    public User(String contact, String name) {
        Contact = contact;
        Name = name;

    }

    public String getContact() {

     return Contact;
    }

    public void setContact(String contact) {

        Contact = contact;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

     Name = name;
    }
}