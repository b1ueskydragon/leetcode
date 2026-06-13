package leetcode.p3838;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MapWordWeightsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMapWordWeights(String[] words, int[] weights, String expected) {
        assertThat(underTest.mapWordWeights(words, weights)).isEqualTo(expected);
    }


    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new String[]{"abcdefg", "hizklm", "aaa", "zzzzzzaa"},
                        new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},
                        "bxlf"
                )
        );
    }

}
