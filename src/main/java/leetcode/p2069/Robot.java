package leetcode.p2069;

class Robot {

    private int w;
    private int h;
    private int cycle;
    private int[][] map;
    private int currIndex;
    private String currDir;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.cycle = width + (height - 1) + (width - 1) + (height - 2);
        this.currIndex = 0;
        this.currDir = "East";

        // 4辺しか回らない. かつ, constraint w,h <= 100.
        // 2D cell を 1D のように numbering in advance.
        //
        //  e.g.,
        //  w=6, h=3,
        //  12 11 10  9  8  7
        //  13              6
        //   0  1  2  3  4  5
        this.map = new int[cycle][2];
        int index = 0;

        for (int i = 0; i < width; i++) {
            map[index][0] = i;
            map[index][1] = 0;
            index++;
        }
        for (int i = 1; i < height; i++) {
            map[index][0] = width - 1;
            map[index][1] = i;
            index++;
        }
        for (int i = width - 2; i >= 0; i--) {
            map[index][0] = i;
            map[index][1] = height - 1;
            index++;
        }
        for (int i = height - 2; i >= 1; i--) {
            map[index][0] = 0;
            map[index][1] = i;
            index++;
        }

        // for (int i = 0; i < map.length; i++) {
        //     System.out.printf("%s %s %n", i, Arrays.toString(map[i]));
        // }
    }

    public void step(int num) {
        int nextIndex = (currIndex + num) % cycle;

        if (nextIndex == 0) {
            // 1周して (0, 0) に戻って止まっている状態なので East にならない.
            // South のみ possible.
            // #step が呼ばれる前に呼ばれる #getDir は initial 値の East を返す.
            currDir = "South";
        } else if (nextIndex < w) {
            currDir = "East";
        } else if (nextIndex < w + h - 1) {
            currDir = "North";
        } else if (nextIndex < w + h - 1 + w - 1) {
            currDir = "West";
        } else {
            currDir = "South";
        }

        currIndex = nextIndex;

    }

    public int[] getPos() {
        return map[currIndex];
    }

    public String getDir() {
        return currDir;
    }
}
