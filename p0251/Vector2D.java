package leetcode.p0251;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

  private final List<List<Integer>> vec2d;
  private final List<Integer> rowPointers = new ArrayList<>();
  private final List<Integer> columnPointers = new ArrayList<>();

  // TODO: AtomicInteger?
  private int rowCursor;
  private int columnCursor;
  private int current;

  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;

    this.rowCursor = 0;
    this.columnCursor = 0;
    this.current = 0;

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
//    System.out.println(rowPointers);
//    System.out.println(columnPointers);
  }

  @Override
  public Integer next() {
    current++;
//    System.out.printf("%d, (%d, %d)  \n", current, rowPointers.get(rowCursor), columnPointers.get(columnCursor));
    return vec2d.get(rowPointers.get(rowCursor++)).get(columnPointers.get(columnCursor++));
  }

  @Override
  public boolean hasNext() {
    return current < columnPointers.size();
  }

  @Override
  public void remove() {
    // if enabled "remove", given 2D should be mutable as like
    //
    //    final List<List<Integer>> vec2d = new ArrayList<>() {{
    //      add(new ArrayList<>() {{
    //        add(1);
    //        add(2);
    //      }});
    //      add(new ArrayList<>() {{
    //        add(3);
    //      }});
    //      add(new ArrayList<>() {{
    //        add(4);
    //        add(5);
    //        add(6);
    //      }});
    //    }};
  }

}
