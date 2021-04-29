import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRoomsII {

    /**
     * Space (N) Needed for sorting and PQ 
     * 
     * Time (NLogN) because of sorting
     */
    public boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length;
        if (len < 1)
            return 0;

        // Sort the array by smallest start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Init the PQ that sort by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(len, (a, b) -> Integer.compare(a[1], b[1]));
        int max = 0;
        for (int i = 0; i < len; i++) {
            int[] nextMeeting = intervals[i];

            // If there is a meeting, and the meeting ends before the current meeting start,
            // pop out of the PQ
            while (!pq.isEmpty() && nextMeeting[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.offer(intervals[i]);
            max = Math.max(max, pq.size());
        }
        return max;
    }

    /**
     * Space (N): Needed for sorting and PQ
     * 
     * Time (N Log N): Because of sorting
     */
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if (len < 1)
            return 0;

        // Sort the array by smallest start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Init the PQ that sort by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(len, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < len; i++) {
            int[] nextMeeting = intervals[i];

            // If there is a meeting, and the meeting ends before the current meeting start,
            // pop out of the PQ
            if (!pq.isEmpty() && nextMeeting[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }

}
