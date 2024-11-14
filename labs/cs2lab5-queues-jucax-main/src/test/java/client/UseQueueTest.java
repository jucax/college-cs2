package client;

import static org.junit.jupiter.api.Assertions.*;

import queues.*;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class UseQueueTest {

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

	QueueInterface<Integer> intQueue1;
	QueueInterface<Integer> intQueue2;
	QueueInterface<String> stringQueue;
	QueueInterface<Double> doubleQueue;

	@BeforeEach
	void createQueues() {
		intQueue1 = new MysteryQueue<>();
		intQueue1.enqueue(4);
		intQueue1.enqueue(4);
		intQueue1.enqueue(40);
		intQueue1.enqueue(345);
		intQueue1.enqueue(99999);
		intQueue1.enqueue(2);

		intQueue2 = new MysteryQueue<>();
		intQueue2.enqueue(23);
		intQueue2.enqueue(-5534);
		intQueue2.enqueue(40);
		intQueue2.enqueue(40);
		intQueue2.enqueue(9234999);
		intQueue2.enqueue(-34);

		stringQueue = new MysteryQueue<>();
		stringQueue.enqueue("A");
		stringQueue.enqueue("B");
		stringQueue.enqueue("test test test");
		stringQueue.enqueue(")(*&^%$#@! \n \t");
		stringQueue.enqueue("B");
		stringQueue.enqueue("B");

		doubleQueue = new MysteryQueue<>();
		doubleQueue.enqueue(1.0);
		doubleQueue.enqueue(0.00000348);
		doubleQueue.enqueue(Double.POSITIVE_INFINITY);
		doubleQueue.enqueue(999999.43543);
	}

	@Test
	void testPrintUntil() {
		UseQueue.printUntil(intQueue1, 4);
		UseQueue.printUntil(intQueue1, 345);
		UseQueue.printUntil(intQueue1, 10067);
		UseQueue.printUntil(stringQueue, "test test test");
		UseQueue.printUntil(stringQueue, "B");
		UseQueue.printUntil(stringQueue, "A");
		UseQueue.printUntil(doubleQueue, 0.00000348);
		UseQueue.printUntil(doubleQueue, 0.5);
		UseQueue.printUntil(doubleQueue, 0.5);

		assertEquals("4"+System.lineSeparator()+
				"FOUND"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"345"+System.lineSeparator()+
				"FOUND"+System.lineSeparator()+
				"99999"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"NOT FOUND"+System.lineSeparator()+
				"A"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"test test test"+System.lineSeparator()+
				"FOUND"+System.lineSeparator()+
				")(*&^%$#@! \n \t"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"FOUND"+System.lineSeparator()+
				"B"+System.lineSeparator()+
				"NOT FOUND"+System.lineSeparator()+
				"1.0"+System.lineSeparator()+
				"3.48E-6"+System.lineSeparator()+
				"FOUND"+System.lineSeparator()+
				"Infinity"+System.lineSeparator()+
				"999999.43543"+System.lineSeparator()+
				"NOT FOUND"+System.lineSeparator()+
				"NOT FOUND"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testQueueWithXOfY() {
		QueueInterface<Integer> fiveHundreds = UseQueue.queueWithXOfY(5, 100);
		assertEquals(Integer.valueOf(100), fiveHundreds.dequeue());
		assertEquals(Integer.valueOf(100), fiveHundreds.dequeue());
		assertEquals(Integer.valueOf(100), fiveHundreds.dequeue());
		assertEquals(Integer.valueOf(100), fiveHundreds.dequeue());
		assertEquals(Integer.valueOf(100), fiveHundreds.dequeue());
		assertTrue(fiveHundreds.isEmpty());

		QueueInterface<String> zeroNones = UseQueue.queueWithXOfY(0, "None");
		assertTrue(zeroNones.isEmpty());

		QueueInterface<Double> eightHalves = UseQueue.queueWithXOfY(8, 0.5);
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertEquals(Double.valueOf(0.5), eightHalves.dequeue());
		assertTrue(eightHalves.isEmpty());
	}

	@Test
	void testTransfer() {
		UseQueue.transfer(intQueue1, intQueue2, 3);
		assertEquals(Integer.valueOf(345), intQueue1.dequeue());
		assertEquals(Integer.valueOf(99999), intQueue1.dequeue());
		assertEquals(Integer.valueOf(2), intQueue1.dequeue());
		assertTrue(intQueue1.isEmpty());
		assertEquals(Integer.valueOf(23), intQueue2.dequeue());
		assertEquals(Integer.valueOf(-5534), intQueue2.dequeue());
		assertEquals(Integer.valueOf(40), intQueue2.dequeue());
		assertEquals(Integer.valueOf(40), intQueue2.dequeue());
		assertEquals(Integer.valueOf(9234999), intQueue2.dequeue());
		assertEquals(Integer.valueOf(-34), intQueue2.dequeue());
		assertEquals(Integer.valueOf(4), intQueue2.dequeue());
		assertEquals(Integer.valueOf(4), intQueue2.dequeue());
		assertEquals(Integer.valueOf(40), intQueue2.dequeue());
		assertTrue(intQueue2.isEmpty());

		QueueInterface<String> emptyQueue = new MysteryQueue<>();
		UseQueue.transfer(stringQueue, emptyQueue, 20);
		assertEquals("A",emptyQueue.dequeue());
		assertEquals("B",emptyQueue.dequeue());
		assertEquals("test test test",emptyQueue.dequeue());
		assertEquals(")(*&^%$#@! \n \t",emptyQueue.dequeue());
		assertEquals("B",emptyQueue.dequeue());
		assertEquals("B",emptyQueue.dequeue());
		assertTrue(emptyQueue.isEmpty());
	}

	@Test
	void testFilterEvens() {
		UseQueue.filterEvens(intQueue1);
		assertEquals(Integer.valueOf(345), intQueue1.dequeue());
		assertEquals(Integer.valueOf(99999), intQueue1.dequeue());
		assertTrue(intQueue1.isEmpty());

		UseQueue.filterEvens(intQueue2);
		assertEquals(Integer.valueOf(23), intQueue2.dequeue());
		assertEquals(Integer.valueOf(9234999), intQueue2.dequeue());
		assertTrue(intQueue2.isEmpty());
	}

	@Test
	void testDoubleElements() {
		UseQueue.doubleElements(intQueue1);
		assertEquals(Integer.valueOf(4), intQueue1.dequeue());
		assertEquals(Integer.valueOf(4), intQueue1.dequeue());
		assertEquals(Integer.valueOf(4), intQueue1.dequeue());
		assertEquals(Integer.valueOf(4), intQueue1.dequeue());
		assertEquals(Integer.valueOf(40), intQueue1.dequeue());
		assertEquals(Integer.valueOf(40), intQueue1.dequeue());
		assertEquals(Integer.valueOf(345), intQueue1.dequeue());
		assertEquals(Integer.valueOf(345), intQueue1.dequeue());
		assertEquals(Integer.valueOf(99999), intQueue1.dequeue());
		assertEquals(Integer.valueOf(99999), intQueue1.dequeue());
		assertEquals(Integer.valueOf(2), intQueue1.dequeue());
		assertEquals(Integer.valueOf(2), intQueue1.dequeue());
		assertTrue(intQueue1.isEmpty());

		UseQueue.doubleElements(stringQueue);
		assertEquals("A",stringQueue.dequeue());
		assertEquals("A",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertEquals("test test test",stringQueue.dequeue());
		assertEquals("test test test",stringQueue.dequeue());
		assertEquals(")(*&^%$#@! \n \t",stringQueue.dequeue());
		assertEquals(")(*&^%$#@! \n \t",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertEquals("B",stringQueue.dequeue());
		assertTrue(stringQueue.isEmpty());

		UseQueue.doubleElements(doubleQueue);
		assertEquals(1.0,doubleQueue.dequeue());
		assertEquals(1.0,doubleQueue.dequeue());
		assertEquals(0.00000348,doubleQueue.dequeue());
		assertEquals(0.00000348,doubleQueue.dequeue());
		assertEquals(Double.POSITIVE_INFINITY,doubleQueue.dequeue());
		assertEquals(Double.POSITIVE_INFINITY,doubleQueue.dequeue());
		assertEquals(999999.43543,doubleQueue.dequeue());
		assertEquals(999999.43543,doubleQueue.dequeue());
		assertTrue(doubleQueue.isEmpty());

	}
}
