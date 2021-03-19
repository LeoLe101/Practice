package src.Leetcode.Companies.Amazon;

public class LC13RomanToInteger {

    /**
     * Space (1) - because we don't need to store anything else 
     * Time (N) - Loop once
     * 
     * Check only the I - X - C because if these stand before other letter once, it
     * will be reduction instead
     */
    public int romanToInt(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {

            case 'I':
                if (result >= 5)
                    result -= 1;
                else
                    result += 1;
                break;

            case 'V':
                result += 5;
                break;

            case 'X':
                if (result >= 50)
                    result -= 10;
                else
                    result += 10;
                break;

            case 'L':
                result += 50;
                break;

            case 'C':
                if (result >= 500)
                    result -= 100;
                else
                    result += 100;
                break;

            case 'D':
                result += 500;
                break;

            case 'M':
                result += 1000;
                break;

            default:
                result += 0;
                break;
            }
        }

        return result;
    }
}
