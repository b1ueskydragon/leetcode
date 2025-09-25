package leetcode.p0120;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumTotalTest {

    private Solution v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(List<List<Integer>> triangle, int expected) {
        assertThat(v1.minimumTotal(triangle)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(Arguments.of(List.of(List.of(2), List.of(3, 1), List.of(0, 5, 9)), 5));
    }
}
