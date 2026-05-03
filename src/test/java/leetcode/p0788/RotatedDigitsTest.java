package leetcode.p0788;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotatedDigitsTest {

    @Test
    void testRotatedDigits() {
        assertThat(new Solution().rotatedDigits(10000)).isEqualTo(2320);
    }

}
