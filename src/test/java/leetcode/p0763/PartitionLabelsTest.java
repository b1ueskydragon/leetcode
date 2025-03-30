package leetcode.p0763;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionLabelsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testPartitionLabels(String s, List<Integer> sizes) {
        assertThat(underTest.partitionLabels(s)).isEqualTo(sizes);
    }

    static Stream<Arguments> testPartitionLabels() {
        return Stream.of(
                Arguments.of("aaababdcddc", List.of(6, 5)),
                Arguments.of("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                // since `e` and `c` are positioned at last, we can't split it more than one
                Arguments.of("eccbbbbdec", List.of(10)),
                Arguments.of("x", List.of(1)),
                Arguments.of("ssssssssssss", List.of(12))
        );
    }
}
