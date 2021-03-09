package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class LC347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        
        // Map to track the key and frequent of the number in array
        Map<Integer, Integer> map = new HashMap<>();
        // Get the most frequent element on top of pq (From most freq to least)
        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(nums.length,
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));

        // Put/Update all the frequencies of that value into map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Put all value mapped above to pq
        for (Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        // Return all the top Frequent Element with k size
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

}
