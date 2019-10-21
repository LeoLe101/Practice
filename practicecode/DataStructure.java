package practicecode;

import java.util.List;
import java.util.Stack;

class DataStructure {

    // ================================================================================
    // ARRAYS
    // ================================================================================
    /**
     * Array is a Random Access data structure, where the access element can be
     * independent from the array order (with element index)
     */

    // ================================================================================
    // LINKED LIST
    // ================================================================================
    /**
     * Linked List is Sequential Access Data Structure, where the access element can
     * only be accessed through a specific or particular order
     *
     *
     *
     */


    // ================================================================================
    // STACK
    // ================================================================================
    /**
     * Stack is a sub-set of Sequential Access (a.k.a Limited Access) that
     * inserted and removed according to the last in, first out (LIFO) principle.
     *
     * Stack is a recursive data structure: Stack either empty
     * or consist of a top or the rest
     *
     * Can be derived from List<> interface
     *
     * Big O of all these methods are O(1):
     *  - Push(): Add the element at the top of the stack
     *  - Pop():  Remove the element from the top of the stack and return that Value
     *  - Peek(): Return the top element from the stack
     *
     */

    // ================================================================================
    // QUEUE
    // ================================================================================



    // ================================================================================
    // BINARY SEARCH TREE
    // ================================================================================

    // #region REVIEW Binary Search Tree
    /**
     * Cracking the Code Interview Page 100-104
     *
     * Binary Search Tree is a sorted-ish binary tree.
     *
     * The node inserted into the tree will be compared with the root node and other
     * nodes accordingly.
     * The nodes in the Left Branch <= root/parent nodes
     * The nodes in the Rigght Branch > root/parent nodes
     *
     * There must not be any duplication in the tree. (or sometimes it does happen...)
     *
     *
     * IN-ORDER Traversal in a BST return the sorted version of the output
     *
     */


    /**
     * Search in BST Big-O time-complexity: O(n)
     * The element to be found is going to be compared with the current node.
     * If smaller, move down to the left branch.
     * If bigger, move down to the right branch.
     *
     * https://leetcode.com/problems/search-in-a-binary-search-tree/
     */
    public TreeNode SearchBST(TreeNode root, int searchVal) {
        if (root.val == searchVal || root == null) {
            return root;
        }

        if (searchVal <= root.val) {
            // Move to left branch if search value is smaller
            return SearchBST(root.left, searchVal);
        } else {
            // Move to right branch if search value is bigger
            return SearchBST(root.right, searchVal);
        }
    }

    /**
     * Insert in BST Big-O time-complexity: O(n)
     * The element to be inserted will be compared with the current node.
     * If smaller, move down to the left branch.
     * If bigger, move down to the right branch.
     * If current node is null, create a new node with the current value to add it
     *
     * https://leetcode.com/problems/insert-into-a-binary-search-tree/
     */
    public TreeNode InsertBST(TreeNode root, int insertVal) {
        if (root == null) {
            root = new TreeNode(insertVal);
            return root;
        }

        // Instead of just return InsertBST(...)
        // root.left/right = InsertBST(...) will reconstruct the tree
        // after the insertion is donw.
        if (insertVal <= root.val) {
            // Move to left branch if search value is smaller
            root.left = InsertBST(root.left, insertVal);
        } else {
            // Move to right branch if search value is bigger
            root.right = InsertBST(root.right, insertVal);
        }
        return root;
    }

    /**
     * Delete in BSY Big-O time-complexity: O(n)
     * Traverse the tree and compare the value to be deleted with current node
     * 1. Node to be deleted is leaf: Remove the last lvl nodes
     *    - Just remove that node
     * 2. Node to be deleted has only one child: Remove the parent with 1 child
     *    - Remove the parent and reconnect its child to replace the removed node
     * 3. Node to be deleted has two child: Remove the parent node with 2 children
     *    - Find the In-Order successor child and replace it with the removed node
     *
     * https://leetcode.com/problems/delete-node-in-a-bst/submissions/
     */
    public TreeNode DeleteBST(TreeNode root, int delVal) {
        // Case 1: Leaf node or the Value to be deleted does not exist
        if (root == null) {
            return null;
        }

        if (delVal < root.val) {
            // Move to left branch if search value is smaller
            root.left = InsertBST(root.left, delVal);
        } else if (delVal > root.val) {
            // Move to right branch if search value is bigger
            root.right = InsertBST(root.right, delVal);
        } else {
            // The deleted value node is found!

            // Case 2: Swap the left or right child to the parent place
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Traverse when Left and Right branches are still available
            // Swap the successor child to the deleted grand-parent place
            root.val = InorderTraverse(root);
            // Remove the swapped node since successor child still exists in the tree.
            root.right = DeleteBST(root, root.val);
        }
        return root;
    }

