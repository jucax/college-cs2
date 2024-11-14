package client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class UseListsTest {

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

	ArrayList<Integer> intList1;
	ArrayList<Integer> intList2;
	ArrayList<Integer> intList3;
	ArrayList<String> stringList;
	ArrayList<Double> doubleList1;
	ArrayList<Double> doubleList2;
	ArrayList<Double> doubleList3;
	ArrayList<Double> doubleList4;

	@BeforeEach
	void createLists() {
		intList1 = new ArrayList<>();
		intList1.add(4);
		intList1.add(4);
		intList1.add(40);
		intList1.add(345);
		intList1.add(99999);
		intList1.add(2);

		intList2 = new ArrayList<>();
		intList2.add(42146);
		intList2.add(-46);
		intList2.add(4046);
		intList2.add(20);

		intList3 = new ArrayList<>();
		intList3.add(4214644);
		intList3.add(-464);
		intList3.add(4046);
		intList3.add(4046);
		intList3.add(4046);
		intList3.add(4046);
		intList3.add(201);

		stringList = new ArrayList<>();
		stringList.add("A");
		stringList.add("B");
		stringList.add("test test test");
		stringList.add(")(*&^%$#@! \n \t");
		stringList.add("test test");
		stringList.add("B");
		stringList.add("B");
		stringList.add("test");

		doubleList1 = new ArrayList<>();
		doubleList1.add(1.0);
		doubleList1.add(0.00000348);
		doubleList1.add(Double.POSITIVE_INFINITY);
		doubleList1.add(999999.43543);

		doubleList2 = new ArrayList<>();
		doubleList2.add(-1.0);
		doubleList2.add(-0.00000348);
		doubleList2.add(Double.NEGATIVE_INFINITY);
		doubleList2.add(-999999.43543);
		doubleList2.add(-999999.43543);
		doubleList2.add(-435.978);
		doubleList2.add(-999999.43543);

		doubleList3 = new ArrayList<>();
		doubleList3.add(99999999.0);
		doubleList3.add(0.00000348);
		doubleList3.add(1.0);
		doubleList3.add(2.0);
		doubleList3.add(342.0);
		doubleList3.add(999999.43543);

		doubleList4 = new ArrayList<>();
		doubleList4.add(0.00000348);
		doubleList4.add(1.0);
		doubleList4.add(2.0);
		doubleList4.add(342.0);
		doubleList4.add(999999.43543);
	}

	@Test
	void testListUpToN() {
		ArrayList<Integer> to5 = UseLists.listUpToN(5);
		assertEquals(5, to5.size());
		for(int i = 0; i < 5; i++) {
			assertEquals(Integer.valueOf(i+1), to5.get(i));
		}
		ArrayList<Integer> to100 = UseLists.listUpToN(100);
		assertEquals(100, to100.size());
		for(int i = 0; i < 100; i++) {
			assertEquals(Integer.valueOf(i+1), to100.get(i));
		}
		ArrayList<Integer> to1 = UseLists.listUpToN(1);
		assertEquals(1, to1.size());
		for(int i = 0; i < 1; i++) {
			assertEquals(Integer.valueOf(i+1), to1.get(i));
		}
	}

	@Test
	void testIndexOfFirstOdd() {
		assertEquals(3, UseLists.indexOfFirstOdd(intList1));
		assertEquals(-1, UseLists.indexOfFirstOdd(intList2));
		assertEquals(6, UseLists.indexOfFirstOdd(intList3));
	}

	@Test
	void testWordsStartingWith() {
		ArrayList<String> result1 = UseLists.wordsStartingWith(stringList, 'A');
		assertEquals(1, result1.size());
		assertEquals("A", result1.get(0));

		ArrayList<String> result2 = UseLists.wordsStartingWith(stringList, 'B');
		assertEquals(3, result2.size());
		assertEquals("B", result2.get(0));
		assertEquals("B", result2.get(1));
		assertEquals("B", result2.get(2));

		ArrayList<String> result3 = UseLists.wordsStartingWith(stringList, 't');
		assertEquals(3, result3.size());
		assertEquals("test test test", result3.get(0));
		assertEquals("test test", result3.get(1));
		assertEquals("test", result3.get(2));

		ArrayList<String> result4 = UseLists.wordsStartingWith(stringList, 'T');
		assertTrue(result4.isEmpty());
	}

	@Test
	void testMaximum() {
		assertEquals(Double.POSITIVE_INFINITY,UseLists.maximum(doubleList1));
		assertEquals(-0.00000348, UseLists.maximum(doubleList2));
		assertEquals(99999999.0, UseLists.maximum(doubleList3));
		assertEquals(999999.43543, UseLists.maximum(doubleList4));
		assertTrue(Double.isNaN(UseLists.maximum(new ArrayList<Double>())));
	}

	@Test
	void testArgMax() {
		assertEquals(4, UseLists.argMax(intList1));
		assertEquals(0, UseLists.argMax(intList2));
		assertEquals(0, UseLists.argMax(intList3));

		assertEquals(2, UseLists.argMax(stringList));

		assertEquals(2, UseLists.argMax(doubleList1));
		assertEquals(1, UseLists.argMax(doubleList2));
		assertEquals(0, UseLists.argMax(doubleList3));
		assertEquals(4, UseLists.argMax(doubleList4));

		assertEquals(-1, UseLists.argMax(new ArrayList<Integer>()));

	}

	@Test
	void testRemoveEvens() {
		UseLists.removeEvens(intList1);
		assertEquals(2, intList1.size());
		assertEquals(345, intList1.get(0));
		assertEquals(99999, intList1.get(1));

		UseLists.removeEvens(intList2);
		assertTrue(intList2.isEmpty());

		UseLists.removeEvens(intList3);
		assertEquals(1, intList3.size());
		assertEquals(201, intList3.get(0));
	}
}