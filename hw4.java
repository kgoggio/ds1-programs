package ds1;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;


public class LinkedIntList {

	// helper linked list node class
	private class Node {
		private int item;
		private Node next;
		
		public Node() {	}
		public Node(int number, Node nextNode) {
			item = number;
			next = nextNode;
		}
	}
	private int myLength() {
		int length = 0;
		for(Node current =first; current != null; current = current.next) {
			length++;
				}
		return length;
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


	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) { // TODO
		//throw new RuntimeException("Not implemented");
		//this works!
		int indexNum = 0;
		for (Node current = first; current != null; current = current.next)
			if(current.item == i) {
				return indexNum;
				//return current.number;
			}else {
				indexNum +=1;
			}
		return -1;
		}
		//use the contains method to theck if it contains the the int i
		//that will be if
		//when if is triggered, run for loop with the get method
		//within the forloop: if the the int i of this parameter == the 
		//contents of the the argument of the index of arg;
		//add the counter inside and outside of the nested if statement;
		//if the desired contents are found, under the if, do the counter,
		//then break/ return whatever the counter is;
		//else 
		//return -1;
		//this is all assuming that there is a way to loop with the 
		//linked list
		//for reference, consider 




	/**
	 * Removes the last occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeLastOccurrence(int i) { // TODO
		//throw new RuntimeException("Not implemented");
		//two scenarios; 
		//1 if the node to be removed is the last one in the sequence,
		//change the previous node's next to null
		//2 if the node containing the thing to be removed is not thelast one,
		//you change the node to the node after the undesireable node
		//3 if the node to be removed is the very first one; that's a special case, check
		//@begining!!!
		//firstNumIndex = .indexOf(i);
		//if(firstNumIndex > -1)
		//should i just run contains to start?
		//if .contains == true {
		//
		//works!
		if(this.contains(i)==false) {
			return false;
			
		}
		Node last = null;
		Node current = first;
		while(current != null) {
			if(current.item == i) {
				last = current;
			}
			current = current.next;
		}
		if(last != null && last.next == null) {
			current = first; //isn't this redudant?
			while(current.next != last) {
				current = current.next;
			}
			current.next = null;
			return true;
		} //i keep getting errors beause last
		if(last !=null & last.next != null) {
			last.item = last.next.item;
			current = last.next;
			last.next = last.next.next;
			return true;
		} 
		
		
		if(first.item == last.item) {
			first = first.next;
			current = first;
			return true;
		}
		return false;
			}
			//cases: 
			//1 last instance is the first item in linked list--first will be first.next
			//2 last instance is the last item in linked list - last will be the previous
			//slot; does that mean the condition must be set at 3rd to last?
			//3 not an edge case; to 2, where i set the previous item's next node to the
			//if first occurence is first list in item

			//
			//if(scenario 2)
			//what's the best way to store the last instance??
			//scenario 3--similar

		//replace the last
		//return true;
	//} 
	//return false;
//}
			//this is rough, but i think this is basically it;

		//theorteically i can use the indexof as my start point
		//loop it starting at whatever first index is
		//if the int i shows up after the first index, set that new
		//index to the next one until it ends up all the way through the list
		//then use set with the stored index to remove it?
		

	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() { // TODO
		//throw new RuntimeException("Not implemented");
		//sum works!
		int sum = 0;
		for(Node current = first; current != null ; current = current.next) {
			sum += current.item;
		}
		return sum;

		//for loop with get
		//indexed accumulator with the get
		//add the return from get to the accumulator
		//outside loop, return the the accumulator
	}



	/**
	 * Constructs a new {@code LinkedIntList} consisting of just the even number from this list
	 * appearing in the same order as they occur in this list.
	 * 
	 * @return a new list that looks like this list be with all the odds removed.
	 */
	public LinkedIntList evens() {  // TODO
		//throw new RuntimeException("Not implemented");
		//how do i create a new linked list
		//create new linked list
		//LinkedIntList newList = new LinkedIntList();
		int length = 0;
		for(Node current =first; current != null; current = current.next) {
				if(current.item %2==0) {
					length++;
				}
				
			}

		//for(Node current =first; current != null; current = current.next) {
			//if(current.item %2==0) {
				//length++;
			//}
			
		//}
		int[] newData = new int[length];
		int counter = 0;
		for(Node current =first; current != null; current = current.next) {
			if(current.item %2==0) {
				newData[counter++] = current.item;
			}
			
		}
		return new LinkedIntList(newData);
		//for loop/indexed accumulator
		//accumulator is a new list
		//inside loop, nest an if; 
		//if get%2 == 0
		//then add the node to be the next node of the new list
	
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
	public LinkedIntList listAddition(LinkedIntList otherList) {  // TODO
		int len = this.myLength();
		int len2 = otherList.myLength();
		if(len-len2 !=0) {
			throw new IllegalArgumentException("diff lengths");
		} 
		int[] newData = new int [len];
		for(int i = 0; i<newData.length;i++) {
			newData[i] = this.get(i) + otherList.get(i);	
			}
		
			return new LinkedIntList(newData);
		}
			
			

			
			

		
			

		
	//} else {
		// new IllegalArgumentException("Different lengths!");
	//}
	
	/* A small main to get started testing */
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 2, 5, 6};
		int[] b = {4,5,6,7,8,9,10};
		int[] c = {11,12,13,14,15,16,17};
		LinkedIntList l = new LinkedIntList(a);
		LinkedIntList B = new LinkedIntList(b);
		LinkedIntList C =
		StdOut.println("Before removing 2: " + l);
		l.removeFirstOccurrence(2);
		StdOut.println("After removing 2:  " + l);
		
	}
}
