package leetcode.p0297;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final String nullStr = "n";
    final String delimiter = ",";

    final Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    final StringBuilder result = new StringBuilder();

    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr != null) {
        result.append(curr.val);
        result.append(delimiter);
        queue.add(curr.left);
        queue.add(curr.right);
      } else {
        result.append(nullStr);
        result.append(delimiter);
      }
    }
    return result.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final String nullStr = "n";
    final String delimiter = ",";
    final String[] parsedData = data.split(delimiter);
    if (parsedData[0].equals(nullStr)) return null;

    final TreeNode root = new TreeNode(Integer.parseInt(parsedData[0]));
    final Deque<TreeNode> searchQueue = new LinkedList<>();
    searchQueue.add(root);

    int i = 1;
    while (i < parsedData.length) {
      TreeNode curr = searchQueue.poll();
      if (curr == null) continue;

      String xLeft = parsedData[i];
      if (!xLeft.equals(nullStr)) {
        curr.left = new TreeNode(Integer.parseInt(xLeft));
      }
      i++;
      searchQueue.add(curr.left);

      String xRight = parsedData[i];
      if (!xRight.equals(nullStr)) {
        curr.right = new TreeNode(Integer.parseInt(xRight));
      }
      i++;
      searchQueue.add(curr.right);
    }

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
