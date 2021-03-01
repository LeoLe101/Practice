package src.Leetcode.Contest;

import java.util.List;

/**
 * LC1773CountItemsMatchingARule
 */
public class LC1773CountItemsMatchingARule {

    // Space (1) - Time (N)
    public int countMatches(List<List<String>> items, String ruleKey, String rulelValue) {
        if (items.size() < 1)
            return 0;

        int counter = 0;
        int index = -1;

        // Find Rule Type index in items
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;

            default:
                break;
        }

        // Check if the index has the same rule value given
        for (List<String> item : items) {
            if (item.get(index).equals(rulelValue))
                counter++;
        }
        return counter;
    }

}