package com.mfino;

public class Node {
    // reference to the next node in the chain,
    // or null if there isn't one.
    Node next;
    // data carried by this node.
    // could be of any type you need.
    int data;
    public Node() {
    	
    }
    // Node constructor
    public Node(int dataValue) {
        next = null;
        data = dataValue;
    }

    // another Node constructor if we want to
    // specify the node to point to.
    public Node(int dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }

    // these methods should be self-explanatory
    public Object getData() {
        return data;
    }

    public void setData(int dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }
}