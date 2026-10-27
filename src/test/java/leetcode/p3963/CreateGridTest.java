package leetcode.p3963;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CreateGridTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCreateGrid(int m, int n, String[] anyValidPattern) {
        assertThat(underTest.createGrid(m, n)).isEqualTo(anyValidPattern);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        3,
                        5,
                        new String[]{
                                ".....",
                                "####.",
                                "####."
                        }
                ),
                Arguments.of(
                        1,
                        4,
                        new String[]{
                                "...."
                        }
                )
        );
    }

}
