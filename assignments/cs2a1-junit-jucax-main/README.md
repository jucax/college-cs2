[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13465693)
# Assignment 1: JUnit Testing

This assignment is a brief introduction to JUnit testing as well as a refresher on various topics from CS1. JUnit testing will be an important part of all future assignments, making this an important assignment to complete and understand. 
```diff
- In contrast to most future assignments, you are allowed and expected to search the internet 
- for any information you want about JUnit or about basic CS1 concepts, but any links/URLs that 
- influenced your code should be provided in the comments of the file you turn in to avoid 
- violating the Honor Code.
```

## Files

There are four provided source files and a text file called `REFLECTION.txt`. Each source file contains TODO comments that indicate where you must provide code. My comments describe the code and tests you must provide. You must also answer the questions in `REFLECTION.txt` as well.

- `REFLECTION.txt` (edit and submit): Every assignment will require you to write brief but thoughtful reflections on the code you have written and your development as a programmer. Often, the same questions will be repeated across several assignments, so be sure to target your response to the specific assignment you have just completed.
- `src/main/java/SimpleStaticMethods.java` (edit and submit): Several method headers are provided. You must provide nearly all code for nearly all of these methods. The comments describe the required behavior of each method.
- `src/main/java/ScannerMethods.java` (edit and submit): This class also provides several method headers, but these methods deal with the `Scanner` class. You must provide the code for these methods, and fit them to the provided descriptions in the comments.
- `src/test/java/SimpleStaticMethodsTest.java` (edit and submit): This class tests the methods in `SimpleStaticMethods.java`. These methods already contain some test cases, but you must provide more. In particular, it is important to test extreme/corner cases. Try inputting large/unusual values to make sure that all methods behave properly.
- `src/test/java/ScannerMethodsTest.java` (edit and submit): This class tests the methods in `ScannerMethods.java`. In order to test these methods, this class creates a text file before all of the tests, and links a `Scanner` to it before each individual test. The resulting `Scanner` should be used in the individual tests. However, you should also create `String` `Scanner`s in your tests too.
- `run-simple.bash` (do not change): Executes the `main` method of `SimpleStaticMethods`.
- `run-scanners.bash` (do not change): Executes the `main` method of `ScannerMethods`.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests. Type `gradle clean test` in the terminal and press enter to run the JUnit tests.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing

To see if your code passes the unit tests (both mine and the ones that you will write), simply type the following command in the terminal and press enter:
```
gradle clean test
```
You want all tests to pass before submitting, but you also need to make sure that your tests are thorough enough to properly test the code.

Although the above command is part of how the code will ultimately be graded, you may need more information or control over the code when troubleshooting. Both the `SimpleStaticMethods` class and the `ScannerMethods` class have `main` methods that are empty, but you can choose to call any method with any test values you want from these `main` methods. The execute the `main` method of `SimpleStaticMethods`, execute:
```
bash run-simple.bash
```
To execute the `main` method of `ScannerMethods`, execute:
```
bash run-scanners.bash
```

## JUnit Tips

Pay attention to the following method annotations recognized by JUnit:

- `@BeforeAll`: a method that is executed once before any tests in the class are executed.
- `@AfterAll`: a method that is executed once after all tests in the class are executed.
- `@BeforeEach`: a method that is executed before each individual test.
- `@AfterEach`: a method that is executed after each individual test.
- `@Test`: a test that verifies correct behavior of certain code.

A test will contain one or more assert commands that should succeed if your test and code are properly designed.

## Grading

The provided files are already well-commented, and therefore should not require much in the way of additional comments. However, all future assignments must be commented as extensively as these files, so you should pay attention to the examples provided here. This assignment will be graded in the following manner:

- 10%: `REFLECTION.txt`: thoughtful answers to each question
- 24%: `SimpleStaticMethods.java`: correctly functioning code
- 18%: `ScannerMethods.java`: correctly functioning code
- 24%: `SimpleStaticMethodsTest.java`: adequate, correct, and thorough tests
- 24%: `ScannerMethodsTest.java`: adequate, correct, and thorough tests

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
