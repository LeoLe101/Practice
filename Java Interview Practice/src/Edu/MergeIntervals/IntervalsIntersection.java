package src.Edu.MergeIntervals;

import java.util.LinkedList;
import java.util.List;

import src.Edu.Interval;

public class IntervalsIntersection {

    // Space () - Time ()
    public Interval[] merge(Interval[] arr1, Interval[] arr2) {
        if (arr1.length < 1)
            return arr2;
        if (arr2.length < 1)
            return arr1;

        int ptr2 = 0;
        Interval comp = arr2[ptr2];
        List<Interval> result = new LinkedList<>();

        for (int ptr1 = 0; ptr1 < arr1.length; ptr1++) {
            Interval curr = arr1[ptr1];
            // Overlapped
            if (curr.end <= comp.end)&& curr.start <= comp.start) {
                
            }
            // arr1 not overlapped
            if (curr.start > comp.end || curr.end < comp.start) {
                result.add(curr);
            }
        }

    }
}
