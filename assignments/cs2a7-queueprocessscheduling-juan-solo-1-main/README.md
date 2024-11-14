[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14194682)
# Assignment 7: Queues - Process Scheduling

The queue is another important data structure that has many uses in computer science. One use is the management of process scheduling by an operating system. You will learn much more about this in later computer science courses, but a rudimentary understanding of how an operating system manages processes is needed for this assignment.
	
A *process* is a program that is loaded into memory for execution. This assignment models a simple system that only has one processor. Only one process can execute on the processor at a time, but the operating system creates the illusion of multiple simultaneously running processes by quickly switching between them. A fair way to assure that all processes have a shot at executing is to use a queue. As processes are launched, they are added to a ready queue, and whenever the processor is idle, the next process to execute comes off of the queue. However, you do not want one long-running process to dominate the processor and prevent others from running. Therefore, there is a pre-set timeout period for processes. This means that whenever a process is executing, it either stays on the processor until it finishes, or it gets booted off after the timeout period elapses ... whichever comes first. Whenever a process is booted off of the processor, it gets added to the back of the ready queue. The point of this programming assignment is to simulate the process scheduler. You will need to start with the following files:

## Files

- `REFLECTION.txt` (edit and submit): The reflection questions for this assignment. Note that two of the questions were also asked on the previous assignment. The answers you give should be updated and revised based on your experience working on this assignment.
- `src/main/java/queues/EmptyQueueException.java` (do not change): Exception that your queue implementation throws when attempting to access an element from an empty queue.
- `src/main/java/queues/QueueInterface.java` (do not change): Interface that your queue implementation must adhere to.
- `src/main/java/queues/ArrayQueue.java` (create from scratch and submit): You need to have a complete implementation of the circular `ArrayQueue` for this assignment. You can copy the code from the book, though we have potentially developed all of the code in class as well, so you can feel free to use the class code.
- `src/test/java/queues/ArrayQueueTest.java` (create from scratch and submit): By now you should know how to thoroughly test code, so you must create JUnit test cases for your queue implementation from scratch. Be sure to thoroughly test all methods.
- `src/main/java/scheduler/Scheduler.java` (edit and submit): This is your main program, which simulates process scheduling on a computer with only one processor.
- `src/test/java/scheduler/SchedulerTest.java` (edit and submit): This file tests the correct functioning of your scheduler simulation. Note that because the scheduler simulator takes file input and creates file output, the test cases must also do the same. One test case is provided, but you must create more.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing

To execute the unit tests, simply run the following console command:

```
gradle clean test
```

Once you create the file `ArrayQueueTest.java` and store it in the correct directory, this testing command will automatically find those tests and run them too. You should start by implementing and thoroughly testing your queue implementation. Once this task is completed, you can move on to the scheduler. This testing command runs the scheduler tests as well.

However, if you want to debug the scheduler code without running test cases, for example by adding print statements to see what values variables have during execution, then you can execute the `main` method of `Scheduler.java`. To execute the code here, first compile it with (this will skip unit testing):
```
gradle build -x test
```
and then execute the compiled jar file with this command
```
java -jar build/libs/CS2A7-QueueProcessScheduling.jar
```

## Simulating Process Scheduling

Note that the class `Scheduler` has an embedded class within it named `Process`. **Do not change this class**, but use it in your simulation. It contains member variables associated with the relevant properties of a process, and it assures that only valid processes are created. Each process has a string `name`, which will appear in your output, a `timeToCompletion`, which is the number of simulated time units that the process must run on the processor, and a `startTime`, which is the simulated time at which the process becomes available for execution. You will not be simulating every actual unit of time, but will instead jump across stretches of time when nothing interesting is happening. This is why the `Process` has a `executeForTime` method that subtracts a given amount of time from the current `timeToCompletion`. Once `timeToCompletion` reaches `0`, a process is finished executing.

Information about processes, when they start executing, and how long they execute for is contained in a plain text input file like the following:

```
0	100	Initialization
0	200	Background service
10	150	Compiler
600	300	Virus scan
600	10	Quick process
610	150	Browser
1630	400	Movie clip
1890	350	Email
2100	100	Data processing
```

There are three columns. The amount of whitespace between columns is irrelevant, but the whitespace within process names (the third column) is important. The first column contains the time in the simulation at which the process is launched. Multiple processes can be launched at the same time, in which case the process that appears earlier in the file is launched first. In fact, a requirement of a validly structured input file is that all processes are listed in order of launch time. The numbers in the first column are therefore non-decreasing (allowing ties means the number does not need to increase, but it can never decrease). Simulated time starts at 0, so no processes may start at a negative time. The second column is how many time units the process must carry out on the processor in order to complete. If this time exceeds the timeout period for the scheduler, then the process will have to run multiple times on the processor in order to finish. This input example is contained within `SchedulerTest.java`. You must write the `simulateProcessor` method to take input files like this and produce the corresponding correct output. 

