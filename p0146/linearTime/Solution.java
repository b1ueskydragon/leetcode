package leetcode.p0146.linearTime;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

  final int capacity;
  // rightmost is the newest key which put or used
  final Deque<Integer> timeQueue;

  final Map<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.timeQueue = new LinkedList<>();

    this.cache = new HashMap<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    updateHistory(key);
    return cache.get(key);
  }

  public void put(int key, int value) {
    // evict
    if (cache.size() == capacity && !cache.containsKey(key)) {
      cache.remove(timeQueue.pollFirst());
    }
    updateHistory(key);
    cache.put(key, value);
  }

  private void updateHistory(int key) {
    // remove the using key from the history first
    int i = 0;
    int n = timeQueue.size();
    while (i < n) {
      int oldKey = timeQueue.pollFirst();
      if (oldKey != key) {
        timeQueue.addLast(oldKey);
      }
      i++;
    }

    // do this after the history check
    if (timeQueue.size() == capacity) {
      timeQueue.pollFirst();
    }
    timeQueue.addLast(key);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
