package leetcode.p0146.s2021.constantTime;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
  private final int capacity;
  private final Map<Integer, Node> cache;

  // sentinels
  private final Node head;
  private final Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    // cache knows the node
    Node node = cache.get(key);
    // remove existing node before insert to the head
    remove(node);
    insert(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    if (cache.size() == capacity) {
      remove(tail.prev);
    }
    insert(new Node(key, value));
  }

  // unlink the node
  private void remove(Node node) {
    cache.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  // insert to the head (next to the sentinel head)
  private void insert(Node node) {
    cache.put(node.key, node);
    Node tmp = head.next; // head.next includes sentinel tail
    head.next = node;
    node.next = tmp;
    tmp.prev = node;
    node.prev = head;
  }


  // Double pointer
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
