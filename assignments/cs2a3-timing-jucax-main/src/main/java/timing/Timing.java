package timing;

import java.io.*;             

/**
 * Starting point for creating an experiment to time
 * the execution of two different loops.                 
 * 
 * @author Jacob Schrum
 */
public class Timing {
	public static final int REPETITIONS = 10;

	public static void main(String[] args) throws IOException {

		// Data will be written to the file "data.txt"
		PrintStream ps = new PrintStream(new File("data.txt"));

		long[] valuesOfN = new long[]{4000,5000,6000,7000,8000,9000,10000,11000,12000,13000,14000,15000,16000}; // TODO: Put whatever values of N you want

		// Print the column headers
		tableHeader(ps);

		for(int i = 0; i < valuesOfN.length; i++){
			ps.print(valuesOfN[i]+"\t");

			// Run the code so that it loads in the cache, to make 
			// upcoming timing executions more reliable.
			timeLoopA(500);

			double averageA = 0; // TODO: Compute
			for(int j = 1; j <= REPETITIONS; j++) {
				long time = timeLoopA(valuesOfN[i]);
				ps.print(time+"\t");
				averageA += time;
			}
			ps.print((averageA / REPETITIONS)+"\t");

			// Run the code so that it loads in the cache, to make 
			// upcoming timing executions more reliable.
			timeLoopB(500);

			// TODO: Compute and display data for Loop B

			double averageB = 0; // TODO: Compute
			for(int j = 1; j <= REPETITIONS; j++) {
				long time = timeLoopB(valuesOfN[i]);
				ps.print(time+"\t");
				averageB += time;
			}
			ps.print((averageB / REPETITIONS)+"\t");
			ps.println();
		}

		ps.close();

		System.out.println("Execution complete. Look for \"data.txt\" in the project directory.");
	}

	/**
	 * Print the table header
	 * 
	 * @param ps a print stream pointing to the output file
	 */
	public static void tableHeader(PrintStream ps) {
		ps.print("#N\t");
		for(int i = 1; i <= REPETITIONS; i++) {
			ps.print("A"+i+"\t");
		}
		ps.print("AVG-A\t");
		for(int i = 1; i <= REPETITIONS; i++) {
			ps.print("B"+i+"\t");
		}
		ps.print("AVG-B");

		ps.println();
	}

	/**
	 * Execute Loop A for a given value of n
	 * and compute the number of nano-seconds
	 * for the loop to complete.
	 * 
	 * @param n input size
	 * @return time in nanoseconds to run the code
	 */
	public static long timeLoopA(long n) {
		long start = System.nanoTime();
		// Important to use long type variables so operations take a bit longer
		long i,j, sum = 0;
		for(i = 1; i<= n; i++) {
			for(j = 1; j <= 10000; j++) {
				sum = sum + j;
			}
		}
		long end = System.nanoTime();
		return end - start;
	}

	/**
	 * Execute Loop B for a given value of n
	 * and compute the number of nano-seconds            
	 * for the loop to complete.
	 * 
	 * @param n input size
	 * @return time in nanoseconds to run the code
	 */
	public static long timeLoopB(long n) {
		long start = System.nanoTime();
		// Important to use long type variables so operations take a bit longer
		long i,j, sum = 0;
		// TODO: Add Loop B code
		for(i = 1; i<= n; i++) {
			for(j = 1; j <= n; j++) {
				sum = sum + j;
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
}                
