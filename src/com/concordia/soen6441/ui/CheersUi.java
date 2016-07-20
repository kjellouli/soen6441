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
				System.out.println("Enter the Radius and Precision:");
				try{
					radius = Float.parseFloat(br.readLine()); // TODO: make parseFloat native
//					precision = Integer.parseInt(br.readLine());
					precision = 100;
					CheersMath cheersMath = new CheersMath(precision); 
					System.out.println("length = " + cheersMath.length(radius));
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
