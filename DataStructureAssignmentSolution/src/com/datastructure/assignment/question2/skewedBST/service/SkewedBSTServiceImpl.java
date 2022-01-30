package com.datastructure.assignment.question2.skewedBST.service;

import com.datastructure.assignment.question2.skewedBST.util.BinarySearchTree;
import com.datastructure.assignment.question2.skewedBST.util.BinarySearchTree.Node;

public class SkewedBSTServiceImpl {

	public Node headNode;
	public Node previousNode;

	public void rightSkewBST(Node root) {

		if (root == null) {
			return;
		}
		rightSkewBST(root.left);
		if (headNode == null) {
			headNode = root;
			root.left = null;
			previousNode = root;
		} else {
			previousNode.right = root;
			root.left = null;
			previousNode = root;
		}
		rightSkewBST(root.right);
	}

	public BinarySearchTree createBST(int[] inputArray) {
		return new BinarySearchTree(inputArray);
	}

	public void printRightSkewedBST(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		printRightSkewedBST(root.right);
	}

}
