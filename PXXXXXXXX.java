
/****
 *   This homework assignment is due on 11/21/2019
 *   To complete the assignment you must complete the code for three methods in the class P00000000.
 *   These methods are found on line numbers 59, 63 and 68 of this file.
 *   Rename the class P00000000 as Pxxxxxxxx where xxxxxxxx are the last 8 digits of your QC ID number.
 *   Remove the initial package statement at the top of your file (if there is one).
 *   Cut your file immediately after the end of the modified P00000000 class and email the
 *   cut file to Alexander.Ryba@qc.cuny.edu
 *   You must send the email from your official Queens College email account.
 *   
 *   You can only submit the homework ONCE.  However, if errors are found when your homework is
 *   being graded, you will get another opportunity to submit it again later for reduced credit.  Late
 *   homework will also receive reduced credit.  Late homework received after 11/21/2019 will receive
 *   no credit.
 *   
 *   Full instructions for the homework are given in the following comments. Read them carefully.
 *   If two or more homeworks contain duplicate code all will receive a score of 0.
 ***/

import java.util.ArrayList;

// Homework P:  Two way priority queues.

// In the project you need to code one class that implements the interface TwoWayPriorityQueue.
// This interface requires methods insert, removeMin and removeMax.
// The remove methods remove either the min or max element from the queue.
// You are to implement your class by extending the class BST which will be used to store data.
// The implementation of BST that we studied in class is attached at the end of this homework
//  assignment.

// You should change the class name P00000000 so that the last 8 digits are your QC ID number.
// You should only make changes inside this class.
// You do not need any more than 40 lines of code in the class.
// After you have tested your work on mars (as well as in your development environment)
// cut the file above the interface TwoWayPriorityQueue and submit it by email.
// Remove the initial package instruction (if you used eclipse) since this will stop your code compiling on other machines. 
// Submit your homework as just one attached file with extension .java.

public class PXXXXXXXX<K extends Comparable<K>> extends BST<K> implements TwoWayPriorityQueue<K> {

	// ---- main program to test required methods
	static PXXXXXXXX<Integer> t = new PXXXXXXXX<Integer>();

	public static void main(String args[]) throws Exception {

		t.insert(3);
		t.insert(1);
		t.insert(4);
		t.insert(15);
		t.insert(9);
		t.insert(2);
		t.insert(6);

		System.out.println(t.removeMin()); // output 1
		System.out.println(t.removeMax()); // output 15

	}

	public void insert(K x) {
		if (t.size() == 0) {
			t.addRoot((Integer) x);
		} else {
			t.add((Integer) x);
		}
	}

	public K removeMin() throws Exception {
		if (t.isEmpty() || t.size == 1) {
			System.out.println("Queue is empty");
			return null;
		}
		BinaryNode<Integer> a = t.inOrder().get(0);
		K xx = (K) a.getData();
		int x = (Integer) a.getData();
		t.remove(x);
		return xx;
	}

	public K removeMax() throws Exception {
		if (t.isEmpty() || t.size == 1) {
			System.out.println("Queue is empty");
			return null;
		}
		BinaryNode<Integer> a = t.inOrder().get(t.size - 1);
		K xx = (K) a.getData();
		int x = (Integer) a.getData();
		t.remove(x);
		return xx;
	}
}