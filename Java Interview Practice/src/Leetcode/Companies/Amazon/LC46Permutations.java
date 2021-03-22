package src.Leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC46Permutations {

    /**
     * Space (N * N!) - required space to store each permutations found Time (N *
     * N!) - N is the height of the tree required to get the permutation - N! is the
     * amount of permutations possible
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1)
            return result;

        List<Integer> rootLevel = new LinkedList<>();
        rootLevel.add(nums[0]);
        int numPtr = 1;

        if (nums.length == 1) {
            result.add(rootLevel);
            return result;
        }

        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(rootLevel);

        while (!q.isEmpty() && numPtr < nums.length) {
            int size = q.size();

            // Traverse through all permutations of this level
            for (int i = 0; i < size; i++) {
                List<Integer> currLevel = q.poll();

                // Add new nums integer into each indicies location
                // The size + 1 is because a new index of nums is being added
                for (int j = 0; j < currLevel.size() + 1; j++) {

                    // Get a copy of curr level and create a new
                    // permutation with the added int at index j
                    List<Integer> newLevel = new LinkedList<>(currLevel);
                    newLevel.add(j, nums[numPtr]);
                    q.offer(newLevel);

                    // This is the last index of nums array (correct permutation level)
                    if (numPtr == nums.length - 1) {
                        result.add(newLevel);
                    }
                }
            }
            numPtr++;
        }

        return result;
    }

    /**
     * Space (N * N!) - With N is the height of the tree required to traverse until reach the permutation 
     *                - N! is the amount of permutations (backtracking)
     * 
     * Time (N * N!) - With N is the height of the tree to get the permutation
     *               - N! is the number of permutations
     */
    public List<List<Integer>> permuteDFS(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 1 || nums == null)
            return result;

        dfsHelper(result, new LinkedList<>(), new HashSet<>(), nums);

        return result;
    }

    private void dfsHelper(List<List<Integer>> result, List<Integer> currLevel, Set<Integer> levelSet, int[] nums) {
        // At the correct permutation level
        if (levelSet.size() == nums.length)
        {
            // Make sure to make a copy of curr list if not, the reference will be messed up
            result.add(new LinkedList<>(currLevel));
            return;
        }

        // Go thru all number in nums
        for (int i = 0; i < nums.length; i++) {
            // Skip existed number to add the next number
            if (levelSet.contains(nums[i])) continue;

            // Add set to track, add list to return result
            levelSet.add(nums[i]);
            currLevel.add(nums[i]);

            // Recursively move forward to the next number
            dfsHelper(result, currLevel, levelSet, nums);

            // Remove the number added from the recursion to backtrack to a new permutation
            int numberFromPrevDFS = currLevel.get(currLevel.size() - 1);
            levelSet.remove(numberFromPrevDFS);
            currLevel.remove(currLevel.size() - 1);
        }

    }
}
