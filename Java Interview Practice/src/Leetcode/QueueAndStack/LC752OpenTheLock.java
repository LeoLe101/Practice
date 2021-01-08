package src.Leetcode.QueueAndStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC752OpenTheLock {

    private final String START = "0000";

    // Not Done yet
    // Space (N) - Time (N)
    public int openLock(String[] deadends, String target) {

        HashSet<String> deadEnds = new HashSet<String>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        int counter = 0;

        visited.add(START);
        queue.offer(START);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while(size > 0) {
                String curr = queue.poll();
                if (deadEnds.contains(curr)) {
                    size--;
                    continue;
                }

                if (curr == target) {
                    return counter;
                }

                StringBuilder sb = new StringBuilder(curr);

                // Loop through each index of the current Lock Combination
                // Increment as needed
                for (int i = 0; i < 4; i++) {
                    char currPos = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (currPos == '9' ? 0 : currPos - '0' + 1);
                    String s2 = sb.substring(0, i) + (currPos == '0' ? 9 : currPos - '0' - 1);

                    if (!visited.contains(s1) && !deadEnds.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }

                    if (!visited.contains(s2) && !deadEnds.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            counter++;
        }
        return counter;
    }

}
