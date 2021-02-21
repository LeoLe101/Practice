package src.Edu.MergeIntervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import src.Edu.Interval;

public class MergeIntervals {

    // Space (N) - Time (N Log N) -
    // - Time N Log N is because the sort and N is the number of intervals
    // - Space N is because it is needed for the sorting Collection.sort() required
    // O(N) space because it use Merge Sort or Tim Sort
    public List<Interval> merge(List<Interval> intervals) {
        // Sort the list before compare
        Collections.sort(intervals,
                (currInterval, nextInterval) -> Integer.compare(currInterval.start, nextInterval.start));

        List<Interval> result = new LinkedList<>();
        Interval currInv = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInv = intervals.get(1);

            // If the next interval start is within the curr/prev interval
            // ==> which mean the intervals overlapped.
            // Fix the end of the curr/prev interval
            if (nextInv.start <= currInv.end) {
                currInv.end = Math.max(nextInv.end, currInv.end);
            } 
            
            // Non-overlapped, add the curr Interval into the result. 
            // Set the next Interval as curr Interval and move on
            else {
                result.add(currInv);
                currInv = nextInv;
            }
        }
        // Add the last interval since the last is not compared
        result.add(currInv);
        return result;
    }

}
