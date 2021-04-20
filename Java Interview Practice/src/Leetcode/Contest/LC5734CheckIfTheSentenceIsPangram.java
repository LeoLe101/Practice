package src.Leetcode.Contest;

public class LC5734CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        int[] arr = new int[26];

        for (char c: sentence.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i : arr) {
            if (i < 1) {
                return false;
            }
        }
        return true;
    }




    
}
