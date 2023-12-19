
package com.sapient;

import java.util.HashMap;

//user getters and setters method in this class. To update the new user, call the setters from
//Register.java, create a storage in UserData.java and set those values.
public class UserData {


    private String firstName;
    private String lastName;
    private int age;
    private String userID;
    private String password;
    private int securityPin;
    private int amount;

    public UserData(){}

    public UserData(String userID, String firstName, String lastName, int age, String password, int securityPin, int amount) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.securityPin = securityPin;
        this.amount = amount;

        //UserData u = new UserData(userID, firstName, lastName, age, password, securityPin);

        //data.put(userID, u);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setSecurityPin(int securityPin) {
        this.securityPin = securityPin;
    }

    public String getUserID() {
        return userID;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSecurityPin() {
        return securityPin;
    }
}

