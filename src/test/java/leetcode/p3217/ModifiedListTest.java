package leetcode.p3217;

import leetcode.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ModifiedListTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testModifiedList(int[] nums, ListNode head, ListNode modified) {
        assertThat(underTest.modifiedList(nums, head)).isEqualTo(modified);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, ListNode.factory(1, 2, 3, 4, 5), ListNode.factory(4, 5)),
                Arguments.of(new int[]{5}, ListNode.factory(1, 2, 3, 4), ListNode.factory(1, 2, 3, 4)),
                Arguments.of(new int[]{1}, ListNode.factory(1, 1, 1, 1, 2, 1, 1), ListNode.factory(2)),
                Arguments.of(new int[]{312, 514, 872, 995, 1204, 1567, 2093, 3057, 4500, 4999, 5781, 6352, 7234, 8345, 9999}, ListNode.factory(234, 312, 405, 514, 672, 872, 995, 1040, 1204, 1500, 1567, 2093, 2500, 3057, 4000, 4500, 4999, 5781, 6000, 6352, 7000, 7234, 8000, 8345, 9000, 9999), ListNode.factory(234, 405, 672, 1040, 1500, 2500, 4000, 6000, 7000, 8000, 9000))
        );
    }

}
