package src.Leetcode.Linkedlist;

import java.util.Stack;

import src.Util.ListNode;

public class ConvertBinaryNumberLLToInteger1290 {

    // Space O(N) Time O(N) Not good
    // Using Stack
    public int getDecimalValue(ListNode head) {
        Stack<Integer> stk = new Stack<Integer>();
        int multiplier = 1;
        int result = 0;

        while (head != null) {
            stk.add(head.val);
            head = head.next;
        }

        while (!stk.isEmpty()) {
            Integer curr = stk.pop();

            if (curr == 1)
                result += multiplier;

            multiplier *= 2;
        }
        return result;
    }

    // Space (1) Time (N)
    // Using math calculation
    public int getDecimalValueOptimized(ListNode head) {
        if (head == null)
            return 0;
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    // Space (1) Time (N)
    public int getDecimalValueBitManipulation(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            // Shift the result to left by 1 and use logical OR to add current value
            num = (num << 1) | head.next.val;
            head = head.next;    
        }
        return num;
    }

}
