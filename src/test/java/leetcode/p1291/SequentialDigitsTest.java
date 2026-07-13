package leetcode.p1291;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialDigitsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSequentialDigits(int low, int high, List<Integer> sortedList) {
        assertThat(underTest.sequentialDigits(low, high)).isEqualTo(sortedList);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        10,
                        1_000_000_000,
                        List.of(
                                12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789,
                                1234, 2345, 3456, 4567, 5678, 6789,
                                12345, 23456, 34567, 45678, 56789,
                                123456, 234567, 345678, 456789,
                                1234567, 2345678, 3456789,
                                12345678, 23456789,
                                123456789
                        )
                ),
                Arguments.of(100, 300, List.of(123, 234)),
                Arguments.of(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
        );
    }

}
