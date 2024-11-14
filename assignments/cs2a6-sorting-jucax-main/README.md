[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14137263)
# Assignment 6: Sorting

This assignment is a fairly straightforward task of implementing sorting algorithms from our course text. We have already implemented some of this code in class, and most of it is available in the book anyway (a few key details were left out, and you will need to fill these in). Since we are sorting `Comparable` objects rather than simple numbers, you will need to use `compareTo` method calls in place of standard inequality comparisons.
	
Even though you are following along with the book to write your code, the process of actually implementing these well-known algorithms should give you a greater appreciation for how they work. Additionally, you will gain an appreciation for how tricky it can be to properly implement them. Here are the files you will need:

## Files

- `src/main/java/sorting/Sorting.java` (edit and submit): Method stubs are provided for the sorting methods you must implement. Some helpful utility methods are also provided (**use them!**). The four sorting methods you must implement are selection sort, insertion sort, merge sort, and quicksort. Do **NOT** change any of the method headers. However, you will need to add helper methods.
- `src/test/java/sorting/SortingTest.java` (do not change): This file contains tests for all four sorting methods you must write in `Sorting.java`. Do not change this file. You are spared from needing to write your own tests for this assignment.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Sorting

Most details on how to implement the required sorting algorithms are available in the book. Some tips are also provided in the comments of the starter code. Be sure to adequately comment all code that you write, and all additional methods you provide. Both your comments and your style will be graded. **For this assignment, you may search the internet for source code of any of these algorithms, but you must type it yourself and adhere to the method headers I provide.** 

```diff
- Provide the link URLs of any sources you use in comments.
```

## Testing

To execute the tests written by me, simply run the following console command:

```
gradle clean test
```

It is important to note that there are many ways of sorting an array, and it is possible to have a flawed implementation that still somehow succeeds in sorting the array. Generally, such flawed solutions only appear to work by being much less efficient than they should be. You could also make the mistake of using the wrong sorting algorithm with a given method name. Therefore, it is possible to lose points for correctness even if you pass all tests. As always, I will visually inspect your code to check its correctness.

If you want to debug the code without running test cases, for example by adding print statements to see what values variables have during execution, then you can call methods from the `main` method of `Sorting.java`. To execute the code here, first compile it with (this will skip unit testing):
```
gradle build -x test
```
and then execute the compiled jar file with this command
```
java -jar build/libs/CS2A6-Sorting.jar
```

## Grading

There is no `REFLECTION.txt` this time. Your assignment will be graded based on the following:

- 20%: `Sorting.java`: Functionality of selection sort
- 20%: `Sorting.java`: Functionality of insertion sort
- 20%: `Sorting.java`: Functionality of merge sort
- 20%: `Sorting.java`: Functionality of quick sort
- 20%: `Sorting.java`: Comments and style across all code

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.
