package src.Leetcode.Problems;

import java.util.HashMap;
import java.util.Map;

public class LC387FirstUniqueCharacterInString {

    // Space (1) Time (N)
    public int firstUniqChar(String s) {
        int freq [] = new int[26];

        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;

        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        
        return -1;
    }

    // Space (1) Time (N)
    public int firstUniqCharMap(String s) {
        if (s.length() < 1) return -1;

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();

        for (char c: arr) {
            if (m.containsKey(c)) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            } else {
                m.put(c, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (m.containsKey(c) && m.getOrDefault(c, 0) == 1) return i;
        }

        return -1;
    }
}

