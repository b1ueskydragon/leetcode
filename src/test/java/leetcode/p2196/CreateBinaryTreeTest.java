package leetcode.p2196;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateBinaryTreeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @Test
    void shouldBuildRightSkewedTree() {
        final int[][] descriptions =
                new int[][]{
                        {85, 74, 0},
                        {38, 82, 0},
                        {39, 70, 0},
                        {82, 85, 0},
                        {74, 13, 0},
                        {13, 39, 0}
                };
        final var root =
                new TreeNode(
                        38,
                        null,
                        new TreeNode(
                                82,
                                null,
                                new TreeNode(
                                        85,
                                        null,
                                        new TreeNode(
                                                74,
                                                null,
                                                new TreeNode(
                                                        13,
                                                        null,
                                                        new TreeNode(
                                                                39,
                                                                null,
                                                                new TreeNode(70)
                                                        )
                                                )
                                        )
                                )
                        )
                );
        assertThat(underTest.createBinaryTree(descriptions)).isEqualTo(root);
    }

}
