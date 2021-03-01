package src.Leetcode.Problems;

import java.util.ArrayList;
import java.util.List;

public class LC386LexicographicalNumbers {

    // Smart way hard to get the idea
    // Space (1) - Time (N Log N) with Log N is the inner loop
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    /**
     * The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
     * Then we visit every node in pre-order. 
          1        2        3    ...
         /\       /\       /\
       10...19  20...29  30...39   ....
     */
    // Space (N) - Time (N)
    public List<Integer> lexicalOrderDFS(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int currNum, int n, List<Integer> result) {
        if (currNum > n)
            return;

        // Add to the result if this is the right order
        result.add(currNum);

        // Recursion down and select the correct lexicon order of the current index
        // constantly go down by curr * 10 + 1
        // if the number > n, backtrack and choose an appropriate lexical order
        for (int i = 0; i < 10; i++) {
            currNum = currNum * 10 + 1;
            if (currNum > n)
                return;
            dfs(currNum, n, result);
        }
    }
}
