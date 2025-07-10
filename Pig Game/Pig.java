package com.aurionpro.assignment17_6;

import java.util.Random;
import java.util.Scanner;

public class Pig {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		final int GOAL = 20;
		int totalScore = 0;
		int turnCount = 0;

		System.out.println("Let's Play PIG!");
		System.out.println("* See how many turns it takes you to get to " + GOAL + ".");
		System.out.println("* Turn ends when you hold or roll a 1.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* If you hold, you save all points for the turn.\n");

		while (totalScore < GOAL) {
			turnCount++;
			int turnScore = 0;
			boolean turnOver = false;

			System.out.println("TURN " + turnCount);

			while (!turnOver) {
				System.out.print("Roll or hold? (r/h): ");
				String input = sc.nextLine().trim().toLowerCase();

				if (input.equals("r")) {
					int die = rand.nextInt(6) + 1;
					System.out.println("Die: " + die);

					if (die == 1) {
						System.out.println("Turn over. No score.\n");
						turnScore = 0;
						turnOver = true;
					} else {
						turnScore += die;
					}

				} else if (input.equals("h")) {
					System.out.println("Score for turn: " + turnScore);
					totalScore += turnScore;
					System.out.println("Total score: " + totalScore + "\n");
					turnOver = true;
				} else {
					System.out.println("Invalid input! Please type 'r' to roll or 'h' to hold.");
				}
			}
		}

		System.out.println("You finished in " + turnCount + " turns!");
		System.out.println("Game over!");
		sc.close();
	}
}
