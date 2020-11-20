package src.Leetcode.Linkedlist;

import src.Util.ListNode;

public class DeleteNodeInLL237 {
    
    // Time + Space(1) Set curr node = next node value
    // Then shift the next node to the next next node (Unlink with the next next node of the curr node)
    public void deleteNodeOptimized(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Space (1) Time (N) Set curr node = next node value, 
    // then constantly shifting the value until the end, reconnect the 2nd end node to null
    public void deleteNode(ListNode node) {
        
        if (node == null) return;
        
        ListNode temp;
        
        while (node != null && node.next != null && node.next.next != null) {
            temp = node.next;
            node.val = temp.val;
            node = temp;
        }
        node.val = node.next.val;
        node.next = null;
    }

}
