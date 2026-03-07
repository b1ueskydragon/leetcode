package leetcode.p0146.p2026;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // key -> value cache.
    // get/put/remove can be performed in O(1) time.
    private Map<Integer, DoublyNode> cache;

    // Constraints:
    // 0 <= key <= 10^4
    // 0 <= value <= 10^5
    // Negative values as a sentinel.
    private static final int NONE = -1;
    private DoublyNode headSentinel = new DoublyNode(NONE, NONE);
    private DoublyNode lastSentinel = new DoublyNode(NONE, NONE);

    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity); // Just for memory saving.
        this.capacity = capacity;

        // To prevent NPE. We don't need to care any null cases from now.
        this.headSentinel.next = this.lastSentinel;
        this.lastSentinel.prev = this.headSentinel;
    }

    // O(1) time.
    // Once referred (used), we need to put it to the head.
    // Evict first, then set to head.
    public int get(int key) {
        final var node = cache.get(key);
        if (node == null) {
            return NONE;
        }
        // Referred.
        // Before set it to head, remove it from the current position, or it will remain unexpectedly.
        evictNode(node);
        setNodeToHead(node);
        return node.val;
    }

    // O(1) time.
    // Once updated (used), we need to put it to the head.
    // Evict first if needed, then set to head.
    public void put(int key, int value) {
        final var node = new DoublyNode(key, value);
        final var oldNode = cache.get(key);
        // Still, a key is replaceable during the capacity reached to its limit.
        // Check if the key already exists first, then check the capacity.
        if (oldNode != null) {
            evictNode(oldNode);
        }
        // No replaceable keys, and the size reached to the capacity.
        // Evict the least recently used.
        else if (cache.size() == capacity) {
            final var last = lastSentinel.prev;
            cache.remove(last.key);
            evictNode(last);
        }
        // Now everything is valid.
        // Keys are unique, capacity is enough.
        cache.put(key, node);
        setNodeToHead(node);
    }

    private void setNodeToHead(DoublyNode node) {
        // Head (sentinel) is fixed, add node next to the head.
        var prevHead = headSentinel.next;

        // Disconnect the prevHead from the headSentinel
        // and relink to an added node.
        prevHead.prev = node;
        node.next = prevHead;

        // Now new head is set.
        node.prev = headSentinel;
        headSentinel.next = node;
    }

    private void evictNode(DoublyNode node) {
        var prevNode = node.prev;
        var nextNode = node.next;

        // Disconnect the node from all directions.
        // Be aware to relink to adjacent nodes to skip only the target node.
        prevNode.next = node.next;
        nextNode.prev = node.prev;

        // Disconnect itself's connections.
        node.prev = null;
        node.next = null;

        // Now the node is not referred from anywhere.
    }

    // Wrap each K,V to the node.
    private static class DoublyNode {
        int key;
        int val;
        DoublyNode prev;
        DoublyNode next;

        DoublyNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
