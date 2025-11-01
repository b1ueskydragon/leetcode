package leetcode.p3217;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /// For test codes ... ///

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListNode otherNode = (ListNode) other;

        return this.val == otherNode.val &&
                // Check the next recursively
                Objects.equals(this.next, otherNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.val, this.next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListNode{");
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = this;
        while (cur != null) {
            if (!visited.add(cur)) {
                sb.append("...(cycle)");
                break;
            }
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        return sb.append('}').toString();
    }

    public static ListNode factory(int... vals) {
        if (vals.length == 0) {
            return null;
        }
        ListNode node = new ListNode();
        ListNode res = node;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return res.next;
    }

}
