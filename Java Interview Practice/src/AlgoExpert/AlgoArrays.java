package src.AlgoExpert;

import java.util.*;

/**
 * TwoSum
 */
public class AlgoArrays {

    // This is not optimized due to Arrays.sort is O(nLogn)
    public static int[] solution1(int[] array, int targetSum) {

        if (array.length <= 0)
            return new int[] {};

        int startIdx = 0;
        int endIdx = array.length - 1;
        int tempSum = 0;
        Arrays.sort(array);

        while (startIdx < endIdx) {
            tempSum = array[startIdx] + array[endIdx];
            if (tempSum == targetSum) {
                return new int[] { array[startIdx], array[endIdx] };
            } else if (tempSum > targetSum) {
                endIdx--;
            } else {
                startIdx++;
            }
        }

        return new int[] {};
    }

    // Optimized using HashMap O(N) for both space and time complexity
    public static int[] solution2(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int requiredNumb = 0;

        for (int number : array) {
            requiredNumb = targetSum - number;

            // Check if in Map yet
            if (!map.containsKey(number)) {

                // Check if any prev Key required this number to reach the targetSum
                if (map.containsValue(number)) {
                    return new int[] { number, requiredNumb };
                }
                map.put(number, requiredNumb);
            } else {
                if (requiredNumb == number)
                    return new int[] { number, requiredNumb };
            }
        }

        return new int[] {};
    }
}