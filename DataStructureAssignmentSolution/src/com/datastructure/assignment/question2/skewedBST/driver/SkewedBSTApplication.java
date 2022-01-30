package com.datastructure.assignment.question2.skewedBST.driver;

import com.datastructure.assignment.question2.skewedBST.service.SkewedBSTServiceImpl;
import com.datastructure.assignment.question2.skewedBST.util.BinarySearchTree;

public class SkewedBSTApplication {

	public static void main(String[] args) {
		int[] inputArray = { 50, 30, 10, 60, 55 };

		SkewedBSTServiceImpl skewedBSTServiceImpl = new SkewedBSTServiceImpl();
		BinarySearchTree bst = skewedBSTServiceImpl.createBST(inputArray);

		skewedBSTServiceImpl.rightSkewBST(bst.root);
		skewedBSTServiceImpl.printRightSkewedBST(skewedBSTServiceImpl.headNode);
	}

}
