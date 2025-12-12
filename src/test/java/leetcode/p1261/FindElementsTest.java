package leetcode.p1261;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindElementsTest {
    // relatively balanced tree; 比較的バランスの取れた木
    @Test
    void testCase1() {
        final TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);

        final var instance = new FindElements(root);
        assertTrue(instance.find(1));
        assertTrue(instance.find(3));
        assertFalse(instance.find(5));

        assertEquals(0, root.val);
        assertEquals(1, root.left.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.left.left.val);
        assertEquals(4, root.left.right.val);
    }

    // right-skewed tree; 歪んだ木
    @Test
    void testCase2() {
        final TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(-1);
        root.right.left.left = new TreeNode(-1);

        final var instance = new FindElements(root);
        assertTrue(instance.find(2));
        assertFalse(instance.find(3));
        assertFalse(instance.find(4));
        assertTrue(instance.find(5));

        assertEquals(0, root.val);
        assertEquals(2, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(11, root.right.left.left.val);
    }
}
