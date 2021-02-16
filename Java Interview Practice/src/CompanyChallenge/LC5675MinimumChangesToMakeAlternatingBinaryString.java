package src.CompanyChallenge;

/**
 * LC5675MinimumChangesToMakeAlternatingBinaryString Nasdaq coding challange
 * https://leetcode.com/discuss/interview-question/975215/nasdaq-online-binary-string-reduction
 * https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
 */
public class LC5675MinimumChangesToMakeAlternatingBinaryString {

    // Space (N) - Time (N)
    // Use the expected character to check the current array
    // Start checking the first elemnt start with '0' throughout the sequence
    // and constantly change expected character accordingly.
    // If currChar in sequence is not as expected, increase count
    public int minOperations(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] cArr = s.toCharArray();

        // 1st run through with 1 as start
        int counter1 = amountAlternation(cArr, '0');
        // 2nd run through with 0 as start
        int counter2 = amountAlternation(cArr, '1');

        return Math.min(counter1, counter2);
    }

    // Check the amount of alternation with the expected character
    private int amountAlternation(char[] cArr, char expected) {
        int counter = 0;
        for (int curr = 1; curr < cArr.length;) {
            if (cArr[curr] != expected) {
                counter++;
            }
            expected = (expected == '1') ? '0' : '1';
        }
        return counter;
    }

}
