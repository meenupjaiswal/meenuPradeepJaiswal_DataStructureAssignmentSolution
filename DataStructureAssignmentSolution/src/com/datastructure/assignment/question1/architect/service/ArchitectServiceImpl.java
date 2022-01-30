package com.datastructure.assignment.question1.architect.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ArchitectServiceImpl {

	private static Queue<Integer> floorInput;
	private static Queue<Integer> floorRefDesc = new LinkedList<Integer>();
	private static Set<Integer> floorsCompleted = new HashSet<Integer>();

	private static void loadReferenceData(final int noOfFloors) {
		// Adds number of floors in descending order
		clearData();
		for (int i = noOfFloors; i > 0; i--)
			floorRefDesc.add(i);
	}

	public static void loadFloorWiseData(final int noOfFloors, final Scanner inputScan) throws Exception {
		loadReferenceData(noOfFloors);
		floorInput = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= noOfFloors; i++) {
			System.out.println("Enter the floor size given on day " + i);
			int floorSize = inputScan.nextInt();
			if (set.add(floorSize)) {
				floorInput.add(floorSize);
			} else {
				throw new Exception("The floor size already exists! Please enter valid values.");
			}
		}
		calculateAndDisplayOrder();
	}

	private static void calculateAndDisplayOrder() {
		System.out.println("\r\nThe order of construction is as follows:");
		int floorCount = floorRefDesc.size();
		int referenceData = 0;
		for (int i = 1; i <= floorCount; i++) {
			System.out.println("\r\nDay " + i + ":");
			if (floorInput.peek() < floorRefDesc.peek()) {
				floorsCompleted.add(floorInput.poll());
			} else {
				displayFloorNumber(referenceData);
				floorInput.poll();
			}
		}
	}

	private static void displayFloorNumber(int referenceData) {
		referenceData = floorRefDesc.poll();
		System.out.print(referenceData + " ");
		floorsCompleted.remove(referenceData);
		referenceData = floorRefDesc.peek() != null ? floorRefDesc.peek() : 0;
		if (floorsCompleted.contains(referenceData))
			displayFloorNumber(referenceData);
	}

	private static void clearData() {
		floorRefDesc.clear();
		floorsCompleted.clear();
	}

}
