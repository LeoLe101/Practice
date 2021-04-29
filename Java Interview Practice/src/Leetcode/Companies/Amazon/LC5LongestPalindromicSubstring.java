public class LC5LongestPalindromicSubstring {

  private int lo, maxLen;

  /**
   * Space (N)
   * 
   * Time (N^2) because we need to loop through each element in the array, then
   * move from that element out to 2 ends in order to find the longest substring
   */
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2)
      return s;

    for (int i = 0; i < len - 1; i++) {
      extendPalindrome(s, i, i); // assume odd length
      extendPalindrome(s, i, i + 1); // assume even length.
    }
    return s.substring(lo, lo + maxLen);
  }

  private void extendPalindrome(String s, int j, int k) {
    // Move outward from this index
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }
    // Keep track of the lowest highest index of the palindrom substring
    if (maxLen < k - j - 1) {
      lo = j + 1;
      maxLen = k - j - 1;
    }
  }
}
