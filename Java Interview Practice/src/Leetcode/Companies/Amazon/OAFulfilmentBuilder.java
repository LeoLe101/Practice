package src.Leetcode.Companies.Amazon;

import java.util.List;
import java.util.PriorityQueue;

public class OAFulfilmentBuilder {

  /**
   * The Amazon Fulfullment Builder will provide an estimate about the time it
   * will take for the item to be created based on the size of each parts. The
   * worker can only combine 2 parts at a time. Time required to put 2 parts is
   * the sum of parts' sizes. The newly combined part will be combined again with
   * other parts until all parts combined into 1 final product
   * 
   * Return minimum time requried to assemble all N parts
   * 
   * Ex: + Parts = [8, 4, 6, 12] ==> Output: 58 + Step 1: Put 2 smallest parts
   * together: 6 + 4 = 10 ==> Parts = [8, 10, 12] + Step 2: Put 2 smallest parts
   * together: 8 + 10 = 18 ==> Parts = [18, 12] + Step 3: Put 2 smallest parts
   * together: 12 + 18 = 30 ==> Parts = [30] + Final: because each steps takes
   * different time, total min time = 10 + 18 + 30 = 58
   * 
   * Constraints: + 1 < N parts < 10^6 + 1 < parts[i] < 10^6 + 0 < i < N parts
   */

  // Space (1) - Time (N)
  public int combineParts(List<Integer> parts) {
    // Min Heap to keep smallest part size
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int minTotalTime = 0;
    int sum = 0;
    int part1 = 0;
    int part2 = 0;

    // Init heap
    for (int part : parts) {
      minHeap.offer(part);
    }

    // Combine all smallest parts until only 1 combined part left
    while (minHeap.size() != 1) {
      part1 = minHeap.poll();
      part2 = minHeap.poll();
      sum = part1 + part2; // Combined part
      minHeap.offer(sum); // put it back in heap once combined
      minTotalTime += sum; // calculate total time of each combination
    }

    return minTotalTime;
  }
}
