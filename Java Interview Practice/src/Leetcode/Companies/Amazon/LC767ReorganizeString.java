package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/**
 * LC767ReorganizeString
 */
public class LC767ReorganizeString {
    
    /**
     * 1. O(n) to build map with <Character, Count> 
     * 
     * 2. add to priority queue: k * lg (k) --> constant 
     *    Notes: this step you just have 26 entries in map 
     * 
     * 3. Building string - StringBuilder O(n * lg k ) , where k is 26 
     *    Notes: you are potentially adding back values into queue
     * 
     * Overall O(n * lg(26)) --> O(n) space: O(1) because map or
     * PQ has size of alphabet
     */
    public String reorganizeStringSolution(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

    // Same as above
    public String reorganizeString(String s) {
        StringBuilder result = new StringBuilder();
        if (s.length() < 1)
            return result.toString();

        Map<Character, Integer> map = new HashMap<>();
        int sLen = s.length();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Not possible to reorganize string if this char is more than half the string
            // itself
            if (map.get(c) > (sLen + 1) / 2) {
                return "";
            }
        }

        // Max Heap keep most frequent char first to least frequent char later
        PriorityQueue<Character> pq = new PriorityQueue<>(map.size(),
                (a, b) -> Integer.compare(map.get(b), map.get(a)));
        for (Entry<Character, Integer> e : map.entrySet()) {
            pq.add(e.getKey());
        }

        while (!pq.isEmpty()) {
            char curr = pq.poll();

            // Case this is brand new and if this curr is not the same char we just added
            if (result.length() == 0 || (map.get(curr) > 0 && curr != result.charAt(result.length() - 1))) {
                result.append(curr);
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) > 0) {
                    pq.add(curr);
                }
            }
            // Case curr is the same char we just added, use the next 1 in poll and re-add
            // both curr and nextChar if their count > 0
            else {
                char nextChar = pq.poll();
                result.append(nextChar);
                map.put(nextChar, map.get(nextChar) - 1);
                if (map.get(nextChar) > 0) {
                    pq.add(nextChar);
                }
                pq.add(curr);
            }
        }

        return result.toString();
    }

    /**
     * This solution doesn't work with "bbbla" since it will be "blabb" because the
     * we traverse map Space (N) - Map to hold all char
     * 
     * Time (N * M) - with N is the size of map with all character and M is the
     * amount of time run until counter hit string leng
     */
    public String reorganizeStringWrong(String s) {
        StringBuilder result = new StringBuilder();
        if (s.length() < 1)
            return result.toString();

        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        int sLen = s.length();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Not possible to reorganize string if this char is more than half the string
            // itself
            if (map.get(c) > (sLen + 1) / 2) {
                return "";
            }
        }

        while (counter < sLen) {
            for (Entry<Character, Integer> e : map.entrySet()) {
                if (map.get(e.getKey()) == 0) {
                    continue;
                }
                if (counter >= sLen) {
                    break;
                }

                map.put(e.getKey(), e.getValue() - 1);
                result.append(e.getKey());
                counter++;
            }
        }
        return result.toString();
    }

}