[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14497294)
# Assignment 9: Doubly Linked List With ListIterator

This assignment requires you to implement a variant of a linked list in which the nodes have links going in both directions, thus allowing for quick traversal both forward and backward when using a `ListIterator`, which you must also implement for this class. Though conceptually simple, correct implementation of all aspects of the program will be tricky. In particular, you will need to demonstrate a thorough understanding of how to maintain and manipulate various memory references. The files you will need to get started are below:

## Files

- `REFLECTION.txt` (edit and submit): The reflection questions for this assignment. Note that two of the questions were also asked on the previous assignment. The answers you give should be updated and revised based on your experience working on this assignment.
- `src/main/java/list/ListInterface.java` (do not change): This is the interface for lists from our textbook, but I have modified the comments to indicate that the first element in the list is at index 0, as with standard Java lists.
- `src/main/java/list/ListWithListIteratorInterface.java` (do not change): This is the only interface that your list should actually implement. It extends the `ListInterface` above, and also the `Iterable` interface. Additionally, it adds a `getIterator` method that returns a `ListIterator`. This method contrasts with the `iterator` method of the `Iterable` interface, which only returns a plain `Iterator` ... the `getIterator` method spares you the hassle of casting from `Iterator` to `ListIterator` in order to gain access to the methods unique to that class.
- `src/main/java/list/DoublyLinkedList.java` (edit and submit): This file will contain your actual list implementation. The signatures for all needed public methods are specified, but you must provide the actual code. You may also need to create completely new `private` methods in order to avoid unnecessarily copied code in some places. However, writing efficient code should be your primary concern.
- `src/test/java/list/DoublyLinkedListTest.java` (edit and submit): This file contains the JUnit tests for your doubly linked list. All needed methods are present, and if you follow the instructions in the TODO comments, then you should be able to fully test both the list and its iterator. I will grade your tests for the `DoublyLinkedList`, but I will not grade tests for the iterator.
- `build.gradle` (do not change): This is a project configuration file that makes it easy to run unit tests.
- `.gitignore` (do not change): Tells GitHub to ignore certain files generated from compiling your code.
- `README.md` (do not change): The file you are currently reading.

## Testing

To execute my tests and the tests you eventually write, run the following console command:

```
gradle clean test
```

This command runs unit tests for the main list methods and for the list iterator. You must write tests for the list methods, but I have provided tests for the iterator. However, **you should note that these tests are insufficient! You can pass all of these tests and still have errors in your implementation.**

If you want to debug the code without running test cases, for example by adding print statements to see what values variables have during execution, then you can execute the `main` method of `DoublyLinkedList.java`. First compile the code with this command (this will skip unit testing):
```
gradle build -x test
```
and then execute the compiled jar file with this command
```
java -jar build/libs/CS2A9-DoublyLinkedList.jar
```

## Implementation

A good place to start with this assignment is the standard singly linked list implementation from the book. **However, recall that this assignment requires the list indices to start at `0` instead of `1`, so you will need to make some small changes to the book code.** You will then need to modify your code to make proper use of the doubly-linked nodes. Always make sure that your nodes have a link to both the preceding and following nodes. The previous link from the first node will be `null`, and the next link from the last node will also be `null`. Watch out for special cases associated with the start and end of the list.

Some of the list methods need to access a particular index. In a standard linked list, such methods must start at the first node and traverse links until the desired index is found. However, all such methods in your doubly-linked list must use the following trick to make such access slightly more efficient: if the desired index is greater than the midpoint of the list, then list traversal should start at the last node and go backward. Access to the lower half of the list should occur as in a standard linked list. This trick does not change the big-Oh complexity of these methods, but still cuts the search time in half. You should define a `private` method to handle this search procedure so that index-based methods can use it.
	
I recommend completing and fully testing all methods associated with the list before moving on to the `ListIterator`. Be sure to test all interesting cases, **including tests for the exceptions that these methods should be throwing under particular circumstances**. When testing and troubleshooting, you may find it useful to write a main method in some class that creates and manipulates instances of your list. Including a `toString` method in the list can also make troubleshooting easier, but implementing this method is not required.
	
