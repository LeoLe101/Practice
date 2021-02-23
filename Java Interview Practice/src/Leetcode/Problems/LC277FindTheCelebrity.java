package src.Leetcode.Problems;

// https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
// https://leetcode.com/problems/find-the-celebrity/
public class LC277FindTheCelebrity {
    private boolean knows(int a, int b) {
        return false;
    }

    // Space (N) - Time (N^2)
    public int findCelebrity(int n) {
        if (n < 1)
            return 0;

        int[] know = new int[n];

        // Loop through graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if j and i know each other.
                // Skip itself because it already known itself
                if (i != j) {
                    if (knows(i, j)) {
                        know[j] += 1;
                    }
                }
            }
        }

        // ex: Knows [1, 3, 1, 1] - Sum of all knows nodes

        // Find max known person within knows
        int maxKnow = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            if (know[i] > maxKnow && know[i] > 0) {
                currentMax = i; // index of max know
                maxKnow = know[i]; // val of max know
            }
        }

        // Check if no one know this max know person
        if (maxKnow == Integer.MIN_VALUE)
            return -1;

        // Check if the amount of people know about this person is all other people
        // (except self)
        if (maxKnow < n - 1)
            return -1;

        // Check the most know person know any other people.
        // If this person know someone, this is not a famous person
        for (int i = 0; i < n; i++) {
            if (currentMax != i && knows(currentMax, i))
                return -1;
        }
        return currentMax;
    }

    // Space (1) - Time (N)
    public int findCelebrityOptimized(int n) {
        int candidate = 0;
        // Go through everyone (Except for the candidate [0]),
        //    check if the current candidate know anyone else
        // Set the candidate to that know person
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }

        // Go through everyone again with the candidate as well
        //    check if this famous person know anyboday and if anyboday know him/her
        //    
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
                return -1;
        }
        return candidate;
    }

}
