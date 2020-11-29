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
    
}
