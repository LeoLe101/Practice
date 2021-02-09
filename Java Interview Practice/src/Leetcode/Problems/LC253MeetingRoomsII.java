package src.Leetcode.Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRoomsII {

    public int minMeetingsRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(intervals.length, (a, b) -> (a[1] - b[1]));
        int max = 0;

        for (int i = 0; i < intervals.length; i++) {
            while (!queue.isEmpty() && intervals[i][0] >= queue.peek()[1])
                queue.poll();
            queue.offer(intervals[i]);
            max = Math.max(max, queue.size());
        }
        return max;
    }

}
