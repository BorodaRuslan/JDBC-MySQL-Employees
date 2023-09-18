package org.example.app.views.employees;

import java.util.Scanner;

public class EmployeeCreateView {

    public String[] getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.println("Enter your Birth date format year-month-day: ");
        String birthDate = scanner.nextLine().trim();
        System.out.println("Enter: your position Id: ");
        String  positionId = scanner.nextLine().trim();
        System.out.println("Enter your phone: ");
        String phone = scanner.nextLine().trim();
        System.out.println("Enter your salary: ");
        String salary = scanner.nextLine().trim();
        return new String[]{firstName, lastName, birthDate, positionId, phone, salary};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
