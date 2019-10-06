package practicecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// REFERENCES:
// https://javarevisited.blogspot.com/2019/04/top-20-searching-and-sorting-algorithms-interview-questions.html
// https://hackernoon.com/50-data-structure-and-algorithms-interview-questions-for-programmers-b4b1ac61f5b0
// https://www.toptal.com/algorithms/interview-questions

class Algo {

    // ================================================================================
    // SEARCH ALGORITHM
    // ================================================================================

    // region REVIEW Binary Search
    /**
     * Binary search Time complexity: O(Log N) This search is best used when the
     * array is sorted! Otherwiser we cannot use it.
     *
     * This is the algorithm that uses divide and conquer to search for the target
     * number. First: Compare the middle of the array with the target. If it is the
     * target, return that index Second: If it is smaller than the target, start
     * comparing the left half of the array. Repeat step 1 again Third: If it is
     * larger than the target, start comparing the right half of the array. Repeat
     * step 1 again
     *
     * Formula to find the middle index within the array: 1. ((high - low) / 2) +
     * low <<< good to avoid overflow 2. (low + high) / 2 <<< might caused overflow
     * because 2 large index numbers
     */
    public int BinarySearchIter(int[] arr, int target) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int middleIndex = 0;

        while (firstIndex <= lastIndex) {
            // Find the middle index
            middleIndex = firstIndex + ((lastIndex - firstIndex) / 2);

            // Return the value if it is equaled with the target
            if (arr[middleIndex] == target) {
                return middleIndex;
            }

            // If the middle value is smaller than the target, search thru the right half of
            // the array
            if (arr[middleIndex] < target) {
                firstIndex = middleIndex + 1;
                continue;
            }

            if (arr[middleIndex] > target) {
                lastIndex = middleIndex - 1;
            }
        }

        return -1; // Return -1 once the target is not found in the array
    }

    // Recursion with helper function
    public int BinarySearchRecur(int[] arr, int target) {
        return BinarySearchRecurHelper(0, arr.length - 1, arr, target);
    }

    public int BinarySearchRecurHelper(int firstIndex, int lastIndex, int[] arr, int target) {

        // Condition to stop this recursion if the value is not in the array
        if (firstIndex <= lastIndex) {
            int middleIndex = ((lastIndex - firstIndex) / 2) + firstIndex; // This is the way to do without overflow
                                                                           // when 2 big numbers plus together

            // If the middle index is the targeted value, return it
            if (arr[middleIndex] == target) {
                return middleIndex;
            }

            // If the middle index is smaller than the targeted value, start looping through
            // the right half of the array.
            if (arr[middleIndex] < target) {
                return BinarySearchRecurHelper(middleIndex + 1, lastIndex, arr, target);
            }

            // If the middle index is bigger than the targeted value, start looping through
            // the left half of the array.
            return BinarySearchRecurHelper(firstIndex, middleIndex - 1, arr, target);
        }
        return -1; // Return -1 if the target is not in the array
    }
    // endregion

    // region REVIEW Depth First Search
    /**
     * Depth First Search Time complexity: O(Log N)
     *
     */
    public void DepthFirstSearch() {

    }
    // endregion

    // region REVIEW Breath First Search
    public void BreathFirstSearch() {

    }
    // endregion

    // region REVIEW Level Order Search in a Binary Tree
    List<List<Integer>> levelOrderTraversal(TreeNode root) {

        return null;
    }
    // endregion

    // region REVIEW Linear Search
    /**
     * Linear Time complexity: O(N)
     *
     * This algorithm is used to loop through a sorted array and find the target
     * index If the value is not found, return -1
     */
    public int LinearSearchIter(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        // If the target is not found in the array, return -1
        return -1;
    }

    // Recursion method
    public int LinearSearchRecur(int[] arr, int target) {
        return LinearSearchRecurHelper(arr, target, 0, arr.length - 1);
    }

    public int LinearSearchRecurHelper(int[] arr, int target, int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) {
            return -1;
        }
        if (arr[firstIndex] == target) {
            return firstIndex;
        }
        if (arr[lastIndex] == target) {
            return lastIndex;
        }
        return LinearSearchRecurHelper(arr, target, firstIndex + 1, lastIndex - 1);
    }
    // endregion

    // region REVIEW Dijkstra's shortest path algorithm
    /**
     * Dijkstra's shortest path algorithm
     */
    public void Dijkstra() {

    }
    // endregion

    // region REVIEW Prim's Minimum Spanning Tree
    /**
     * Prim Algorithm to find the minimum spanning tree
     */
    public void MinimumSpanningTree() {

    }
    // endregion
}

class Sort {

    // ================================================================================
    // SORT ALGORITHM
    // ================================================================================

    // region REVIEW Bubble Sort
    /**
     * Time Complexity O(n) | O(n^2) | O(n^2) Requirements: Explain,
     *
     * Compare each pair of adjacent elements and swapped them if they are not
     * in sorted order. Here are the steps to be taken:
     * 1. If the first element is smaller than the second adjacent element, then
     *    move the pointer to the second adjacent element and start using it for
     *    the next comparision.
     * 2. If the first element is bigger than the second adjacent element, then
     *    swap their location and start compare the current to the next element.
     * 3. Once the biggest element of the current iteration is at the end of the
     *    array, start bubbling the rest of the array again with 1 less length.
     *    As the last elements are already considered as the largest.
     * 4. Continue doing this until the length reach 0;
     *
     * Why it's awful: The time complexity will reach to over O(n^2) if the database
     * is large. As for the average and worst case, it will be O(n^2) depending on the
     * number of items/elements in the array.
     *
     * Implement, why it's awful
     */
    public void BubbleSort(int[] arr, int length) {
        boolean swapped = false;
        for (int i = 0; i < (length - 1); i++) {
            swapped = false;
            for (int l = 1; l < (length - i - 1); l++) {
                if (arr[i] > arr[l]) {
                    int temp = arr[i];
                    arr[i] = arr[l];
                    arr[l] = temp;
                    swapped = true;
                }
            }
            // If this element is
            if (!swapped) {
                break;
            }
        }
    }
    // endregion

