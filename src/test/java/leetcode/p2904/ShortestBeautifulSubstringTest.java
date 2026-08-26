package leetcode.p2904;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestBeautifulSubstringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testShortestBeautifulSubstring(String s, int k, String sbs) {
        assertThat(underTest.shortestBeautifulSubstring(s, k)).isEqualTo(sbs);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "100011001",
                        3,
                        "11001"
                ),
                Arguments.of(
                        "1011",
                        2,
                        "11"
                ),
                Arguments.of(
                        "000",
                        1,
                        ""
                ),
                Arguments.of(
                        "011001111011000110011",
                        6,
                        "1111011"
                ),
                Arguments.of(
                        "011001111011000110011",
                        4,
                        "1111"
                ),
                Arguments.of(
                        "1001110001011101010111001110000110011011101010101011001110000110011011101010101110011100001100110101",
                        14,
                        "110111010101011100111"
                ),
                Arguments.of(
                        "0001110001011101010111001110000110011011101010101011001110000110011011101010101110011100001100110101",
                        9,
                        "1011101010111"
                ),
                Arguments.of(
                        "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                        99,
                        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                ),
                Arguments.of(
                        "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                        98,
                        "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                ),
                Arguments.of(
                        "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                        1,
                        "1"
                ),
                Arguments.of(
                        "1100111000101110101011100111000011001101110101010101100111000011001101110101010111001110000111111101",
                        11,
                        "1101110101010111"
                )
        );
    }

}
