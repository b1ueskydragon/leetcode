package leetcode.p2287;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RearrangeCharactersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "baaalllloonbn, balloon, 1",
            "boo, balloon, 0",
            "baaallanoolloonbn, balloon, 2",
            "balloon, balloon, 1",
    })
    void testRearrangeCharacters(String s, String target, int minNumber) {
        assertThat(underTest.rearrangeCharacters(s, target)).isEqualTo(minNumber);
    }

}
