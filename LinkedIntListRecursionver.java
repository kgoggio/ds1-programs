package hw7;

import java.util.NoSuchElementException;

import algs4.StdOut;

public class LinkedIntList {

	// helper linked list node class
	private class Node {
		private int item;
		private Node next;

		public Node() {
		}

		public Node(int number, Node nextNode) {
			item = number;
			next = nextNode;
		}
	}

	private Node first; // first node of the list

	/**
	 * Constructs an empty list.
	 */
	public LinkedIntList() {
		first = null;
	}

	/**
	 * Constructs a list containing the elements of the specified array, in the
	 * order they appear in the array.
	 *
	 * @param data the array whose elements are to be placed into this list
	 * @throws NullPointerException if the specified array is null
	 */
	public LinkedIntList(int[] data) {
		first = null;
		for (int i = data.length - 1; i >= 0; i--) {
			Node newNode = new Node();
			newNode.item = data[i];
			newNode.next = first;
			first = newNode;
		}
	}

	/**
	 * Constructs a string representing the list. The ints in the list appear in a
	 * comma separated list contained inside square brackets.
	 * 
	 * @return a string represeting the list.
	 */
	public String toString() {
		if (first == null)
			return "[]";
		String answer = "[" + first.item;
		Node ptr = first.next;
		while (ptr != null) {
			answer += ", " + ptr.item;
			ptr = ptr.next;
		}
		answer += "]";
		return answer;
	}

