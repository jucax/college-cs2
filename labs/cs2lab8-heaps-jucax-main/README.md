[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14925457)
# Heaps

A heap is an unusual data structure because it is conceptually organized as a complete binary tree, but is implemented with an underlying array. The fact that the binary tree is *complete* makes it possible to use the array for storage, and always know exactly which position in the array corresponds to each node of the conceptual binary tree. The organization of the tree requires that each element is larger than the value in its parent node.

## Day 1: MinHeap

You will implement a MinHeap, which is a data structure which can quickly retrieve the smallest element of a collection. This is essentially a specific implementation of a priority queue, which prioritizes smaller elements. Add code to `src/main/java/heap/MinHeap.java` to implement the MinHeap. This file can then be tested with the complete tests in `src/test/java/heap/MinHeapTest.java` by using this command:
```
gradle test --tests 'heap.MinHeapTest'
```
If you add any code to the `main` method of `MinHeap`, you can execute it using the command:
```
bash run.bash
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