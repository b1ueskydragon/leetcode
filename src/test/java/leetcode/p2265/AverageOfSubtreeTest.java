package leetcode.p2265;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AverageOfSubtreeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testAverageOfSubtree(TreeNode root, int matchedCount) {
        assertThat(underTest.averageOfSubtree(root)).isEqualTo(matchedCount);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                // [4,8,5,0,1,null,6]
                Arguments.of(
                        new TreeNode(
                                4,
                                new TreeNode(
                                        8,
                                        new TreeNode(0),
                                        new TreeNode(1)
                                ),
                                new TreeNode(
                                        5,
                                        null,
                                        new TreeNode(6)
                                )
                        ),
                        5 // Five nodes 0, 1, 6, 5, 4 except the node 8.
                ),
                // [1]
                Arguments.of(
                        new TreeNode(1),
                        1 // A leaf itself.
                ),
                // [4,8,null,5,null,1,null,0,null,6]
                Arguments.of(
                        new TreeNode(
                                4,
                                new TreeNode(
                                        8,
                                        new TreeNode(
                                                5,
                                                new TreeNode(
                                                        1,
                                                        new TreeNode(
                                                                0,
                                                                new TreeNode(6),
                                                                null
                                                        ),
                                                        null
                                                ),
                                                null
                                        ),
                                        null
                                ),
                                null
                        ),
                        2
                ),
                // [4,null,8,null,6,null,0,null,1,null,6]
                Arguments.of(
                        new TreeNode(
                                4,
                                null,
                                new TreeNode(
                                        8,
                                        null,
                                        new TreeNode(
                                                6,
                                                null,
                                                new TreeNode(
                                                        0,
                                                        null,
                                                        new TreeNode(
                                                                1,
                                                                null,
                                                                new TreeNode(6)
                                                        )
                                                )
                                        )
                                )
                        ),
                        2
                ),
                // [0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0]
                Arguments.of(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        0,
                                        new TreeNode(
                                                0,
                                                new TreeNode(
                                                        0,
                                                        new TreeNode(0),
                                                        null
                                                ),
                                                new TreeNode(0)
                                        ),
                                        new TreeNode(
                                                0,
                                                new TreeNode(0),
                                                new TreeNode(0)
                                        )
                                ),
                                new TreeNode(
                                        0,
                                        new TreeNode(
                                                0,
                                                new TreeNode(0),
                                                new TreeNode(0)
                                        ),
                                        new TreeNode(
                                                0,
                                                new TreeNode(0),
                                                null
                                        )
                                )
                        ),
                        15
                )
        );
    }

}
