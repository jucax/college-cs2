[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13866667)
# Assignment 4: Stacks and Lisp Expressions

Our book explained how to use a stack to process mathematical expressions in postfix notation, and how to convert expressions from infix to postfix notation. Prefix notation was also mentioned, but no algorithms concerning this notation were presented. This assignment requires you to write code that evaluates expressions written in a particular variant of prefix notation associated with the Lisp programming language.

Lisp is the second oldest programming language, and is still in common use. It is known for its exclusive use of prefix notation and its heavy use of parentheses. Here is an example of a simple mathematical expression in Lisp being simplified:

```
  (+ 6 (- (* 2 5) 2))
= (+ 6 (- 10 2))
= (+ 6 8)
= 14
```

If you paid attention to the discussion in the book, then at this point you may be wondering why all of these parentheses are necessary if we are using prefix notation ... isn't one of the advantages of prefix notation that all expressions are unambiguous without parentheses? The reason this is usually true is that every mathematical operator (`+`, `-`, etc) has a known arity (number of operands or parameters). Usually, we allow/require `+`, `-`, `*`, and `/` to have exactly two operands, but this is not true in Lisp, because the four basic arithmetic operators are generalized to take an arbitrary number of operands in the following fashion:

- `(+ a b c ...)` is the sum of all of the operands. Additionally, `(+)` by itself returns `0`.
- `(- a b c ...)` is `a - b - c - ...`, and `(- a)` returns `-a`. The minus operator must have at least one operand.
- `(* a b c ...)` is the product of all of the operands. Additionally, `(*)` by itself returns `1`.
- `(/ a b c ...)` is `a / b / c / ...`, and `(/ a)` returns `1/a`. The division operator must have at least one operand.

Given this information, see how a more complicated Lisp expression gets evaluated:

```
  (+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))
= (+ (- 6) (* 2 3 4) (/ 3 1 -2))
= (+ -6 24 -1.5)
= 16.5
```

You can evaluate more Lisp expressions at [this website](https://common-lisp.net/downloads), which provides an online interpreter for a variant of Lisp. 
Simply click on the red "Try Lisp Online" button.
You can use this site to check what the correct output for any expression is, which will help you with the following assignment: write a program that evaluates strings of arithmetic Lisp expressions.
	
Here are the files that you will need:

## Files

- `REFLECTION.txt` (edit and submit): The reflection questions for this assignment. The answers you give should be very specific based on your experience working on this assignment. Do not answer with vague generalities about the power of hard work.
- `src/main/java/stack/StackInterface.java` (do not change): This is the interface for a stack data type from our textbook.
- `src/main/java/stack/LinkedStack.java` (edit and submit): You need to have a complete implementation of the `LinkedStack` for this assignment. You can copy the code from the book, though we have likely developed all of the code in class as well, so you can feel free to use the class code.
- `src/test/java/stack/LinkedStackTest.java` (edit and submit): Before working on evaluating Lisp expressions, you must thoroughly test your stack implementation. This file indicates how much testing is required, but it is ultimately up to you to provide all test cases. Be sure you cover a range of interesting cases, since the quality of your tests is one component of your grade.
- `src/main/java/lisp/LispEvaluate.java` (edit and submit): This is your main program, which takes arithmetic Lisp expressions and evaluates them. You must write the method `lispCalculate` in order to evaluate each expression, but some other helper methods are also provided to guide you. Do NOT use an `ArrayList` or plain array in this file at all. Your solution should be based on stacks.
- `src/test/java/lisp/LispEvaluateTest.java` (edit and submit): This class tests the `lispCalculate` method. Make sure you thoroughly test your code, since the quality of your tests is part of your grade.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests and compile the project.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing and Running

You will want to run unit tests and the Lisp evaluation program to evaluate your code. As in the previous project, you can run tests with this command:
```
gradle clean test
```
This will test the functionality of both the `LinkedStack` and `LispEvaluate`. However, you can also compile the project into a `.jar` file that runs the `main` method in `LispEvaluate`. Use this command:
```
gradle build
```
However, this command will only work if all of your unit tests pass. If you want to skip the unit tests when compiling then you can use this command:
```
gradle build -x test
```
This command compiles the code into a runnable `.jar` file: `build/libs/CS2A4-PrefixLispExpressions.jar`. You can run it with this command from the main project directory in the terminal:
```
java -jar build/libs/CS2A4-PrefixLispExpressions.jar
```
However, you may find it simpler to select `Run -> Run Without Debugging` from the menu while `LispEvaluate.java` is selected. However, this will require you to install several Java-related extensions that the VS Code environment recommends to you from within the codespace.

## Evaluating Lisp Expressions

Your solution to evaluating Lisp expressions must use a stack or stacks. The starter code provides headers for some helper methods that convert the prefix Lisp expressions into postfix expressions so that you can use an algorithm similar to the one provided in the book for postfix expressions, though the algorithm from the book will require some modifications on account of Lisp operators not having fixed arity. Here are some general tips to consider:

- Though not required for testing, adding a `toString` method to your stack class will make troubleshooting much easier.
- If you insert whitespace between parentheses and other parts of an expression, you will have a much easier time processing it with a `Scanner`'s `next` method.
- You can assume that all input expressions are valid, and will never produce results like infinity or `NaN` (not a number), which are valid but unusual `double` values. This is useful, because `Double.NaN` can be inserted into a stack, which can be detected using the `Double.isNaN` method. This special symbol can be used to signify some kind of important distinction between values above and below `NaN` in a stack.
- The code for handling the distinction between the versions of `-` and `/` that have one vs. many operands can be complicated. Try getting the many operand versions working first, then worry about the single operand versions.

## Grading

I will only be grading `REFLECTION.txt`, `LinkedStackTest.java`, `LispEvaluateTest.java`, and `LispEvaluate.java`. One important restriction for this assignment is that you are *NOT* allowed to use an `ArrayList` or arrays at all. I will use my own copies of the stack interface and stack implementation from the book to grade your code. Here is the grading rubric for this assignment:
- 10%: `REFLECTION.txt`: thoughtful answers to each question
- 15%: `LinkedStackTest.java`: quality/correctness of tests
- 10%: `LispEvaluateTest.java`: quality/correctness of tests
- 35%: `LispEvaluate.java`: correctness of code
- 30%: `LispEvaluate.java`: quality of comments and style/organization

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
