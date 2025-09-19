package leetcode.p3484;

class Spreadsheet {

    private final int[][] sheet;

    // 1-indexed row
    // e.g., rows=3
    //     A B C ... X Y Z
    //  1  0 0 0 ... 0 0 0
    //  2  0 0 0 ... 0 0 0
    //  3  0 0 0 ... 0 0 0
    public Spreadsheet(int rows) {
        sheet = new int[26][rows + 1];
    }

    public void setCell(String cell, int value) {
        final int[] pos = cellToPos(cell);
        sheet[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    // - A format of the formula should be: e.g., =A1+B2 or =A1+6 or =10+B2
    // - Operators only contain +, =
    // - The sum won't exceed Integer.MAX_VALUE
    public int getValue(String formula) {
        // We can ignore '='
        final String[] values = formula.substring(1).split("\\+");
        int sum = 0;
        for (String value : values) {
            final int v;
            final char prefix = value.charAt(0);
            if ('A' <= prefix && prefix <= 'Z') {
                final int[] pos = cellToPos(value);
                v = sheet[pos[0]][pos[1]];
            } else {
                v = Integer.parseInt(value);
            }
            sum += v;
        }
        return sum;
    }

    private static int[] cellToPos(String cell) {
        // A cell consists of single upper case character + Number
        final int column = cell.charAt(0) - 'A';
        // Use #parseInt instead of #valueOf to avoid unboxing
        final int row = Integer.parseInt(cell.substring(1));
        return new int[]{column, row};
    }

}
