package leetcode.p1200;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumAbsDifferenceTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] arr, List<List<Integer>> expected) {
        assertThat(v2.minimumAbsDifference(arr)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] arr, List<List<Integer>> expected) {
        assertThat(v1.minimumAbsDifference(arr)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 8, -10, 23, 19, -4, -14, 27}, List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27)))
        );
    }

}
