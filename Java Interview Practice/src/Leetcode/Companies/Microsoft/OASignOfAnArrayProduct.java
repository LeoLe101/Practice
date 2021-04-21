public class OASignOfAnArrayProduct {

    /**
     * Write a function that given an array A of N integers (between -100 to 100),
     * return the sign (-1, 0, 1) of the product of all number in the array
     * multiplied together. Assume that N is between 1 and 1000.
     * 
     * Ex: A = [1, -2, -3, 5] --> Out: 1 
     * Ex: A = [1, 2, -3, 5]  --> Out: -1 
     * Ex: A = [1, -2, -3, 0] --> Out: 0
     */
    public int findProductSign(int[] array) {
        if (array.length < 1) return 0;
        int counter = 0;

        // Count the amount of negative number
        for (int i: array) {
            // If the array has 0, return 0 since it will be 0 once multiplied
            if (i == 0)
                return 0;
            
            if (i < 0) 
                counter++;
        }

        // If the counter is even number, means negative number cancel out
        return counter % 2 == 0 ? 1 : -1;
    }
}
