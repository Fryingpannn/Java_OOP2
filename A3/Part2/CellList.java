/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #3         |
 * Part 2                          |
 * Due Date: August 9th, 2020      |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
package Part2;

import java.util.NoSuchElementException;

/**
 * This is the linked list class which stores objects of type CellPhone.
 * 
 * @author Matthew Pan
 */
public class CellList {
	
	/**
	 * private inner Node class
	 * 
	 * - Privacy leak note:
	 * If this private inner class was public, there would be a privacy leak. The reason being that the user could then
	 * access the nodes of a given CellList directly, from outside of the outer class. In order to avoid privacy leaks, 
	 * it is best to create the Node class as a private inner class of the linked list class, and setting attributes to private.
	 */
	private class CellNode{
		
		private CellPhone data;
		private CellNode link; //pointer
		
		//no args constructor
		public CellNode() {
			data = null;
			link = null;
		}
		
		//param constructor
		public CellNode(CellPhone aData, CellNode aLink) {
			data = aData;
			link = aLink;
		}
		
		/**
		 * copy constructor
		 * @param c CellNode to be copied
		 */
		public CellNode(CellNode c) {
			data = c.data.clone();
			link = c.link;
		}
		
		/**
		 * clone method
		 */
		public CellNode clone() {
			return (new CellNode(this));
		}
		
		/*
		 * - ACCESSOR & MUTATOR METHODS:
		 * These methods that are asked for the CellNode class have not been added. The reason being that since
		 * this inner class is private, there is no need for getters/setters as we may directly reference the attributes,
		 * and they would also be inaccessible from outside of the outer class.
		 * */
	} //end of CellNode class
	
	//CellList class:
	private CellNode head;	//points to first node
	private int size;	//numbers of nodes
	private int count = 0; //counts iteration times in find() method
	
	//default constructor; empty list
	public CellList() {
		head = null;
		size = 0;
	}
	
	/**
	 * sets the size of list
	 */
	public void setSize() {
		size = 0;
		CellNode position = head;
		while(position != null) {
			size++;
			position = position.link;
		}
	}
	
	/**
	 * @return size of list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * - Copy constructor (Deep Copy):
	 * Using temporary pointers;
	 * t1: increments the position in the list to allow copying each node.
     * t2: the first t2 stores the first node, then sets the head of new copy list to this first node. Subsequently,
     *     it sets the new pointer (link) for the copy nodes, by pointing to t3.
     * t3: stores the newly copied next node to be linked with the previous copied node. Linked by t2.
     * This process is repeated with a while loop until the list to be copied reaches its end ( == null).
	 * @param c list to be deep copied
	 */
	public CellList(CellList c) {
		if(c == null)
			throw new NullPointerException();	//if list is null, throws exception
		else if(c.head == null)	//if list is empty
			head = null;
		else {	//if list is not empty
			head = null;
			CellNode t1, t2, t3; //temporary pointers
			
			t1 = c.head;
			t2 = t3 = null;
			
			while(t1 != null) {
				if(head == null) {
					t2 = new CellNode(t1.data.clone(), null);
					head = t2;
				}
				else {
					t3 = new CellNode(t1.data.clone(), null);
					t2.link = t3;
					t2 = t3;
				}
				t1 = t1.link;
			}
			t2 = t3 = null;
		}
		setSize();
	}
	
	/**
	 * adds a CellPhone to start of list as a node
	 * @param c CellPhone to add to start
	 * @return true if successfully added
	 */
	public boolean addToStart(CellPhone c) {
		CellNode start = new CellNode(c, head);
		head = start;
		start = null; //no need for this pointer as head already points to the node
		setSize();
		return true;
	}
	
	/**
	 * Delete first node
	 * @return true if successfully deleted, false if list already empty
	 */
	public boolean deleteFromStart() {
		if(head != null) {
			head = head.link;
			setSize();
			return true;
		}
		else
			return false; //list is already empty
	}
	
