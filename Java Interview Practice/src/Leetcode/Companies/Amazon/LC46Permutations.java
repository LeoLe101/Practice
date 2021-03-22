package src.Leetcode.Companies.Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC46Permutations {

    public List<List<Integer>> permute(int[] nums) {






















    }

    public static List<List<Integer>> posPermutation(int[] arr) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (arr.length < 1 || arr == null) {
            return result;
        }
        LinkedList<Integer> currLevel = new LinkedList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        currLevel.offer(1);
        q.offer(currLevel);
        int ptr = 1;

        while (!q.isEmpty() && ptr < arr.length) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                List<Integer> curr = q.poll();

                for (int j = 0; j < curr.size() + 1; j++) {
                    LinkedList<Integer> newLvl = new LinkedList<>(curr);
                    newLvl.add(j, arr[ptr]);
                    q.offer(newLvl);

                    if (ptr == arr.length - 1) {
                        result.add(newLvl);
                    }
                }
            }
            ptr++;
        }
        return result;
    }

}
