package scheduler;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests the process scheduler simulation.
 * Two example input files are created and                         
 * the resulting output files are checked for
 * correct contents. You must add more tests
 * to complete this class.
 * 
 * @author Jacob Schrum
 */
class SchedulerTest {

	// Inputs for first test case
	public static final String INPUT_NAME1 = "InputExample1.txt";
	public static final int TIMEOUT1 = 50;
	public static final String OUTPUT_NAME1 = "ExpectedOutput1.txt";

	public static final String INPUT_NAME2 = "InputExample2.txt";
	public static final int TIMEOUT2 = 100;            
	public static final String OUTPUT_NAME2 = "ExpectedOutput2.txt";

	public static final String INPUT_NAME3 = "InputExample3.txt";
	public static final int TIMEOUT3 = 10;            
	public static final String OUTPUT_NAME3 = "ExpectedOutput3.txt";

	public static final String INPUT_NAME4 = "InputExample4.txt";
	public static final int TIMEOUT4 = 20;            
	public static final String OUTPUT_NAME4 = "ExpectedOutput4.txt";

	public static final String INPUT_NAME5 = "InputExample5.txt";
	public static final int TIMEOUT5 = 100;            
	public static final String OUTPUT_NAME5 = "ExpectedOutput5.txt";

	public static final String INPUT_NAME6 = "InputExample6.txt";
	public static final int TIMEOUT6 = 400;            
	public static final String OUTPUT_NAME6 = "ExpectedOutput6.txt";

	public static final String INPUT_NAME7 = "InputExample7.txt";
	public static final int TIMEOUT7 = 500;            
	public static final String OUTPUT_NAME7 = "ExpectedOutput7.txt";

