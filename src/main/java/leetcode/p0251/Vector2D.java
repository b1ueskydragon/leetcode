package leetcode.p0251;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Vector2D implements Iterator<Integer> {

  private final List<List<Integer>> vec2d;
  private final List<Integer> rowPointers = new ArrayList<>();
  private final List<Integer> columnPointers = new ArrayList<>();

  private AtomicInteger rowCursor;
  private AtomicInteger columnCursor;
  private AtomicInteger current;

  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;

    this.rowCursor = new AtomicInteger(0);
    this.columnCursor = new AtomicInteger(0);
    this.current = new AtomicInteger(0);

    int r = 0;
    for (List<Integer> rows : this.vec2d) {
      int c = 0;
      for (Integer ignored : rows) {
        rowPointers.add(r);
        columnPointers.add(c);
        c++;
      }
      r++;
    }
  }

  @Override
  public Integer next() {
    if (current.get() >= columnPointers.size()) {
      throw new IndexOutOfBoundsException("End of the List");
    }
    current.incrementAndGet();
    return vec2d.get(rowPointers.get(rowCursor.getAndIncrement())).get(columnPointers.get(columnCursor.getAndIncrement()));
  }

  @Override
  public boolean hasNext() {
    return current.get() < columnPointers.size();
  }

}
