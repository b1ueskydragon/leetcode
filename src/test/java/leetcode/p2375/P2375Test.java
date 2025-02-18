package leetcode.p2375;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class P2375Test {

  private Solution underTest;

  @BeforeEach
  void setUp() {
    underTest = new Solution();
  }

  @ParameterizedTest
  @MethodSource
  void testCountBackwardD(String pattern, int[] expected) {
    assertThat(underTest.countBackwardD(pattern)).isEqualTo(expected);
  }

  static Stream<Arguments> testCountBackwardD() {
    return Stream.of(
        Arguments.of("IIIDIDDD", new int[]{0, 0, 0, 1, 0, 3, 0, 0, 0}),
        Arguments.of("DDD", new int[]{3, 0, 0, 0}),
        Arguments.of("DID", new int[]{1, 0, 1, 0}),
        Arguments.of("DIIIDIDD", new int[]{1, 0, 0, 0, 1, 0, 2, 0, 0}),
        Arguments.of("IIIIIIII", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}),
        Arguments.of("DDDDDDDD", new int[]{8, 0, 0, 0, 0, 0, 0, 0, 0}),
        Arguments.of("IDDIDIDI", new int[]{0, 2, 0, 0, 1, 0, 1, 0, 0}),
        Arguments.of("I", new int[]{0, 0}),
        Arguments.of("D", new int[]{1, 0})
    );
  }

  @ParameterizedTest
  @CsvSource({
      "IIIDIDDD, 123549876",
      "DDD, 4321",
      "DID, 2143",
      "DIIIDIDD, 213465987",
      "IIIIIIII, 123456789",
      "DDDDDDDD, 987654321",
      "IDDIDIDI, 143265879",
      "I, 12",
      "D, 21"
  })
  void testSmallestNumber(String pattern, String expected) {
    assertThat(underTest.smallestNumber(pattern)).isEqualTo(expected);
  }
}
