package leetcode.p3484;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpreadsheetTest {

    @Test
    void testCase1() {
        final var underTest = new Spreadsheet(3);
        assertThat(underTest.getValue("=5+7")).isEqualTo(12);
        underTest.setCell("A1", 10);
        assertThat(underTest.getValue("=A1+6")).isEqualTo(16);
        underTest.setCell("B2", 15);
        assertThat(underTest.getValue("=A1+B2")).isEqualTo(25);
        underTest.resetCell("A1");
        assertThat(underTest.getValue("=A1+B2")).isEqualTo(15);
    }

    @Test
    void testCase2() {
        final var underTest = new Spreadsheet(458);
        assertThat(underTest.getValue("=O126+10272")).isEqualTo(10272);
        assertThat(underTest.getValue("=0126+10272")).isEqualTo(10398);
    }

    @Test
    void testCase3() {
        final var underTest = new Spreadsheet(24);
        underTest.setCell("B24", 66688);
        underTest.resetCell("O15");
    }

}
