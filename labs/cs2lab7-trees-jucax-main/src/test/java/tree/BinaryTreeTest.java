package tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class BinaryTreeTest {

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

	BinaryTree<Integer> intTree;
	BinaryTree<String> expressionTree;
	BinaryTree<Double> doubleTree;

	@BeforeEach
	void createTrees() {
		intTree = new BinaryTree<>(100,
				new BinaryTree<>(90,
						new BinaryTree<>(85,
								new BinaryTree<>(40,
										new BinaryTree<>(30),
										new BinaryTree<>(21)),
								new BinaryTree<>(37)),
						new BinaryTree<>(70,
								new BinaryTree<>(67),
								new BinaryTree<>(22))),
				new BinaryTree<>(80,
						new BinaryTree<>(64,
								new BinaryTree<>(10),
								new BinaryTree<>(44,
										new BinaryTree<>(43,
												new BinaryTree<>(5),
												null),
										null)),
						new BinaryTree<>(53,
								new BinaryTree<>(39),
								new BinaryTree<>(49,
										null,
										new BinaryTree<>(30,
												new BinaryTree<>(15),
												new BinaryTree<>(2))))));

		expressionTree = new BinaryTree<>("+",
				new BinaryTree<>("*",
						new BinaryTree<>("3"),
						new BinaryTree<>("/",
								new BinaryTree<>("50"),
								new BinaryTree<>("+",
										new BinaryTree<>("2"),
										new BinaryTree<>("3")))),
				new BinaryTree<>("-",
						new BinaryTree<>("*",
								new BinaryTree<>("-",
										new BinaryTree<>("50"),
										new BinaryTree<>("20")),
								new BinaryTree<>("7")),
						new BinaryTree<>("100")));

		doubleTree = new BinaryTree<>(54.3,
				new BinaryTree<>(100.0,
						new BinaryTree<>(-234.32),
						new BinaryTree<>(0.0)),
				new BinaryTree<>(234.23));
	}

	@Test
	void testGetHeight() {
		assertEquals(6, intTree.getHeight());
		assertEquals(5, expressionTree.getHeight());
		assertEquals(3, doubleTree.getHeight());
	}

	@Test
	void testGetNumberOfNodes() {
		assertEquals(22, intTree.getNumberOfNodes());
		assertEquals(15, expressionTree.getNumberOfNodes());
		assertEquals(5, doubleTree.getNumberOfNodes());
	}

	@Test
	void testPrintPreOrder() {
		intTree.printPreOrder();
		expressionTree.printPreOrder();
		doubleTree.printPreOrder();

		assertEquals("100"+System.lineSeparator()+
				"90"+System.lineSeparator()+
				"85"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"30"+System.lineSeparator()+
				"21"+System.lineSeparator()+
				"37"+System.lineSeparator()+
				"70"+System.lineSeparator()+
				"67"+System.lineSeparator()+
				"22"+System.lineSeparator()+
				"80"+System.lineSeparator()+
				"64"+System.lineSeparator()+
				"10"+System.lineSeparator()+
				"44"+System.lineSeparator()+
				"43"+System.lineSeparator()+
				"5"+System.lineSeparator()+
				"53"+System.lineSeparator()+
				"39"+System.lineSeparator()+
				"49"+System.lineSeparator()+
				"30"+System.lineSeparator()+
				"15"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"/"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"20"+System.lineSeparator()+
				"7"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"54.3"+System.lineSeparator()+
				"100.0"+System.lineSeparator()+
				"-234.32"+System.lineSeparator()+
				"0.0"+System.lineSeparator()+
				"234.23"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testPrintPostOrder() {
		intTree.printPostOrder();
		expressionTree.printPostOrder();
		doubleTree.printPostOrder();

		assertEquals("30"+System.lineSeparator()+
				"21"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"37"+System.lineSeparator()+
				"85"+System.lineSeparator()+
				"67"+System.lineSeparator()+
				"22"+System.lineSeparator()+
				"70"+System.lineSeparator()+
				"90"+System.lineSeparator()+
				"10"+System.lineSeparator()+
				"5"+System.lineSeparator()+
				"43"+System.lineSeparator()+
				"44"+System.lineSeparator()+
				"64"+System.lineSeparator()+
				"39"+System.lineSeparator()+
				"15"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"30"+System.lineSeparator()+
				"49"+System.lineSeparator()+
				"53"+System.lineSeparator()+
				"80"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"/"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"20"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"7"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"-234.32"+System.lineSeparator()+
				"0.0"+System.lineSeparator()+
				"100.0"+System.lineSeparator()+
				"234.23"+System.lineSeparator()+
				"54.3"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testPrintInOrder() {
		intTree.printInOrder();
		expressionTree.printInOrder();
		doubleTree.printInOrder();

		assertEquals("30"+System.lineSeparator()+
				"40"+System.lineSeparator()+
				"21"+System.lineSeparator()+
				"85"+System.lineSeparator()+
				"37"+System.lineSeparator()+
				"90"+System.lineSeparator()+
				"67"+System.lineSeparator()+
				"70"+System.lineSeparator()+
				"22"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"10"+System.lineSeparator()+
				"64"+System.lineSeparator()+
				"5"+System.lineSeparator()+
				"43"+System.lineSeparator()+
				"44"+System.lineSeparator()+
				"80"+System.lineSeparator()+
				"39"+System.lineSeparator()+
				"53"+System.lineSeparator()+
				"49"+System.lineSeparator()+
				"15"+System.lineSeparator()+
				"30"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"/"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"+"+System.lineSeparator()+
				"50"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"20"+System.lineSeparator()+
				"*"+System.lineSeparator()+
				"7"+System.lineSeparator()+
				"-"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"-234.32"+System.lineSeparator()+
				"100.0"+System.lineSeparator()+
				"0.0"+System.lineSeparator()+
				"54.3"+System.lineSeparator()+
				"234.23"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testEvaluateExpressionTree() {
		assertEquals(140.0, BinaryTree.evaluateExpressionTree(expressionTree));
	}
}
