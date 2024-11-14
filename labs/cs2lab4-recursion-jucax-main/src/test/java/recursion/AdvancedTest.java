
package recursion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class AdvancedTest {

	PrintStream outputConsole;
	ByteArrayOutputStream byteOutputStream;

	@BeforeEach
	void backupConsole() {
		// Create a stream to hold the output
		byteOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteOutputStream);
		// IMPORTANT: Save the old System.out!
		outputConsole = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
	}

	@AfterEach
	void restoreConsole() {
		// Put things back
		System.out.flush();
		System.setOut(outputConsole);
	}

	@Test
	void testFib1() {
		for(long n = 0; n < 20; n++) {
			assertEquals(Advanced.fib3(n),Advanced.fib1(n));
		}
	}

	@Test
	void testFib2() {
		for(long n = 0; n < 20; n++) {
			assertEquals(Advanced.fib3(n),Advanced.fib2(n));
		}
	}

	@Test
	void testComputePrefix() {
		assertEquals(9, Advanced.computePrefix("+ 3 6"));
		assertEquals(27, Advanced.computePrefix("+ * 3 7 6"));
		assertEquals(27, Advanced.computePrefix("+ * 3 / 14 2 6"));
		assertEquals(-5.5, Advanced.computePrefix("- / 7 2 + 3 6"));
		assertEquals(22, Advanced.computePrefix("- + * 3 7 6 / 10 2"));
		assertEquals(12.5, Advanced.computePrefix("/ 100 8"));
	}

	@Test
	void testSolveMaze() {
		Advanced.PathStep path = Advanced.solveMaze(Advanced.maze1,1,1,1,7);
		assertEquals(1,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(1,path.getRow());
		assertEquals(2,path.getColumn());
		path = path.getNextStep();
		assertEquals(1,path.getRow());
		assertEquals(3,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(3,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(4,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(5,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(6,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(7,path.getColumn());
		path = path.getNextStep();
		assertEquals(1,path.getRow());
		assertEquals(7,path.getColumn());
		path = path.getNextStep();
		assertNull(path);

		Advanced.clearMaze(Advanced.maze1);

		path = Advanced.solveMaze(Advanced.maze1,1,1,10,7);
		assertEquals(1,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(2,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(3,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(4,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(5,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(6,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(7,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(1,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(2,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(3,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(4,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(5,path.getColumn());
		path = path.getNextStep();
		assertEquals(8,path.getRow());
		assertEquals(6,path.getColumn());
		path = path.getNextStep();
		assertEquals(9,path.getRow());
		assertEquals(6,path.getColumn());
		path = path.getNextStep();
		assertEquals(10,path.getRow());
		assertEquals(6,path.getColumn());
		path = path.getNextStep();
		assertEquals(10,path.getRow());
		assertEquals(7,path.getColumn());
		path = path.getNextStep();
		assertNull(path);
	}
}
