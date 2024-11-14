[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13431297)
# CS1 Refresher

This lab will introduce you to using GitHub codespaces, unit testing with gradle, and refresh you on some content that you hopefully learned in CS1. However, everyone's background is different, and some people have programmed less frequently/recently than others, so don't worry if you can't complete all of these exercises. However, do let me know where you need the most help, so I can help you fill in the gaps.

## Code to Write

The file you need to write code in is `src/main/java/refresh/Refresh.java`. The reason that such a convoluted file path is needed is because the tool we will be using for unit testing, `gradle`, imposes some restrictions on the directory structure. More on this in a moment. There are too many exercises in `Refresh.java` for you to reasonably complete in the class time. I recommend that you attempt one or two easy exercises of your choice, and then challenge yourself by specifically attempting one that you perceive as more difficult. If you successfully code these exercises, then keep going, but be sure to verify that your code works before moving on to other exercises.

If you are working in GitHub codespaces, then the browser-based IDE environment is essentially the same as VSCode (Visual Studio Code). Some extensions to support Java can be installed to help, and we will walk through these steps in class.

## Unit Testing

A major focus of this class will be writing unit tests to verify the functionality of your code. However, for today, you will mainly just be using pre-existing unit tests to be able to appreciate their benefit. To test the functionality of your code, type the following in the console and press enter:
```
gradle test
```
Given that you are starting from scratch, this should report that the build failed. All of the exercises will be listed with a stack trace detailing exactly how the output produced by your code differs from what was expected. As you succesfully complete the exercises in `Refresh.java`, the red FAILED messages will change to green PASSED messages.

The actual tests being executed are in `src/test/java/refresh/RefreshTest.java`. There is a test method associated with each exercise in this file, and each method has one or more assertion commands that indicate that some output is expected from running the code.

## Running Without Unit Testing

Sometimes a test won't pass, and you don't understand why. In these situations, it can be helpful to run the code without testing it.
Perhaps you want to add print statements to the code that output the values of variables for the sake of troubleshooting. There is a
`main` method inside of `Refresh.java` that is empty. You can add any code here that you want, such as a method call to one of the
exercises. In order to compile and run that main method in the terminal, execute this command:
```
bash run.bash
```
This command still uses `gradle`, so you'll see a message about the build succeeding before seeing any output from your
code. Of course, this assumes your code has no syntax errors and successfully compiles. It cannot run if it cannot compile.

## Saving your work

Changes to files in a GitHub codespace are saved within that codespace automatically, but they are not saved to your repository automatically. You will only be able to see the changes in the codespace itself and not within the associated repository, but codespaces eventually get deleted after being inactive for too long. To save your work permanently, you need to commit and push your changes using command line `git` commands. This will present a bit of a technical hurdle, but hopefully you will become used to it in time.

You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then your code is not in the repository yet. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then let me know so that I can help.
