package game;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import bag.*;

/**
 * This is a skeleton of code for a guessing game
 * that uses a bag. The bag is filled with random      
 * integers, and the user repeatedly tries to guess
 * what those numbers are. There are some utility         
 * methods to help you, but you should write additional
 * methods to organize your code.        
 * 
 * @author Jacob Schrum
 */
public class Guess {
	
	// ONLY use this Random number generator to fill your bag with random numbers.
	public static Random RAND = new Random();           
	
	/**
	 * Create a Scanner and play the game as long as the user
	 * answers "yes" to the main prompt.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (yesTo("Do you want to play the guessing game?", console)){
			// Starting new game
			int largest = positiveInt("What is the largest number that can be in the bag?",console);
			int numItems = positiveInt("How many items are in the bag?",console);
			

			BagInterface<Integer> randomBag = getRandomBag(numItems,largest);

			// TODO: Print out some more messages
			do {
				System.out.println("Try to guess the numbers in the bag.");
				System.out.println("There are " + numItems + " numbers from 1 to " + largest + ".");

				int numberGuessesCorrect = getCorrectGuesses(randomBag, numItems, console);

				if (isItCorrect(numItems, numberGuessesCorrect)) break;
			} while (true);
		}
	}

	// TODO: Other methods that break the problem into pieces for playing the game.
	/**
	 * Helper method that iterates through each item asking the 
	 * user for guesses of the items inside the bag with the 
	 * characteristics especified, it analize the guesses and 
	 * return the number of correct guesses.
	 * 
	 * @param randomBag The bag with the random Integers that the user specified
	 * @param numItems Number of items that were added to the bag
	 * @param console A scanner of the console
	 * @return An int with the correct guesses that the user did
	 */
	private static int getCorrectGuesses(BagInterface<Integer> randomBag, int numItems, Scanner console) {
		int numberGuessesCorrect = 0;

		for (int counter = 1 ; counter <= numItems ; counter ++) {
			System.out.print("Guess for item #" + counter + ": ");
			int guess = console.nextInt();
			if (randomBag.contains(guess)){
				numberGuessesCorrect++;
			}
		}

		return numberGuessesCorrect;
	}

	/**
	 * Helper method that provides feedback and checks if the user 
	 * guessed all the items comparing the number of correct guesses
	 * and the total number of items inside the bag.
	 * 
	 * @param numItems Number of items that were added to the bag
	 * @param numberGuessesCorrect Number of guesses that the user had correct
	 * @return True if the user guessed all the items, false otherwise
	 */
	private static boolean isItCorrect (int numItems, int numberGuessesCorrect) {
		if (numberGuessesCorrect == numItems){
			System.out.println("You are correct!");
			return true;
		} 

		System.out.println(numberGuessesCorrect + " of your guesses are correct. Guess again.");
		return false;
	}

	/**
	 * Helper method that creates a new bag with the especified 
	 * quantity of random Integers within the range also especified.
	 * 
	 * @param numItems Number of items to add to the bag
	 * @param largest Largest possible value of item in the bag
	 * @return Bag of numItems random integers in range 1 to largest (inclusive)
	 */
	private static BagInterface<Integer> getRandomBag(int numItems, int largest) {
		BagInterface<Integer> randomBag = new ArrayBag<>(numItems);
		for(int i = 0; i < numItems; i++) {
			int value = RAND.nextInt(largest) + 1;
			randomBag.add(value);
		}
		return randomBag;
	}

	/**
	 * Utility function that prompts the user to enter
	 * a single positive integer, which is then returned.
	 * Invalid responses cause the prompt to repeat until
	 * the user provides correct input. Do not change this
	 * method.
	 * 
	 * @param prompt text of the question prompt
	 * @param console a Scanner of the console
	 * @return positive integer entered by user
	 */
	public static int positiveInt(String prompt, Scanner console) {
		for(;;) {
			System.out.print(prompt + " ");
			if(console.hasNextInt()) {
				int input = console.nextInt();
				if(input > 0) {
					return input;
				}
			} else {
				// Discard non-integer token
				console.next();
			}
			System.out.println("Please answer with a positive integer.");
		}
	}

	/**
	 * Utility function to ask user yes or no.
	 * No modifications are necessary for this method.
	 * It uses a forever loop -- but the loop stops when something is returned.
	 * 
	 * @param prompt text of the question prompt
	 * @param console a Scanner of the console
	 * @return true if y is entered, false if n is entered
	 */
	public static boolean yesTo(String prompt, Scanner console) {
		for (;;) {
			System.out.print(prompt + " (y/n)? ");
			String response = console.next().trim().toLowerCase();
			if (response.equals("y"))
				return true;
			else if (response.equals("n"))
				return false;
			else
				System.out.println("Please answer y or n.");
		}
	}
}