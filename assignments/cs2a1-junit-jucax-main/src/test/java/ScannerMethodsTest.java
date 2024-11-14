import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class has tests for the methods
 * in ScannerMethods. Those methods
 * must pass the tests in this class, some
 * of which must be written by you.
 * 
 * NOTE: Your tests must use the declared fileScanner
 *       as well as String Scanners which you define.
 * 
 * @author Jacob Schrum
 */
class ScannerMethodsTest {

	/**
	 * A file that will be created to test Scanner methods.
	 * The file should contain at least 10 lines that have
	 * a variety of different types of data. Test a broad
	 * range of possibilities.
	 */
	public static File file;
	public static Scanner fileScanner;

	// TODO: Define more lines of text.
	public static final String LINE1 = "This is the first line of text";
	public static final String LINE2 = "This is @n0ther l&n3 0f C0d 3";
	public static final String LINE3 = "Line with numbers 5132 13421 009543";
	public static final String LINE4 = "OneLineWithoutSpaces";

	/**
	 * 5 points
	 * 
	 * Create a file for a Scanner to read from.
	 * Code is executed before any tests are run.
	 * 
	 * @throws FileNotFoundException Problem creating file
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		file = new File("temp.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.println(LINE1);
		pw.println(LINE2);
		pw.println(LINE3);
		pw.println(LINE4);

		// TODO: Write more lines defined in static final String variables above
		pw.close();
	}

	/**
	 * Delete the file created for the Scanner tests.
	 * Code is executed after all tests in this class.
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		file.delete();
	}

	/**
	 * Create file scanner before each test.
	 * 
	 * @throws FileNotFoundException problem reading file.
	 */
	@BeforeEach
	void setUp() throws Exception {
		fileScanner = new Scanner(file);
	}

	/**
	 * Close file scanner after each test
	 */
	@AfterEach
	void tearDown() throws Exception {
		fileScanner.close();
	}

	/**
	 * 5 points
	 */
	@Test
	void testFirstInt() {
		assertEquals(7, ScannerMethods.firstInt(new Scanner("This string has a 7 in it.")));
		assertEquals(5, ScannerMethods.firstInt(new Scanner("The numbers are 5 , 7 , 10")));
		assertEquals(32424, ScannerMethods.firstInt(new Scanner("Here 32424 is a big number")));
		assertEquals(5132, ScannerMethods.firstInt(new Scanner(LINE3)));
		assertEquals(3, ScannerMethods.firstInt(fileScanner));
		// TODO: At least 4 more tests. Be sure to cover a broad range of input/output possibilities.
		//       Use both the fileScanner and newly declared String Scanners.

		// Verify that an exception occurs
		assertThrows(IllegalArgumentException.class, () -> {
			ScannerMethods.firstInt(new Scanner("No numbers here"));
		});		
		assertThrows(IllegalArgumentException.class, () -> {
			ScannerMethods.firstInt(new Scanner("Numb3ers but n0 in indiv1dual t0k3ns"));
		});	

		// TODO: One more test that checks for the IllegalArgumentException
	}

	/**
	 * 5 points
	 */
	@Test
	void testCountTokens() {
		assertEquals(7, ScannerMethods.countTokens(new Scanner("Here are seven tokens in a string")));
		assertEquals(4, ScannerMethods.countTokens(new Scanner("This string has 4")));
		assertEquals(1, ScannerMethods.countTokens(new Scanner("HereThereIsOneToken")));
		assertEquals(7, ScannerMethods.countTokens(new Scanner("Here we have 4 5 6 tokens")));
		assertEquals(1, ScannerMethods.countTokens(new Scanner(LINE4)));
		assertEquals(21, ScannerMethods.countTokens(fileScanner));

		// TODO: At least 5 more tests. Be sure to cover a broad range of input/output possibilities.
		//       Use both the fileScanner and newly declared String Scanners.
	}

	/**
	 * 4 points
	 */
	@Test
	void testCountLines() {
		assertEquals(3, ScannerMethods.countLines(new Scanner("Each line is separated by newline characters\nBackslash n is a special escape sequence\nCool, huh?")));
		assertEquals(5, ScannerMethods.countLines(new Scanner("This line is 1\nThis is 2\nThis 3\nThis 4\nThis5")));
		assertEquals(4, ScannerMethods.countLines(fileScanner));

		// TODO: At least 2 more tests. Make one test that reads from the fileScanner, 
		//       and another test that reads from a String Scanner with carriage returns.
	}

	/**
	 * 5 points
	 */
	@Test
	void testGetLines() {
		ArrayList<String> lines = ScannerMethods.getLines(fileScanner);
		ArrayList<String> expected = new ArrayList<>();
		expected.add(LINE1);
		expected.add(LINE2);
		expected.add(LINE3);
		expected.add(LINE4);
		// TODO: Fill an ArrayList up with the remaining correct lines
		assertEquals(expected,lines);

		ArrayList<String> lines2 = ScannerMethods.getLines(new Scanner(LINE1));
		ArrayList<String> expected2 = new ArrayList<>();
		expected2.add(LINE1);

		assertEquals(expected2,lines2);
	}

}
