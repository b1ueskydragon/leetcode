package leetcode.p1123.s2025;

import java.util.stream.Stream;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LcaDeepestLeavesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testLcaDeepestLeaves(TreeNode root, TreeNode lca) {
        assertThat(underTest.lcaDeepestLeaves(root)).isEqualTo(lca);
    }

    static Stream<Arguments> testLcaDeepestLeaves() {
        final var root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(2);

        final var root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        return Stream.of(
                // Only one deepest leaf -> The leaf itself is a LCA
                Arguments.of(root1, root1.left.right),
                // Multiple deepest leaves -> Their common ancestor is a LCA
                Arguments.of(root2, root2)
        );
    }
}