As you work on the `ListIterator` within the list, you should pay close attention to the interface specification from the book. The book provides an example of an `Iterator` for a standard linked list, but this is not a `ListIterator` ... in fact, there is not even an implementation of the `remove` method. This code is a good starting point for the `next` and `hasNext` methods, but modifications are needed to meet all of the requirements of the `ListIterator`. The book also has a `ListIterator` implementation for an array-based list. Even though this implementation does not apply to a linked list (let alone a doubly-linked list) it does bring up some issues that you should be aware of when writing your `ListIterator` implementation. When comparing your code with the array-based `ListIterator`, keep in mind the following confusing issue: although the book's list interface is for lists that start with index `1`, the `ListIterator` interface is a standard Java interface, meaning that it assumes lists start with an index of `0` (as yours will). 

```diff
- Also, beware: the array-based iterator uses several methods of the parent 
- class (using ArrayListWithListIterator.this syntax). Do NOT do this with 
- the doubly-linked list! Your iterator methods should have an efficiency 
- of O(1), but all methods of the parent class that you might call will cost 
- O(n). This is inefficient.
```

Here is some guidance regarding the member variables of the `DoublyLinkedListIterator` class. The `nextNode` contains the value that will be returned when the `next` method is called. In contrast, the `previous` method should return the value in the node preceding this node. The `nextIndex` variable should always contain the index of the `nextNode` within the list (recall that the first list index is `0`). The `isRemoveOrSetLegal` and `lastMove` variables behave essentially the same in this class as they do in the array-based `ListIterator`.
	
Although you will be implementing all methods of the `ListIterator`, they are split up into methods for navigation and methods that modify the list. You should implement all of the methods for navigation first and make sure that they pass my tests. Once these methods work, you will have an easier time implementing the modifying methods one by one. If you are confused about how the `ListIterator` works, then you can test drive Java's built-in `ListIterator` for the `LinkedList` or `ArrayList` by declaring one in some other project. Although the `ListIterator` is implemented differently for each type of list, it's high-level behavior is the same.

Throughout this whole process, be sure to thoroughly comment your code. Specifically, a comment for each method in the `DoublyLinkedList` class should indicate **AND** explain the big-Oh time complexity of that method, including distinctions between best/average/worst cases when appropriate. Additionally, explain when and why certain parts of the code are broken up into several cases. Methods in the `DoublyLinkedListIterator` class do not need big-Oh information listed, but you should keep in mind that ALL of these methods are supposed to have a big-Oh time complexity of O(1). If this is not the case for any of your methods, then you will lose points for incorrect implementation.

## Grading

Note that the interfaces provide Javadoc header comments for the methods you are implementing. This is why the only comments that are being graded pertain to big-Oh runtimes. Any tricky aspects of the implementation will need to appear in the explanation of the big-Oh runtimes. The reason that body comments are not being graded for the iterator portion of the assignment is simply that there are already too many parts to the assignment. I still recommend using comments to clarify what is happening in the many cases some of these methods will have, but they will not be graded. Your assignment will be graded based on the following:

- 10%: `REFLECTION.txt`: thoughtful answers to each question
- 30%: `DoublyLinkedList.java`: Correct functioning of list methods 
- 10%: `DoublyLinkedList.java`: Provide complete big-Oh information for each list method
- 30%: `DoublyLinkedList.java`: Correct functioning of methods for iterator class
- 20%: `DoublyLinkedListTest.java`: Thoroughness/correctness of required test cases

## Submission

You will submit your code via GitHub. You will learn a lot about using GitHub in future classes, but for this one you simply need to know some basic commands to get by. Whenever you want to save your work and save your most up-to-date changes to your GitHub repo, execute the following sequence of three commands by typing them in the terminal and pressing enter after each one.

```
git add *
git commit -m "Updated code"
git push
```

If these three commands do not all succeed, then I will not be able to see the changes you have made to the code. They may exist in your codespace, but they will not be visible in the GitHub repo. Make sure that the code you view in the GitHub repo via a browser matches what you want to submit. If any of these commands give errors indicating that the code cannot be added, committed, or pushed, then contact me immediately on Slack for help. Try to complete the assignment sufficiently ahead of the deadline to avoid anxiety from unexpected issues with the submission process.

