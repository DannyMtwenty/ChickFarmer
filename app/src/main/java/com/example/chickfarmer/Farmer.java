package com.example.chickfarmer;

public class Farmer{
    private int id;
    private String FirstName,LastName, Age, Contacts,Username,Password;

    public Farmer(int id, String FirstName, String LastName, String Age, String Contacts, String Username, String Password) {
        this.id=id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Age=Age;
        this.Contacts=Contacts;
        this.Username=Username;
        this.Password=Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName= LastName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age =Age;
    }

    public String getContacts() {
        return Contacts;
    }

    public void setContacts(String Contacts) {
        this.Contacts= Contacts;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String  Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age='" + Age + '\'' +
                ", Contacts='" + Contacts + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
