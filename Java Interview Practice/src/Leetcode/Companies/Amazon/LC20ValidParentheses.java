package src.Leetcode.Companies.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class LC20ValidParentheses {

    /**
     * Space (N) push all opening brackets onto the stacks and worst case we have to
     * put whole array of open brackets in space
     * 
     * Time (N) Traverse thru whole string
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
            case '[':
            case '{':
            case '(':
                stack.offer(c);
                break;

            case ']':
                if (stack.isEmpty() || stack.pollLast() != '[')
                    return false;
                break;
            case '}':
                if (stack.isEmpty() || stack.pollLast() != '{')
                    return false;
                break;

            case ')':
                if (stack.isEmpty() || stack.pollLast() != '(')
                    return false;
                break;

            default:
                return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidShortCleanVersion(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            // Add all closing bracket
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');

            // Once this is the closing bracket, check if stack empty or this is the
            // expected bracket
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of
                // '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return
                // false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}