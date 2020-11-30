package src.Leetcode.Problems;

import java.util.HashMap;
import java.util.Map;

public class LC389FindTheDifferences {
    // First implementation
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int currVal = 0;
        char curr = ' ';
        // put all character into the hashmap, if it is more than 1, just increase the
        // value
        for (int i = 0; i < t.length(); i++) {
            curr = t.charAt(i);
            if (!charMap.containsKey(curr)) {
                charMap.put(curr, 1);
            } else {
                currVal = charMap.get(curr);
                charMap.put(curr, currVal + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            currVal = charMap.get(curr);
            if (currVal == 1) {
                charMap.remove(curr);
            } else {
                charMap.put(curr, currVal - 1);
            }
        }
        Map.Entry<Character, Integer> entry = charMap.entrySet().iterator().next();
        return entry.getKey();
    }

    // Stole implementation from discussion
    public char findTheDifferenceAlter(String s, String t) {
        int[] f = new int[26];
        for (char c : t.toCharArray())
            f[c - 'a']++;
        for (char c : s.toCharArray())
            f[c - 'a']--;
        for (int i = 0; i < 26; i++)
            if (f[i] == 1)
                return (char) (i + 'a');
        return 'a';
    }
}
