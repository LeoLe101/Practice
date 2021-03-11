package src.Leetcode.Contest;

public class LC1784CheckIfBinaryStringHashAtMostOneSegmentOfOnes {

  // Sliding Window
  // Space (1) - Time (N * K)
  public static boolean atMostOneSegment(String s) {
    int segment = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        if (segment == 1) {
          return false;
        }
        segment++;
        while (i < s.length() && s.charAt(i) == '1') {
          i++;
        }
        i--;
      }
    }
    return segment <= 1;
  }

}
