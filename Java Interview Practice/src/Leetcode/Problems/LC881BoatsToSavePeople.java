package src.Leetcode.Problems;

import java.util.Arrays;

public class LC881BoatsToSavePeople {

    // Space (N) - Time (N Log N) because of Sort
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        // Pair the heaviest with the lightest
        // if heaviest > limit ans++; else heaviest + lighter ans++;
        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return ans;
    }

}
