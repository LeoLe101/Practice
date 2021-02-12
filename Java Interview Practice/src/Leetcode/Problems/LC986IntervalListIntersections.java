package src.Leetcode.Problems;

import java.util.LinkedList;
import java.util.List;

public class LC986IntervalListIntersections {

    // Space (N) - Time (N)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new LinkedList<>();

        if (firstList.length <= 0 || secondList.length <= 0)
            return new int[][] {};

        int ptr1 = 0;
        int ptr2 = 0;
        int start = 0;
        int end = 1;

        while (ptr1 < firstList.length && ptr2 < secondList.length) {

            // Find the range of overlapped
            int maxStart = Math.max(firstList[ptr1][start], secondList[ptr2][start]);
            int minEnd = Math.min(firstList[ptr1][end], secondList[ptr2][end]);

            // start and end within range of overlapped
            if (maxStart <= minEnd) {
                result.add(new int[] { maxStart, minEnd });
            }
            // Move ptr from the list that has the end == to minEnd
            if(firstList[ptr1][end] < secondList[ptr2][end]) {
                ptr1++;
            } else {
                ptr2++;
            }
    
        return result.toArray(new int[result.size()][2]);
    }

}
