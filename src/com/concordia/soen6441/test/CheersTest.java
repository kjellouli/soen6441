package com.concordia.soen6441.test;

import java.lang.Math;

import com.concordia.soen6441.incarnation1.*;

public class CheersTest extends CheersMath_I1{

	private static final double RADIUS = 5.0;
	private static final int PRECISION = 20;
	private static final int PRECISIONOUTPUT = 2;
	private static final boolean TEST_COS = false;
	private static final boolean TEST_SIN = false;
	private static final boolean TEST_SQRT = false;
	private static final boolean TEST_PI = false;
	private static final boolean TEST_ALPHA = true;
	static CheersTest test;
	
	public CheersTest(double radius, int precision,int precisionOutput) throws CheersException_I1 {
		super(radius, precision,precisionOutput);
	}
	
	private static void compareCos(double angdeg) {
	
		System.out.println("Test - Comparing Cos("+angdeg+") in Cheers and Native\n");
		double rad = test.convertDegreeToRadian(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaCos   = " + Math.cos(rad));
		System.out.println("cheersCos = " + test.getCos(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void compareSin(double angdeg) {
	
		System.out.println("Test - Comparing Sin("+angdeg+") in Cheers and Native\n");
		double rad = test.convertDegreeToRadian(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaSin   = " + Math.sin(rad));
		System.out.println("cheersSin = " + test.getSin(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void comparePi() {
		System.out.println("Test - Comparing PI in Cheers and Native\n");
		System.out.println("javaPi   = " + Math.PI);
		System.out.println("cheersPi = " + test.getPi());
		System.out.println("=======================================\n");
	}
	
	private static void showAlpha() {
		System.out.println("Test - Compute alpha value in Cheers\n");
		System.out.println("cheersAlpha = " + test.getAlpha());
		System.out.println("=======================================\n");
	}

	public static void main(String args[]) throws CheersException_I1 {

		test = new CheersTest(RADIUS, PRECISION,PRECISIONOUTPUT);
		try {
			if(TEST_COS)
				for(int angle=0; angle<=90; angle+=30){
					compareCos(angle);
				}
			if(TEST_SIN)
				for(int angle=0; angle<=90; angle+=30){
					compareSin(angle);
				}
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
