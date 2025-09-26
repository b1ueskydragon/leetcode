package leetcode.p0120;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumTotalTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(List<List<Integer>> triangle, int expected) {
        assertThat(v2.minimumTotal(triangle)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(List<List<Integer>> triangle, int expected) {
        assertThat(v1.minimumTotal(triangle)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(List.of(2), List.of(3, 1), List.of(0, 5, 9)), 5),
                Arguments.of(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)), 11)
        );
    }
}
