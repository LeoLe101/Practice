package src.Leetcode.Problems;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharReplacement {

    // Space (N) - Time (N)
    public int characterReplacement(String s, int k) {
        int maxSub = 0, maxLen = 0, len = s.length(), left = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        for (int end = 0; end < len; end++) {
            char curr = s.charAt(end);
            m.put(curr, m.getOrDefault(curr, 0) + 1);
            maxSub = Math.max(maxSub, m.get(curr));

            if (end - left + 1 - maxSub > k) {
                char leftChar = s.charAt(left);
                m.put(leftChar, m.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, end - left + 1);
        }
        return maxLen;
    }

}
