package src.Leetcode.Problems;

public class LC1446ConsecutiveCharacters {

    // Space (1) Time (N)
    public int maxPower(String s) {
        // Check s validation
        if (s.length() < 1)
            return -1;

        // Init var
        int ptr1 = 0;
        int counter = 1;
        int result = 1;

        // Loop thru Arr
        for (int ptr2 = 1; ptr2 < s.length(); ptr2++) {
            // Check ptr2 != ptr1
            if (s.charAt(ptr2) != s.charAt(ptr1)) {
                // Reset counter and get the amount count
                ptr1 = ptr2;
                if (counter > result)
                    result = counter;
                counter = 1;
            } else {
                counter++;
            }
        }

        // Return val
        return (counter > result) ? counter : result;
    }

}
