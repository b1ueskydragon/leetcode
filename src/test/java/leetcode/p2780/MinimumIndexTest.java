package leetcode.p2780;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumIndexTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinimumIndex(List<Integer> nums, int minSplitPoint) {
        assertThat(underTest.minimumIndex(nums)).isEqualTo(minSplitPoint);
    }

    static Stream<Arguments> testMinimumIndex() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 2, 2), 2),
                Arguments.of(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1), 4),
                Arguments.of(List.of(1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 2), 0),
                Arguments.of(List.of(3, 3, 3, 3, 7, 2, 2), -1)
        );
    }
}
