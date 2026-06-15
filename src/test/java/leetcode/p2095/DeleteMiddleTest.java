package leetcode.p2095;

import leetcode.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteMiddleTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testDeleteMiddle(ListNode head, ListNode deleteAfter) {
        assertThat(underTest.deleteMiddle(head)).isEqualTo(deleteAfter);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        ListNode.factory(1),
                        null
                ),
                Arguments.of(
                        ListNode.factory(1, 2),
                        ListNode.factory(1)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3),
                        ListNode.factory(1, 3)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3, 4),
                        ListNode.factory(1, 2, 4)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3, 4, 5),
                        ListNode.factory(1, 2, 4, 5)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3, 4, 5, 6),
                        ListNode.factory(1, 2, 3, 5, 6)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3, 4, 5, 6, 7),
                        ListNode.factory(1, 2, 3, 5, 6, 7)
                ),
                Arguments.of(
                        ListNode.factory(1, 2, 3, 4, 5, 6, 7, 8),
                        ListNode.factory(1, 2, 3, 4, 6, 7, 8)
                )
        );
    }

}
