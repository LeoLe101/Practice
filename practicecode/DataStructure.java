package practicecode;

class DataStructure {

    // ================================================================================
    // IMPLEMENT DATA STRUCTURE
    // ================================================================================

    // region REVIEW Binary Search Tree

    // endregion

    // region REVIEW Min Heap
    /**
     * Cracking the Code Interview Page 100-104
     *
     * Min Heap is a complete/balanced binary tree in which the value in each
     * internal node is smaller than or equal to the values in the children of that
     * node.
     *
     * The Root element will always be less than or equal to either of its child
     * elements.
     *
     * Insertion - Time Complexity: O(Log n) | n is the amount of nodes in heap +
     * Insert the element at the rightmost of the bottom level to maintain Complete
     * Binary Tree rules + Compare the node added with its parent node. Constantly
     * swapping by bubbling up toward a specific location.
     *
     * Heap Extract Minimum Element - Time Complexity: O(Log n) + Remove the root
     * (as it is the minimum element). Replace it with the bottommost, rightmost
     * node in the heap. Start bubbling down that value to the smallest child node
     * and re-order its location in the heap after bubbling down.
     */
    // endregion

    // region REVIEW Max Heap
    /**
     * Cracking the Code Interview Page 100-104 Max Heap is a complete/balanced
     * binary tree in which the value in each internal node is greater than or equal
     * to the values in the children of that node.
     *
     * The Root element will always be greater than or equal to either of its child
     * element.
     *
     * The rest is almost the same as Min-Heap but reverse a bit.
     */
    // endregion

    // region REVIEW Hash Table
    /**
     * Hash Table is a data structure which stores data in an associative manner. In
     * a Hash Table, data is stored in array format, where each data values has its
     * own unique index value. Access of data becomes very fast as we know the index
     * of the desired data.
     *
     * Hash Table is good for insertion and search irrespective of the size of the
     * data. Array is used as a storage medium and uses hash technique to generate
     * an index where an element is to be inserted and located.
     *
     * Hashing Technique: key % SIZE
     *
     * Comparing to Hash Map:
     *      + Hash Table is synchronized, Hash Map is asynchronized
     *      + Hash Map is better for non-threaded app due to async
     *      + Hash Table does not allow NULL key or values
     *      + Hash Map allow 1 Null Key and any Null values
     */
    // endregion

    // region REVIEW HashMap
    /**
     * Hash Map is al
     * Comparing to Hash Map:
     *      + Hash Table is synchronized, Hash Map is asynchronized
     *      + Hash Map is better for non-threaded app due to async
     *      + Hash Table does not allow NULL key or values
     *      + Hash Map allow 1 Null Key and any Null values
     */
    // endregion

    // region REVIEW HashSet
    /**
     *
     */
    // endregion
}