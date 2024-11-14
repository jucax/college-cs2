
package recursion;

import static org.junit.jupiter.api.Assertions.*;
import static recursion.Basic.Node;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class BasicTest {

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

	Node<Integer> intChain;
	Node<String> stringChain;
	Node<Double> doubleChain;

	@BeforeEach
	void createChains() {
		intChain = new Node<>(7);
		intChain = new Node<>(43, intChain);
		intChain = new Node<>(-1, intChain);
		intChain = new Node<>(44, intChain);
		intChain = new Node<>(545, intChain);
		intChain = new Node<>(9, intChain);
		intChain = new Node<>(-435, intChain);

		stringChain = new Node<>("End");
		stringChain = new Node<>("Second to last", stringChain);
		stringChain = new Node<>("Third to last", stringChain);
		stringChain = new Node<>("middle", stringChain);
		stringChain = new Node<>("third", stringChain);
		stringChain = new Node<>("SECOND", stringChain);
		stringChain = new Node<>("FIRST", stringChain);

		doubleChain = new Node<>(324.43);
	}

	int[] empty;
	int[] big;

	@BeforeEach
	void createArrays() {
		empty = new int[0];
		big = new int[]{345,32,-234,4357,54,33,22,0,53,1,2,3,5467,-34522,3,-54};
	}

	@Test
	void testSumToN() {
		assertEquals(1, Basic.sumToN(1));
		assertEquals(3, Basic.sumToN(2));
		assertEquals(6, Basic.sumToN(3));
		assertEquals(55, Basic.sumToN(10));
		assertEquals(5050, Basic.sumToN(100));
	}

	@Test
	void testMultiply() {
		assertEquals(50, Basic.multiply(5,10));
		assertEquals(0, Basic.multiply(0,10));
		assertEquals(0, Basic.multiply(5,0));
		assertEquals(100, Basic.multiply(10,10));
		assertEquals(56, Basic.multiply(7,8));
		assertEquals(56, Basic.multiply(8,7));
	}

	@Test
	void testPower() {
		assertEquals(1,Basic.power(2,0));
		assertEquals(1,Basic.power(-342,0));
		assertEquals(-2,Basic.power(-2,1));
		assertEquals(256,Basic.power(2,8));
		assertEquals(-27,Basic.power(-3,3));
		assertEquals(100000000,Basic.power(10,8));
	}

	@Test
	void testArraySum() {
		assertEquals(0,Basic.arraySum(empty));
		assertEquals(-24438,Basic.arraySum(big));
	}

	@Test
	void testChainSum() {
		assertEquals(212,Basic.chainSum(intChain));
	}

	@Test
	void testPrintChainReverse() {
		Basic.printChainReverse(intChain);
		Basic.printChainReverse(stringChain);
		Basic.printChainReverse(doubleChain);

		assertEquals("7"+System.lineSeparator()+
				"43"+System.lineSeparator()+
				"-1"+System.lineSeparator()+
				"44"+System.lineSeparator()+
				"545"+System.lineSeparator()+
				"9"+System.lineSeparator()+
				"-435"+System.lineSeparator()+
				"End"+System.lineSeparator()+
				"Second to last"+System.lineSeparator()+
				"Third to last"+System.lineSeparator()+
				"middle"+System.lineSeparator()+
				"third"+System.lineSeparator()+
				"SECOND"+System.lineSeparator()+
				"FIRST"+System.lineSeparator()+
				"324.43"+System.lineSeparator(), byteOutputStream.toString());
	}


}