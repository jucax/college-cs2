[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13902261)
# Recursion

Recursion is an important topic in Computer Science that will become increasingly relevant throughout the semester and in later classes. It is also a challenging concept that many students have to see multiple times before fully grasping. When something is recursively defined, it means that it is defined in terms of itself. From a purely syntactical standpoint, a recursive method is one where you call the method you are defining from inside of that same method. This is known as the recursive case. Of course, in order to actually terminate, every recursive case needed a base case, which is a case where you do not make a recursive call. This lab will focus on both simply and advanced examples of recursion, and be used in two different class sessions.

## Day 1: Basic Recursion

This lab starts by focusing on fairly simple examples. In fact, many of the examples in `src/main/java/recursion/Basic.java` are merely for instructional purposes, and do not actually represent good examples of when you should use recursion. Still, this does not mean that all of them are easy to understand. In particular, there are some examples of recursively processing arrays and linked chains, which requires a few tricks. The linked chains used here are defined slightly differently because there is no data structure to wrap them in, but the internal `Node` class has enough similarities that you should be able to understand how it is used.
Try to implement all methods to pass the tests in `src/test/java/recursion/BasicTest.java`. You can also look at the code inside of this test class to learn more about how the linked chains are manipulated. Run these tests with the following command in the terminal:
```
gradle test --tests 'recursion.BasicTest'
```
If you add any code to the `main` method of `Basic`, you can execute it using the command:
```
bash run_day1.bash
```

## Day 2: Advanced Recursion

This session focuses on some situations where recursion makes a bit more sense, but first discusses the famous Fibonacci sequence. This well-known mathematical sequence is typically recursively defined. However, using a naive recursive approach ends up being horribly inefficient. You are then asked to implement a more efficient approach that is still recursive. Note that in Assignment 5, you will learn yet another way to efficiently implement recursive methods, including the Fibonacci sequence, by saving and reusing previously calculated values, but that is not the focus for today. The remaining exercises are challenging but fitting applications of recursion. When working on the advanced problems, keep in mind that a recursive method can make multiple recursive calls, and could even have a loop that makes recursive calls from inside of it. The file you will work on is `src/main/java/recursion/Advanced.java`. The last problem in this file deals with finding a route to a goal in a maze, and if you run the `main` method of this file you can print out a simple visualization to the console of solutions to this problem, once you have implemented the solution at least. To simply unit test the code, run this command:
```
gradle test --tests 'recursion.AdvancedTest'
```
To test your maze solution, or run any other code that you place in 
the `main` method of `Advanced`, execute this command:
```
bash run_day2.bash
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
