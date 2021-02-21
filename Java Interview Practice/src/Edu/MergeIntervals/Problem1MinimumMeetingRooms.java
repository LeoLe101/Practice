package src.Edu.MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import src.Edu.Meeting;

public class Problem1MinimumMeetingRooms {

    public int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings.size() < 1)
            return 0;
            
        // Sort arr with the start of each meeting
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        // Use priority queue to keep the min ending time of each meeting
        PriorityQueue<Meeting> pq = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        int roomsNeeded = 0;

        for (Meeting m : meetings) {

            // Remove all the meeting that ended before this curr meeting
            while (!pq.isEmpty() && m.start >= pq.peek().end) {
                pq.poll();
            }

            // Add curr meeting to pq
            pq.offer(m);

            // Check for the max amount of room occupied for meetings uptil now
            roomsNeeded = Math.max(roomsNeeded, pq.size());
        }
        return roomsNeeded;
    }
}
