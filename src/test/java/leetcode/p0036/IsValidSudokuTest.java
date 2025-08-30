package leetcode.p0036;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsValidSudokuTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testIsValidSudoku(char[][] board, boolean expected) {
        assertThat(underTest.isValidSudoku(board)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        }, true),
                Arguments.of(
                        new char[][]{
                                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
                        , false),
                Arguments.of(
                        new char[][]{
                                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
                        }, false)
        );
    }

}
