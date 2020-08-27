public class FindNumbersWithEvenNumberDigit {
    public int findNumbersByConvertToString(int[] nums) {
        String temp;
        int counter = 0;
        for (int currNumb : nums) {
            temp = String.valueOf(currNumb);
            if (temp.length() % 2 == 0)
                counter++;
        }
        return counter;
    }
    
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int currNumb : nums) {
            if (currNumb >= 10 && currNumb < 100) {
                counter++;
            }
            if (currNumb >= 1000 && currNumb < 10000) {
                counter++;
            }  
            if (currNumb == 100000) {
                counter++;
            }
        }
        return counter;
    }
}