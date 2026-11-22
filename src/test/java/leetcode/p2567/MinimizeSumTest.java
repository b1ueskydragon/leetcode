package leetcode.p2567;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimizeSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimizeSum(int[] nums, int minScore) {
        assertThat(underTest.minimizeSum(nums)).isEqualTo(minScore);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                // When `nums` is sorted:
                // nums[n - 1] - nums[2]
                Arguments.of(new int[]{1, 4, 7, 8, 5}, 3),
                Arguments.of(new int[]{1, 4, 3}, 0),
                // nums[n - 3] - nums[0]
                Arguments.of(new int[]{1, 15, 25, 50, 100, 200}, 49),
                // nums[n - 2] - nums[1]
                Arguments.of(new int[]{
                        1840655, 4449133, 7425842, 19083352, 19526613, 127981493, 147477958,
                        151550922, 155661148, 209712009, 236401819, 238845322, 243289567, 254936614,
                        257253523, 282572553, 283858519, 284940529, 290787977, 294053866, 322387111,
                        322490099, 322757656, 331231757, 335235109, 336812781, 337302821, 790111328,
                        791828551, 800514596, 804502977, 823446863, 845510561, 852366101, 854095524,
                        866606592, 898758136, 953795478, 957180914, 958082786, 983192886, 989927048
                }, 956242131)
        );
    }

}
