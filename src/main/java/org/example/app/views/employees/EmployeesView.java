package org.example.app.views.employees;

import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeesView {
    Scanner scanner;

    int option;


    public int chooseOption(){
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        }  catch (InputMismatchException ime){
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu(){
        System.out.println("""
                 __ Employees Menu ___________
                1 - Create a employee
                2 - View employee
                0 - Close the App.
                """);
    }

    public void getOutput (int choice, String output){
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
