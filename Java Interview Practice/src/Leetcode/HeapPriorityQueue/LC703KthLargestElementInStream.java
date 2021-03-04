package src.Leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class LC703KthLargestElementInStream {

  private PriorityQueue<Integer> pq;
  private int kthLargest;

  public LC703KthLargestElementInStream(int k, int[] nums) {
    kthLargest = k;

    // Init priority queue (min-heap) and add all nums into pq
    pq = new PriorityQueue<Integer>(nums.length);
    for (int num : nums)
      add(num);

    /**
     * ex: nums[4, 5, 8, 2] --> pq[4, 5, 8]
     *     add(3)           --> pq[4, 5, 8]  return 4 - since 3 added on top and size > kth, remove 3
     *     add(5)           --> pq[5, 5, 8]  return 5 - since 4 added on top and size > kth, remove 4
     *     add(10)          --> pq[5, 8, 10] return 5 - since 5 added on top and size > kth, remove 5
     *     add(9)           --> pq[8, 9, 10] return 8 - since 5 added on top and size > kth, remove 5
     *     add(4)           --> pq[8, 9, 10] return 8 - since 4 added on top and size > kth, remove 4
     */
  }

  // Add the new number and return the kth largest number after added
  // Space () - Time ()
  public int add(int val) {
    pq.offer(val);

    // Remove the smallest value in the priority queue once it pass kth largest
    // element
    // Only need to keep kth amount of element in pq,
    // since the top of min heap is the kth largest element
    if (pq.size() > kthLargest) {
      pq.poll();
    }
    return pq.peek(); // Return the smallest element in pq
  }

}
