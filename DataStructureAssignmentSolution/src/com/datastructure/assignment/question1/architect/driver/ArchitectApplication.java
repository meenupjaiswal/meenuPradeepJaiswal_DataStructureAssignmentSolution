package com.datastructure.assignment.question1.architect.driver;

import java.util.Scanner;

import com.datastructure.assignment.question1.architect.service.ArchitectServiceImpl;

public class ArchitectApplication {

	public static void main(String[] args) throws Exception {
		startApplication();
	}

	private static void startApplication() {
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building\r\n");
		int noOfFloors = inputScan.nextInt();
		try {
			ArchitectServiceImpl.loadFloorWiseData(noOfFloors, inputScan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			inputScan.close();
		}

	}

}
