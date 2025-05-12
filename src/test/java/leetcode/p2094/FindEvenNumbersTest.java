package leetcode.p2094;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindEvenNumbersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testFindEvenNumbers(int[] digits, int[] results) {
        assertThat(underTest.findEvenNumbers(digits)).isEqualTo(results);
    }

    static Stream<Arguments> testFindEvenNumbers() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 0}, new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320}),
                Arguments.of(new int[]{2, 2, 8, 8, 2}, new int[]{222, 228, 282, 288, 822, 828, 882}),
                Arguments.of(new int[]{3, 7, 5}, new int[]{}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{132, 312})
        );
    }

}
