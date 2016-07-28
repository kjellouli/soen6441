package com.concordia.soen6441.ui;

import com.concordia.soen6441.src.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheersUi {

	public static void main(String args[]) throws CheersException {
		try {
			double radius = 0;
			int precision = 0;
			int precisionOutput = 0;
			int operation = 0;
			// Get user input
			while (true) {
				InputStreamReader is = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);

				System.out.println("Please choose one of the operations below: (1 or 2)");
				System.out.println("1. Calculate Length between the two coasters");
				System.out.println("2. Exit");
				try {
					operation = Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid operation type.");
				}

				if (operation == CheersConfig.OPERATION_CALCULATE || operation == CheersConfig.OPERATION_EXIT) {
					switch (operation) {
						case CheersConfig.OPERATION_CALCULATE:
							System.out.println("Please enter the Radius:");
							// TODO: make parseFloat native and control radius not
							// to be
							// too much small or big
							// check from Internet what is the smallest-biggest size
							// to
							// add as fact
							// TODO: Come up with our own decimal format function
							radius = Double.parseDouble(br.readLine());
							System.out.println("Please enter the precision of intermediate values calculation:");
							precision = Integer.parseInt(br.readLine());
							System.out.println("Please enter the precision for the output:");
							precisionOutput = Integer.parseInt(br.readLine());
							System.out.println("Calculating the length. Please wait...");
							CheersMath cheersMath = new CheersMath(radius, precision, precisionOutput);
							System.out.println("The two coasters need to be moved " + cheersMath.getLength()
									+ " inch far from each other");
	
						case CheersConfig.OPERATION_EXIT:
							System.out.println("Program Cheers Ended!");
							System.exit(0);
					}
				}
				else{
					System.out.println("Operation not found. Available choices are 1 and 2 only.");
				}
			}
		} catch (Exception e) {
			System.out.println("Cheers UI Exception: " + e);
		} finally {
			System.out.println("Program ended");
		}
	}

}
