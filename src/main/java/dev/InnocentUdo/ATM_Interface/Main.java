package dev.InnocentUdo.ATM_Interface;

import dev.InnocentUdo.ATM_Interface.Services.ATM_ServiceImpl.ATM_ServiceImpl;
import dev.InnocentUdo.ATM_Interface.Services.ATM_Services;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM_Services atmServices = new ATM_ServiceImpl();
        int correctATMNumber = 123456789;
        int correctATMPin = 1234;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");

        System.out.print("Enter ATM Number: ");
        int atmNumber = input.nextInt();
        System.out.print("Enter PIN: ");
        int pin = input.nextInt();

        if (atmNumber == correctATMNumber && pin == correctATMPin) {
            while (true) {
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        atmServices.viewBalance();
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        atmServices.withdrawAmount(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = input.nextDouble();
                        atmServices.depositAmount(depositAmount);
                        break;

                    case 4:
                        atmServices.viewMiniStatement();
                        break;

                    case 5:
                        System.out.println("Collect your ATM Card");
                        System.out.println("Thank you for using ATM Machine!!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please enter a correct choice.");
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN.");
            System.exit(0);
        }
    }
}

