import java.util.HashSet;
import java.util.Set;

public class LC1304FindNUniqueIntegersSumUpToZero {

  /**
   * Space (N) 
   * Time (N)
   * @param n
   * @return
   */
  public int[] sumZero(int n) {
    int[] res = new int[n];
    int left = 0, right = n - 1, start = 1;
    while (left < right) {
        res[left++] = start;
        res[right--] = -start;
        start++;
    }
    return res;
  }
}
