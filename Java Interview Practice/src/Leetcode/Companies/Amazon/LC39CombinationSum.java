package src.Leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39CombinationSum {

    /**
     * Space (T/M) With T (Target) and M (Minimal value) in the list of candidates.
     * Since target / minval is the limit where the result combination cannot pass
     * over, it is T/M
     * 
     * Time (2^N) Because stack call for each case, either keep adding curr indx or
     * go to next index due to this 2 path, each case will be 2 recur down
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (candidates.length < 1)
            return result;

        // Must sort the candidates for backtracking later
        Arrays.sort(candidates);
        // Recursively go through the stack
        getCombination(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    // Recursively get the combination
    private void getCombination(int[] candidates, int sum, int index, int target, List<Integer> currList,
            List<List<Integer>> result) {
        // Pop/Return when index or target is more than expected
        if (index >= candidates.length || sum > target) {
            return;
        }

        // Add candidate to list for tracking and add to sum
        currList.add(candidates[index]);
        sum += candidates[index];

        // If combination found, add to result
        if (sum == target) {
            result.add(currList);
        }

        // If combination < Target, recur down to the SAME CANDIDATE util it is > or =
        // target
        // This is for cases: [2, 2, 3] = 7
        if (sum < target) {
            getCombination(candidates, sum, index, target, currList, result);
        }

        // Remove most recent added candidate from sum and list
        sum -= currList.get(currList.size() - 1);
        currList.remove(currList.size() - 1);

        // After refresh list and sum, recur down to NEXT CANDIDATE
        getCombination(candidates, sum, index + 1, target, currList, result);
    }

}