    // region REVIEW Insertion Sort
    /**
     * Insertion Sort Time Complexity O(n) | O(n^2) | O(n^2) Requirements: Explain
     * when it can be better than mergesort and quicksort
     */
    public void InsertionSort() {

    }
    // endregion

    // region REVIEW Merge Sort
    /**
     * Merge Sort Implementation steps:
     * 1. Check if the array only has 1 value; if yes, return accordingly
     * 2. Recursively break the array in half until it cannot be divided any further than that.
     * 3. Merge the both broken down array together in sorted order.
     *
     * Time Complexity O(n Log(n)) | O(n Log(n)) | O(n Log(n))
     * Space Complexity O(n)
     * Requirements: Implement it, talk space complexity, time complexity
     *
     * @param arr    The array to be sort
     * @param length the length of the array
     */
    public void MergeSort(int[] arr, int length) {
        if (length < 2) {
            return;
        }
        // Find middle point to break the array
        int middleIndex = length / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[length - middleIndex];

        // Insert all available element from the left to middle into LeftArray
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[i];
        }

        // Insert all available element from the middle to the end into RightArray
        for (int i = middleIndex; i < rightArray.length; i++) {
            rightArray[i] = arr[i];
        }

        // After breaking down 2 arrays from original array,
        // continue to break down the rest on both left
        // and right side until it is not able to break down anymore
        MergeSort(leftArray, leftArray.length);
        MergeSort(rightArray, rightArray.length);

        // After completely broken down, merge them back
        merge(arr, leftArray, rightArray, leftArray.length, rightArray.length);
    }

    /**
     * Merge function for the merge sort. This function will sort both left and
     * right array back into the 1 array
     *
     * @param arr            The original Array
     * @param length         The original Array length
     * @param leftArr        The Array that is broken down
     * @param rightArr       The Array that is broken down
     * @param leftArrLength  Left Array Length
     * @param rightArrLength Right Array Length
     */
    public void merge(int[] arr, int[] leftArr, int[] rightArr, int leftArrLength, int rightArrLength) {
        int i = 0;
        int l = 0;
        int k = 0;

        // Check both arrays, the smaller element from each array will be added
        // into the original array. Then iterate through the both Array with 2 ptrs
        while (i < leftArrLength && l < rightArrLength) {
            if (leftArr[i] < rightArr[l]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[l++];
            }
        }

        // After the comparison end, if one of the array still remain,
        // add them all to the end of the original array.
        // At this point, 1 of the array is considered to be iterated through already.
        while (i < leftArrLength) {
            arr[k++] = leftArr[i++];
        }

        while (l < rightArrLength) {
            arr[k++] = rightArr[l++];
        }
    }
    // endregion

    // region REVIEW Heap Sort
    /**
     * Heap Sort Time Complexity O(n Log(n)) | O(n Log(n)) | O(n Log(n))
     * Requirements: Explain how it works, how heaps work in general
     */
    public void HeapSort() {

    }
    // endregion

    // region REVIEW Quick Sort
    /**
     * Quick Sort Time Complexity O(n Log(n)) | O(n Log(n)) | O(n^2) Requirements:
     * Implement it, Explain it
     */
    public void QuickSort() {

    }
    // endregion

    // region REVIEW Selection Sort
    /**
     * Selection Sort Time Complexity Requirements: Talk about an example if you
     * know
     */
    public void SelectionSort() {

    }
    // endregion
}

class TreeTraversal {

    // ================================================================================
    // IMPLEMENT Tree Traversal
    // ================================================================================

    // region REVIEW In-order Traversal
    /**
     * In order traverse through the tree with the order: Left - Visit - Right Time
     * Complexity O(n)
     *
     * @param node Root of the tree to be traversed
     */
    public void InOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        InOrderTraversal(node.left);
        System.out.println(node.val);
        InOrderTraversal(node.right);
    }
    // endregion

    // region REVIEW Post-order Traversal
    /**
     * Post order traverse through the tree with the order: Left - Right - Visit
     * Time Complexity O(n)
     *
     * @param node Root of the tree to be traversed
     */
    public void PostOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        PostOrderTraversal(node.left);
        PostOrderTraversal(node.right);
        System.out.println(node.val);
    }
    // endregion

    // region REVIEW Pre-order Traversal
    /**
     * Pre order traverse through the tree with the order: Visit - Left - Right Time
     * Complexity O(n)
     *
     * @param node Root of the tree to be traversed
     */
    public void PreOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        PreOrderTraversal(node.left);
        PreOrderTraversal(node.right);
    }
    // endregion

    // region REVIEW Level-order Traversal
    /**
     * Level order traverse through the tree thru level (Breadth First) Time
     * Complexity O(n)
     *
     * This implementation use the Queue Data Structure to hold the next child nodes
     * of current node. The queue will poll the element at the top of the queue in a
     * FIFO manner. This will help the traverse to be on the same level without
     * moving downward and recur back up.
     *
     * @param node Root of the tree to be traversed
     */
    public void LevelOrderTraversalQueue(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val); // Do something with the data here
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
    // endregion
}