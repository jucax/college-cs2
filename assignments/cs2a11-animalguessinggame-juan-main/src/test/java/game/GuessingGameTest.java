package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This file tests the play method of the GuessingGame, and
 * thus indirectly tests the learn method (which you must write)
 * as well. The testing procedure is very tricky, because it  
 * depends on simulating a prolonged interaction with the program
 * that gradually builds up a large decision tree inside of it.
 * This is accomplished by creating one file that contains all
 * of the input that should be given to the program, and one that
 * contains all of the expected output from the program. This
 * output file is compared to the output actually produced by
 * the program.   
 * 
 * One example test is provided, but you must provide another.
 * Note that the same animal database will be used in both tests.
 * The test that you write will start by loading the database
 * from the first test and proceed to build on it.        
 * 
 * @author Jacob Schrum
 */
class GuessingGameTest {

	public static File inputs1; // User inputs to the program
	public static File correctOutputs1; // Expected outputs from the program
	public static File programOutputs1; // Actual outputs from the program

	public static File inputs2; // User inputs to the program
	public static File correctOutputs2; // Expected outputs from the program
	public static File programOutputs2; // Actual outputs from the program

	// TODO: Create one more set of inputs and the two corresponding output files.

	public static final String DATABASE_FILE = "TestDatabase.txt"; // File to save animal database

