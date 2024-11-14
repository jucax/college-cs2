[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14813283)
# Trees

Trees are another important data structure in computer science that appear in a variety of places. Trees can take many forms, and you will learn about many in future classes, but for now we will focus on binary trees, and binary search trees. We will spend two days on this topic.

## Day 1: Binary Tree

A binary tree implementation is already fairly complex, so we will start with a working tree and then simply expand on its functionality a bit. You will need to edit the tree itself in `src/main/java/tree/BinaryTree.java` and the associated node class in `src/main/java/tree/BinaryNode.java`. Implement the methods with **TODO** notes in the tree class, but be aware that the majority of the implementation for some methods may need to appear in the node class instead. Complete tests for all methods already exist in `src/test/java/tree/BinaryTreeTest.java`, which you can run with this command:
```
gradle test --tests 'tree.BinaryTreeTest'
```
If you want to test code in the `main` method of `BinaryTree`, you can execute it using the command:
```
bash run_day1.bash
```

## Day 2: Binary Search Tree

Raw binary trees are a bit hard to work with, since there is no easy way to simply add an element. A general binary tree doesn't impose any restriction on where elements can appear in the tree. In contrast, a binary search tree stores elements in an order that makes it very easy to search for and retrieve elements. Every element in a left sub-tree must be less than the value in that sub-tree's root, and every value in any right sub-tree must be greater than the root's value. Implement the binary search tree by adding code to `src/main/java/tree/BinarySearchTree.java`. Some tests for the tree are already in `src/test/java/tree/BinarySearchTreeTest.java`. Run these tests with this command:
```
gradle test --tests 'tree.BinarySearchTreeTest'
```
If you want to test code in the `main` method of `BinarySearchTree`, you can execute it using the command:
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