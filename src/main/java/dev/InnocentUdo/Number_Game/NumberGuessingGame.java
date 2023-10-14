package dev.InnocentUdo.Number_Game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playGame();
    }
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowest = 1;
        int highest = 100;
        int maxAttempts = 5;
        int guess = 0;
        int RAND = random.nextInt(highest - lowest + 1) + lowest;


        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowest + " and " + highest + ". Try to guess it.");

        while (guess < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < lowest || userGuess > highest) {
                System.out.println("Please enter a number between " + lowest + " and " + highest + ".");
            } else if (userGuess < RAND) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > RAND) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the correct number, which is " + RAND + ".");
                break;
            }
            guess++;
        }
        if (guess == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of guess. The correct number was " + RAND + ".");
        }
        scanner.close();
    }
}
