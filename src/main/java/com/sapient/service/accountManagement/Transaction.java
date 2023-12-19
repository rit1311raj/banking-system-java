
package com.sapient.service.accountManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.sapient.App;
import com.sapient.UserData;
import static java.lang.StringTemplate.STR;

public class Transaction {
    private App app;
    Scanner scanner = new Scanner(System.in);
    private UserData userData;
    public Transaction(UserData userData, App app){
        this.userData = userData;
        this.app = app;
    }


    public void transaction() {
        System.out.println("Transactions:");

        System.out.println("Enter receiver's userID: ");
        String receiverUserID = scanner.nextLine();

        if (app.checkPresence(receiverUserID)) {

            System.out.print("Enter your security pin: ");
            int inputSecurityPin = scanner.nextInt();

            if(inputSecurityPin == userData.getSecurityPin()){
//                System.out.print("Enter the amount you want to send: ");
                int transactionAmount = getValidTransactionAmount();
                if(transactionAmount>userData.getAmount()){
                    System.out.println("Insufficient balance");
                }
                else{
                    userData.setAmount(userData.getAmount()-transactionAmount);
                    UserData receiver = app.getUser(receiverUserID);
                    receiver.setAmount(receiver.getAmount()+transactionAmount);
                    app.addUser(receiverUserID,receiver);
                    app.addUser(userData.getUserID(), userData);
                    System.out.println(STR."\{transactionAmount} has been transferred successfully");
                }
            }

            else{
                System.out.println("Entered security pin is incorrect. Transaction aborted.");
            }
        }
        else{
            System.out.println("This user does not exist in bank.");
        }
    }
    private int getValidTransactionAmount() {
        int transactionAmount = -1;

        while (transactionAmount <= 0) {
            System.out.println("Enter the transaction Amount: ");
            transactionAmount = scanner.nextInt();

            if (transactionAmount <= 0) {
                System.out.println("Please enter a valid positive transaction amount.");
            }
        }
        return transactionAmount;
    }
}
