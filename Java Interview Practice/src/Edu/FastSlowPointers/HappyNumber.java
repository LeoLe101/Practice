package src.Edu.FastSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * Problem: Any number will be called a happy number if, after repeatedly
     * replacing it with a number equal to the sum of the square of all of its
     * digits, leads us to number ‘1’. All other (not-happy) numbers will never
     * reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not
     * include ‘1’.
     * 
     * Space (1) - Time (Log N)
     */

    // #region ==== Personal Solution ====
    // Space (N) - Time (Log N)
    public boolean isHappy(int num) {
        int sum = num;
        Set<Integer> s = new HashSet<Integer>();

        // Loop until the repeated integer is met
        while (!s.contains(sum)) {
            s.add(sum);
            sum = 0;

            // Calculate all digits within this int
            while (num > 0) {
                sum += Math.pow(num % 10, 2);
                num = num / 10;
            }
            num = sum;

            // If the calculation result in 1, return true;
            if (num == 1)
                return true;
        }
        return false;
    }
    // #endregion

    // #region ---- EDUCATIVE Solution ----
    // Space(1) - Time (Log N) Solution from LinkedList Cycle idea
    // Because the faster value = double the slow value, it will certainly meet up
    // in the future somewhere. If that somewhere is 1, this is the happy number.
    public boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
    // #endregion

}
