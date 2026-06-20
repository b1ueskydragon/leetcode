package leetcode.p3612;

/**
 * Doubly linked list version (StringBuilder is the standard approach).
 */
class Solution {
    public String processStr(String s) {
        boolean reversed = false;
        DNode head = null;
        DNode last = null;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                // duplicate
                if (head == null && last == null) {
                    // No target to duplicate.
                    continue;
                }
                DNode tmp = head;
                DNode dup = null;
                DNode dupHead = null;
                DNode dupLast = null;
                while (tmp != null) {
                    if (dup == null) {
                        dup = new DNode(tmp.val);
                        dupHead = dup;
                    } else {
                        dup.next = new DNode(tmp.val);
                        dup.next.prev = dup;
                        dup = dup.next;
                    }
                    if (tmp.next == null) {
                        dupLast = dup;
                    }
                    tmp = tmp.next;
                }
                if (!reversed) {
                    last.next = dupHead;
                    dupHead.prev = last;
                    last = dupLast;
                } else {
                    dupLast.next = head;
                    head.prev = dupLast;
                    head = dupHead;
                }
            } else if (c == '%') {
                reversed = !reversed;
            } else if (c == '*') {
                // remove the last
                if (!reversed) {
                    if (last == null) {
                        // No target to remove.
                        continue;
                    }
                    if (last.prev == null) {
                        // A single node.
                        // Remove both head and last to remove a broken pointer.
                        head = null;
                        last = null;
                        continue;
                    }
                    DNode newLast = last.prev;
                    newLast.next = null;
                    last.prev = null;
                    last = newLast;
                } else {
                    if (head == null) {
                        // No target to remove.
                        continue;
                    }
                    if (head.next == null) {
                        // A single node.
                        // Remove both head and last to remove a broken pointer.
                        head = null;
                        last = null;
                        continue;
                    }
                    DNode newHead = head.next;
                    newHead.prev = null;
                    head.next = null;
                    head = newHead;
                }
            } else {
                // append
                DNode newNode = new DNode(c);
                if (!reversed) {
                    if (last == null) {
                        head = newNode;
                        last = newNode;
                    } else {
                        last.next = newNode;
                        newNode.prev = last;
                        last = newNode;
                    }
                } else {
                    if (head == null) {
                        head = newNode;
                        last = newNode;
                    } else {
                        head.prev = newNode;
                        newNode.next = head;
                        head = newNode;
                    }
                }
            }
        }

        final var ans = new StringBuilder();
        if (!reversed) {
            while (head != null) {
                ans.append(head.val);
                head = head.next;
            }
        } else {
            while (last != null) {
                ans.append(last.val);
                last = last.prev;
            }
        }
        return ans.toString();
    }

    /**
     * Doubly linked list notes:
     * - Always update both prev and next links.
     * - When the list becomes empty, set both head and last to null.
     */
    private static class DNode {
        char val;
        DNode prev;
        DNode next;

        DNode(char val) {
            this.val = val;
        }
    }

}
