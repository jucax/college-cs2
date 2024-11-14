[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13496450)
# Bags

The bag is our first data structure. It is simply an unordered collection of items that allows duplicates. In formal mathematics, a bag is known as a multi-set. A related data structure is a set, which is an unordered collection that does not allow duplicates. This repository will be used in three different class sessions.

## Day 1: Using a Bag

This lab introduces you to the bag data structure by letting you solve problems using a working bag implementation whose code you cannot see. The point is that you do not need to know how a bag is implemented in order to use it. In fact, different implementations exist, but they behave the same.
The file you need to write code in is `src/main/java/client/UseBag.java`. The methods here make use of `BagInterface` data types, but whenever you construct your own bag, you should construct one of type `MysteryBag` (no parameters).
See if you can complete all empty methods. You'll notice an unusual syntax using `<T>`. In these cases, the `T` denotes a generic type variable, in that it could represent any non-primitive type, such as `Integer`, `String`, etc. Completed unit tests for all of these methods exist in `src/test/java/client/UseBagTest.java`. You can learn a lot about how bags work, and about proper unit testing by looking at the code in this file. If one of the methods you implement does not pass all tests, then you can look at the specific test here to get some sense of what is wrong. To test only the methods in this file, execute this command in the terminal:
```
gradle test --tests 'client.*'
```
If you add any code to the `main` method of `UseBag`, you can execute it using the command:
```
bash run.bash
```

## Day 2: Array-based Bag

This session involves implementing an array-based bag as was done in the book. Use the class time to write the implementation in accordance with the book, asking for help understanding the implementation as you go. The file you will write is `src/main/java/bag/ArrayBag.java`. You will need a working implementation in order to work on Assignment 2. You should also start unit testing the bag to make sure it works, and because such tests are also needed as part of Assignment 2. In fact, both the `ArrayBag` and its associated unit test file `src/test/java/bag/ArrayBagTest.java` come from Assignment 2. The test file actually contains some example tests, but you should add to these. The command to execute these tests is:
```
gradle test --tests 'bag.ArrayBagTest'
```

## Day 3: Linked Bag

This session involves the implementation of a link-based bag. Linked nodes are an important and challenging concept that will come up repeatedly in this course. You will once again strive to implement the code from the book with guidance in class. The class to work on is in `src/main/java/bag/LinkedBag.java` and the unit test file is `src/test/java/bag/LinkedBagTest.java`. The tests in this file roughly match those from the `ArrayBag` tests, but are slightly modified because the `LinkedBag` has no fixed size. As before, additional cases should be added to thoroughly test your data structure, which can be done with this command:
```
gradle test --tests 'bag.LinkedBagTest'
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
