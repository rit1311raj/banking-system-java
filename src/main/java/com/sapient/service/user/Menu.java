package com.sapient.service.user;
import java.util.Scanner;

import com.sapient.UserData;
import com.sapient.service.accountManagement.Transaction;
import com.sapient.service.user.ProfileUpdate;
public class Menu {
    private ProfileUpdate profile;
    private Transaction transact;

    Scanner scanner = new Scanner(System.in);
    public Menu() {}

    public Menu(ProfileUpdate profileUpdate, Transaction transact) {
        this.profile = profileUpdate;
        this.transact = transact;
    }



    public void menu() {
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Transaction");
            System.out.println("2. Update Profile");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transact.transaction();
                    break;
                case 2:
                    profile.profileUpdate();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid entry. Please enter a valid number: ");
            }
        }
    }
}
