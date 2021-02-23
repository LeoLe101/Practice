package src.Leetcode.Problems;

import java.util.List;

// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LC524LongestWordInDictionaryThroughDeleting {

    // #region Good
    // Space (1) - Time (N * K) with N = length of d and K = length of S
    public String findLongestWord(String s, List<String> d) {
        if (d.size() < 1)
            return null;

        String result = "";

        // Loop all arr for each Str
        for (String curr : d) {

            // index to move through curr string
            int i = 0;

            // loop thru s string and check each char with curr string
            for (char c : s.toCharArray()) {
                // Increase index when S has this char
                if (i < curr.length() && c == curr.charAt(i))
                    i++;
            }

            // Find longest string in Dict that is in S
            if (i == curr.length() && curr.length() >= result.length()) {

                // Check lexicography word between curr and result (Which before which --> ex:
                // apple, appla)
                if (curr.length() > result.length() || curr.compareTo(result) < 0)
                    result = curr;
            }
        }

        return result;
    }
    // #endregion

    // #region 2 Ptrs to check if s has the curr string in d array 
    // Space (1) - Time (N * K)
    public String test(String s, List<String> d) {
        if (d.size() < 1)
            return "";

        String result = "";

        // Loop all arr for each Str
        // Time: N = length d
        for (String curr : d) {

            int ptrStr = 0; // ptr to S
            int ptrList = 0; // ptr to curr
            // loop both arr and s string
            // Time: K = max(length s ,length curr);
            while (ptrList < curr.length() && ptrStr < s.length()) {
                // 2 char equal
                if (curr.charAt(ptrList) == s.charAt(ptrStr)) {
                    ptrList++;
                    ptrStr++;
                }
                // if s doesn't have curr char
                else
                    ptrStr++;
            }

            // Find longest string in Dict that is in S
            if (ptrList >= curr.length()) {
                if (curr.length() >= result.length()) {
                    if (curr.length() == result.length())
                        result = curr.compareTo(result) < 0 ? curr : result;
                    else
                        result = curr;
                }
            }
        }
        return result;
    }
    // #endregion

}
