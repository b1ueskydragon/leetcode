package leetcode.p3551;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinSwapsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinSwaps(int[] nums, int swaps) {
        assertThat(underTest.minSwaps(nums)).isEqualTo(swaps);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{52, 43, 25, 34, 7},
                        3
                ),
                Arguments.of(
                        new int[]{40, 10, 20, 30},
                        3
                ),
                Arguments.of(
                        new int[]{357140560, 275632665, 649358313, 717319406},
                        2
                ),
                Arguments.of(
                        new int[]{480243744},
                        0
                ),
                Arguments.of(
                        new int[]{
                                190148864, 649873037, 202362130, 319833878,
                                277383831, 453042975, 672340774, 363793319,
                                784749222, 396121131, 831484975, 140831024,
                                686867891, 109059125, 292382136, 593605313,
                                991462338, 645251139, 71133132, 880591309,
                                258779470, 847727069, 598086881, 935509474,
                                138411874, 883164770, 741761637, 162594021,
                                665090285, 971413874, 739642998, 759352439,
                                18893050, 950703998
                        },
                        29
                ),
                Arguments.of(
                        new int[]{18, 43, 34, 16},
                        2
                )
        );
    }

}
