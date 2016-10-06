/**
 * Data-Structures-in-Java
 */
package com.deepak.data.structures.LinkedList;

/**
 * Implementation of Singly linked list 
 * 
 * <br> Operations supported are :
 * - Inserting a element in the list - This can be at beginning, at end or at a given position. 
 * - Traversing through linked list.
 * - Check the size of the list.
 * - Check if list is empty.
 * - Search a element by index.
 * - Search a element by value.
 * - Delete a element from the list - This can again be at beginning, at end or at given position.
 * - Converting a list to and from a Array.
 * - Reverse a linked list using iteration and recursion.
 * - Print elements in forward and reverse order
 * </br>
 * 
 * @author Deepak
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {

	/* Head is needed to keep track of first node */
	private Node<E> head;

	/* Size to keep track of number of elements in list. 
	 * This should be increased by 1 when a element is added
	 * and should be reduced by 1 when a element is deleted */
	private int size = 0;

	/**
	 * Inserts a element into a linked list at head position.
	 * This does not require traversal through entire list.
	 * 
	 * <br> Complexity :
	 * Since there is no traversal involved here, and insertion
	 * always happens at the head, this can be done in constant 
	 * time. Hence, complexity comes out to be O(1) 
	 * </br>
	 * 
	 * @param value
	 */
	public void insertAtHead(E value) {
		Node<E> newNode = new Node<E>(value); 
		newNode.next = head; 
		head = newNode;
		size++;
	}

	/**
	 * Inserts a element into a linked list at tail position.
	 * This needs traversal through entire list before insertion happens.
	 * 
	 * <br> Complexity :
	 * Since, traversal through entire list is involved here before
	 * new node gets inserted, and let's assume list has n elements, 
	 * so insertion at tail will take O(n) time
	 * </br>
	 * 
	 * @param value
	 */
	public void insertAtTail(E value) {
		Node<E> newNode = new Node<E>(value);
		newNode.next = null; /* Since this insertion is at tail, this new node will point to null */
		if (null == head) { /* When list is empty */
			head = newNode;
			size++;
		} else {
			Node<E> tempNode = head;
			while (null != tempNode.next) {
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
			size++;
		}
	}

	/**
	 * Inserts a element into a linked list at a given position.
	 * This needs traversal through the linked list till the given position.
	 * 
	 * <br> Complexity :
	 * This insertion can possibly happen at last node, means in worst case 
	 * we may have to traverse entire linked list. On an average case with 
	 * linked list having n elements, this will take n/2 time and after ignoring
	 * the constant term, complexity comes out to be O(n)
	 * </br>
	 * 
	 * @param value
	 * @param position
	 */
	public void insertAtPosition(E value, int position) {
		if (position < 0 || position > size) {
			throw new IllegalArgumentException("Position is Invalid");
		} /* Conditions check passed, let's insert the node */
		Node<E> newNode = new Node<E>(value);
		if (position == 0) {
			newNode.next = head;
			size++;
		} else {
			Node<E> tempNode = head;
			for (int i = 0; i < position - 1; i++) {
				tempNode = tempNode.next;
			}
			Node<E> nodeNextToNewNode = tempNode.next;
			tempNode.next = newNode;
			newNode.next = nodeNextToNewNode;
			size++;
		}
	}

	/**
	 * Traverse through the linked list and print the items
	 */
	public void traverse() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
	}

	/**
	 * Returns size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true is list is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the Node containing data item after searching
	 * for a given index. If invalid index is passed, proper
	 * exception is thrown. 
	 *  
	 * @param index
	 * @return
	 */
	public Node<E> searchByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid index passed while searching for a value");
		} /* Validation passed, let's search for value using the index */
		Node<E> temp = head;
		for (int i = 0; i < index; i++) { /* Start from 0 and go till one less then index 
											because we are jumping to next node inside the loop */
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Returns the node containing data item after searching 
	 * for a given value. If there are multiple same values
	 * in linked list, first one will be returned.
	 * 
	 * @param value
	 * @return
	 */
	public Node<E> searchByValue(E value) { /* Traverse through each node until this value is found */
		Node<E> temp = head;
		while (null != temp.next && temp.item != value) {
			temp = temp.next;
		}
		if (temp.item == value) {
			return temp;
		}
		return null;
	}

	/**
	 * Node class of a linked list
	 * This is needed since entire linked list is a collection 
	 * of nodes connected to each other through links
	 * 
	 * <br> We are keeping it generic so that it can be used with 
	 * Integer, String or something else </br>
	 * 
	 * <br> Each node contains a data item and pointer to next node.
	 * Since this is a Singly linked list and each node points in 
	 * one direction, we maintain only pointer to one (next) node </br>
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class Node<T> {

		/* Data item in the node */
		T item;

		/* Pointer to next node */
		Node<T> next;

		/* Constructor to create a node */
		public Node(T item) {
			this.item = item;
		}

		/* toString implementation to print just the data */
		@Override
		public String toString() {
			return "Data Item = " + item;
		}

	}

}
