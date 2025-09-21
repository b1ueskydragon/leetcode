package leetcode.p3508;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RouterTest {

    @Test
    void testCase1() {
        final var underTest = new Router(3);
        assertThat(underTest.addPacket(1, 4, 90)).isTrue();
        assertThat(underTest.addPacket(2, 5, 90)).isTrue();
        assertThat(underTest.addPacket(1, 4, 90)).isFalse();
        assertThat(underTest.addPacket(3, 5, 95)).isTrue();
        assertThat(underTest.addPacket(4, 5, 105)).isTrue();
        assertThat(underTest.forwardPacket()).isEqualTo(new int[]{2, 5, 90});
        assertThat(underTest.addPacket(5, 2, 110)).isTrue();
        assertThat(underTest.getCount(5, 100, 110)).isEqualTo(1);
    }

    @Test
    void testCase2() {
        final var underTest = new Router(2);
        assertThat(underTest.addPacket(7, 4, 90)).isTrue();
        assertThat(underTest.forwardPacket()).isEqualTo(new int[]{7, 4, 90});
        assertThat(underTest.forwardPacket()).isEqualTo(new int[]{});

    }

}
