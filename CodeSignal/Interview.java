public class Interview {

    public Interview() {
    }

    /**
     * Given a string s consisting of small English letters, find and return the
     * first instance of a non-repeating character in it. If there is no such
     * character, return '_'.
     * 
     * For s = "abacabad", the output should be 'c'. There are 2 non-repeating
     * characters in the string: 'c' and 'd'. Return c since it appears in the
     * string first.
     * 
     * For s = "abacabaabacaba", the output should be '_'. There are no characters
     * in this string that do not repeat.
     * 
     * @param {*} s String given from the user
     * @return The first non-repeated char or '_' if none existed.
     */
    public char firstNotRepeatingCharacter(String s) {
        int[] chars = new int[26];
        int[] pos = new int[26];
        int lowestIndex = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (pos[n] == 0)
                pos[n] = i + 1;

            chars[n]++;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1 && pos[i] < lowestIndex)
                lowestIndex = pos[i];
        }

        if (lowestIndex == Integer.MAX_VALUE)
            return '_';
        return s.charAt(lowestIndex - 1);
    }
}