	/**
	 * Create files containing sequences of program inputs and expected
	 * sequences of program outputs.
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		File database = new File(DATABASE_FILE);
		if(database.exists()) {
			database.delete(); // Make database start from scratch
		}

		// Create a file with all user inputs during a session
		inputs1 = new File("inputs1.txt");
		// Create a file with all expected program outputs
		correctOutputs1 = new File("correctOutputs1.txt"); 
		// Create a file with all program outputs during a session
		programOutputs1 = new File("programOutputs1.txt");

		// The sequence of inputs needs to be created.
		PrintStream psInputs1 = new PrintStream(inputs1);
		// The program outputs that should be interleaved with the inputs.
		PrintStream psCorrectOutputs1 = new PrintStream(correctOutputs1);

		// Print sequence of data to both input and expected output file
		psCorrectOutputs1.println("Starting new game database: "+DATABASE_FILE);
		psCorrectOutputs1.println("Do you want to play the animal guessing game?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("My guess is Cow. Am I right?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("I win."); 
		psCorrectOutputs1.println("Do you want to play the animal guessing game?"); 
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("My guess is Cow. Am I right?");
		psInputs1.println("no");
		psCorrectOutputs1.println("I give up. What are you?"); 
		psInputs1.println("Tiger");
		psCorrectOutputs1.println("Give a question whose answer is yes for Tiger and no for Cow:"); 
		psInputs1.println("Is it a carnivore?");
		psCorrectOutputs1.println("Do you want to play the animal guessing game?"); 
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is it a carnivore?");
		psInputs1.println("no");
		psCorrectOutputs1.println("My guess is Cow. Am I right?");
		psInputs1.println("no");
		psCorrectOutputs1.println("I give up. What are you?"); 
		psInputs1.println("Whale");
		psCorrectOutputs1.println("Give a question whose answer is yes for Whale and no for Cow:"); 
		psInputs1.println("Does it live in the water?");
		psCorrectOutputs1.println("Do you want to play the animal guessing game?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("no");
		psCorrectOutputs1.println("My guess is Squid. Am I right?");
		psInputs1.println("no");
		psCorrectOutputs1.println("I give up. What are you?"); 
		psInputs1.println("Ant");
		psCorrectOutputs1.println("Give a question whose answer is yes for Ant and no for Squid:"); 
		psInputs1.println("Is it an insect?");
		psCorrectOutputs1.println("Do you want to play the animal guessing game?"); 
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("no");
		psCorrectOutputs1.println("Is it an insect?");
		psInputs1.println("no");
		psCorrectOutputs1.println("My guess is Squid. Am I right?");
		psInputs1.println("no");
		psCorrectOutputs1.println("I give up. What are you?"); 
		psInputs1.println("Crab");
		psCorrectOutputs1.println("Give a question whose answer is yes for Crab and no for Squid:"); 
		psInputs1.println("Does it have claws?");
		psCorrectOutputs1.println("Do you want to play the animal guessing game?"); 
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is the animal a mammal?");
		psInputs1.println("yes");
		psCorrectOutputs1.println("Is it a carnivore?");
		psInputs1.println("no");
		psCorrectOutputs1.println("Does it live in the water?");
		psInputs1.println("no");
		psCorrectOutputs1.println("My guess is Cow. Am I right?");
		psInputs1.println("no");
		psCorrectOutputs1.println("I give up. What are you?"); 
		psInputs1.println("Elephant");
		psCorrectOutputs1.println("Give a question whose answer is yes for Elephant and no for Cow:"); 
		psInputs1.println("Does it have a trunk?");
		psCorrectOutputs1.println("Do you want to play the animal guessing game?"); 
		psInputs1.println("no");
		psCorrectOutputs1.println("Saving file: "+DATABASE_FILE);

		psInputs1.close();
		psCorrectOutputs1.close();

		//TODO: Create other input and output files and fill them with
		//      appropriate contents. This second test should start by
		//      loading the animal database created at the end of the 
		//      first test. The sequence of inputs should build on the
		//      first tree, but should also verify that ALL content in
		//      the tree at the end of the first test was completely loaded
		//      for the second test.

		inputs2 = new File("inputs2.txt");
		correctOutputs2 = new File("correctOutputs2.txt"); 
		programOutputs2 = new File("programOutputs2.txt");

		PrintStream psInputs2 = new PrintStream(inputs2);
		PrintStream psCorrectOutputs2 = new PrintStream(correctOutputs2);

		psCorrectOutputs2.println("Do you want to play the animal guessing game?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is it a carnivore?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Tiger. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Lion");
		psCorrectOutputs2.println("Give a question whose answer is yes for Lion and no for Tiger:"); 
		psInputs2.println("Does it live in a dry climate?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is it a carnivore?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Does it live in a dry climate?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Lion. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Snake");
		psCorrectOutputs2.println("Give a question whose answer is yes for Snake and no for Lion:"); 
		psInputs2.println("Does it live under the sand?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Is it an insect?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Ant. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Butterfly");
		psCorrectOutputs2.println("Give a question whose answer is yes for Butterfly and no for Ant:"); 
		psInputs2.println("Does it fly?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Is it an insect?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Does it fly?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Butterfly. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Mosquito");
		psCorrectOutputs2.println("Give a question whose answer is yes for Mosquito and no for Butterfly:"); 
		psInputs2.println("Does it bite people?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is it a carnivore?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Does it live in the water?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Whale. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Shark");
		psCorrectOutputs2.println("Give a question whose answer is yes for Shark and no for Whale:"); 
		psInputs2.println("Is it very aggressive?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Is it an insect?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Does it have claws?");
		psInputs2.println("no");
		psCorrectOutputs2.println("My guess is Squid. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Cotorro");
		psCorrectOutputs2.println("Give a question whose answer is yes for Cotorro and no for Squid:"); 
		psInputs2.println("Is it a bird?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("yes");
		psCorrectOutputs2.println("Is the animal a mammal?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Is it an insect?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Does it have claws?");
		psInputs2.println("no");
		psCorrectOutputs2.println("Is it a bird?");
		psInputs2.println("yes");
		psCorrectOutputs2.println("My guess is Cotorro. Am I right?");
		psInputs2.println("no");
		psCorrectOutputs2.println("I give up. What are you?"); 
		psInputs2.println("Pigeon");
		psCorrectOutputs2.println("Give a question whose answer is yes for Pigeon and no for Cotorro:"); 
		psInputs2.println("Is it white and gray?");
		psCorrectOutputs2.println("Do you want to play the animal guessing game?"); 
		psInputs2.println("no");
		psCorrectOutputs2.println("Saving file: "+DATABASE_FILE);

		psInputs2.close();
		psCorrectOutputs2.close();
	}

	/**
	 * Delete files when done.
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		inputs1.deleteOnExit();
		correctOutputs1.deleteOnExit();
		programOutputs1.deleteOnExit();

		// TODO: Delete other files containing program input and output.
		inputs2.deleteOnExit();
		correctOutputs2.deleteOnExit();
		programOutputs2.deleteOnExit();

		new File(DATABASE_FILE).deleteOnExit();
	}

	/**
	 * Test play method of game and indirectly test learn method.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	void testPlay() throws FileNotFoundException {
		// File of program inputs
		Scanner console = new Scanner(new FileInputStream(inputs1));
		// File that will contain program outputs
		PrintStream out = new PrintStream(programOutputs1);
		// Client session that uses designated files for input and output
		Client c = new Client(console, out, DATABASE_FILE);
		// Play the game, which fills the program outputs file and the animal database
		c.play(); 
		// Close output file
		out.close(); 
		// Close input source
		console.close();
		// Read the outputs created by the program
		Scanner actualOut = new Scanner(programOutputs1);
		// Read the outputs expected from the program
		Scanner expectedOut = new Scanner(correctOutputs1);

		// Loop while either file has lines left. If one file has more lines
		// than the other, then the call to nextLine will crash the test and
		// it will fail.
		while(expectedOut.hasNextLine() ||  actualOut.hasNextLine()) {
			// Compare the lines from the two files. The trim method removes extra
			// spaces at the end of a line so that this minor issue will not cause
			// the test to fail.
			assertEquals(expectedOut.nextLine().trim(), actualOut.nextLine().trim());
		}

		actualOut.close();
		expectedOut.close();

		// TODO: Play the game with your second input file
		//       and verify the correct output of the Client's
		//       play method.

		Scanner console2 = new Scanner(new FileInputStream(inputs2));
		PrintStream out2 = new PrintStream(programOutputs2);
		c = new Client(console2, out2, DATABASE_FILE);

		c.play(); 
		out2.close(); 
		console2.close();

		Scanner actualOut2 = new Scanner(programOutputs2);
		Scanner expectedOut2 = new Scanner(correctOutputs2);

		while(expectedOut2.hasNextLine() ||  actualOut2.hasNextLine()) {
			assertEquals(expectedOut2.nextLine().trim(), actualOut2.nextLine().trim());
		}

	}

}
