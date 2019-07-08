package com.mfino;

import java.util.Iterator;

public class BinarySearchTree<T extends java.lang.Comparable<T>> {

	/**
	 * A node in a binary tree
	 * 
	 * @author Edo Biagioni
	 * @lecture ICS 211 Mar 15 or later
	 * @date March 14, 2011
	 * @bugs private class: include this code within a larger class
	 */

	private static class BinaryNode<T> {
		private T item;
		private BinaryNode<T> left;
		private BinaryNode<T> right;

		/**
		 * constructor to build a node with no subtrees
		 * 
		 * @param the
		 *            value to be stored by this node
		 */
		private BinaryNode(T value) {
			item = value;
			left = null;
			right = null;
		}

		/**
		 * constructor to build a node with a specified (perhaps null) subtrees
		 * 
		 * @param the
		 *            value to be stored by this node
		 * @param the
		 *            left subtree for this node
		 * @param the
		 *            right subtree for this node
		 */
		private BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r) {
			item = value;
			left = l;
			right = r;
		}
	}

	/* the root of the tree is the only data field needed */
	protected BinaryNode<T> root = null; // null when tree is empty

	/*
	 * constructs an empty tree
	 */
	public BinarySearchTree() {
		super();
	}

	/*
	 * constructs a tree with one element, as given
	 * 
	 * @param value to be used for the one element in the tree
	 */
	public BinarySearchTree(T value) {
		super();
		root = new BinaryNode<T>(value);
	}

	/*
	 * constructs a tree with the given node as root
	 * 
	 * @param newRoot to be used as the root of the new tree
	 */
	public BinarySearchTree(BinaryNode<T> newRoot) {
		super();
		root = newRoot;
	}

	/*
	 * find a value in the tree
	 * 
	 * @param key identifies the node value desired
	 * 
	 * @return the node value found, or null if not found
	 */
	public T get(T key) {
		BinaryNode<T> node = root;
		while (node != null) {
			if (key.compareTo(node.item) == 0) {
				return node.item;
			}
			if (key.compareTo(node.item) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	/*
	 * add a value to the tree, replacing an existing value if necessary
	 * 
	 * @param value to be inserted
	 */
	public void add(T value) {
		root = add(value, root);
	}

	/*
	 * add a value to the tree, replacing an existing value if necessary
	 * 
	 * @param value to be inserted
	 * 
	 * @param node that is the root of the subtree in which to insert
	 * 
	 * @return the subtree with the node inserted
	 */
	protected BinaryNode<T> add(T value, BinaryNode<T> node) {
		if (node == null) {
			return new BinaryNode<T>(value);
		}
		if (value.compareTo(node.item) == 0) {
			// replace the value in this node with a new value
			node.item = value;
			// alternative code creates new node, leaves old node unchanged:
			// return new BinaryNode<T>(value, node.left, node.right);
		} else {
			if (value.compareTo(node.item) < 0) { // add to left subtree
				node.left = add(value, node.left);
			} else { // add to right subtree
				node.right = add(value, node.right);
			}
		}
		return node;
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 */
	public void remove(T key) {
		root = remove(key, root);
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 * 
	 * @param node the root of the subtree from which to remove the value
	 * 
	 * @return the new tree with the value removed
	 */
	protected BinaryNode<T> remove(T value, BinaryNode<T> node) {
		if (node == null) { // key not in tree
			return null;
		}
		if (value.compareTo(node.item) == 0) { // remove this node
			if (node.left == null) { // replace this node with right child
				return node.right;
			} else if (node.right == null) { // replace with left child
				return node.left;
			} else {
				// replace the value in this node with the value in the
				// rightmost node of the left subtree
				node.item = getRightmost(node.left);
				// now remove the rightmost node in the left subtree,
				// by calling "remove" recursively
				node.left = remove(node.item, node.left);
				// return node; -- done below
			}
		} else { // remove from left or right subtree
			if (value.compareTo(node.item) < 0) {
				// remove from left subtree
				node.left = remove(value, node.left);
			} else { // remove from right subtree
				node.right = remove(value, node.right);
			}
		}
		return node;
	}

	protected T getRightmost(BinaryNode<T> node) {
		assert (node != null);
		BinaryNode<T> right = node.right;
		if (right == null) {
			return node.item;
		} else {
			return getRightmost(right);
		}
	}

	public void inOrderTraversal(BinaryNode<T> root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(" " + root.item);
			inOrderTraversal(root.right);
		}
	}

	/*
	 * toString
	 * 
	 * @returns the string representation of the tree.
	 */
	public String toString() {
		return toString(root);
	}

	protected String toString(BinaryNode<T> node) {
		if (node == null) {
			return "";
		}
		return node.item.toString() + "(" + toString(node.left) + ", "
				+ toString(node.right) + ")";
	}
	
	public int changeValues(BinaryNode<Integer> root, int greater) {
		if(root == null) return 0;
		int rootVal = root.item;
		int right = changeValues(root.right, greater);
		if((right+greater) > rootVal) {
			root.item = right+greater;
		}
		int left = changeValues(root.left, rootVal+root.item);
		return rootVal+left+right;
	}

	/*
	 * unit test
	 * 
	 * @param arguments, ignored
	 */
	public static void main(String[] arguments) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		tree.add(5);
		tree.add(7);
		tree.add(9);
		tree.add(3);
		tree.add(1);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		tree.add(10);

		System.out.println(tree);

		System.out.println("in-order: ");
		tree.inOrderTraversal(tree.root);
		tree.changeValues(tree.root, 0);
		System.out.println("in-order: ");
		tree.inOrderTraversal(tree.root);
		/*System.out.println("");

		if (!tree.get(5).equals(5)) {
			System.out.println("error: tree does not have 5");
		}
		if (tree.get(13) != null) {
			System.out.println("error: tree has 13, should not");
		}
		if (!tree.get(10).equals(10)) {
			System.out.println("error: tree does not have 10");
		}

		tree.add(10);
		System.out.println(tree);

		tree.remove(10);
		tree.remove(2);
		tree.remove(5);
		tree.remove(9);
		tree.remove(10);
		tree.remove(9);
		System.out.println(tree);

		if (tree.get(5) != null) {
			System.out.println("error: tree has 5, should not");
		}
		if (tree.get(13) != null) {
			System.out.println("error: tree has 13, should not");
		}
		if (!tree.get(3).equals(3)) {
			System.out.println("error: tree does not have 3");
		}
*/
	}
}