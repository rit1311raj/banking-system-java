
package com.sapient;

import com.sapient.service.accountManagement.Transaction;
import com.sapient.service.user.Login;
import com.sapient.service.user.ProfileUpdate;
import com.sapient.service.user.Register;
import com.sapient.service.user.Menu;
import com.sapient.UserData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class App {
    private Map<String, UserData> data = new HashMap<>();
    public void addUser(String userID, UserData user){
        data.put(userID, user);
    }

    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        int val = scanner.nextInt();
        App app = new App();

        //Dummy data insertion
        //userID, firstName, lastName, age, password, securityPin)

        UserData user1 = new UserData("1", "vivek", "shukla", 22, "vivek", 1234, 500);
        app.addUser("1", user1);

        UserData user2 = new UserData("2", "prince", "kesharwani", 22, "prince", 1234, 500);
        app.addUser("2", user2);

        UserData user3 = new UserData("3", "ritik", "raj", 22, "ritik", 1234, 500);
        app.addUser("3", user3);

        UserData user4 = new UserData("4", "aditya", "chauhan", 22, "aditya", 1234, 500);
        app.addUser("4", user4);

        UserData user5 = new UserData("5", "saloni", "sharma", 22, "saloni", 1234, 500);
        app.addUser("5", user5);

        while(true){
            System.out.println("Welcome to the banking application!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    Register r = new Register(app);
                    r.register();
                    break;
                case 2:
                    Login l = new Login(app);
                    UserData userdata = l.login();
                    if(userdata!=null){
                        ProfileUpdate profileupdate = new ProfileUpdate(userdata, app);
                        Transaction transaction = new Transaction(userdata, app);
                        Menu menu = new Menu(profileupdate, transaction);
                        menu.menu();
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 4 :
                    app.data.forEach((key,val)->{
                        System.out.println(STR."\{key} -> [\{val.getUserID()},\{val.getSecurityPin()},\{val.getAmount()}]");
                    });
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }}

    public void insertUser(String userID, UserData newUser) {

        data.put(userID, newUser);
    }

    public void updateUser(UserData userdata, String userID){
        data.put(userID, userdata);
    }
    public boolean validUser(String userId, String password) {
        UserData user = data.get(userId);
        if(!data.containsKey(userId))
            return false;

        else {
            return user.getPassword().equals(password);
        }
    }

    public boolean checkPresence(String userID){
        return data.containsKey(userID);
    }
    public int getDataSize(){
        return data.size();
    }

    public int getUserSecurityPin(String userID){
        return data.get(userID).getSecurityPin();
    }

    public int getUserAccountBalance(String userID){
        return data.get(userID).getAmount();
    }

    public UserData getUser(String userID){
        return data.get(userID);
    }

}