	/**
	 * This setup method creates several input files
	 * for use with the simulator. They must all be               
	 * validly formatted. Two are provided by me, and more
	 * must be provided by you.
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		PrintStream ps1 = new PrintStream(new File(INPUT_NAME1));
		ps1.println("0      50   First");
		ps1.println("0      100  Second");
		ps1.println("0      50   Third");
		ps1.close();

		PrintStream ps2 = new PrintStream(new File(INPUT_NAME2));
		ps2.println("0      100  Initialization");
		ps2.println("0      200  Background service");
		ps2.println("10     150  Compiler");
		ps2.println("600    300  Virus scan");
		ps2.println("600    10   Quick process");
		ps2.println("610    150  Browser");
		ps2.println("1630   400  Movie clip");
		ps2.println("1890   350  Email");
		ps2.println("2100   100  Data processing");
		ps2.close();

		// TODO: Create five more validly formatted input files for testing.
		//       Three can be small, simple cases. The other two must be 
		//       sufficiently larger than my second example above.
		//       Your collection of tests must cover a wide range of 
		//       interesting cases.

		PrintStream ps3 = new PrintStream(new File(INPUT_NAME3));
		ps3.println("0     15   TaskX");
		ps3.println("15    25   TaskY");
		ps3.println("40    10   TaskZ");
		ps3.close();

		PrintStream ps4 = new PrintStream(new File(INPUT_NAME4));
		ps4.println("0    70   Start");
		ps4.println("70   40   MiddleUpper");
		ps4.println("110  50   Middle");
		ps4.println("160  30   MiddleLower");
		ps4.println("220  60   End");
		ps4.close();

		PrintStream ps5 = new PrintStream(new File(INPUT_NAME5));
		ps5.println("0     80    FirstTask");
		ps5.println("80    40    SecondTask");
		ps5.println("120   30    ThirdTask");
		ps5.println("200   50    FourthTask");
		ps5.close();

		PrintStream ps6 = new PrintStream(new File(INPUT_NAME6));
		ps6.println("0       300   Title Screen");
		ps6.println("500     1500  Level 1 - Introduction");
		ps6.println("2200    800   Level 2 - Challenges Begin");
		ps6.println("3500    1200  Level 3 - Boss Fight");
		ps6.println("4900    1000  Level 4 - Exploration");
		ps6.println("6100    1500  Level 5 - Final Showdown");
		ps6.println("7800    200   Credits");
		ps6.close();

		PrintStream ps7 = new PrintStream(new File(INPUT_NAME7));
		ps7.println("0       1000  Launching Photoshop");
		ps7.println("1200    600   Opening Project");
		ps7.println("2000    2000  Designing Logo");
		ps7.println("4500    800   Editing Photos");
		ps7.println("5700    1500  Applying Filters");
		ps7.println("7500    300   Exporting Images");
		ps7.println("7900    1000  Saving Changes");
		ps7.close();

	}

	/**
	 * After testing, all input files and output files must be deleted.
	 * 
	 * @throws Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		new File(INPUT_NAME1).delete();
		new File(OUTPUT_NAME1).delete();

		new File(INPUT_NAME2).delete();
		new File(OUTPUT_NAME2).delete();

		// TODO: Delete files created for your other tests.
		new File(INPUT_NAME3).delete();
		new File(OUTPUT_NAME3).delete();

		new File(INPUT_NAME4).delete();
		new File(OUTPUT_NAME4).delete();

		new File(INPUT_NAME5).delete();
		new File(OUTPUT_NAME5).delete();

		new File(INPUT_NAME6).delete();
		new File(OUTPUT_NAME6).delete();

		new File(INPUT_NAME7).delete();
		new File(OUTPUT_NAME7).delete();

	}

	/**
	 * Test the simulateProcessor method of the Scheduler class
	 * with each of the test files you create.
	 * 
	 * @throws FileNotFoundException If input or output files
	 *                               are not found/created.
	 */
	@Test
	void testSimulateProcessor() throws FileNotFoundException {
		// Simulate scheduler and processor
		Scheduler.simulateProcessor(INPUT_NAME1, OUTPUT_NAME1, TIMEOUT1);
		Scheduler.simulateProcessor(INPUT_NAME2, OUTPUT_NAME2, TIMEOUT2);
		// TODO: Run with all of your input files and timeout values.
		//       Be sure to perform tests with different timeout values
		//       on the same input file.

		Scheduler.simulateProcessor(INPUT_NAME3, OUTPUT_NAME3, TIMEOUT3);
		Scheduler.simulateProcessor(INPUT_NAME4, OUTPUT_NAME4, TIMEOUT4);
		Scheduler.simulateProcessor(INPUT_NAME5, OUTPUT_NAME5, TIMEOUT5);
		Scheduler.simulateProcessor(INPUT_NAME6, OUTPUT_NAME6, TIMEOUT6);
		Scheduler.simulateProcessor(INPUT_NAME7, OUTPUT_NAME7, TIMEOUT7);

		// Reads the output file and verifies correct contents of each line
		Scanner scan1 = new Scanner(new File(OUTPUT_NAME1));
		assertEquals("At time 0: run \"First\" for 50 time units", scan1.nextLine());
		assertEquals("At time 50: run \"Second\" for 50 time units", scan1.nextLine());
		assertEquals("At time 100: run \"Third\" for 50 time units", scan1.nextLine());
		assertEquals("At time 150: run \"Second\" for 50 time units", scan1.nextLine());
		scan1.close(); // close file after reading

		Scanner scan2 = new Scanner(new File(OUTPUT_NAME2));
		assertEquals("At time 0: run \"Initialization\" for 100 time units", scan2.nextLine());
		assertEquals("At time 100: run \"Background service\" for 100 time units", scan2.nextLine());
		assertEquals("At time 200: run \"Compiler\" for 100 time units", scan2.nextLine());
		assertEquals("At time 300: run \"Background service\" for 100 time units", scan2.nextLine());
		assertEquals("At time 400: run \"Compiler\" for 50 time units", scan2.nextLine());
		assertEquals("CPU idle from time 450 until time 600", scan2.nextLine());
		assertEquals("At time 600: run \"Virus scan\" for 100 time units", scan2.nextLine());
		assertEquals("At time 700: run \"Quick process\" for 10 time units", scan2.nextLine());
		assertEquals("At time 710: run \"Browser\" for 100 time units", scan2.nextLine());
		assertEquals("At time 810: run \"Virus scan\" for 100 time units", scan2.nextLine());
		assertEquals("At time 910: run \"Browser\" for 50 time units", scan2.nextLine());
		assertEquals("At time 960: run \"Virus scan\" for 100 time units", scan2.nextLine());
		assertEquals("CPU idle from time 1060 until time 1630", scan2.nextLine());
		assertEquals("At time 1630: run \"Movie clip\" for 100 time units", scan2.nextLine());
		assertEquals("At time 1730: run \"Movie clip\" for 100 time units", scan2.nextLine());
		assertEquals("At time 1830: run \"Movie clip\" for 100 time units", scan2.nextLine());
		assertEquals("At time 1930: run \"Email\" for 100 time units", scan2.nextLine());
		assertEquals("At time 2030: run \"Movie clip\" for 100 time units", scan2.nextLine());
		assertEquals("At time 2130: run \"Email\" for 100 time units", scan2.nextLine());
		assertEquals("At time 2230: run \"Data processing\" for 100 time units", scan2.nextLine());
		assertEquals("At time 2330: run \"Email\" for 100 time units", scan2.nextLine());
		assertEquals("At time 2430: run \"Email\" for 50 time units", scan2.nextLine());
		scan2.close(); // close file after reading

		// TODO: Verify correct contents of all output files you create.
		Scanner scan3 = new Scanner(new File(OUTPUT_NAME3));
		assertEquals("At time 0: run \"TaskX\" for 10 time units", scan3.nextLine());
		assertEquals("At time 10: run \"TaskX\" for 5 time units", scan3.nextLine());
		assertEquals("At time 15: run \"TaskY\" for 10 time units", scan3.nextLine());
		assertEquals("At time 25: run \"TaskY\" for 10 time units", scan3.nextLine());
		assertEquals("At time 35: run \"TaskY\" for 5 time units", scan3.nextLine());
		assertEquals("At time 40: run \"TaskZ\" for 10 time units", scan3.nextLine());
		scan3.close();

		Scanner scan4 = new Scanner(new File(OUTPUT_NAME4));
		assertEquals("At time 0: run \"Start\" for 20 time units", scan4.nextLine());
		assertEquals("At time 20: run \"Start\" for 20 time units", scan4.nextLine());
		assertEquals("At time 40: run \"Start\" for 20 time units", scan4.nextLine());
		assertEquals("At time 60: run \"Start\" for 10 time units", scan4.nextLine());
		assertEquals("At time 70: run \"MiddleUpper\" for 20 time units", scan4.nextLine());
		assertEquals("At time 90: run \"MiddleUpper\" for 20 time units", scan4.nextLine());
		assertEquals("At time 110: run \"Middle\" for 20 time units", scan4.nextLine());
		assertEquals("At time 130: run \"Middle\" for 20 time units", scan4.nextLine());
		assertEquals("At time 150: run \"Middle\" for 10 time units", scan4.nextLine());
		assertEquals("At time 160: run \"MiddleLower\" for 20 time units", scan4.nextLine());
		assertEquals("At time 180: run \"MiddleLower\" for 10 time units", scan4.nextLine());
		assertEquals("CPU idle from time 190 until time 220", scan4.nextLine());
		assertEquals("At time 220: run \"End\" for 20 time units", scan4.nextLine());
		assertEquals("At time 240: run \"End\" for 20 time units", scan4.nextLine());
		assertEquals("At time 260: run \"End\" for 20 time units", scan4.nextLine());
		scan4.close();

		Scanner scan5 = new Scanner(new File(OUTPUT_NAME5));
		assertEquals("At time 0: run \"FirstTask\" for 80 time units", scan5.nextLine());
		assertEquals("At time 80: run \"SecondTask\" for 40 time units", scan5.nextLine());
		assertEquals("At time 120: run \"ThirdTask\" for 30 time units", scan5.nextLine());
		assertEquals("CPU idle from time 150 until time 200", scan5.nextLine());
		assertEquals("At time 200: run \"FourthTask\" for 50 time units", scan5.nextLine());
		scan5.close();

		Scanner scan6 = new Scanner(new File(OUTPUT_NAME6));
		assertEquals("At time 0: run \"Title Screen\" for 300 time units", scan6.nextLine());
		assertEquals("CPU idle from time 300 until time 500", scan6.nextLine());
		assertEquals("At time 500: run \"Level 1 - Introduction\" for 400 time units", scan6.nextLine());
		assertEquals("At time 900: run \"Level 1 - Introduction\" for 400 time units", scan6.nextLine());
		assertEquals("At time 1300: run \"Level 1 - Introduction\" for 400 time units", scan6.nextLine());
		assertEquals("At time 1700: run \"Level 1 - Introduction\" for 300 time units", scan6.nextLine());
		assertEquals("CPU idle from time 2000 until time 2200", scan6.nextLine());
		assertEquals("At time 2200: run \"Level 2 - Challenges Begin\" for 400 time units", scan6.nextLine());
		assertEquals("At time 2600: run \"Level 2 - Challenges Begin\" for 400 time units", scan6.nextLine());
		assertEquals("CPU idle from time 3000 until time 3500", scan6.nextLine());
		assertEquals("At time 3500: run \"Level 3 - Boss Fight\" for 400 time units", scan6.nextLine());
		assertEquals("At time 3900: run \"Level 3 - Boss Fight\" for 400 time units", scan6.nextLine());
		assertEquals("At time 4300: run \"Level 3 - Boss Fight\" for 400 time units", scan6.nextLine());
		assertEquals("CPU idle from time 4700 until time 4900", scan6.nextLine());
		assertEquals("At time 4900: run \"Level 4 - Exploration\" for 400 time units", scan6.nextLine());
		assertEquals("At time 5300: run \"Level 4 - Exploration\" for 400 time units", scan6.nextLine());
		assertEquals("At time 5700: run \"Level 4 - Exploration\" for 200 time units", scan6.nextLine());
		assertEquals("CPU idle from time 5900 until time 6100", scan6.nextLine());
		assertEquals("At time 6100: run \"Level 5 - Final Showdown\" for 400 time units", scan6.nextLine());
		assertEquals("At time 6500: run \"Level 5 - Final Showdown\" for 400 time units", scan6.nextLine());
		assertEquals("At time 6900: run \"Level 5 - Final Showdown\" for 400 time units", scan6.nextLine());
		assertEquals("At time 7300: run \"Level 5 - Final Showdown\" for 300 time units", scan6.nextLine());
		assertEquals("CPU idle from time 7600 until time 7800", scan6.nextLine());
		assertEquals("At time 7800: run \"Credits\" for 200 time units", scan6.nextLine());
		scan6.close();

		Scanner scan7 = new Scanner(new File(OUTPUT_NAME7));
		assertEquals("At time 0: run \"Launching Photoshop\" for 500 time units", scan7.nextLine());
		assertEquals("At time 500: run \"Launching Photoshop\" for 500 time units", scan7.nextLine());
		assertEquals("CPU idle from time 1000 until time 1200", scan7.nextLine());
		assertEquals("At time 1200: run \"Opening Project\" for 500 time units", scan7.nextLine());
		assertEquals("At time 1700: run \"Opening Project\" for 100 time units", scan7.nextLine());
		assertEquals("CPU idle from time 1800 until time 2000", scan7.nextLine());
		assertEquals("At time 2000: run \"Designing Logo\" for 500 time units", scan7.nextLine());
		assertEquals("At time 2500: run \"Designing Logo\" for 500 time units", scan7.nextLine());
		assertEquals("At time 3000: run \"Designing Logo\" for 500 time units", scan7.nextLine());
		assertEquals("At time 3500: run \"Designing Logo\" for 500 time units", scan7.nextLine());
		assertEquals("CPU idle from time 4000 until time 4500", scan7.nextLine());
		assertEquals("At time 4500: run \"Editing Photos\" for 500 time units", scan7.nextLine());
		assertEquals("At time 5000: run \"Editing Photos\" for 300 time units", scan7.nextLine());
		assertEquals("CPU idle from time 5300 until time 5700", scan7.nextLine());
		assertEquals("At time 5700: run \"Applying Filters\" for 500 time units", scan7.nextLine());
		assertEquals("At time 6200: run \"Applying Filters\" for 500 time units", scan7.nextLine());
		assertEquals("At time 6700: run \"Applying Filters\" for 500 time units", scan7.nextLine());
		assertEquals("CPU idle from time 7200 until time 7500", scan7.nextLine());
		assertEquals("At time 7500: run \"Exporting Images\" for 300 time units", scan7.nextLine());
		assertEquals("CPU idle from time 7800 until time 7900", scan7.nextLine());
		assertEquals("At time 7900: run \"Saving Changes\" for 500 time units", scan7.nextLine());
		assertEquals("At time 8400: run \"Saving Changes\" for 500 time units", scan7.nextLine());
		scan7.close();
	}  
}
             