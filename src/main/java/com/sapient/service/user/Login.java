package com.sapient.service.user;

import com.sapient.App;
import com.sapient.UserData;


import java.util.Scanner;

public class Login {

    //New
    private UserData userData;
    private App app;
    public Login(App app) {
        this.app = app;
    }
    Scanner scanner = new Scanner(System.in);


    public Login(){

    }

    public UserData  login(){

        System.out.println("Enter UserId");
        String userId = scanner.next();

        System.out.println("Enter Password");
        String password = scanner.next();

        if(app.validUser(userId, password)){
            System.out.println("Login successful");
            return app.getUser(userId);
        }
        else {
            System.out.println("Invalid credentials");
            return null;
        }
    }
}