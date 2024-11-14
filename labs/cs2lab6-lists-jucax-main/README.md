[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14256739)
# Lists

Lists are a common and powerful data structure available in most languages. They support a wide variety of operations, and we will be spending many days focused on this topic.

## Day 1: Using Lists

Although you were introduced to the `ArrayList` back in CS1, this lab day will serve as a refresher on using and manipulating lists. Today, we will simply use Java's `java.util.ArrayList` instead of using one based on the book's `ListInterface`. Fill out the code in `src/main/java/client/UseLists.java` and execute the tests in `src/test/java/client/UseListsTest.java` with the command:
```
gradle test --tests 'client.*'
```
If you add any code to the `main` method of `UseLists`, you can execute it using the command:
```
bash run.bash
```

## Day 2: Array-based List

This is yet another array-based data structure, but the number of operations supported by lists is much more than previous data structures. We will also be using the book's `ListInterface` rather than the standard interface for Java lists, so some of the method names are a bit different. Also, the textbook's list implementations store the first list element at index 1 instead of index 0. Because this differs from how lists are indexed in standard Java lists and in most languages, I want you to implement 0-based indexing instead. This change will require some small tweaks in how the list is implemented in comparison with what is laid out in the book. Edit the file `src/main/java/lists/ArrayList.java`, and write unit tests in `src/test/java/lists/ArrayListTest.java`. Run your tests with:
```
gradle test --tests 'lists.ArrayListTest'
```

## Day 3: Link-based List

Now we will make a linked list. The textbook presents two versions of the linked list: one that only maintains a reference to the first node, and one that also maintains a reference to the last node, or *tail*, for the sake of efficiency. You will be jumping straight to implementing the version that maintains a reference to the last node in the file `src/main/java/lists/LinkedList.java`. This file also implements the book's `ListInterface`, except that we will once again use 0-based indexing, in contrast to what the book does. You can test the list using `src/test/java/lists/LinkedListTest.java`, which can contain copies of the tests for the array-based list. Both lists should behave the same. Run tests with this command:
```
gradle test --tests 'lists.LinkedListTest'
```

## Day 4: Iterators

In order to work on the code today, you will have to have working implementations of both the `ArrayList` and the `LinkedList` from the past two sessions. You will be adding support for iterators to both lists. Start by adding `Iterable<T>` to the list of interfaces that these classes implement, and then add a method with this signature to each class:
```
Iterator<T> iterator()
```
However, this method will ultimately do very little. The actual work of the iterator will be handled by private inner classes that implements the class `Iterator`. Time allowing, we will upgrade the standard `Iterator` to a `ListIterator` by simply having each list class implement the `ListWithListIteratorInterface`. Any tests we create will be added to the `ArrayListTest` and `LinkedListTest`, and you can run all of these tests with this command:
```
gradle test --tests 'lists.*'
```

## Day 5: Sorted Lists

Today we will implement a different type of list data structure: A list that always maintains its elements in sorted order. The specific implementation we will focus on is a sorted linked-list, whose code you will write in `src/main/java/lists/SortedLinkedList.java`. You could write a sorted array-based list as well, but we only have time to focus on one today. Implement the linked list based on the book and the guidance given in class, and add tests in `src/test/java/lists/SortedLinkedListTest.java`, which you can run with this command:
```
gradle test --tests 'lists.SortedLinkedListTest'
```

## Day 6: Inheritance with Lists

You may have noticed when implementing the `SortedLinkedList` that we copy-pasted a lot of code from the standard `LinkedList`. In general, copying code is bad, and should be avoided. Inheritance provides a way to reuse code from existing classes when making new ones, but it can also lead to problems if done incorrectly. We will first put code in the file `src/main/java/lists/SortedLinkedListFromLinkedList.java`, which tries to implement a sorted linked list by taking advantage of existing code in the original `LinkedList`. Although this will work, it is not a great idea to do inheritance in this way. Still, you can test this class by copy-pasting tests from `SortedLinkedListTest` to `src/test/java/lists/SortedLinkedListFromLinkedListTest.java`. In order to demonstrate a better way of doing inheritance, we'll first start with the abstract class in the file `src/main/java/lists/BaseLinkedList.java`. This will contain the core methods common to both types of linked lists. Next, we will add two files that are not present in the repo yet: `src/main/java/lists/LinkedListFromBase.java` which will implement the `ListInterface` and `src/main/java/lists/SortedLinkedListFromBase.java` which will implement the `SortedListInterface`. However, both of these classes will extend the `BaseLinkedList`. We'll make test cases for these lists as needed, and test all classes in the package with this command:
```
gradle test --tests 'lists.*'
```

## Day 7: Binary Search in a Sorted Array-based List

There are no pre-existing files for this lab day except for those from previous classes. Specifically, we will build on the previously implemented `ArrayList` to make a new file: `src/main/java/lists/SortedArrayListFromArrayList.java`. Use your knowledge of inheritance from the previous session to implement `SortedArrayListFromArrayList` in a way that extends `ArrayList` and implements the `SortedListInterface`. However, when implementing some of these methods, recall what the video lectures taught about binary search. This is a search technique that works on a sorted array. Which operations of the `SortedArrayListFromArrayList` can benefit from using binary search? As you implement these operations, make a new file to add tests to: `src/test/java/lists/SortedArrayListFromArrayListTest.java`. Run tests from this file with the command:
```
gradle test --tests 'lists.SortedArrayListFromArrayListTest'
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
