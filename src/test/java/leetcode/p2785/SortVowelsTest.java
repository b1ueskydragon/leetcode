package leetcode.p2785;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SortVowelsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "lEetcOde, lEOtcede",
            "lYmpH, lYmpH",
            "EeO, EOe",
            "A, A",
            "a, a",
            "Z, Z",
            "z, z",
            "OEIoiOEAUEaiIAIAeaAiOIuuOUeUUoEAEEEuIIioeIEaEoEUiaUuIAuiaeaoIaeoiEOOOIIIaiaiOeooOuaaiaAOAIOOOiAaeiUA, AAAAAAAAAAEEEEEEEEEEEIIIIIIIIIIIIIOOOOOOOOOOOOOUUUUUUUaaaaaaaaaaaaaeeeeeeeiiiiiiiiiiiioooooooouuuuuu",
            "cSqMsXICUMAIEPyGCrekvsEGjeKbyInGHAuGEpRnsgqCCrrDZbLYpAkWQjZCgUmVqnhrqlhntsQKGoLyvDjJvOqkXUnXkIYAtNfs, cSqMsXACAMAAEPyGCrEkvsEGjIKbyInGHIIGOpRnsgqCCrrDZbLYpUkWQjZCgUmVqnhrqlhntsQKGULyvDjJveqkXenXkoYutNfs"
    })
    void testSortVowels(String s, String t) {
        assertThat(underTest.sortVowels(s)).isEqualTo(t);
    }
}
