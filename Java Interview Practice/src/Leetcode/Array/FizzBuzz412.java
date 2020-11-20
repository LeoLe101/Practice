package src.Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {

    public List<String> fizzBuzz(int n) {
    // ans list
    List<String> ans = new ArrayList<String>();

    for (int num = 1; num <= n; num++) {

      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);

      if (divisibleBy3 && divisibleBy5) {
        // Divides by both 3 and 5, add FizzBuzz
        ans.add("FizzBuzz");
      } else if (divisibleBy3) {
        // Divides by 3, add Fizz
        ans.add("Fizz");
      } else if (divisibleBy5) {
        // Divides by 5, add Buzz
        ans.add("Buzz");
      } else {
        // Not divisible by 3 or 5, add the number
        ans.add(Integer.toString(num));
      }
    }

    return ans;
    }

    // Method without calculation
    public List<String> fizzBuzzNoCal(int n) {
        List<String> ret = new ArrayList<String>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                ret.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                ret.add("Buzz");
                buzz = 0;
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
