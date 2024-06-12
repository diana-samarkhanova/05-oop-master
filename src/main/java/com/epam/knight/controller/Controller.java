package com.epam.knight.controller;
import java.util.Scanner;
public class Controller {
    private final Scanner scanner;

    public Controller() {
        this.scanner = new Scanner(System.in);
    }
    public int getNumberFromUser(int first, int last) {
        int numFromUser = 0;
        boolean userEnterInteger = false;

        do {

            if (scanner.hasNextInt()) {
                numFromUser = scanner.nextInt();
                if (numFromUser >= first && numFromUser <= last) {
                    userEnterInteger = true;
                } else {
                    System.out.println("Number out of range. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        } while (!userEnterInteger);
        return numFromUser;
    }
}
