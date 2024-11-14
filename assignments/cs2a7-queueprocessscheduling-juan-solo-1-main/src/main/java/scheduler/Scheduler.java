package scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import queues.*; 

/**
 * This program simulates a simple process scheduler 
 * for a system with a single processor. Each process         
 * has a start time and a pre-specified duration. The
 * simulateProcessor method reads this data from an            
 * input file, and then writes an output file indicating
 * when and for how long each process is using the             
 * processor.                             
 * 
 * @author Jacob Schrum
 */
public class Scheduler {

	/**
	 * This internal class represents a single process. A name
	 * is used to identify the process, and a start time and duration
	 * are also stored. The simulation time starts at 0 and advances
	 * upward from there. Do not modify this class.
	 * 
	 * @author Jacob Schrum
	 */
	private static class Process {
		private String name;
		private int timeToCompletion;
		private int startTime;

		/**
		 * Creates new process with specified
		 * start time, execution duration, and name.
		 * 
		 * @param startTime Non-negative simulation time.
		 * @param executionTime Positive number of time units
		 * 						that process requires on processor.
		 * @param name Name that identifies process in output file.
		 */
		public Process(int startTime, int executionTime, String name) {
			if(executionTime <= 0) { // Don't allow non-positive execution durations
				throw new IllegalArgumentException("Execution time must be positive: " + executionTime);
			}
			if(startTime < 0) { // Don't allow negative start times
				throw new IllegalArgumentException("Start times cannot be negative: " + startTime);
			}
			this.name = name;
			this.timeToCompletion = executionTime;
			this.startTime = startTime;
		}

		/**
		 * When the process should appear in the ready queue in terms of
		 * simulation time (starts from 0 and goes up from there)
		 * @return Integer start time of process.
		 */
		public int getStartTime() {
			return startTime;
		}

		/**
		 * Get name identifying the process
		 * @return String name of process
		 */
		public String getName(){
			return name;
		}

		/**
		 * Returns remaining number of time units that the
		 * process must spend on the processor in order to complete.
		 * @return Remaining execution time
		 */
		public int getTimeRemaining(){
			return timeToCompletion;
		}

		/**
		 * Executes the process for a given number of time units, which
		 * simply means subtracting the given time from the remaining 
		 * timeToCompletion. The provided time must be positive and
		 * cannot exceed the timeToCompletion without causing an exception.
		 * 
		 * @param processorTime Time to run process for. Must be positive and
		 *                      less than or equal to timeToCompletion.
		 */
		public void executeForTime(int processorTime) {
			if(processorTime <= 0) { // Cannot run for a non-positive amount of time
				throw new IllegalArgumentException("Time spent on processor must be positive: " + processorTime);
			} else if(processorTime > timeToCompletion) { // Cannot run more than the process has left to run
				throw new IllegalArgumentException("Cannot execute for more time than is remaining: " + processorTime + " > " + timeToCompletion);
			}
			timeToCompletion -= processorTime;
		}
	}

	/**
	 * DO NOT CHANGE THIS METHOD.
	 * 
	 * Creates a Scanner for a specified input file name and an output stream for
	 * a specified output file name, and runs the processor simulation with a
	 * given timeout period using the two files. All resources are closed
	 * at the completion of the method.
	 * 
	 * @param inputFile Name of file containing correctly formatted input data (see below)
	 * @param outputFile Name of file that will contain output data
	 * @param timeout How long a process can be on the processor before being kicked off
	 * @throws FileNotFoundException If either the input or output files are not found/created
	 */
	public static void simulateProcessor(String inputFile, String outputFile, int timeout) throws FileNotFoundException {
		Scanner processList = new Scanner(new File(inputFile));
		PrintStream processHistory = new PrintStream(new File(outputFile));

		simulateProcessor(processList, processHistory, timeout);

		processList.close();
		processHistory.close();
	}

