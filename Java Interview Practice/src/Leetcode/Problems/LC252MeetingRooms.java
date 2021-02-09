package src.Leetcode.Problems;

import java.util.Arrays;

public class LC252MeetingRooms {

    // Space (N) - Time (N Log N) - Due to the sorting algo
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 1)
            return true;

        // Sort with start time from small to big
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prevMeeting = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prevMeeting[1] > intervals[i][0]) {
                return false;
            }
            prevMeeting = intervals[i];
        }
        return true;
    }

}
