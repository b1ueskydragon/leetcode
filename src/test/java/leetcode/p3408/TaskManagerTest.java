package leetcode.p3408;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskManagerTest {

    @Test
    void testCase1() {
        final var tasks = List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15));
        final var underTest = new TaskManager(tasks);

        underTest.add(4, 104, 5);
        underTest.edit(102, 8);
        assertThat(underTest.execTop()).isEqualTo(3);
        underTest.rmv(101);
        underTest.add(5, 105, 15);
        assertThat(underTest.execTop()).isEqualTo(5);
    }

    @Test
    void testCase2() {
        final var tasks = List.of(List.of(1, 101, 15), List.of(2, 102, 10));
        final var underTest = new TaskManager(tasks);

        underTest.edit(101, 15);
        assertThat(underTest.execTop()).isEqualTo(1);
        assertThat(underTest.execTop()).isEqualTo(2);
    }

    @Test
    void testCase3() {
        final var tasks = List.of(List.of(1, 101, 30));
        final var underTest = new TaskManager(tasks);

        underTest.rmv(101);
        underTest.add(1, 101, 30);
        assertThat(underTest.execTop()).isEqualTo(1);
        assertThat(underTest.execTop()).isEqualTo(-1);
    }

    @Test
    void testCase4() {
        final var tasks = List.of(List.of(10, 4, 10), List.of(10, 0, 6), List.of(5, 23, 50), List.of(3, 29, 50), List.of(2, 15, 9));
        final var underTest = new TaskManager(tasks);

        assertThat(underTest.execTop()).isEqualTo(3);
    }


}
