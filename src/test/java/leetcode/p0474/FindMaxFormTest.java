package leetcode.p0474;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaxFormTest {

    private Solution v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(String[] strs, int m, int n, int expected) {
        assertThat(v1.findMaxForm(strs, m, n)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3, 4),
                Arguments.of(new String[]{"10", "0", "1"}, 1, 1, 2),
                Arguments.of(new String[]{"10001111", "111111110001", "10000011001", "111111111", "0000000000"}, 5, 3, 0),
                Arguments.of(new String[]{"0001", "0101", "1000", "1000"}, 9, 3, 3),
                Arguments.of(new String[]{"10", "0001", "111001", "1", "0"}, 4, 3, 3),
                Arguments.of(new String[]{"10", "1"}, 2, 2, 2),
                Arguments.of(new String[]{"100", "1111", "011"}, 1, 3, 1),
                Arguments.of(new String[]{"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101", "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111"}, 9, 80, 17)
        );
    }
}
