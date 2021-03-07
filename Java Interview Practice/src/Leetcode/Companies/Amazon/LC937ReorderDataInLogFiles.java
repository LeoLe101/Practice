package src.Leetcode.Companies.Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class LC937ReorderDataInLogFiles {

    // Space (N) - Time (N Log N) Due to Array.sort
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length < 1)
            return new String[] {};

        // Create new comparator for sorting below
        Comparator<String> strComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Get the first space of both strings
                // Will be used to track the identifier and first char index of the whole string
                int s1FirstSpaceIndx = s1.indexOf(' ');
                int s2FirstSpaceIndx = s2.indexOf(' ');

                // After the space index is the first char index
                char s1FirstChar = s1.charAt(s1FirstSpaceIndx + 1);
                char s2FirstChar = s2.charAt(s2FirstSpaceIndx + 1);

                // Str 1 (Digit)
                if (s1FirstChar <= '9') {

                    // Str 2 (also Digit) return 0, keep the same order for both Digit logs
                    if (s2FirstChar <= '9') return 0;

                    // Str 2 (Letter) return 1 since Str 1 (Digit) < Str 2 (Letter)
                    return 1;
                }

                // Str 1 (letter) > Str 2 (Digit)
                if (s2FirstChar <= '9') return -1;

                // Check 2 Letters lexicon
                String s1String = s1.substring(s1FirstSpaceIndx + 1);
                String s2String = s2.substring(s2FirstSpaceIndx + 1);
                int checkLexicon = s1String.compareTo(s2String);

                // Same word in str, check identifier 
                if (checkLexicon == 0) {
                    return s1.substring(0, s1FirstSpaceIndx).compareTo(s2.substring(0, s2FirstSpaceIndx));
                }

                // Else return result
                return checkLexicon;
            }
        };
        
        // Sort the logs with the comparator above
        Arrays.sort(logs, strComparator);
        return logs;
    }

}