The output is a sequence of lines describing what the processor is doing for each interval of time. If the processor is running a process, then the start time will be provided, along with the name of the process, and the duration for which the process runs on the processor. If no processes are being run (which can happen if all launched processes finish before the start time of a later process), then the output indicates the start and end time of the idle period. There are also several formatting details to take into account to make the output completely correct. For the test case above, the following is the correct output when using a timeout period of `100`:

```
At time 0: run "Initialization" for 100 time units
At time 100: run "Background service" for 100 time units
At time 200: run "Compiler" for 100 time units
At time 300: run "Background service" for 100 time units
At time 400: run "Compiler" for 50 time units
CPU idle from time 450 until time 600
At time 600: run "Virus scan" for 100 time units
At time 700: run "Quick process" for 10 time units
At time 710: run "Browser" for 100 time units
At time 810: run "Virus scan" for 100 time units
At time 910: run "Browser" for 50 time units
At time 960: run "Virus scan" for 100 time units
CPU idle from time 1060 until time 1630
At time 1630: run "Movie clip" for 100 time units
At time 1730: run "Movie clip" for 100 time units
At time 1830: run "Movie clip" for 100 time units
At time 1930: run "Email" for 100 time units
At time 2030: run "Movie clip" for 100 time units
At time 2130: run "Email" for 100 time units
At time 2230: run "Data processing" for 100 time units
At time 2330: run "Email" for 100 time units
At time 2430: run "Email" for 50 time units
```

Note that every aspect of the formatting of the output must match in order to pass the test case. This test case is useful because it already deals with some tricky situations, but you will certainly want to make some easier test cases to get started (one easy test case is also provided in `SchedulerTest.java`). Regardless, here are some helpful observations about the result above:

- The `Initialization` process runs exactly once because the timeout period of `100` happens to exactly equal to duration of this process. In fact, a problem with this test case is that many (but not all) of the processes have durations that are divisible by the timeout period. Be sure to consider more interesting cases.
- Note that a single line of text covers each interval within which the processor (CPU) is idle, no matter how long that interval is. In contrast, the process `Movie clip` runs back to back for several consecutive intervals because it is the only active process in the system, but there is a separate line of output for each interval.
- Note that the double quotes around each process name are not part of the original input, and must be added to perfectly match the specification.
- Although the timeout period is `100`, not every start time is divisible by `100`. This is because process durations and start times do not need to be divisible by `100`, and thus the processor could suddenly start executing a process at any time.

In order to complete this assignment, I recommend using two queues of processes. The first is the launch queue, and should be loaded with all processes from the input file as soon as the `simulateProcessor` method is launched. Because the input file must contain processes in non-decreasing order of start time, processes will move from the launch queue to your second queue, the ready queue, in order. The ready queue should immediately be loaded with all processes from the launch queue that have a start time of `0`. From this point, you simply need to loop until both queues are empty, and do the following:

- If the ready queue is empty, figure out when the next process from the launch queue starts, and advance the time to that point.
- If the ready queue is not empty, dequeue a process and run it on the processor. Advance the time accordingly.
- Noting the time, move processes from the launch queue to the ready queue as necessary.
- If the process that just used the processor did not finish, then load it back onto the ready queue. Note that it should be behind any newly added processes from the launch queue.

## Grading

You are required to write one method in `Scheduler.java`, though the use of additional helper methods is certainly appropriate. You won't be able to run any code without a correctly functioning `ArrayQueue.java` implementation, though I will not be grading this file at all. I will replace it with my own version of the queue, and the tests that you write in `ArrayQueueTest.java` must match my queue implementation. You must also write additional tests of the scheduler in `SchedulerTest.java`. As usual, you will be graded for the quality of both your style and comments, so break up and explain your code accordingly. Complete details of how assignments will be graded is as follows:

- 10%: `REFLECTION.txt`: thoughtful answers to each question
- 20%: `ArrayQueueTest.java`: Thorough testing of your queue implementation 
- 35%: `Scheduler.java`: Correctly functioning scheduler simulation 
- 10%: `Scheduler.java`: Style and comments in your scheduler simulation 
- 25%: `SchedulerTest.java`: Thorough testing of your scheduler simulation 

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
