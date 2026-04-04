package leetcode.p2075;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DecodeCiphertextTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "iveo    eed   l te   olc, 4, i love leetcode" ,
            "coding, 1, coding" ,
            "ch   ie   pr, 3, cipher" ,
            "'', 5, ''" ,
    })
    void testDecodeCiphertext(String encodedText, int rows, String decodedText) {
        assertThat(underTest.decodeCiphertext(encodedText, rows)).isEqualTo(decodedText);
    }

}
