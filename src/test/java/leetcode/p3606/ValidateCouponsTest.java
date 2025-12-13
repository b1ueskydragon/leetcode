package leetcode.p3606;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateCouponsTest {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testValidateCoupons(String[] code, String[] businessLine, boolean[] isActive, List<String> expected) {
        assertThat(underTest.validateCoupons(code, businessLine, isActive)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"},
                        new String[]{"restaurant", "grocery", "pharmacy", "restaurant"},
                        new boolean[]{true, true, true, true},
                        List.of("PHARMA5", "SAVE20")
                ),
                Arguments.of(
                        new String[]{"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"},
                        new String[]{"grocery", "electronics", "invalid"},
                        new boolean[]{false, true, true},
                        List.of("ELECTRONICS_50")
                ));
    }

}
