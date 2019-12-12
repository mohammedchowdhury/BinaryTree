import java.util.ArrayList;

interface TreeNode {
  public ArrayList<? extends TreeNode> getChildren();
  public TreeNode getParent();
  public String toString();
}