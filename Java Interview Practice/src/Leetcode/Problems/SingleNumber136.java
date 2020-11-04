package src.Leetcode.Problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber136 {

    // Solved Space and Time: O(N)
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i : nums) {
            if (s.contains(i))
                s.remove(i);
            else
                s.add(i);
        }
        Iterator<Integer> iter = s.iterator();
        return iter.hasNext() ? iter.next() : -1;
    }

    // The most god like solution Bit Manipulation --- Space O(1) Time O(N)
    /**
     * A number XOR 0 will be itself A number XOR itself will be 0 Therefore, if we
     * XOR all the array, knowing there is only 1 special number. That number will
     * show up after XOR the whole array together
     */
    public int singleNumberOptimized(int[] nums) {
        int result = 0;
        for (int number : nums) {
            result ^= number;
        }
        return result;
    }
}