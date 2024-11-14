package refresh;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class RefreshTest {

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
	void testExercise1() {
		Refresh.exercise1();
		assertEquals("Hello World!"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise2() {
		Refresh.exercise2();
		assertEquals("4.795831523312719"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise3() {
		Refresh.exercise3();
		assertEquals("1"+System.lineSeparator()+
				"2"+System.lineSeparator()+
				"3"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"5"+System.lineSeparator()+
				"6"+System.lineSeparator()+
				"7"+System.lineSeparator()+
				"8"+System.lineSeparator()+
				"9"+System.lineSeparator()+
				"10"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise4() {
		Refresh.exercise4();
		assertEquals("4560"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise5() {
		Refresh.exercise5(1,2);
		Refresh.exercise5(1000,200);
		Refresh.exercise5(-100,50);
		Refresh.exercise5(12,23);
		Refresh.exercise5(-100.05,50.25);
		Refresh.exercise5(12.001,23.5);
		assertEquals("3.0"+System.lineSeparator()+
				"1200.0"+System.lineSeparator()+
				"-50.0"+System.lineSeparator()+
				"35.0"+System.lineSeparator()+
				"-49.8"+System.lineSeparator()+
				"35.501"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise6() {
		assertEquals(3.0,Refresh.exercise6(1,2));
		assertEquals(1200.0,Refresh.exercise6(1000,200));
		assertEquals(-50.0,Refresh.exercise6(-100,50));
		assertEquals(35.0,Refresh.exercise6(12,23));
		assertEquals(-49.8,Refresh.exercise6(-100.05,50.25));
		assertEquals(35.501,Refresh.exercise6(12.001,23.5));
	}

	@Test
	void testExercise7() {
		Refresh.exercise7();
		assertEquals("**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator(), byteOutputStream.toString());

	}

	@Test
	void testExercise8() {
		Refresh.exercise8(10,3);
		Refresh.exercise8(2,5);
		Refresh.exercise8(4,1);
		assertEquals("**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**********"+System.lineSeparator()+
				"**"+System.lineSeparator()+
				"**"+System.lineSeparator()+
				"**"+System.lineSeparator()+
				"**"+System.lineSeparator()+
				"**"+System.lineSeparator()+
				"****"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise9() throws Exception {
		Class<?> rect = Refresh.Rectangle.class;
		Constructor<?> cons = rect.getConstructor(Double.TYPE, Double.TYPE);
		Object o = cons.newInstance(2.5,4.7);
		Method width = rect.getMethod("getWidth", new Class[0]);
		assertEquals(2.5, width.invoke(o,new Object[0]));
		Method height = rect.getMethod("getHeight", new Class[0]);
		assertEquals(4.7, height.invoke(o,new Object[0]));
		Method area = rect.getMethod("getArea", new Class[0]);
		assertEquals(11.75, area.invoke(o,new Object[0]));
	}

	@Test
	void testExercise10() {
		Refresh.exercise10(new int[]{1,2,4,7});
		Refresh.exercise10(new int[]{100,-234,2203,1,0,0,234});
		Refresh.exercise10(new int[]{-100, -200, -32});
		Refresh.exercise10(new int[0]);
		assertEquals("14"+System.lineSeparator()+
				"2304"+System.lineSeparator()+
				"-332"+System.lineSeparator()+
				"0"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise11() {
		Refresh.exercise11("Hello");
		Refresh.exercise11("testing");
		Refresh.exercise11("a sentence with words");
		assertEquals("H"+System.lineSeparator()+
				"e"+System.lineSeparator()+
				"l"+System.lineSeparator()+
				"l"+System.lineSeparator()+
				"o"+System.lineSeparator()+
				"t"+System.lineSeparator()+
				"e"+System.lineSeparator()+
				"s"+System.lineSeparator()+
				"t"+System.lineSeparator()+
				"i"+System.lineSeparator()+
				"n"+System.lineSeparator()+
				"g"+System.lineSeparator()+
				"a"+System.lineSeparator()+
				" "+System.lineSeparator()+
				"s"+System.lineSeparator()+
				"e"+System.lineSeparator()+
				"n"+System.lineSeparator()+
				"t"+System.lineSeparator()+
				"e"+System.lineSeparator()+
				"n"+System.lineSeparator()+
				"c"+System.lineSeparator()+
				"e"+System.lineSeparator()+
				" "+System.lineSeparator()+
				"w"+System.lineSeparator()+
				"i"+System.lineSeparator()+
				"t"+System.lineSeparator()+
				"h"+System.lineSeparator()+
				" "+System.lineSeparator()+
				"w"+System.lineSeparator()+
				"o"+System.lineSeparator()+
				"r"+System.lineSeparator()+
				"d"+System.lineSeparator()+
				"s"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise12() throws Exception {
		InputStream stdin = System.in;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream("27\n123\n".getBytes());
			System.setIn(bais);
			Refresh.exercise12();
			assertEquals("3321"+System.lineSeparator(), byteOutputStream.toString());
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	void testExercise13() {
		assertEquals(14,Refresh.exercise13(IntStream.of(new int[]{1,2,4,7}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(2304,Refresh.exercise13(IntStream.of(new int[]{100,-234,2203,1,0,0,234}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(-332,Refresh.exercise13(IntStream.of(new int[]{-100, -200, -32}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(0,Refresh.exercise13(IntStream.of(new int[0]).boxed().collect(Collectors.toCollection(ArrayList::new))));
	}

	@Test
	void testExercise14() {
		assertEquals(1, Refresh.exercise14(0));
		assertEquals(1, Refresh.exercise14(1));
		assertEquals(2, Refresh.exercise14(2));
		assertEquals(6, Refresh.exercise14(3));
		assertEquals(24, Refresh.exercise14(4));
		assertEquals(3628800, Refresh.exercise14(10));
	}

	@Test
	void testExercise15() {
		Refresh.exercise15(new int[]{1,2,4,7});
		Refresh.exercise15(new int[]{100,-234,2203,1,0,0,234});
		Refresh.exercise15(new int[]{-100, 3, -200, -5, -32});
		Refresh.exercise15(new int[0]);
		assertEquals("2"+System.lineSeparator()+
				"4"+System.lineSeparator()+
				"100"+System.lineSeparator()+
				"-234"+System.lineSeparator()+
				"0"+System.lineSeparator()+
				"0"+System.lineSeparator()+
				"234"+System.lineSeparator()+
				"-100"+System.lineSeparator()+
				"-200"+System.lineSeparator()+
				"-32"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise16() {
		Refresh.exercise16(new String[]{"Here","is","a","test"});
		Refresh.exercise16(new String[]{"words","in","an","array"});
		Refresh.exercise16(new String[]{"I","can","use","odd","words"});
		Refresh.exercise16(new String[0]);
		assertEquals("Here"+System.lineSeparator()+
				"is"+System.lineSeparator()+
				"test"+System.lineSeparator()+
				"in"+System.lineSeparator()+
				"an"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise17() {
		ArrayList<String> answer;
		ArrayList<String> result;
		answer = Arrays.stream(new String[]{"a"}).collect(Collectors.toCollection(ArrayList::new));
		result = Refresh.exercise17(new String[]{"Here","is","a","test"});
		assertEquals(answer,result);
		answer = Arrays.stream(new String[]{"words","array"}).collect(Collectors.toCollection(ArrayList::new));
		result = Refresh.exercise17(new String[]{"words","in","an","array"});
		assertEquals(answer,result);
		answer = Arrays.stream(new String[]{"I","can","use","odd","words"}).collect(Collectors.toCollection(ArrayList::new));
		result = Refresh.exercise17(new String[]{"I","can","use","odd","words"});
		assertEquals(answer,result);
		answer = Arrays.stream(new String[0]).collect(Collectors.toCollection(ArrayList::new));
		result = Refresh.exercise17(new String[0]);
		assertEquals(answer,result);
	}

	@Test
	void testExercise18() throws Exception {
		Refresh.exercise18("test_file.txt");
		assertEquals("This is an example text file."+System.lineSeparator()+
				""+System.lineSeparator()+
				"It has lots of text."+System.lineSeparator()+
				"It is used to test exercise 18."+System.lineSeparator()+
				""+System.lineSeparator()+
				"Here is some random math: 4 + 5 = 9"+System.lineSeparator()+
				""+System.lineSeparator()+        
				"!!!!!!!!!!!!!!!!!!!"+System.lineSeparator()+
				""+System.lineSeparator()+        
				"END"+System.lineSeparator(), byteOutputStream.toString());
	}

	@Test
	void testExercise19() {
		assertEquals(100.0, Refresh.exercise19(new double[]{100.0}));
		assertEquals(-100.0, Refresh.exercise19(new double[]{-100.0}));
		assertEquals(456, Refresh.exercise19(new double[]{1,2,3.435,6,456,100.0,3,34}));
		assertEquals(-1, Refresh.exercise19(new double[]{-1,-2,-3.34,-6,-456,-100.0,-3,-34}));
	}

	@Test
	void testExercise20() {
		assertEquals(100, Refresh.exercise20(IntStream.of(new int[]{100}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(-100, Refresh.exercise20(IntStream.of(new int[]{-100}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(1, Refresh.exercise20(IntStream.of(new int[]{1,2,3,6,456,100,3,34}).boxed().collect(Collectors.toCollection(ArrayList::new))));
		assertEquals(-456, Refresh.exercise20(IntStream.of(new int[]{-1,-2,-3,-6,-456,-100,-3,-34}).boxed().collect(Collectors.toCollection(ArrayList::new))));
	}

	@Test
	void testExercise21() throws Exception {
		File f = new File("output.txt");
		if(f.exists()) f.delete();
		Refresh.exercise21();
		Scanner s = new Scanner(f);
		assertEquals("TEST",s.nextLine());
		assertFalse(s.hasNextLine());
		s.close();
		if(f.exists()) f.delete();
	}

}
