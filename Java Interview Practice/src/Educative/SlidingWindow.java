package src.Educative;

public class SlidingWindow {

    public SlidingWindow() {} 

    // Find the average of all contiguous subarrays of size ‘5’ in the given array.
    // Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    // Output: [2.2, 2.8, 2.4, 3.6, 2.8]
    public double[] BF_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1]; // Since the window is always K size
        double sum = 0.0;
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = 0; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    // Optimization: Save the calculated common areas within the array by minus the
    // first and add the last elmnt
    public double[] OPT_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double sum = 0.0;
        int windowStart = 0;

        // First calculation
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // Starting optimization calculation
        for (int j = 0; j < result.length; j++) {
            if (j > 0) {
                sum = sum - arr[windowStart] + arr[j + k - 1];
            }
            result[j] = sum / k;
            windowStart = j;
        }
        return result;
    }

    public int findMinSubArray(int s, int[] arr) {
        int winStart = 0;
        int k = 0;
        int sum = 0;

        // Constantly increment the amount of K window size and reset windowStart
        while (k < arr.length) {

            // Sum of all element in this K window size
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];

                if (i >= k) {
                    if (sum >= s) {
                        return k + 1;
                    }
                    sum -= arr[winStart];
                    winStart++;
                }
            }
            winStart = 0;
            k++;
        }
        return -1;
    }
}