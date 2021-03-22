package src.Leetcode.Problems;

import java.util.LinkedList;
import java.util.List;

public class LC438FindAllAnagramsInString {


    /**
     * Space (N) - List of result
     * Time (N) - Go through String s Length once.
     */
    public List<Integer> findAnagramsOptimize(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < 1 || pLen < 1 || sLen < pLen) 
            return result;

        int[] hash = new int[26];
        for (char c: p.toCharArray()) { // The toCharArray() in java is O(N)
            hash[c - 'a']++;
        }
        
        int count = 0;
        int left = 0;
        int right = 0;

        // Go until right pointer meet s Length
        while (right < sLen) {
            // Curr char is in hash
            if (hash[s.charAt(right) - 'a'] > 0) {
                hash[s.charAt(right) - 'a']--; // Remove this hash because it pops up in string s 
                count++;                 // Count curr char as it is in p
                right++;                 // Slide upper limit of window up 
            }

            // Re-insert the char in p back into hash and reduce hash count as window slide
            else {
                hash[s.charAt(left) - 'a']++; // Add this char to hash
                count--;                // This char doesn't count as not in p
                left++;                 // Slide lower limit of window up
            }

            // Count this window exactly same as string p ==> anagram
            // Put lower limit in
            if (count == pLen) {
                result.add(left);
            }
        }

        return result;
    }



    /**
     * Space (N) - Need list of result
     * Time (N^2) - Since go through string S length twice (1. sliding window - 2. finding anagram for each substring)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < 1 || pLen < 1) {
            return result;
        }

        if (sLen < pLen) return result;

        int left = 0;
        for (int right = pLen - 1; right < sLen; right++) {
            String curr = s.substring(left, right);
            while (right - left >= pLen) {
                if (isAnagram(curr, p)) {
                    result.add(left);
                }
                left++;
            }
        }

        return result;
    }

    /**
     * Space (1) - Since we know how much we need to keep 26 chars Time (N) -
     * Traverse thru each string once
     */
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;

            if (alphabet[t.charAt(i) - 'a'] < 0)
                return false;
        }

        for (int i : alphabet)
            if (i != 0)
                return false;

        return true;
    }
}
