package leetcode.p0401;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReadBinaryWatchTest {

    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int turnedOn, List<String> expected) {
        assertThat(v1.readBinaryWatch(turnedOn)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(2, List.of("0:03", "0:05", "0:09", "0:17", "0:33", "0:06", "0:10", "0:18", "0:34", "0:12", "0:20", "0:36", "0:24", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "3:00", "5:00", "9:00", "6:00", "10:00")),
                Arguments.of(8, List.of("7:31", "7:47", "7:55", "7:59", "11:31", "11:47", "11:55", "11:59")),
                Arguments.of(9, List.of())
        );
    }

}
