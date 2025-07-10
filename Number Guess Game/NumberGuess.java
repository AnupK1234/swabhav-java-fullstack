package com.aurionpro.assignment17_6;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		final int MAX_ATTEMPTS = 5;

		boolean playAgain = true;

		while (playAgain) {
			int targetNumber = rand.nextInt(100) + 1; // Random number between 1 and 100
			int attempts = 0;
			boolean hasWon = false;

			System.out.println("\nA random number between 1 to 100 has been generated.");

			while (attempts < MAX_ATTEMPTS) {
				System.out.print("Guess a number: ");
				int guess;

				guess = sc.nextInt();
				attempts++;

				if (guess == targetNumber) {
					System.out.println("You won: in attempt " + attempts);
					hasWon = true;
					break;
				} else if (guess < targetNumber) {
					System.out.println("Sorry, too low.");
				} else {
					System.out.println("Sorry, too high.");
				}
			}

			if (!hasWon) {
				System.out.println("You've used all " + MAX_ATTEMPTS + " attempts. The number was: " + targetNumber);
			}

			System.out.print("Do you want to play the game again? (yes/no): ");
			sc.nextLine();
			String response = sc.nextLine().trim().toLowerCase();
			playAgain = response.equals("yes");
		}

		System.out.println("Thank you for playing!");
		sc.close();
	}
}
