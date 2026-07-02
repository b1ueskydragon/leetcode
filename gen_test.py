#!/usr/bin/env python3
import sys
from pathlib import Path

template = """\
package leetcode.{package};

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

# e.g.
# python3 gen_test.py p9999 Foo
def main():
    if len(sys.argv) != 3:
        print(
            "Usage: python3 gen_test.py <package> <ClassName>",
            file=sys.stderr,
        )
        sys.exit(1)

    package = sys.argv[1]
    name = sys.argv[2]

    output_dir = Path("src/test/java/leetcode") / package
    output_dir.mkdir(parents=True, exist_ok=True)

    output_file = output_dir / f"{name}Test.java"

    if output_file.exists():
        print(f"Error: {output_file} already exists.", file=sys.stderr)
        sys.exit(1)

    output_file.write_text(
        template.format(package=package, name=name),
        encoding="utf-8",
    )

    print(f"Generated: {output_file}")


if __name__ == "__main__":
    main()
