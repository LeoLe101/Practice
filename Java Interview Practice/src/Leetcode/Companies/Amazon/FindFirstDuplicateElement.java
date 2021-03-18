package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array arr[] of size N. The task is to find the first repeating
 * element in an array of integers, i.e., an element that occurs more than once
 * and whose index of first occurrence is smallest.
 * 
 * The index has to be the smallest. EX: "baab" => 0 EX: "leetcode" => 1 EX: "10
 * 3 5 4 5 9 10 3" => 0
 * 
 */
public class FindFirstDuplicateElement {

    /**
     * Space (1) 
     * Time (N^2) - Traverse thru same word twice each char
     */
    public int firstDupBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    return i;
            }
        }
        return -1;
    }

    /**
     * Space (N) - Map 
     * Time (N) - Traverse thru the f
     */
    public int firstDupHashMap(String s) {
        if (s.length() < 1)
            return -1;

        Map<Character, Integer> m = new HashMap<>();
        int right = s.length() - 1;
        int left = 0;

        while (left < right) {
            if (m.containsKey(s.charAt(left))) {
                return left;
            }
            if (m.containsKey(s.charAt(right))) {
                return m.get(s.charAt(right));
            }

            m.put(s.charAt(left), left);
            m.put(s.charAt(right), right);
            left++;
            right--;
        }
        return -1;
    }

    /**
     * Space (N) - SET 
     * Time (N) - Trarverse once
     */
    public int firstDupHashSet(String s) {
        if (s.length() < 1)
            return -1;

        Set<Character> set = new HashSet<>();
        int firstDupIndex = -1;

        // Keep updating the duplicate index until it reaches the start of the array
        for (int i = s.length() - 1; i >= 0; i--) {
            if (set.contains(s.charAt(i)))
                firstDupIndex = i;
            else
                set.add(s.charAt(i));
        }

        return firstDupIndex;
    }
}
