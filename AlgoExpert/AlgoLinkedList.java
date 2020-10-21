import java.util.*;

public class AlgoLinkedList {

}

// Feel free to add new properties and methods to the class.
class Program {
    class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            while (head != node) {
                Node
            }
        }

        public void setTail(Node node) {
            // Write your code here.
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            // Write your code here.
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return false;
        }
    }

    // Do not edit the class below.
    class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

class MergeLinkedList {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Time (N + M) where n is number of Node in headOne and M is number of Node in
    // headTwo
    // Space (1) - No new DS needed
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        LinkedList result = new LinkedList(-1);
        LinkedList tem = result;

        while (headOne != null && headTwo != null) {
            if (headOne.value <= headTwo.value) {
                tem.next = headOne;
                headOne = headOne.next;
            } else {
                tem.next = headTwo;
                headTwo = headTwo.next;
            }
            tem = tem.next;
        }

        if (headOne != null) {
            tem.next = headOne;
        } else if (headTwo != null) {
            tem.next = headTwo;
        }

        return result.next;
    }

    // This only work for K < linkedlist length
    public static LinkedList shiftLinkedList(LinkedList head, int k) {

        LinkedList slow = head;
        LinkedList fast = head;
        k = Math.abs(k);

        // Find the new head
        while (fast != null && fast.next != null) {
            if (k <= 0) {
                slow = slow.next;
            } else {
                k--;
            }
            fast = fast.next;
        }

        fast.next = head;
        LinkedList result = slow.next;
        slow.next = null;

        return result;
    }

    // Best version
    // Space (1) - Time (N)
    public static LinkedList shiftLinkedListOptimized(LinkedList head, int k) {
        LinkedList slow = head;
        LinkedList fast = head;
        int len = 1;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            len++;
        }

        // The amount of actual Traversal Needed
        int traverse = Math.abs(k) % len;
        // Find the slow node position
        int target = k > 0 ? len - traverse : traverse;

        if (traverse == 0)
            return head;

        // Move to the slow/last Node location for Re-Linking the LL
        for (int i = 1; i < target; i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}