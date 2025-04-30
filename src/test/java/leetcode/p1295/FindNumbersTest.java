package leetcode.p1295;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindNumbersTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    // Both v1 and v2 never modify the given array `nums`
    @ParameterizedTest
    @MethodSource
    void testFindNumbers(int[] nums, int count) {
        assertThat(v1.findNumbers(nums)).isEqualTo(count);
        assertThat(v2.findNumbers(nums)).isEqualTo(count);
    }

    static Stream<Arguments> testFindNumbers() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 100, 1000, 10000, 100000}, 3, 3)
        );
    }

}
