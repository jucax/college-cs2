[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14084122)
# Queues

Queues are another fundamental data structure that will appear in multiple future CS courses. They are often used to buffer
data comming from the internet or from peripheral devices. They are also used by the Operating System to schedule processes. Queues are another form of limited access data structure, but a queue adds elements at one end and removes them from the other. They are known as First-In-First-Out (FIFO) data structures, or equivalently as Last-In-Last-Out (LILO). The queue can also be generalized into a double-ended queue, known as a deque. Elements can be added to and removed from either end of a deque.
This repository will be used in three different class sessions.

## Day 1: Using a Queue

This lab introduces you to the queue data structure by letting you solve problems using an implementation whose code you cannot see. The file you need to write code in is `src/main/java/client/UseQueue.java`. Construct queues of type `MysteryQueue` when needed and store them in variables of type `QueueInterface`. See if you can complete all empty methods.
Completed unit tests for all of these methods exist in `src/test/java/client/UseQueueTest.java`. You can learn a lot about how queues work, and about proper unit testing by looking at the code in this file. If one of the methods you implement does not pass all tests, then you can look at the specific test here to get some sense of what is wrong. To test only the methods in this file, execute this command in the terminal:
```
gradle test --tests 'client.*'
```
If you add any code to the `main` method of `UseQueue`, you can execute it using the command:
```
bash run.bash
```

## Day 2: Array-based Circular Queue

This is another array-based data structure, but it is slightly more complicated than stacks and bags. In order to avoid constantly shifting elements around within the array, separate indices are maintained for the front and back of the queue, and both cycle forward as elements are added and removed. Once the end of the array is reached, these values wrap around back to the front. Once the back index catches up to the front, it means the array is full and needs to be resized, but the elements need to be reorganized when this happens. Also, note that the queue purposefully maintains an extra empty slot at all times to make it easier to distinguish between a full queue and an empty queue (since the front and back indices would be in the same relative locations in both cases otherwise). This lab will challenge you a bit by having you create the whole file from scratch. The file you create should be named `src/main/java/queues/ArrayQueue.java`. You will need a complete working version of this queue for Assignment 7. You will also need to thoroughly unit test the queue implementation for Assignment 7. The file `src/test/java/queues/ArrayQueueTest.java` exists, but all of its tests are empty. Once you've added tests to this file, you can run them with this command:
```
gradle test --tests 'queues.ArrayQueueTest'
```

## Day 3: Doubly-linked Deque

A queue can be generalized into a double-ended queue, also known as a deque. This deque implementation uses linked nodes, but differs from previous linked implementations in that each node is doubly-linked, having links to both the previous and next nodes. This difference introduces some complexity and special cases, but makes it easy to access elements from either end of the data structure for the purposes of adding or removing nodes. Although there is no assignment dealing specifically with deques, you will need to implement a different doubly-linked data structure in Assignment 9, so this lab is a good introduction to the concept. The file that will contain your implementation is `src/main/java/queues/LinkedDeque.java`. It has empty method headers, and also the implementation of the internal double-linked `Node` class. There is also a file `src/test/java/queues/LinkedDequeTest.java` which will contain the tests you write. These tests can be executed with the command:
```
gradle test --tests 'queues.LinkedDequeTest'
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
