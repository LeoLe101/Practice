package src.Leetcode.Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

    // My solution
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> m = new HashMap<>();
        m.put('{', '}');
        m.put('[', ']');
        m.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '}' || curr == ')' || curr == ']') {
                char prev = stk.isEmpty() ? 'b' : stk.pop();
                if (!m.containsKey(prev) || curr != m.get(prev))
                    return false;
            } else {
                stk.add(curr);
            }
        }
        return stk.isEmpty();
    }

    // Best solution
    public boolean isValidOptimized(String s) {
        char[] stack = s.toCharArray();

        int top = 0;
        for (char c : stack) {
            if (c == ')' || c == ']' || c == '}') {
                char pop = top > 0 ? stack[--top] : '#';
                if (c == ')' && pop != '(')
                    return false;
                else if (c == ']' && pop != '[')
                    return false;
                else if (c == '}' && pop != '{')
                    return false;
            } else
                stack[top++] = c;
        }

        return top <= 0;
    }

}
