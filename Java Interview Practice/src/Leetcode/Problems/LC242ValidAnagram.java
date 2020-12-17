package src.Leetcode.Problems;

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

		for (char c:.toCharArray()) {
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

	// Space (1) Time (N Log N)
	public boolean isAnagram3(String s, String t) {

		int[] alphabet = new int[26];
		for (char c: s.toCharArray()) {
			alphabet[c - 'a']++;
		}
		
		for (char c: t.toCharArray()) {
			alphabet[c - 'a']--;
		}

		for (int i : alphabet) {
			if (i != 0) return false;
		}

		return true;
	}
}
