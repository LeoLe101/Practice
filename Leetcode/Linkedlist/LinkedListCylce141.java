public class LinkedListCylce141 {

    // Space and Time O(N)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }


    // Best solution Time O(N) 
    // --- if no Cycle O(N)
    // --- if Cycle O(N + K) with K is some of the repeated nodes but this is also O(N)
    // Space O(1)
    public boolean hasCycleOptimized(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    


    
}