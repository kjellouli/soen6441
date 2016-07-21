package com.concordia.soen6441.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.concordia.soen6441.src.*;

public class CheersUi {

	public static void main(String args[]) throws CheersException {
		try {
			float radius = 0;
			int precision = 0;
			// Get user input
			while (true) {
				InputStreamReader is = new InputStreamReader(System. in );
				BufferedReader br = new BufferedReader(is);
				System.out.println("Please enter the Radius:");
				try{
					 // TODO: make parseFloat native and control radius not to be too much small or big 
					// check from internet what is the smallest-biggest size to add as fact
					radius = Float.parseFloat(br.readLine());
					System.out.println("Please enter the Precision:");
					precision = Integer.parseInt(br.readLine());
					CheersMath cheersMath = new CheersMath(precision); 
					System.out.println("The two coasters need to be moved " + cheersMath.length(radius) + " inch far from each other");
				}
				catch(NumberFormatException e){
					System.out.println("Wrong Number Format");
				}
			}
		}
		catch (Exception e) {
			System.out.println("Cheers UI Exception: " + e);
		}
		finally{
			System.out.println("Program ended");	
		}
	}
}
