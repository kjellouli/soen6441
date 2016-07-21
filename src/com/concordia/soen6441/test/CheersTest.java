package com.concordia.soen6441.test;

import java.lang.Math;

import com.concordia.soen6441.src.*;

public class CheersTest extends CheersMath{

	private static final int PRECISION = 20;
	private static final boolean TEST_COS = false;
	private static final boolean TEST_SIN = false;
	private static final boolean TEST_SQRT = false;
	private static final boolean TEST_PI = false;
	private static final boolean TEST_ALPHA = true;
	static CheersTest test = new CheersTest(PRECISION);
	
	public CheersTest(int precision) {
		super(precision);
	}
	
	private static void compareCos(double angdeg) {
	
		System.out.println("Test - Comparing Cos("+angdeg+") in Cheers and Native\n");
		double rad = test.degToRad(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaCos   = " + Math.cos(rad));
		System.out.println("cheersCos = " + test.cos(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void compareSin(double angdeg) {
	
		System.out.println("Test - Comparing Sin("+angdeg+") in Cheers and Native\n");
		double rad = test.degToRad(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaSin   = " + Math.sin(rad));
		System.out.println("cheersSin = " + test.sin(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void comparePi() {
		System.out.println("Test - Comparing PI in Cheers and Native\n");
		System.out.println("javaPi   = " + Math.PI);
		System.out.println("cheersPi = " + test.pi());
		System.out.println("=======================================\n");
	}

	private static void compareSqrt(double nb) {
		System.out.println("Test - Comparing Sqrt in Cheers and Native\n");
		System.out.println("javaPi   = " + Math.sqrt(nb));
		System.out.println("cheersPi = " + test.sqrt(nb));
		System.out.println("=======================================\n");
	}
	
	private static void showAlpha() {
		System.out.println("Test - Compute alpha value in Cheers\n");
		System.out.println("cheersAlpha = " + test.alpha());
		System.out.println("=======================================\n");
	}

	public static void main(String args[]) throws CheersException {

		try {
			if(TEST_COS)
				for(int angle=0; angle<=90; angle+=30){
					compareCos(angle);
				}
			if(TEST_SIN)
				for(int angle=0; angle<=90; angle+=30){
					compareSin(angle);
				}
			if(TEST_SQRT)
				compareSqrt(16);
			
			if(TEST_PI)
				comparePi();
			
			if(TEST_ALPHA)
				showAlpha();
		}
		catch (Exception e) {
			System.out.println("Cheers Test Exception: " + e);
		}
		finally{
			System.out.println("Test Ended Successfully!");	
		}
	}
}