	/**
	 * insert CellPhone at given index.
	 * @param c CellPhone to insert
	 * @param i index place to insert (start at 0)
	 * @return true if successfully inserted node at given index
	 */
	public boolean insertAtIndex(CellPhone c, int i) {
		CellNode position = head;
		CellNode previous = position;
		
		if(i < 0 || i >= getSize())
			throw new NoSuchElementException();
		else if(i == 0)
			return addToStart(c);
		else {
			while(i > 0) {
				previous = position;
				position = position.link;	//the 'i'th element is the node at 'position'
				i--;
			}
			CellNode insert = new CellNode(c, position);
			previous.link = insert;
			setSize();
			return true;
		}
	}
	
	/**
	 * deleting the node a given index
	 * @param i index of node to be deleted
	 * @return true if successfully deleted node at index
	 */
	public boolean deleteFromIndex(int i) {
		CellNode position = head;
		CellNode previous = position;
		
		if(i < 0 || i >= getSize())
			throw new NoSuchElementException();
		else if(i == 0)
			return deleteFromStart();	//false if list empty
		else {
			while(i > 0) {
				previous = position;
				position = position.link;	//the 'i'th element is the node at 'position'
				i--;	
			}
			previous.link = position.link;
			position = position.link;	//letting deleted node be garbage collected
			setSize();
			return true;
		}
	}
	
	/**
	 * Replaces the CellPhone at given index with new one
	 * @param c new CellPhone to insert
	 * @param i index place to replace
	 * @return true if successfully replaced
	 */
	public boolean replaceAtIndex(CellPhone c, int i) {
		CellNode position = head;
		CellNode previous = position;
		
		if(i < 0 || i >= getSize())
			throw new NoSuchElementException();
		else if(i == 0) {
			CellNode newHead = new CellNode(c, head.link);
			head = newHead;
			newHead = null;	//garbage collect 
			return true;
		}
		else {
			while(i > 0) {
				previous = position;
				position = position.link;	//the 'i'th element is the node at 'position'
				i--;	
			}
			CellNode newHead = new CellNode(c, position.link);
			previous.link = newHead;
			newHead = null; //garbage collect
			return true; 
		}
	}
	
	/**
	 * finds a node with given serial number
	 * @param num serial number to be found
	 * @return	the pointer to the node where the target serial number is
	 */
	private CellNode find(long num) {
		count = 0;
		CellNode position = head;
		while(position != null) {
			if(position.data.getSerialNum() == num) 
				return position;	//target found
			else {
				position = position.link;
				count++;
			}
		}
		return null; //target not found
	}
	
	/**
	 * @return number of iterations
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * checks if list contains the given serial number
	 * @param num serial number to be found
	 * @return true if serial number found
	 */
	public boolean contains(long num) {
		if(find(num) != null)
			return true;
		else 
			return false;
	}
	
	/**
	 * displays contents of list
	 */
	public void showContents() {
		CellNode position = head;
		if(position != null) {
			int count = 0;
			System.out.println("\nThe current size of the list is " + getSize() + ". Here are its contents: ");
			System.out.println("=====================================================================================");
			while(position != null) {
				System.out.println("[" + count + "]" + " - " + position.data);
				position = position.link;
				count++;
			}
		}
		else
			System.out.println("The list is empty, nothing to display.");
	}
	
	/**
	 * Iterates through both lists and compares the CellPhones
	 * @param e other list to compare with
	 * @return true if no mistmatch found
	 */
	public boolean equals(CellList e) {
		if(e == null)
			return false;
		else if(getSize() != e.getSize())
			return false;
		else {
			CellNode position = head;
			CellNode position2 = e.head;
			
			while(position != null) { //iterate through both lists and compare node data
			 if(!(position.data.equals(position2.data)))
				 return false;	//if found mismatch
			 position = position.link;
			 position2 = position2.link;
			}
			return true;	//no mismatch found!
		}
	}
}
