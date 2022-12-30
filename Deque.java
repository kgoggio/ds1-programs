package hw5;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions. Your code needs to run in
 * constant time. It is OK if your testing code has loops (like in
 * checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node first; 	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node last; 		// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	private class Node {

		public T item; 		// The data stored at this node.
		public Node next; 	// The node to the right (or null if there is no
							// node to the right)
		public Node prev; 	// The node to the lett (or null if there is no
							// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		first = null;
		last = null;
		N = 0;
		
		
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		if(N==0) {
			return true;
		} else { 
			return false;
		}
	}

	/**
	 * Returns the number of items currenlty in this <code>Deque</code>.
	 * 
	 * @return the number of items currenlty in this <code>Deque</code>
	 */
	public int size() {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushFront(T item) {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		Node n = new Node();
		n.item = item;
		N++;
		if(first==null) {
			first = n;
			if(last==null) {
				last = n;
			}
		}
		if(first !=null) {
			first.next = n;
			n.prev = first;
			first = n;
			
		}
		
	}

	/**
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushBack(T item) {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		Node n = new Node();
		n.item = item;
		N++;
		if(last==null) {
			last = n;
			if(first == null) {
				first = n;
			}
 		}
		if( last !=null) {
			last.prev = n;
			n.next = last;
			last = n;
		}
			
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popFront() {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		if(N==0) {
			throw new NoSuchElementException("empty");
		}
		N--;
		T poppedItem = first.item;
		first = first.prev;
		if(N==0) {
			last = null;
			first = null;
		}
		return poppedItem;

	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		// TODO - Repalce the line below with a correct solution.
		//throw new RuntimeException("Not implemented");
		if(N==0) {
			throw new NoSuchElementException("empty");
		}
		N--;
		T poppedItem = last.item;
		last = last.next;
		if(N==0) {
			first = null;
			last = null;
		}
		return poppedItem;	
	
	}
}
