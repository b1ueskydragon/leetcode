package leetcode.p0844.multi_cursors;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sc = s.length() - 1;
        int tc = t.length() - 1;

        int sdel = 0;
        int tdel = 0;

        while (sc >= 0 || tc >= 0) {
            while (sc >= 0 && s.charAt(sc) == '#') {
                sdel++;
                sc--;
            }
            while (tc >= 0 && t.charAt(tc) == '#') {
                tdel++;
                tc--;
            }

            while (sc >= 0 && sdel > 0) {
                if (s.charAt(sc) == '#') sdel++;
                else sdel--;
                sc--;
            }
            while (tc >= 0 && tdel > 0) {
                if (t.charAt(tc) == '#') tdel++;
                else tdel--;
                tc--;
            }

            // それぞれのカーソルは、それぞれ右から一番最新の'#'を全て消した位置に止まっている
            // 文字の左先にまだ'#'が残っている可能性はある
            final char scurr = (sc >= 0) ? s.charAt(sc) : '\u0000';
            final char tcurr = (tc >= 0) ? t.charAt(tc) : '\u0000';

            // この除去は次のループに任せる
            if (scurr == '#' || tcurr == '#') {
                continue;
            }

            // early return
            if (scurr != tcurr) {
                return false;
            }

            // continue anyway
            sc--;
            tc--;
        }

        return true;
    }
}
