import java.io.*;
import java.util.*;

/*
  Implement a function that takes a currency symbol (string) and 
  a stream of characters and returns a list of currency values as strings:

  get_currency_values(String currency_symbol, Stream data) => String[]

  examples:
  data = Stream("Lorem ipsum £100 dolor sit amet, £200 consectetur $300 adipiscing elit.")
  get_currency_values("£", data) -> ["100", "200"]
  get_currency_values("$", data) -> ["300"]
  get_currency_values("₱", data) -> []

  What is a Stream?
  A stream has two methods on it:
  hasNext(): returns true if there are more characters available in the string
  next(): returns a string of the next available character in the string

  Stream Example:
  data = Stream("test");
  data.hasNext()   => true
  data.next()   => 't'
  data.hasNext()   => true
  data.next()   => 'e'
  data.hasNext()   => true
  data.next()   => 's'
  data.hasNext()   => true
  data.next()   => 't'
  data.hasNext()   => false
  data.next()   => error
  
  Iterator<String> data = Arrays.asList(("Lorem ipsum £100 dolor sit amet, £200 consectetur $300 adipiscing elit.").split("")).listIterator();
*/

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {

    // Init stream
    Iterator<String> data = Arrays.asList(("Lorem ipsum B$T1,sddsds000.32 dolor sit amet, £200.56 consectetur $300 adipiscing elit.").split("")).listIterator();
    
    // Print out result from helper function take in the currency symbol and Stream data and return an array of match integer
    System.out.println(get_currency_values("£", data));
  }
  
  public static List<String> get_currency_values(String currSymbol, Iterator<String> data) {
  
    // init an empty arr
    List<String> result = new ArrayList<String>();

    // Loop thru the stream to find the currency symbol 
    while (data.hasNext()) {

      // if a currency symbol is found, move to the next char and check if it is an integer. 
      if (data.next().equalsIgnoreCase(currSymbol)) {
        String currStr = "";
        boolean isFirstCharCheck = false;
        while (data.hasNext()) {
          
          char a = data.next().toCharArray()[0];
          
          // If it is not integer, stop
          if (!isFirstCharCheck && a < '0' && a > '9') {
            break;
          } else {
            // Mark the first check as done
            isFirstCharCheck = true;
          }
          
          // If it is, add it into a new string to hold the integer value
          if (a >= '0' && a <= '9') {
            currStr += a;
          } else if (a == ',' || a == '.') {
            // If it is comma or a dot and before this is a number put it into a new string then move forward
            currStr += a;
          } else {
            // If it is a normal char, stop and add whatever in the string to the result arr.
            if (currStr.charAt(currStr.length() - 1) == '.') {
                currStr = currStr.replaceAll(".$", "");
            }
            if (currStr.charAt(currStr.length() - 1) == ',') {
              currStr = currStr.replaceAll(",$", "");            
            }
            result.add(currStr);
            break;
          }
          

  
          // If it is a negative char right after the currency symbol, add it to the new string
          // else stop and move this string to the result arr
          
        }
      }
      
      // continue the loop to find another concurrency symbol
    }
    
    
    return result;
  
  }
}