	/**
	 * Takes input file Scanner and PrintStream to the output file from the simulateProcessor
	 * method above, along with the timeout, and actually runs the simulation. The input file
	 * contains one line per process to be loaded, and three columns. The first column is the
	 * start time, the second column is the execution duration, and all remaining text makes
	 * up the process name. Note that process names may consist of multiple string tokens
	 * separated by whitespace. Note that the start times of sequential processes in the file
	 * must be non-decreasing (times increase, but ties are allowed).
	 * 
	 * @param processList Scanner that reads the input file
	 * @param processHistory PrintStream to the output file
	 * @param timeout How long a process can be on the processor before being kicked off
	 */
	private static void simulateProcessor(Scanner processList, PrintStream processHistory, int timeout) {
		// Break up into helper methods
		// Load the data
		ArrayQueue<Process> startQueue = new ArrayQueue<>();
		loadData(processList, startQueue);

		// Simulate the processor
		ArrayQueue<Process> readyQueue = new ArrayQueue<>();
		int simulationTime = 0;
		boolean done = false;
		while (!done) {
			// If process at front of start queue has arrived, move to ready queue
			while (!startQueue.isEmpty() && startQueue.getFront().getStartTime() <= simulationTime) {
				readyQueue.enqueue(startQueue.dequeue());
			}

			if (!readyQueue.isEmpty()) {
				// Then run the process
				Process p = readyQueue.dequeue();
				int timeToRun = timeout; // Not always this
				if (p.getTimeRemaining() < timeout) timeToRun = p.getTimeRemaining();
				p.executeForTime(timeToRun); // simulate running on the processor

				processHistory.println("At time " + simulationTime + ": run \"" + p.getName() + "\" for " + timeToRun + " time units");
				simulationTime += timeToRun;

				//Process p is not finished yet
				if (p.getTimeRemaining() > 0) {
					// Process needs to wait for the next cycle
					p = new Process(p.getStartTime(), p.getTimeRemaining(), p.getName());
					
					// Enqueue incomplete process back to readyQueue after other processes that should execute first
					while (!startQueue.isEmpty() && startQueue.getFront().getStartTime() < simulationTime) {
						readyQueue.enqueue(startQueue.dequeue());
					}
					readyQueue.enqueue(p);
				}
			} else {
				// CPU idle until the next process start time
				processHistory.println("CPU idle from time " + simulationTime + " until time " + startQueue.getFront().getStartTime());
				simulationTime = startQueue.getFront().getStartTime();
			}
			// If both queues are empty, we finish the simulation
			if (startQueue.isEmpty() && readyQueue.isEmpty()) done = true;
		}
	}
	
	/**
	 * Helper method that reads process start time, time to completition and name, from the input Scanner 
	 * and adds processes to a startQueue that will later send the processes to another launch queue.
	 * Each line in the scanner represents a process with their corresponding properties following the 
	 * rules assigned for the implementation.
	 * 
	 * @param processList Scanner that reads the input file
	 * @param startQueue ArrayQueue to store processes for simulation
	 */
	private static void loadData(Scanner processList, ArrayQueue<Process> startQueue) {
		while(processList.hasNextLine()) {
			int startTime = processList.nextInt();
			int runTime = processList.nextInt();
			String name = processList.nextLine().trim(); // trim removes surrounding whitespace

			Process process = new Process(startTime, runTime, name);
			startQueue.enqueue(process);
		}

		processList.close();
	}

	/**
	 * Can run the program from here for troubleshooting purposes.
	 * Use these commands in the console.
	 * 
	 * javac -cp src/main/java/queues src/main/java/queues/*.java src/main/java/scheduler/Scheduler.java
	 * java -cp src/main/java scheduler.Scheduler
	 * 
	 * @param args Ignored
	 */
	public static void main(String[] args) {
		System.out.println("Running simulation from main method.");
		Scanner example = new Scanner("0      50   First\n"
		                             +"0      100  Second\n"
		                             +"0      50   Third");
									 
		simulateProcessor(example, System.out, 50);	
	}
}                     