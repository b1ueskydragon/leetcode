package leetcode.p2874;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumTripletValueTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaximumTripletValue(int[] nums, long maxResult) {
        assertThat(underTest.maximumTripletValue(nums)).isEqualTo(maxResult);
    }

    static Stream<Arguments> testMaximumTripletValue() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 3, 4, 19}, 133),
                // Big integers which may lead to long type result
                Arguments.of(new int[]{13585, 44070, 77033, 16445, 33905, 89558,
                        27782, 40020, 98094, 99182, 96106, 23982}, 6127067232L)
        );
    }
}
