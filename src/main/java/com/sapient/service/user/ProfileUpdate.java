package com.sapient.service.user;
import java.util.Scanner;
import com.sapient.App;
import com.sapient.UserData;

public class ProfileUpdate {
    private UserData userData;
    private App app;

    Scanner scanner = new Scanner(System.in);


    public ProfileUpdate(UserData userData, App app) {
        this.userData = userData;
        this.app = app;
    }


    public void profileUpdate(){
//        String currUserID = userData.getUserID();
//        System.out.print("Enter your userID to proceed: ");
//        String userID = scanner.nextLine();

        System.out.print("Enter new security pin: ");
        int newPin = scanner.nextInt();

        System.out.print("Confirm new security pin: ");
        int confirmNewPin = scanner.nextInt();

        if(newPin == confirmNewPin){
            userData.setSecurityPin(newPin);
            System.out.println("Security Pin updated successfully");
        }
        else{
            System.out.println("Security Pin is not matching.");
        }
        app.updateUser(userData, userData.getUserID());
    }
}
