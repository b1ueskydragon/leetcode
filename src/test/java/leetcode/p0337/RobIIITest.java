package leetcode.p0337;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RobIIITest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testRobIII(TreeNode root, int result) {
        assertThat(underTest.rob(root)).isEqualTo(result);
    }

    static Stream<Arguments> testRobIII() {
        final var root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.left.left = new TreeNode(2);
        root1.left.left.left = new TreeNode(3);

        final var root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(5);
        root2.left.right = new TreeNode(4);

        return Stream.of(
                Arguments.of(root1, 7),
                Arguments.of(root2, 9)
        );
    }
}
