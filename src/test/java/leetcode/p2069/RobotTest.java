package leetcode.p2069;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RobotTest {

    @Test
    void testBasic() {
        // ["Robot","step","step","getPos","getDir","step","step","step","getPos","getDir"]
        // [[6,3],[2],[2],[],[],[2],[1],[4],[],[]]
        Robot obj = new Robot(6, 3);
        obj.step(2);
        obj.step(2);
        assertThat(obj.getPos()).isEqualTo(new int[]{4, 0});
        assertThat(obj.getDir()).isEqualTo("East");
        obj.step(2);
        obj.step(1);
        obj.step(4);
        assertThat(obj.getPos()).isEqualTo(new int[]{1, 2});
        assertThat(obj.getDir()).isEqualTo("West");
    }

    @Test
    void testRobotReturnsToZeroPoint() {
        Robot obj = new Robot(3, 4);
        obj.step(5);
        assertThat(obj.getPos()).isEqualTo(new int[]{2, 3});
        obj.step(10);
        assertThat(obj.getDir()).isEqualTo("North");
        obj.step(15);
        assertThat(obj.getPos()).isEqualTo(new int[]{0, 0}); // Robot returns to zero.
        assertThat(obj.getDir()).isEqualTo("South"); // Not the East.
        obj.step(20);
        assertThat(obj.getPos()).isEqualTo(new int[]{0, 0}); // Robot returns to zero again.
        assertThat(obj.getDir()).isEqualTo("South"); // Not the East.
    }

    @Test
    void testGetAllDirections() {
        Robot obj = new Robot(16, 30);
        obj.step(13);
        assertThat(obj.getPos()).isEqualTo(new int[]{13, 0});
        assertThat(obj.getDir()).isEqualTo("East");
        obj.step(25130);
        assertThat(obj.getPos()).isEqualTo(new int[]{0, 25});
        assertThat(obj.getDir()).isEqualTo("South");
        obj.step(73421);
        assertThat(obj.getPos()).isEqualTo(new int[]{4, 0});
        assertThat(obj.getDir()).isEqualTo("East");
        obj.step(31647);
        assertThat(obj.getPos()).isEqualTo(new int[]{0, 29});
        assertThat(obj.getDir()).isEqualTo("West");
        obj.step(14851);
        assertThat(obj.getPos()).isEqualTo(new int[]{15, 23});
        assertThat(obj.getDir()).isEqualTo("North");
    }

}
