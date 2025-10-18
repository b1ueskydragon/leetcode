package leetcode.p3397;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistinctElementsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxDistinctElements(int[] nums, int k, int expected) {
        assertThat(underTest.maxDistinctElements(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 3, 4}, 2, 6),
                Arguments.of(new int[]{4, 4, 4, 4}, 1, 3),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5}, 3, 10),
                Arguments.of(new int[]{1, 10, 20}, 5, 3),
                Arguments.of(new int[]{287790084, 365888621, 492338064, 259802769, 555135600, 954661332, 629032658, 221498114, 620707865, 647343698, 678253107, 14626984, 555049872, 273106516, 371430680, 640251017, 597421919, 441805514, 756785386, 611305330, 747650429, 148131383, 716550699, 875488990, 315221807, 953358688, 406857379, 919141793, 496809159, 463433642, 849202654, 12914744, 809296795, 907158214, 277200809, 634003506, 204141696, 74967702, 790586081, 252842021, 566289633, 601886119, 600058268, 793377975, 334729576, 682136491, 504771207, 869340970, 909679698, 814446185, 554601798, 865621748, 967223848, 123142601, 636776977, 667436152, 270978349, 682278234, 815972910, 145835683, 284237287, 534749932, 617265799, 664749054, 552769786, 347449714, 540174523, 770150475, 570698533, 909818271, 601120646, 974378705, 481973117, 854300165, 102012641, 561367728, 588157640, 677788003, 714958728, 947242219, 123165872, 286984709, 35974834, 679640814, 531285887, 119117914, 560376989, 417170291, 296895087, 898183632, 882921551, 300882039, 139702285, 789398990, 506113998, 959357568, 571131246, 952865501, 424741497}, 1000000000, 99)
        );
    }

}
