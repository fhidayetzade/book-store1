package springdata.bookstore1.services;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        System.out.print("Enter a number: ");
        boolean valid = false;

        while (!valid) {

            try {
                number = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        System.out.println("You entered the number: " + number);
        scanner.close();
    }
}
