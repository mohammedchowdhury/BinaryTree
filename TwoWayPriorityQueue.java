//-------  CUT HERE.  Place all your new code above this line and submit only the ------
//-------  code above this line as your homework.  Do not make any code changes ----
//-------  below this line.  

// interface to implement 

interface TwoWayPriorityQueue<K extends Comparable<K>> {
  public void insert(K x) throws Exception;
  public K removeMin() throws Exception;
  public K removeMax() throws Exception;
}