package src.Leetcode.Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC575DistributeCandies {

  // Space (N) - Time (N)
  public int distributeCandiesSet(int[] candyType) {
    int len = candyType.length;
    if (len < 1)
      return 0;

    int limit = len / 2;
    int amountAte = 0;
    Set<Integer> candyAte = new HashSet<>();

    // Loop and add all diff candy into set, return set if reach limit
    for (int candy : candyType) {
      amountAte = candyAte.size();
      candyAte.add(candy);
      if (amountAte >= limit) {
        return amountAte;
      }
    }
    return amountAte;
  }

  // Space (1) - Time (N Log N)
  public int distributeCandiesSort(int[] candyType) {
    int len = candyType.length;
    if (len < 1)
      return 0;

    int limit = len / 2;
    int result = 0;
    int curr = 0;

    // Sort the candy type
    Arrays.sort(candyType);

    for (int next = 1; result < limit && next < len; next++) {
      if (candyType[curr] != candyType[next]) {
        curr = next;
        result++;
      }
    }
    return result;
  }

}
