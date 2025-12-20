package leetcode.p0944;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinDeletionSizeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinDeletionSize(String[] strs, int expected) {
        assertThat(underTest.minDeletionSize(strs)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new String[]{"abcafswwetwz", "zbcafswwetwz", "abcafswwetwz", "abcafswwetwz"}, 1),
                Arguments.of(new String[]{"zyx", "wvu", "tsr"}, 3),
                Arguments.of(new String[]{"cba", "daf", "ghi"}, 1)
        );
    }

}
