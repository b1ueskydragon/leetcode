package leetcode.p0146.s2021.s202307;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    private static class DoublyNode {
        int key;
        int value;
        DoublyNode prev;
        DoublyNode next;

        DoublyNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, DoublyNode> cache;
    private final DoublyNode head;
    private final DoublyNode last;
    private final int cap;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;

        // sentinels
        // to allow to make an initial doubly-connection
        head = new DoublyNode(-1, -1);
        last = new DoublyNode(-1, -1);
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        return Optional.ofNullable(cache.get(key))
                       .map(node -> {
                           pop(node);
                           linkToHead(node);
                           return node.value;
                       })
                       .orElse(-1);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            pop(cache.get(key));
        }
        if (cache.size() == cap) {
            pop(last.prev); // the pure last is a sentinel
        }
        linkToHead(new DoublyNode(key, value));
    }

    private void linkToHead(DoublyNode node) {
        cache.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head; // the pure head is a sentinel
    }

    private void pop(DoublyNode node) {
        cache.remove(node.key);
        //if (node.prev != null) {
        node.prev.next = node.next;
        //}
        //if (node.next != null) {
        node.next.prev = node.prev;
        //}
    }
}
