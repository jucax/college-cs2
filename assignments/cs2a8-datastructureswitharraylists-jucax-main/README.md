[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14433312)
# Assignment 8: Implementing Data Structures With Underlying ArrayLists

This assignment revisits several previous data structures we have discussed and gives you an opportunity to practice using the `ArrayList` datatype. The textbook provides its own definition and interface for an array-based list, but for this assignment you will be using the actual `ArrayList` class included with Java in the `java.util` package. You will be generating most of the code for this assignment from scratch.

## Files

Some interfaces are provided to start with, but most of the files need to be created by you:

- `src/main/java/main/Main.java` (ignored by me): You can run code from here to help with debugging, but you do not need to use this file at all, and it will be ignored by me during grading.
- `src/main/java/stack/StackInterface.java` (do not change): This is the stack interface provided in the book, which you have already used in a previous assignment.
- `src/main/java/deque/EmptyQueueException.java` (do not change): Same exception used with the previous assignment about queues.
- `src/main/java/deque/DequeInterface.java` (do not change): Deque interface provided by the book. A deque is a special variant of a queue.
- `src/main/java/set/SetInterface.java` (do not change): Set interface provided by the book. A set is a more restrictive variant of a bag.
- `src/main/java/stack/ArrayListStack.java` (create from scratch and submit): This is a stack that is implemented using an `ArrayList` for the underlying data storage. It must implement the `StackInterface`.
- `src/main/java/deque/ArrayListDeque.java` (create from scratch and submit): This is a deque that is implemented using an `ArrayList` for the underlying data storage. It must implement the `DequeInterface`.
- `src/main/java/set/ArrayListSet.java` (create from scratch and submit): This is a set that is implemented using an `ArrayList` for the underlying data storage. It must implement the `SetInterface`.
- `src/test/java/stack/ArrayListStackTest.java` (create from scratch and submit): This class contains JUnit test cases for all methods of your `ArrayListStack`.
- `src/test/java/deque/ArrayListDequeTest.java` (create from scratch and submit): This class contains JUnit test cases for all methods of your `ArrayListDeque`.
- `src/test/java/set/ArrayListSetTest.java` (create from scratch and submit): This class contains JUnit test cases for all methods of your `ArrayListSet`.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing

To execute the tests you eventually write, run the following console command:

```
gradle clean test
```

This should execute all tests in `ArrayListSet.java`, `ArrayListDequeTest.java`, and `ArrayListSetTest.java` as long as you have created and placed those files in the correct locations specified above. These tests should be thorough and well-structured, testing each method of each data structure.

There is also a file whose sole purpose is to act as a sort of scratchpad for testing your code. To execute the `main` method of `Main.java`, first compile it with (this will skip unit testing):
```
gradle build -x test
```
and then execute the compiled jar file with this command
```
java -jar build/libs/CS2A8-DataStructuresWithArrayLists.jar
```

## Implementation

The important thing to remember for all of these data structures is that they are **NOT** "array-based" implementations. They are based on the `ArrayList`. The only `private` instance variable needed in any of these implementations is an `ArrayList`, because the methods and data encapsulated in the `ArrayList` provide all of the additional functionality you need.

Creation of the stack should be relatively straightforward, as it is nearly identical to the vector-based stack implementation discussed in the book. Most of the JUnit test cases for this data structure can be taken directly from our previous assignment involving stacks (assuming you received a good grade on that portion of the previous assignment). However, some extra tests may be needed.
	
The other data structures you must implement are more interesting because we only discussed them briefly when covering them earlier in the semester. A deque is a double-ended queue (or a double-ended stack) because you can add and remove elements to/from either end of the structure. Further details are available in the book. A set is like a more restrictive bag. The main difference is that a set does not allow duplicate elements (in fact, a more formal name for a bag is a multi-set, because bags do allow multiple copies of the same element). Therefore, your `add` command must make sure an element is not already in the set before actually adding it. Further details are available in the book.
	
You should find that being able to use the `ArrayList` to implement these data structures is much easier than implementing them from scratch using a pure array or linked structure. Look at the [javadoc](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) for the `ArrayList` class in order to familiarize yourself with its methods. Note that the `ArrayList` behaves like the book's array-based list data structure in nearly every way.

An important aspect of the `ArrayList` functionality that must be tested is the way it automatically resizes the underlying array storage container. However, testing this aspect of the `ArrayList` when it is hidden inside of another data structure is tricky. You need to make sure that all methods of the stack, deque, and set work in the following two cases: 1) an `ArrayList` resize has never occurred, and 2) an `ArrayList` resize has occurred. These cases can be tested by initializing each `ArrayList` in the proper way in your setUp methods. Note that the `ArrayList` constructor can take a parameter defining its initial capacity, and that the add methods will automatically resize the array when you surpass the initial capacity.

```diff	
- Every method must indicate the big-Oh time complexity of running the method in the 
- best, worst, and average cases. Comments explaining why the big-Oh time is what it 
- is are also required. 
```

You should strive to make your implementations efficient, but they should also be very simple. Many, but not all, of the methods you implement will consist of a single line of code, because you can simply call a corresponding method of the `ArrayList`. When it comes to efficiency, some tradeoffs are inevitable, and even though the code will be easy to write, an `ArrayList` is not the best underlying data structure for all of the abstract data types you are creating for this assignment. In order to provide accurate big-Oh time complexities, you will need to thoroughly understand the costs of the various operations the `ArrayList` can perform. These costs are the same as the costs for the corresponding array-based list described in our book.

## Grading

There is no `REFLECTION.txt` this time. Also, the only comments that are being graded pertain to the big-Oh behavior of each method. Actual Javadoc header comments are in the interfaces themselves, and all of these methods should be so short that body comments are not really needed. Any tricky aspects of the implementation will need to appear in the explanation of the big-Oh runtimes anyway, so these are the only comments that are graded. Your assignment will be graded based on the following:

- 10%: `ArrayListStack.java`: Correct implementation
- 5%: `ArrayListStack.java`: Provide complete big-Oh information for each method
- 10%: `ArrayListStackTest.java`: Correct and thorough tests
- 16%: `ArrayListDeque.java`: Correct implementation
- 8%: `ArrayListDeque.java`: Provide complete big-Oh information for each method
- 13%: `ArrayListDequeTest.java`: Correct and thorough tests
- 16%: `ArrayListSet.java`: Correct implementation 
- 8%: `ArrayListSet.java`: Provide complete big-Oh information for each method
- 14%: `ArrayListSetTest.java`: Correct and thorough tests

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