    // In-order traversal to find the left-most child in the right branch
    // of the tree to swap with the deleted parent
    public int InorderTraverse(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }
        return InorderTraverse(root.left);
    }
    // #endregion


    // #region REVIEW Graph
    /**
     * Graph is a (non-linear) pictorial representation of a set of objects where
     * some pairs of objects are connected by LINKS. The interconnected objects
     * represented by points termed as VERTICES, and the LINKS that connect the
     * VERTICES are called EDGES.
     *
     * Graph is a pair of sets (V, E) where V: set of VERTICES
     *                                      E: Set of EDGES
     * V and E show the connection between pairs of VERTICES
     *
     * Vertex: Each node in graph is a vertex
     * Edges: Represent the path between 2 vertices or a line between them
     *
     * Adjacency: 2 nodes/vertices are adjacent if they are connected with
     *            each other thru an edge.
     *
     * Edge/Path: Path represents a sequence of edges between the two vertices
     *            Ex: From A - Z must go thru path: A-B, B-D, D-Z (ABDZ)
     *
     * Graph can be undirected/directed, cyclic/acycli (usually directed), weighted
     * Only way to traverse thru a graph is BFS or DPS
     *      Directed: Each path between 2 nodes has different direction
     *      Un-directed: The nodes linked together can be traversed either way
     *      Cyclic: A graph with at least 1 cycle (this is the only graph that
     *              is not any form of a Tree since it is cycled)
     *      Acyclic: A graph without any cycle (this is from of tree if it is
     *              Directed Acyclic Graph)
     *
     * Graph is also used for Adjacency List
     *
     * Time Complexity (in GRAPH): O(V + E) where V - vertices, E - Edges
     * Space Complexity (in GRAPH): O(V)    where V - vertices,
     *
     * Time Complexity (in TREE): O(b^m) where b - number of nodes of current path,
     *                   m - length of longest path (level of the tree)
     * Space Complexity (in TREE): O(bm) where b - number of nodes of current path,
     *                   m - length of longest path (level of the tree)
     */

    /**
     * Depth First Search Time complexity: O(Log N)
     *
     * Starting at the top (Root Node), iterate down a given branch as far as
     * possible, and then backtracks until it finds an unexplored path, and go
     * that path.
     *
     * Worst case is the algorithm is going to traverse through the whole tree
     * to explore all unexplored path.
     *
     * DFS uses STACK:
     *    1. Add the first Node into the stack.
     *    2. Pop out an element from Stack and add all of its connected nodes to stack.
     *    3. Repeat these 2 steps above until Stack is Empty
     */
    public void DepthFirstSearchTraversalRecur(GraphNode startNode) {

        // Do print logic for each nodes visited
        System.out.println("Node visited: " + startNode.val);

        // Get the list of current node neighbours and mark current node visited
        List<GraphNode> neighboursList = startNode.getNeighbours();
        startNode.visited = true;

        // Traverse through all neighbour nodes and explore unvisited nodes down the path
        for (GraphNode node : neighboursList) {
            GraphNode tempNode = node;
            if (tempNode != null && !tempNode.visited) {
                DepthFirstSearchTraversalRecur(tempNode);
            }
        }
    }

    public GraphNode DepthFirstSearchFindingElement(GraphNode startNode, int target) {
        if (startNode.val == target) {
            return startNode;
        }

        // Get the list of current node neighbours and mark current node visited
        List<GraphNode> neighboursList = startNode.getNeighbours();
        startNode.visited = true;

        // Traverse through all neighbour nodes and explore unvisited nodes down the path
        for (GraphNode node : neighboursList) {
            if (node != null && !node.visited) {
                return DepthFirstSearchFindingElement(node, target);
            }
        }
        return startNode;
    }


    /**
     * Whenever using iteration for Tree/Graph traversal, use Stack if it is
     * DFS. (inorder, postorder, preorder are all considered DFS)
     *
     * Iterate thru all the nodes within the graph and put it into the stack.
     * Once the node is in the graph, move to all adjacent nodes in this path
     * and constantly put it to the Stack. Each iteration will pop() the Stack
     * and mark that node visited.
     */
    public void DepthFirstSearchIter(GraphNode startNode) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.add(startNode);

        while (!stack.isEmpty()) {
            GraphNode tempNode = stack.pop();

            // If this node is not visited, do logic with it
            if (!tempNode.visited) {
                System.out.println("Current node: " + tempNode.val);
                tempNode.visited = true;
            }

            // Traverse through the rest of current node neighbours
            List<GraphNode> neighbourList = tempNode.getNeighbours();
            for (GraphNode node : neighbourList) {
                if (node != null && !node.visited) {
                    stack.add(node);
                }
            }
        }
    }

    /**
     * Breadth First Search Time complexity: O(Log N)
     *
     */
    public void BreathFirstSearch() {

    }
    // #endregion



    // #region REVIEW Min Heap
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
    // #endregion




    // #region REVIEW Max Heap
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
    // #endregion




    // #region REVIEW Hash Table
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
    // #endregion




    // #region REVIEW HashMap
    /**
     * Hash Map is al
     * Comparing to Hash Map:
     *      + Hash Table is synchronized, Hash Map is asynchronized
     *      + Hash Map is better for non-threaded app due to async
     *      + Hash Table does not allow NULL key or values
     *      + Hash Map allow 1 Null Key and any Null values
     */
    // #endregion




    // #region REVIEW HashSet
    /**
     *
     */
    // #endregion




}