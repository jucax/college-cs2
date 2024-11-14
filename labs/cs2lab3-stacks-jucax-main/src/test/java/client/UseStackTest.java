package client;

import static org.junit.jupiter.api.Assertions.*;

import stack.*;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class UseStackTest {

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

	StackInterface<Integer> intStack;
	StackInterface<String> stringStack;
	StackInterface<Double> doubleStack;

	@BeforeEach
	void createStacks() {
		intStack = new MysteryStack<>();
		intStack.push(4);
		intStack.push(4);
		intStack.push(40);
		intStack.push(345);
		intStack.push(99999);
		intStack.push(2);

		stringStack = new MysteryStack<>();
		stringStack.push("A");
		stringStack.push("B");
		stringStack.push("test test test");
		stringStack.push(")(*&^%$#@! \n \t");
		stringStack.push("B");
		stringStack.push("B");

		doubleStack = new MysteryStack<>();
		doubleStack.push(1.0);
		doubleStack.push(0.00000348);
		doubleStack.push(Double.POSITIVE_INFINITY);
		doubleStack.push(999999.43543);
	}

	@Test
	void testPrintStack() {
		UseStack.printStack(intStack);
		UseStack.printStack(stringStack);
		UseStack.printStack(doubleStack);


		assertEquals("2"+System.lineSeparator()+
				"99999"+System.lineSeparator()+
				"345"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				")(*&^%$#@! \n \t"+System.lineSeparator()+
				"test test test"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"A"+System.lineSeparator()+
				"999999.43543"+System.lineSeparator()+
				"Infinity"+System.lineSeparator()+
				"3.48E-6"+System.lineSeparator()+
				"1.0"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testPrintStackReverse() {
		UseStack.printStackReverse(intStack);
		UseStack.printStackReverse(stringStack);
		UseStack.printStackReverse(doubleStack);


		assertEquals("4"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"345"+System.lineSeparator()+
				"99999"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"A"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"test test test"+System.lineSeparator()+
				")(*&^%$#@! \n \t"+System.lineSeparator()+                     
				"B"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"1.0"+System.lineSeparator()+
				"3.48E-6"+System.lineSeparator()+
				"Infinity"+System.lineSeparator()+
				"999999.43543"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testStackWithXOfY() {
		StackInterface<Integer> fiveNines = UseStack.stackWithXOfY(5, 9);
		assertEquals(Integer.valueOf(9), fiveNines.pop());
		assertEquals(Integer.valueOf(9), fiveNines.pop());
		assertEquals(Integer.valueOf(9), fiveNines.pop());
		assertEquals(Integer.valueOf(9), fiveNines.pop());
		assertEquals(Integer.valueOf(9), fiveNines.pop());
		assertTrue(fiveNines.isEmpty());        
		StackInterface<String> threeJavas = UseStack.stackWithXOfY(3, "Java");
		assertEquals("Java", threeJavas.pop());
		assertEquals("Java", threeJavas.pop());
		assertEquals("Java", threeJavas.pop());
		assertTrue(threeJavas.isEmpty());
		StackInterface<Double> zeroTens = UseStack.stackWithXOfY(0, 10.0);
		assertTrue(zeroTens.isEmpty());
	}

	@Test
	void testBalancedDelimiters() {
		assertTrue(UseStack.balancedDelimiters("there are no delimiters here"));
		assertTrue(UseStack.balancedDelimiters(""));
		assertTrue(UseStack.balancedDelimiters("()"));
		assertTrue(UseStack.balancedDelimiters("{}"));
		assertTrue(UseStack.balancedDelimiters("[]"));
		assertTrue(UseStack.balancedDelimiters("()()[]{}{}()"));
		assertTrue(UseStack.balancedDelimiters("{()[()[]{}{}]()}"));
		assertTrue(UseStack.balancedDelimiters("{[]} (() ({[] []}) ())"));
		assertTrue(UseStack.balancedDelimiters("public class Example { int x; public Example() { x = 5; } public int m(int y) { return y + x; } }"));

		assertFalse(UseStack.balancedDelimiters("("));
		assertFalse(UseStack.balancedDelimiters("} {()[()[]{}{}]()}"));
		assertFalse(UseStack.balancedDelimiters("}"));
		assertFalse(UseStack.balancedDelimiters("]"));
		assertFalse(UseStack.balancedDelimiters("()([)]{}{}()"));
		assertFalse(UseStack.balancedDelimiters("{()[()[]{{}]()}"));
		assertFalse(UseStack.balancedDelimiters("{[]} (() ({[] []}) ()) ("));
		assertFalse(UseStack.balancedDelimiters("{[]} (() ({[] []}) ()) ]"));
		assertFalse(UseStack.balancedDelimiters("public class Example { int x; public Example() [{ x = 5; } public int m(int y) { return y + x; } }"));

	}

	@Test
	void testEvaluatePostfix() {
		assertEquals(5.0, UseStack.evaluatePostfix("3 2 +"));
		assertEquals(9.0, UseStack.evaluatePostfix("4 3 + 2 +"));
		assertEquals(14.0, UseStack.evaluatePostfix("4 3 * 2 +"));
		assertEquals(1.5, UseStack.evaluatePostfix("3 2 /"));
		assertEquals(1.0, UseStack.evaluatePostfix("3 2 -"));
		assertEquals(-2.0, UseStack.evaluatePostfix("1 3 -"));
		assertEquals(4.0, UseStack.evaluatePostfix("2 9 3 + 2 - * 5 /"));
		assertEquals(0.0605620908258624, UseStack.evaluatePostfix("43 132.3 + 90 3.3 2.8 + - 34.5 * /"));
	}

}