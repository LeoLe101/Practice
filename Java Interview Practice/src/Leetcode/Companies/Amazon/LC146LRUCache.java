package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {

  /**
   * Space (N) - Time (N)
   * 
   * Doubly Linked List to keep track of most recent used
   * Map to keep track of the key value pair
   * 
   * Ex: Capactity = 3
   * 
   * put(1, 3)             1 : 3
   * put(2, 4) ==> Map = { 2 : 4 }
   * put(4, 1)             4 : 1
   * 
   * put(6, 7) => reached cap, remove least used key out
   * 
   *         1 : 3 <-- remove
   * Map = { 2 : 4 }
   *         4 : 1
   * 
   *         2 : 4 <-- pushed bottom up and become least used since 6 : 7 is the latest
   * Map = { 4 : 1 }
   *         6 : 7
   * 
   * get(2) return 4
   * 
   *         4 : 1 <-- pushed bottom up and become least used since 2 : 4 is recently used
   * Map = { 6 : 7 }
   *         2 : 4
   * 
   * Use Double Linked List to keep track this least recent used key value and reorder them
   */        

  // Base of Doubly Linked List
  /**
   * Help remove and add function to be O(1) instead of O(N) because it doesn't need to traverse whole linked list
   */
  class CacheNode {
    CacheNode next;
    CacheNode prev;
    int val;
    int key;
  }

  private void add(CacheNode node) {
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void remove(CacheNode node) {
    node.next.prev = node.prev;
    node.prev.next = node.next;
  }

  private void moveToHead(CacheNode node) {
    remove(node);
    add(node);
  }

  private CacheNode popTail() {
    CacheNode res = tail.prev;
    remove(tail.prev);
    return res;
  }

  private Map<Integer, CacheNode> map;
  private int cap;
  private CacheNode head;
  private CacheNode tail;

  public LC146LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.cap = capacity;
    this.head = new CacheNode();
    this.tail = new CacheNode();

    // Connect Head Node and Tail Node together
    head.next = tail;
    head.prev = null;

    tail.next = null;
    tail.prev = head;
  }

  public int get(int key) {
    CacheNode curr = map.get(key);
    if (curr != null) {
      moveToHead(curr);
      return curr.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    CacheNode curr = map.get(key);

    // Case this is a new key : val pair
    if (curr == null) {
      CacheNode addNode = new CacheNode();
      addNode.key = key;
      addNode.val = value;
      map.put(key, addNode);
      add(addNode);
    } 
    // Case this key pair existed, change value
    else {
      curr.val = value;
      // NOTE: no need to change map value since map already point to this node's reference
      moveToHead(curr);
    }

    // Check if over capacity
    if (map.size() > cap) {
      CacheNode removedNode = popTail();
      map.remove(removedNode.key);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */