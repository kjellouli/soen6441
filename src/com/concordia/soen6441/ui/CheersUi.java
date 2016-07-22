package com.concordia.soen6441.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.concordia.soen6441.src.CheersException;
import com.concordia.soen6441.src.CheersMath;

public class CheersUi {

	public static void main(String args[]) throws CheersException {
		try {
			double radius = 0;
			int precision = 0;
			// Get user input
			while (true) {
				InputStreamReader is = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);
				System.out.println("Please enter the Radius:");
				try {
					// TODO: make parseFloat native and control radius not to be
					// too much small or big
					// check from Internet what is the smallest-biggest size to
					// add as fact
					// TODO: Come up with our own decimal format function
					radius = Double.parseDouble(br.readLine());
					System.out.println("Please enter the Precision:");
					precision = Integer.parseInt(br.readLine());
					CheersMath cheersMath = new CheersMath(precision);
					DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
					df.setMaximumFractionDigits(340); // 340 is the DOUBLE_FRACTION_DIGITS
					System.out.println("The two coasters need to be moved " + df.format(cheersMath.length(radius))
							+ " inch far from each other");
				} catch (NumberFormatException e) {
					System.out.println("Wrong Number Format");
				}
			}
		} catch (Exception e) {
			System.out.println("Cheers UI Exception: " + e);
		} finally {
			System.out.println("Program ended");
		}
	}

}
