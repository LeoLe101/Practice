package practicecode;

import java.io.*;

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
     * Binary search Time complexity: O(Log N)
     * This search is best used when the array is sorted! Otherwiser we cannot use it.
     *
     * This is the algorithm that uses divide and conquer to search for the target
     * number. First: Compare the middle of the array with the target. If it is the
     * target, return that index Second: If it is smaller than the target, start
     * comparing the left half of the array. Repeat step 1 again Third: If it is
     * larger than the target, start comparing the right half of the array. Repeat
     * step 1 again
     *
     * Formula to find the middle index within the array:
     * 1. ((high - low) / 2) + low <<< good to avoid overflow
     * 2. (low + high) / 2 <<< might caused overflow because 2 large index numbers
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

    // endregion

    // region REVIEW Linear Search
    /**
     * Linear Time complexity: O(N)
     *
     * This algorithm is used to loop through a sorted array and find the target index
     * If the value is not found, return -1
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
        return LinearSearchRecurHelper(arr, target, 0);
    }

    public int LinearSearchRecurHelper(int[] arr, int target, int currIndex) {
        if (arr[currIndex] == target) {
            return currIndex;
        }

        if () {
            // If the target is not found in the array, return -1
            return -1;
        }
        return LinearSearchRecurHelper(arrLength, arr, target);
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
     * Bubble Sort Time Complexity O(n) | O(n^2) | O(n^2) Requirements: Explain,
     * Implement, why it's awful
     */
    public void BubbleSort() {

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
     * Merge Sort Time Complexity O(n Log(n)) | O(n Log(n)) | O(n Log(n))
     * Requirements: Implement it, talk space complexity, time complexity
     */
    public void MergeSort() {

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

class DataStructure {

    // ================================================================================
    // IMPLEMENT DATA STRUCTURE
    // ================================================================================

    // region REVIEW Binary Search Tree

    // endregion

    // region REVIEW Max Heap
    /**
     * Max Heap is a complete/balanced binary tree in which the value in each
     * internal node is greater than or equal to the values in the children of that
     * node.
     *
     * The Root element will always be greater than or equal to either of its child
     * element
     */
    // endregion

    // region REVIEW Min Heap
    /**
     * Min Heap is a complete/balanced binary tree in which the value in each
     * internal node is smaller than or equalt to the valudes in the children of
     * that node.
     *
     * The Root element will always be less than or equal to either of its child
     * element
     */
    // endregion
}

class TreeTraversal {

    // ================================================================================
    // IMPLEMENT Tree Traversal
    // ================================================================================

    // region REVIEW In-order Traversal

    // endregion

    // region REVIEW Post-order Traversal

    // endregion

    // region REVIEW Pre-order Traversal

    // endregion


}