package src.Leetcode.Problems;

public class ReverseString344 {

    public void reverseString(char[] s) {
        int firstIndx = 0;
        int lastIndx = s.length - 1;

        while (firstIndx < lastIndx) {
            char temp = s[firstIndx];
            s[firstIndx] = s[lastIndx];
            s[lastIndx] = temp;
            firstIndx++;
            lastIndx--;
        }
    }

    public void reverseStringRecursion(char[] s) {
        recHelper(s, 0, s.length - 1);
        return;
    }

    private void recHelper(char[] s, int left, int right) {
        if (left >= right) return;

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        recHelper(s, left + 1, right - 1);
        return;
    }

    
}
