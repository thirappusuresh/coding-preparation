package com.mfino;

public class LinkedList
{
	// reference to the head node.
	private Node head;
	private int listCount;
	
	// LinkedList constructor
	public LinkedList()
	{
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = null;
		listCount = 0;
	}
	
	public void add(Object data)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(data);
		Node current = head;
		if(head == null) {
			head=temp;
		} else {
			// starting at the head node, crawl to the end of the list
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			// the last node's "next" reference set to our new node
			current.setNext(temp);
		}
		listCount++;// increment the number of elements variable
	}
	
	public void add(Object data, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		Node temp = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for(int i = 1; i < index && current.getNext() != null; i++)
		{
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	public Object get(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}
	
	public int size()
	// post: returns the number of elements in this list.
	{
		return listCount;
	}
	
	public String toString()
	{
		Node current = head;
		String output = "";
		while(current != null)
		{
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
    public Node reverseLinkedList(Node head) {
    	Node prev = null;
    	Node curr = head;
    	Node next;
    	while(curr != null) {
    		next = curr.getNext();
    		curr.setNext(prev);
    		prev = curr;
    		curr = next;
    	}
    	head= prev;
    	return head;
    }
    
    public Node reverseLinkedListRecur(Node prevOne, Node currOne) {
    	if(currOne != null) {
    		Node next = currOne.getNext();
    		currOne.setNext(prevOne);
    		return reverseLinkedListRecur(currOne, next);
    	} else {
    		return prevOne;
    	}
    }
    
    public Node addOneToList(Node head) {
    	int carry = 0;
    	Node curr = head;
    	Node prev = null;
    	while(curr.getNext() != null) {
    		if((Integer.parseInt(curr.getData().toString()) != 9) && (Integer.parseInt(curr.getNext().getData().toString()) == 9)) {
    			prev = curr;
    		}
    		curr = curr.getNext();
    	}
    	if(Integer.parseInt(curr.getData().toString()) == 9) {
    		curr.setData((Integer.parseInt(curr.getData().toString()) + 1) % 10);
    		carry = 1;
    	} else {
    		curr.setData(Integer.parseInt(curr.getData().toString()) + 1);
    	}
    	if(carry == 1) {
    		if(prev == null) {
    			prev = new Node(1);
    			prev.setNext(head);
    			head = prev;
    		} else {
    			prev.setData(Integer.parseInt(prev.getData().toString()) + 1);
    		}
    		while(prev != curr) {
    			prev = prev.getNext();
    			prev.setData(0);
    		}
    	}
    	return head;
    }
    
    public static void main(String[] args) {
        LinkedList lList = new LinkedList();
 
        // add elements to LinkedList
        lList.add(2);
        lList.add(9);
        lList.add(2);
        lList.add(9);
        lList.add(9);
        lList.add(3);
        System.out.println("lList - print linkedlist: " + lList);
        //lList.head = lList.reverseLinkedListRecur(null, lList.head);
        lList.head = lList.addOneToList(lList.head);
        /*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 
        System.out.println("lList - print linkedlist: " + lList);
    }
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;
		

		// Node constructor
		public Node(Object _data)
		{
			next = null;
			data = _data;
		}
		
		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object _data, Node _next)
		{
			next = _next;
			data = _data;
		}
		
		// these methods should be self-explanatory
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
	}
}