package leetcode.p2594;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RepairCarsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testRepairCars(int[] ranks, int cars, long minT) {
        assertThat(underTest.repairCars(ranks, cars)).isEqualTo(minT);
    }

    static Stream<Arguments> testRepairCars() {
        return Stream.of(
                Arguments.of(new int[]{5, 1, 8}, 6, 16),
                Arguments.of(new int[]{100, 1, 100}, 3, 9)
        );
    }
}
