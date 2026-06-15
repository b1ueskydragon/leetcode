package leetcode.p2130;

import leetcode.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class PairSumTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(ListNode head, int maxSumPair) {
        assertThat(v1.pairSum(head)).isEqualTo(maxSumPair);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(ListNode head, int maxSumPair) {
        assertThat(v2.pairSum(head)).isEqualTo(maxSumPair);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        ListNode.factory(9, 1, 100000, 2, 100000, 100000, 999, 100000, 9999, 100000, 99, 9999, 9, 100000),
                        200000
                ),
                Arguments.of(
                        ListNode.factory(4, 2, 2, 3),
                        7
                ),
                Arguments.of(
                        ListNode.factory(100000, 100000),
                        200000
                )
        );
    }

}
