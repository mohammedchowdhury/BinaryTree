import java.util.ArrayList;

class Tree {
  private TreeNode root;
  public int size;

  public Tree() {
    setRoot(null);
    size = 0;
  }

  public TreeNode root() {
    return root;
  }

  public TreeNode parent(TreeNode node) {
    return node.getParent();
  }

  public boolean isRoot(TreeNode node) {
    return node == root();
  }

  public boolean isInternal(TreeNode node) {
    return node.getChildren().size() > 0;
  }

  public boolean isLeaf(TreeNode node) {
    return !isInternal(node);
  }

  public int size() {
    return size;
  }

  public boolean empty() {
    return size == 0;
  }

  public int depth(TreeNode node) {
    if (isRoot(node))
      return 0;
    return 1 + depth(node.getParent());
  }

  public int height(TreeNode node) {
    if (isLeaf(node))
      return 0;
    int maxChildHeight = 0;
    ArrayList<? extends TreeNode> c = node.getChildren();
    for (TreeNode t:c) {
      int hc = height(t);
      if (hc > maxChildHeight)
        maxChildHeight = hc;
    }
    return maxChildHeight + 1;
  }

  public int height() {
    if (root() == null)
      return -1;
    return height(root());
  }

  public ArrayList<TreeNode> preOrder() {
    ArrayList<TreeNode> answer = new ArrayList<>();
    preOrder(root(), answer);
    return answer;
  }

  public void preOrder(TreeNode node, ArrayList<TreeNode> nodeOrder) {
    if (node == null) return;
    nodeOrder.add(node);
    for (TreeNode n:node.getChildren()) {
      preOrder(n, nodeOrder);
    }
  }

  public ArrayList<TreeNode> postOrder() {
    ArrayList<TreeNode> answer = new ArrayList<TreeNode>();
    postOrder(root(), answer);
    return answer;
  }

  public void postOrder(TreeNode node, ArrayList<TreeNode> nodeOrder) {
    if (node == null)
      return;
    for (TreeNode n:node.getChildren()) {
      postOrder(n, nodeOrder);
    }
    nodeOrder.add(node);
  }

  public ArrayList<TreeNode> levelOrder() {
    ArrayList<TreeNode> waiting = new ArrayList<>();
    if (root() == null) return waiting;
    waiting.add(root());
    int done = 0;
    while (done < waiting.size()) {
      TreeNode oldNode = waiting.get(done++);
      for (TreeNode n:oldNode.getChildren())
        waiting.add(n);
    }
    return waiting;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }
}
