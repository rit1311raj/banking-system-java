package com.sapient.service.user;
import java.util.*;
import com.sapient.UserData;

import java.util.HashMap;
import java.util.Scanner;
import com.sapient.App;
//import com.sapient.
public class Register{
    private App app;

    public Register() {
    }

    public Register(App app) {
        this.app = app;
    }

    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your details");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter userID: ");
        String userID = scanner.next();


        System.out.print("Enter your password: ");
        String password = scanner.next();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.next();

        System.out.print("Enter Security Pin: ");
        int securityPin = scanner.nextInt();

        System.out.print("Enter the amount you want to submit: ");
        int amount = scanner.nextInt();

        if(app.getDataSize()>0){
            if(!app.checkPresence(userID)){
                if(password.equals(confirmPassword)){
                    UserData newUser = new UserData(userID, firstName, lastName, age, password, securityPin, amount);

                    app.insertUser(userID, newUser);
                    System.out.println("Account created successfully");
                }
                else{
                    System.out.println("Password is not matching");
                }
            }
            else{
                System.out.println("User already exists");
            }
        }
    }
}