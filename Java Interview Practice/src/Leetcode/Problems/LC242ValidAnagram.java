package src.Leetcode.Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC242ValidAnagram {

	// Space (N) Time (N)
	public boolean isAnagram(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		String curr = sLen > tLen ? s : t;
		String comp = sLen > tLen ? t : s;
		Map<Character, Integer> m = new HashMap<>();

		for (char c: comp.toCharArray()) {
			if (m.containsKey(c)) {
				m.put(c, m.getOrDefault(c, 0) + 1);
			} else {
				m.put(c, 1);
			}
		}

		for (char c: curr.toCharArray()) {
			if (m.containsKey(c)) {

				if (m.get(c) <= 0) return false;

				m.put(c, m.getOrDefault(c, 0) - 1);

			} else {
				return false;
			}
		}
		return true;
	}

	// Space (1) Time (N Log N)
	public boolean isAnagram2(String s, String t) {
		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();

		// Sort both arr to see if they have the same chars amount
		Arrays.sort(arrS);
		Arrays.sort(arrT);

		return Arrays.equals(arrS, arrT);
	}

    /**
     * Space (1) - Since we know how much we need to keep 26 chars
     * Time (N) - Traverse thru each string once
     */
    public boolean isAnagramArr(String s, String t) {
        // Only need 26 because the range in ASCII table 
        // for lowercase a to z is 97 to 122
        int[] alphabet = new int[26];

        /**
         * Put all char of string s into the arr.
         * The index utilize the distance from current character in string s to 'a' char.
         * By substract to 'a', it will return the index of this char from 'a' 
         * EX: 'a' - 'a' = 0 (97 - 97 = 0 - in ASCII table) 
         *     'v' - 'a' = 21 (118 - 97 = 21)
         */
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        
        // Subtract from what've been added from prev string s
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;

            // Stop once if string t has more of this char than string s
            if (alphabet[t.charAt(i) - 'a'] < 0)
                return false;
        }

        // Check all alphabet if string s has more char that t doesn't have
        for (int i : alphabet)
            if (i != 0)
                return false;

        return true;
    }
}
