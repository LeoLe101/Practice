package src.Hackerrank.DictMap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps&isFullScreen=true

    public static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magMap = mapString(magazine);
        HashMap<String, Integer> noteMap = mapString(note);
        System.out.println(check(magMap, noteMap) ? "Yes" : "No");
        return;
    }

    // Helper functions
    private static HashMap<String, Integer> mapString(String[] arr) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String str : arr) {
            if (result.containsKey(str)) {
                result.put(str, result.get(str) + 1);
            } else {
                result.put(str, 1);
            }
        }
        return result;
    }

    private static boolean check(HashMap<String, Integer> magMap, HashMap<String, Integer> noteMap) {
        for (Map.Entry<String, Integer> noteEntry : noteMap.entrySet()) {
            String word = noteEntry.getKey();
            if (!magMap.containsKey(word) || magMap.get(word) < noteEntry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
