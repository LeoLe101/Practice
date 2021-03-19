package src.Leetcode.Companies.Amazon;

public class LC12IntegerToRoman {

    /**
     * Space (1) - No use of space
     * 
     * Time (N) - Run thru until number is 0
     * 
     * Inefficient
     */
    public String intToRoman(int num) {
        String result = "";

        while (num != 0) {
            if (num >= 1000) {
                result += "M";
                num -= 1000;
            } else if (num >= 900) {
                result += "CM";
                num -= 900;
            } else if (num >= 500) {
                result += "D";
                num -= 500;
            } else if (num >= 400) {
                result += "CD";
                num -= 400;
            } else if (num >= 100) {
                result += "C";
                num -= 100;
            } else if (num >= 90) {
                result += "XC";
                num -= 90;
            } else if (num >= 50) {
                result += "L";
                num -= 50;
            } else if (num >= 40) {
                result += "XL";
                num -= 40;
            } else if (num >= 10) {
                result += "X";
                num -= 10;
            } else if (num >= 9) {
                result += "IX";
                num -= 9;
            } else if (num >= 5) {
                result += "V";
                num -= 5;
            } else if (num >= 4) {
                result += "IV";
                num -= 4;
            } else {
                result += "I";
                num--;
            }
        }

        return result;
    }

    /**
     * Space (1) - Since we know how much space needed for val and str, space is 1
     * instead of n amount of space (only when we do not know like BFS, DFS)
     * 
     * Time (N) - Amount of traverse required to clear the number
     */
    public String intToRomanOptimized(int num) {
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // Use string builder instead of String in Java
        // Since it doesn't create new String object everytime appending str
        // Furthermore, String Builder is mutable. String is immutable
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - val[i] >= 0) {
                res.append(str[i]);
                num -= val[i];
            } else {
                i++;
            }
        }
        return res.toString();
    }

}
