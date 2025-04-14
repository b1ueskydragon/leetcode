package leetcode.p1534;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountGoodTripletsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @Test
    void testCountGoodTriplets() {
        assertThat(underTest.countGoodTriplets(
                // max length
                new int[]{
                        504, 803, 828, 258, 55, 377, 666, 425, 187, 588,
                        444, 825, 386, 940, 217, 532, 436, 13, 844, 138,
                        670, 226, 102, 231, 540, 1000, 951, 645, 269, 478,
                        737, 121, 834, 483, 148, 147, 603, 55, 862, 751, 44,
                        97, 876, 330, 606, 740, 915, 775, 959, 905, 523, 867,
                        301, 223, 200, 156, 894, 75, 278, 547, 218, 778, 644,
                        177, 499, 494, 341, 84, 771, 175, 431, 549, 985, 580,
                        893, 462, 384, 871, 258, 708, 404, 327, 382, 439, 794,
                        905, 852, 872, 196, 16, 832, 549, 715, 357, 163, 746,
                        21, 189, 556, 613
                },
                700, 200, 300))
                .isEqualTo(29620);
    }
}
