package com.datastructure.assignment.question2.skewedBST.util;

public class BinarySearchTree {

	public Node root;

	public BinarySearchTree(int[] inputArray) {
		Node root = null;
		Node result = null;
		for (int i = 0; i < inputArray.length; i++) {
			if (root == null) {
				root = insertNode(root, inputArray[i]);
			} else {
				result = insertNode(root, inputArray[i]);
				if (result.key == inputArray[i])
					i -= 1;
			}
		}
		this.root = root;
	}

	public static class Node {
		public Node left, right;
		public int key;
	}

	private static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	private static Node insertNode(Node root, int key) {
		Node newNode = newNode(key);
		Node x = root;
		Node y = null;
		while (x != null) {
			y = x;// Storing the root
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!");
				return newNode;
			}
		}
		if (y == null) {
			y = newNode;
		} else if (key < y.key)
			y.left = newNode;
		else
			y.right = newNode;
		return y;
	}

}
