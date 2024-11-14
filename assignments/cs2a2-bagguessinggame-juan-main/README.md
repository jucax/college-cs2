[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13570703)
# Assignment 2: ArrayBag Guessing Game

This assignment has you use an `ArrayBag` to create a simple text-based guessing game. Here are some files to start with:

## Files

- `REFLECTION.txt` (edit and submit): The reflection questions for this assignment. Note that two of the questions were also asked on the previous assignment. The answers you give should be updated and revised based on your experience working on this assignment.
- `src/main/java/bag/BagInterface.java` (do not change): This is the interface for bags provided in our textbook. 
- `src/main/java/bag/ArrayBag.java` (edit and submit): You need to have a complete implementation of the fixed-size `ArrayBag` for this assignment. You can copy the code from the book, or use the class code. Make sure the default capacity is 25.
- `src/test/java/bag/ArrayBagTest.java` (edit and submit): Before you can work on the guessing game, you need to test your `ArrayBag` implementation. This file contains tests for the methods in the `ArrayBag` class, but you must provide additional test cases to each test method.
- `src/main/java/game/Guess.java` (edit and submit): This is where you will write the code for the guessing game. This is the main class with a `main` method that you must provide. There are some utility methods to help you, but you will need to provide additional methods.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests and compile the project.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing and Running

You will want to run unit tests and the guessing game program to evaluate your code. As in the previous project, you can run tests with this command:
```
gradle clean test
```
However, this will only test the functionality of the `ArrayBag`. To test the guessing game, you will need to interact with it yourself. First you need to compile the code. One way to do this is with this command:
```
gradle build
```
However, this command will only work if all of your unit tests pass. This makes some sense, because you cannot properly work on the guessing game code until the `ArrayBag` works. However, if you want to skip the unit tests when compiling then you can use this command:
```
gradle build -x test
```
This command compiles the code into a runnable `.jar` file: `build/libs/CS2A2-BagGuessingGame.jar`. You can run it with this command from the main project directory in the terminal:
```
java -jar build/libs/CS2A2-BagGuessingGame.jar
```
However, you may find it simpler to select `Run -> Run Without Debugging` from the menu while `Guess.java` is selected. However, this will require you to install several Java-related extensions that the VS Code environment recommends to you from within the codespace.

## Guessing Game

Here are the details of the guessing game. The user can play multiple games in a session. After agreeing to play a game, the user is asked to provide two positive integers. The first is `m`, the maximum integer value that can be contained in the bag, and the second is `n`, the number of items in the bag. Behind the scenes, the program then adds `n` randomly chosen integers in the range 1 to `m` (inclusive) into an `ArrayBag`. The contents of the bag remain the same throughout the course of a game, but change for each new game played. Once the bag is filled, the user is repeatedly asked to guess the items in the bag. After `n` integers are provided, the program lets the user know how many of the provided numbers are actually in the bag, unless the user guessed all of the values in the bag, in which case the user wins and the game ends (there is no way to lose, except to terminate the program). The user is repeatedly asked to guess `n` integers until succeeding.

Note that it is possible for your bag to have multiple copies of the same number. If there are more copies of a number in the bag than the user specified, then the user only gets credit for the numbers entered. For example, if the bag contains four copies of 5, and the user guesses 5, 5, 6, 7, then the feedback will say that the user made 2 correct guesses. Similarly, guesses beyond what is actually in the bag also do not receive credit. For example, if the bag contains 5, 5, 6, 6, and the user guesses 5, 5, 5, 7, then the program will tell the user that there are 2 correct guesses.

The code that you submit in `Guess.java` must be well commented with javadoc style. All parameters (`@param`) and return values (`@return`) for methods must be tagged in comments, and interesting or complicated code within the methods must also be commented. You should break your code up into several methods rather than putting it all into the `main` method.

Here is a transcript from a sample interaction with the finished program. Note that it contains both text output from the program, and text input provided by the human user. 
```diff
- The text prompts used in your program should match the formatting in this example exactly.
```

```
Do you want to play the guessing game? (y/n)? y
What is the largest number that can be in the bag? 10
How many items are in the bag? 4
Try to guess the numbers in the bag.
There are 4 numbers from 1 to 10.
Guess for item #1: 1
Guess for item #2: 2
Guess for item #3: 3
Guess for item #4: 4
2 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 4 numbers from 1 to 10.
Guess for item #1: 1
Guess for item #2: 2
Guess for item #3: 5
Guess for item #4: 6
3 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 4 numbers from 1 to 10.
Guess for item #1: 1
Guess for item #2: 2
Guess for item #3: 5
Guess for item #4: 7
3 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 4 numbers from 1 to 10.
Guess for item #1: 1
Guess for item #2: 2
Guess for item #3: 5
Guess for item #4: 8
You are correct!
Do you want to play the guessing game? (y/n)? y
What is the largest number that can be in the bag? 4
How many items are in the bag? 2
Try to guess the numbers in the bag.
There are 2 numbers from 1 to 4.
Guess for item #1: 1
Guess for item #2: 1
0 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 2 numbers from 1 to 4.
Guess for item #1: 2
Guess for item #2: 2
0 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 2 numbers from 1 to 4.
Guess for item #1: 3
Guess for item #2: 3
0 of your guesses are correct. Guess again.
Try to guess the numbers in the bag.
There are 2 numbers from 1 to 4.
Guess for item #1: 4
Guess for item #2: 4
You are correct!
Do you want to play the guessing game? (y/n)? n
```

## Grading

I will only be grading `REFLECTION.txt`, `ArrayBagTest.java`, and `Guess.java`. One important restriction for this assignment is that you are *NOT* allowed to use an `ArrayList` at all. I will use my own copies of the bag interface and bag implementation from the book to grade your code. Here is the grading rubric for this assignment:
- 10%: `REFLECTION.txt`: thoughtful answers to each question
- 25%: `ArrayBagTest.java`: quality/correctness of additional tests
- 40%: `Guess.java`: correctness of guessing game code
- 25%: `Guess.java`: quality of comments and style/organization

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
