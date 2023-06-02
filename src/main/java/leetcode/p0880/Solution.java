package leetcode.p0880;

class Solution {
  public String decodeAtIndex(String S, int K) {
    long totalSize = 0; // decoded string has less than 2^63 letters
    int encodedSize = S.length();
    for (int i = 0; i < encodedSize; i++) {
      char c = S.charAt(i);
      if (Character.isDigit(c)) {
        int times = Character.getNumericValue(c);
        totalSize *= times;
        continue;
      }
      totalSize++;
    }

    // backwards
    for (int i = encodedSize - 1; i >= 0; i--) {
      char c = S.charAt(i);
      K %= totalSize; // K th also be changed during totalSize changes

      // shorten totalSize until last element would be a target

      if (K == 0 && Character.isLetter(c)) {
        return String.valueOf(c);
      }

      if (Character.isDigit(c)) {
        int times = Character.getNumericValue(c);
        totalSize /= times;
      } else {
        totalSize--; // one-time pattern's char
      }
    }
    return "";
  }
}
