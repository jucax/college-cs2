[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13716579)
# Stacks

Stacks are a fundamental data structure which will come up repeatedly in future CS courses. They are used to manage method/procedure calls, but can also be used more directly to store and process data. Stacks are one type of limited access data structure. They only allow access from the top, where elements are pushed and popped. Since anything that enters a stack has to wait for elements that came afterward to leave before being able to leave themselves, stacks are First-In-Last-Out (FILO) data structures. They are also called by the equivalent name Last-In-First-Out (LIFO). This repository will be used in two different class sessions.

## Day 1: Using a Stack

This lab introduces you to the stack data structure by letting you solve problems using a working stack implmentation whose code you cannot see. The point is that you do not need to know how a stack is implemented in order to use it. In fact, different implementations exist, but they behave the same.
The file you need to write code in is `src/main/java/client/UseStack.java`. Construct stacks of type `MysteryStack` when needed and store them into variables of type `StackInterface`. See if you can complete all empty methods. 
Some of these algorithms were presented in the video lectures. See if you can recall the solutions without revisiting the videos first, but refer back to them, or the textbook, if needed.
Completed unit tests for all of these methods exist in `src/test/java/client/UseStackTest.java`. You can learn a lot about how stacks work, and about proper unit testing by looking at the code in this file. If one of the methods you implement does not pass all tests, then you can look at the specific test here to get some sense of what is wrong. To test only the methods in this file, execute this command in the terminal:
```
gradle test --tests 'client.*'
```
If you add any code to the `main` method of `UseStack`, you can execute it using the command:
```
bash run.bash
```

## Day 2: Stack Implementations

Having already seen array-based and link-based implementations of a bag, we can go through the implementations of stacks fairly quickly. They are slightly simpler, and their implmentations were already presented in the video lectures. The array-based stack is slightly complicated because the underlying array must resize when it gets full.
This file is `src/main/java/stack/ArrayStack.java`. 
However, you may want to focus more on the link-based stack first, since this file will be required for Assignment 4: `src/main/java/stack/LinkedStack.java`.
Both implementations have their associated unit test files as well: `src/test/java/stack/ArrayStackTest.java` and `src/test/java/stack/LinkedStackTest.java`.
These test cases can be essentially identical, though only the `LinkedStackTest` file will be needed for Assignment 4.
Tests of both stack implementations can be executed with this command:
```
gradle test --tests 'stack.*'
```

## Saving your work

Changes to files in a GitHub codespace are saved within that codespace automatically, but they are not saved to your repository automatically. You will only be able to see the changes in the codespace itself and not within the associated repository, but codespaces eventually get deleted after being inactive for too long. To save your work permanently, you need to commit and push your changes using command line `git` commands. 

You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then your code is not in the repository yet. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then let me know so that I can help.
