package leetcode.p1807;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testEvaluate(String s, List<List<String>> knowledge, String replaced) {
        assertThat(underTest.evaluate(s, knowledge)).isEqualTo(replaced);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "(name)is(age)yearsold",
                        List.of(
                                List.of("name", "bob"),
                                List.of("age", "two")
                        ),
                        "bobistwoyearsold"
                ),
                Arguments.of(
                        "hi(name)",
                        List.of(
                                List.of("a", "b")
                        ),
                        "hi?"
                ),
                Arguments.of(
                        "(a)(a)(a)aaa",
                        List.of(
                                List.of("a", "yes")
                        ),
                        "yesyesyesaaa"
                )
        );
    }
}
