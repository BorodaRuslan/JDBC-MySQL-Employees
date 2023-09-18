package org.example.app.views.positions;

import java.util.Scanner;

public class PositionCreateView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position name: ");
        String position = scanner.nextLine().trim();
        return new String[]{position};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
