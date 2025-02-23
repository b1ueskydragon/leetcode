package leetcode.p0145;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PostorderTraversalTest {
    private Solution underTest;
    private SolutionV2 underTestV2;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
        underTestV2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource
    void testPostorderTraversal(TreeNode root, List<Integer> postorder) {
        assertThat(underTest.postorderTraversal(root)).isEqualTo(postorder);
        assertThat(underTestV2.postorderTraversal(root)).isEqualTo(postorder);
    }

    static Stream<Arguments> testPostorderTraversal() {
        // [1,2,3,4,5,6,7,null,null,null,null,null,null,8]
        TreeNode given = new TreeNode(1);
        given.left = new TreeNode(2);
        given.right = new TreeNode(3);
        given.left.left = new TreeNode(4);
        given.left.right = new TreeNode(5);
        given.right.left = new TreeNode(6);
        given.right.right = new TreeNode(7);
        given.right.right.left = new TreeNode(8);

        return Stream.of(Arguments.of(given, List.of(4, 5, 2, 6, 8, 7, 3, 1)));
    }
}
