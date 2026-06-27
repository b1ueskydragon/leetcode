#!/usr/bin/env python3
import sys

template = """\
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class {name}Test {{

    private Solution underTest;

    @BeforeEach
    void setUp() {{
        underTest = new Solution();
    }}

    @ParameterizedTest
    @MethodSource("testSource")
    void test{name}() {{

    }}

    static Stream<Arguments> testSource() {{
        return Stream.of();
    }}

}}
"""

# e.g.,
# python3 gen_test.py Foo > FooTest.java
def main():
    if len(sys.argv) != 2:
        print("Usage: python3 gen_test.py <ClassName>", file=sys.stderr)
        sys.exit(1)

    name = sys.argv[1]
    print(template.format(name=name))

if __name__ == "__main__":
    main()
