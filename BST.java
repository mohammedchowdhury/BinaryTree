// --- Code for binary search trees as in class.  Do not make any changes to the classes below this line

class BST<K extends Comparable<K>> extends BinaryTree<K> {

  @SuppressWarnings("unchecked")
  public BinaryNode<K> findNode(K target) {
    if (root() == null)
      return null;
    return recursiveFindNode((BinaryNode<K>) root(), target);
  }

  // either find the node containing target or the future parent of a Node that would contain target
  protected BinaryNode<K> recursiveFindNode(BinaryNode<K> node, K target) {
    int comparison = target.compareTo(node.getData());
    if (comparison == 0) return node;
    if (comparison < 0 && node.getLeft() != null) 
      return recursiveFindNode(node.getLeft(), target);
    if (comparison > 0 && node.getRight() != null) 
      return recursiveFindNode(node.getRight(), target);
    return node;
  }

  public void remove(K target) throws Exception {
    BinaryNode<K> n = findNode(target);
    if (n == null || !n.getData().equals(target)) throw new Exception("Target not present");
    removeNode(n);
  }

  public void add(K newData) throws Exception {
    BinaryNode<K> node = findNode(newData);
    if (node == null) addRoot(newData);
    else if ((node.getData()).compareTo(newData) > 0) addLeft(node, newData);
    else if ((node.getData()).compareTo(newData) < 0) addRight(node, newData);
    else node.setData(newData);
  }

  public boolean contains(K target) {
    BinaryNode<K> node = findNode(target);
    if (node == null || !node.getData().equals(target))
      return false;
    return true;
  }

  public boolean isEmpty() {
    return root() == null;
  }

  public K get(K partialData) {
    BinaryNode<K> node = findNode(partialData);
    if (node == null || !node.getData().equals(partialData))
      return null;
    return node.getData();
  }

  @Override  // when removing from a BST, we can only promote from a neighbor in order
  public BinaryNode<K> descendant(BinaryNode<K> node) {
    BinaryNode<K> lower = node.getLeft();
    if (lower != null) {
      while (lower.getRight() != null) lower = lower.getRight();
      return lower;    // immediate predecessor of node (in order)
    }
    lower = node.getRight();
    if (lower != null) {
      while (lower.getLeft() != null) lower = lower.getLeft();
      return lower;   // immediate successor of node (in order)
    }
    return null;
  }
}