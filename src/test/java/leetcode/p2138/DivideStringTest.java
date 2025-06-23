package leetcode.p2138;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DivideStringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testDivideString(String s, int k, char fill, String[] expected) {
        assertThat(underTest.divideString(s, k, fill)).isEqualTo(expected);
    }

    static Stream<Arguments> testDivideString() {
        return Stream.of(
                Arguments.of("abcde", 1, 'x', new String[]{"a", "b", "c", "d", "e"}),
                Arguments.of("joeatjeagrwhxbfhgkhebiczutmpgboinsnfxyeipndskmfqesuxlhvkgzxepjxmsuibrxjvaswslckrniqst", 19, 'x', new String[]{"joeatjeagrwhxbfhgkh", "ebiczutmpgboinsnfxy", "eipndskmfqesuxlhvkg", "zxepjxmsuibrxjvasws", "lckrniqstxxxxxxxxxx"}),
                Arguments.of("joeatjeagrwhxbfhgkhebiczutmpgboinsnfxyeipndskmfqesuxlhvkgzxepjxmsuibrxjvaswslckrniqstxxxxxxxxxxxxxxx", 100, 'x', new String[]{"joeatjeagrwhxbfhgkhebiczutmpgboinsnfxyeipndskmfqesuxlhvkgzxepjxmsuibrxjvaswslckrniqstxxxxxxxxxxxxxxx"})
        );
    }

}