	/**
	 * Prints the list to StdOut as a comma separted list inside of square brackets
	 */
	public void printList() {
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			StdOut.print(ptr.item + " ");
		}
	}

	/**
	 * Returns the first int in this list.
	 *
	 * @return the first int in this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.item;
	}

	/**
	 * Removes and returns the first int from this list.
	 *
	 * @return the first int from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		int answer = first.item;
		first = first.next;
		return answer;
	}

	/**
	 * Inserts the specified int at the beginning of this list. Shifts all ints
	 * already in the list to the right (adds one to their indices).
	 * 
	 * @param i the int to add
	 */
	public void addFirst(int i) {
		Node newFirst = new Node();
		newFirst.item = i;
		newFirst.next = first;
		first = newFirst;
	}

	/**
	 * Returns {@code true} if this list contains the specified int.
	 *
	 * @param i int whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 */
	public boolean contains(int i) { // IN CLASS Do Array loop first
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			if (ptr.item == i)
				return true;
		}
		return false;
	}

	/**
	 * Returns the int at the specified position in this list.
	 *
	 * @param index index of the int to return
	 * @return the int at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int get(int index) {
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		else
			return ptr.item;
	}

	/**
	 * Replaces the int at the specified position in this list with the specified
	 * int.
	 *
	 * @param index index of the element to replace
	 * @param i     int to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int set(int index, int i) {
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		int answer = ptr.item;
		ptr.item = i;
		return answer;
	}

	/**
	 * Inserts the specified int at the specified position in this list. Shifts the
	 * int currently at that position (if any) and any subsequent ints to the right
	 * (adds one to their indices).
	 *
	 * @param index index at which the specified int is to be inserted
	 * @param i     int to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, int i) {
		Node previous = null;
		Node position = first;
		while (index > 0 && position != null) {
			previous = position;
			position = position.next;
			index--;
		}
		if (index > 0)
			throw new IndexOutOfBoundsException();
		Node newNode = new Node();
		newNode.item = i;
		newNode.next = position;
		if (previous == null)
			first = newNode;
		else
			previous.next = newNode;
	}
	

	/**
	 * Removes the first occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeFirstOccurrence(int i) {
		if (first == null)
			return false;
		if (first.item == i) {
			first = first.next;
			return true;
		}
		Node ptr = first;
		while (ptr.next != null && ptr.next.item != i)
			ptr = ptr.next;
		if (ptr.next == null)
			return false;
		ptr.next = ptr.next.next;
		return true;
	}
	
	/*********************HOMEWORK************************/

	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) {

		return indexOfH(first, i);
	}

	private int indexOfH(Node front, int i) {  // TODO
		//throw new RuntimeException("Not implemented");
		//fully works!
		if(front==null) {
			return -1;
		}
			if(front.item==i) {
				return 0;
			}
			if (front.next ==null) {
				return -1;
			}
			int myIndex = this.indexOfH(front.next,i);
			if(myIndex==-1) {
				return -1;
			}
			else {
				return 1 + myIndex;
			}
		
		}
			//if(front.item==j) {
				//index+=1;
				//return index;
			//}
			//index+=1;
		//} else {
			//return index;	
		//}

	/**
	 * Returns the number of times a specified number appears in the list.
	 *
	 * @param i int to be counted
	 * @return the number of times the number {@code i} appears in the list
	 */
	public int count(int i) {
		return countH(first, i);
	}
	
	private int countH(Node front, int i) {  // TODO
		//throw new RuntimeException("Not implemented");
		//count works!
		
		if(this.contains(i)==false||front==null) {
			return 0;
		}else {
			if(front.item==i && front.next==null) {
				return 1;
			} else if(front.item==i) {
				//this.count
				return 1 + this.countH(front.next, i);
			} else {
				return 0 + this.countH(front.next,i);
			}
		}
	}

	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() {
		return sumH(first);
	}
	
	private int sumH(Node front) {  // TODO
		//throw new RuntimeException("Not implemented");{
		//works

		int mySum;
		if(front == null) {
			mySum = 0;
			return mySum;
		} else {
			mySum = front.item;
			if(front.next !=null) {
				return mySum +this.sumH(front.next);
			} else {
				return mySum;
			}
		}
	}

	/**
	 * Constructs a new {@code LinkedIntList} consisting of just the even number
	 * from this list appearing in the same order as they occur in this list.
	 * 
	 * @return a new list that looks like this list be with all the odds removed.
	 */
	public LinkedIntList evens() {
		LinkedIntList answer = new LinkedIntList();
		answer.first = evensH(first);
		return answer;
	}
	
	public Node evensH(Node front) {  // TODO
		//throw new RuntimeException("Not implemented");
		
		


		//v9
		//same result as v8, but prettier
		/*
	Node last = null;
	if(front==null) {
		return this.first;
	} else {
		if(front.item%2==0) {
			Node n = new Node();
			n.item = front.item;
			if(last ==null) {
				front = n;
				last = front;
			} else {
				last.next = n;
				last = n;
			}
	}
	}
	return last;
	}
	*/
		//v10
		//the else thing made everything worse!
		/*
		Node last = null;
		if(front==null) {
			return this.first;
		} else {
			if(front.item%2==0) {
				Node n = new Node();
				n.item = front.item;
				if(last ==null) {
					front = n;
					last = front;
				} else {
					last.next = n;
					last = n;
				}
		} else {
			last = evensH(front.next);
		}
		}
		return last;
		}
		*/
		//v11
		//nope

		//v12
		//doubles still at 250
		//large still at 269, but will get first 0
		/*
		Node last = null;
		if(front==null) {
			return this.first;
		} else {
			if(front.item%2==0) {
				Node n = new Node();
				n.item = front.item;
				if(last ==null) {
					front = n;
					last = front;
					last.next = n.next;
					last = n;
		}
		}
		}
		return last;
	}
	*/
	//v13
		//completely works!
		Node last = null;
	if(front==null) {
		return this.first;
	} else {
		if(front.item%2==0) {
			last = front;
			last.item = front.item;
			if(front.next == null) {
				return last;
			} else
			return new Node(front.item, evensH(front.next));
			} else {
				if(front.next ==null) {
					return last;
				} else {
					return evensH(front.next);
				}
			}
	}
	}
	

		
		
			

	/**
	 * Constructs a new int list where each entry in the new list is the sum of the
	 * corresponding entries in this list and the argument list.
	 * 
	 * @arg otherList the other list to be added to this list
	 * @return a new list where each entry in the new list is the sum of the
	 *         corresponding entries in this list and the argument list
	 * @throws IllegalArgumentException if this list and the other list have have
	 *                                  different lengths
	 */
	public LinkedIntList listAddition(LinkedIntList otherList) {
		LinkedIntList answer = new LinkedIntList();
		answer.first = listAdditionH(first, otherList.first);
		return answer;
	}
	
	public Node listAdditionH(Node thisFront, Node otherFront) {  // TODO

		//works!!!!!!!!!!!!!!!!!!!!!!!!!!
		Node last = new Node();//listAdditionH(thisFront,otherFront);
		Node current = thisFront;
		Node otherCurrent = otherFront;
		if(otherCurrent == null && current !=null) {
			throw new IllegalArgumentException("different lengths!");
		} else if(otherCurrent !=null && current==null) {
			throw new IllegalArgumentException("different lengths!");
		}else if(otherCurrent ==null & current ==null) {
			last = null;
		return last;
			
	}else {
			last.item += current.item +otherCurrent.item;
			//thisFront.item = last.item;
			//otherFront.item = last.item;
			last.next = listAdditionH(thisFront.next, otherFront.next);
			return last;
		
			//return listAdditionH(thisFront.next, otherFront.next);
			//return listAdditionH(thisFront.next, otherFront.next);
		}
}

	
	

	/* A small main to get started testing */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 2, 5, 6 };
		LinkedIntList l = new LinkedIntList(a);
		StdOut.println("The list: " + l.toString());
		StdOut.printf("has %d occurences of the number 2", l.count(2));
	}
}
