
// Reg Number:202412892

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ATM PIN
        int correctPin = 1234;
        int attempts = 0;
        int maxAttempts = 3;
        int pin;
        boolean loggedIn = false;

        // Account balance
        double balance = 1000;

        // Transaction history
        String[] transactions = new String[100];
        int transactionCount = 0;

        // Login system
        while (attempts < maxAttempts) {

            System.out.print("Enter your PIN: ");
            pin = input.nextInt();

            if (pin == correctPin) {
                loggedIn = true;
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN!");

                if (attempts < maxAttempts) {
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Account locked. Too many attempts.");
        } else {

            int choice;

            // Main menu
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. View Transactions");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Your balance is: "
                                + balance);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double deposit = input.nextDouble();

                        if (deposit > 0) {
                            balance += deposit;

                            transactions[transactionCount] = "Deposit: +" + deposit;

                            transactionCount++;

                            System.out.println("Deposit successful!");
                            System.out.println("New balance: "
                                    + balance);
                        } else {
                            System.out.println("Invalid amount!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawal = input.nextDouble();

                        if (withdrawal > 0
                                && withdrawal <= balance) {

                            balance -= withdrawal;

                            transactions[transactionCount] = "Withdrawal: -" + withdrawal;

                            transactionCount++;

                            System.out.println("Withdrawal successful!");
                            System.out.println("New balance: "
                                    + balance);

                        } else {
                            System.out.println(
                                    "Insufficient balance or invalid amount!");
                        }
                        break;

                    case 4:
                        System.out.println("\nTransaction History:");

                        if (transactionCount == 0) {
                            System.out.println("No transactions yet.");
                        } else {
                            for (int i = 0; i < transactionCount; i++) {

                                System.out.println(
                                        (i + 1) + ". "
                                                + transactions[i]);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for using ATM!");
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

            } while (choice != 5);
        }

        input.close();
    }
}
