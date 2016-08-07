package com.concordia.soen6441.incarnation1;

public class CheersTest extends CheersMath_I1{

	private static final double RADIUS = 3.5;
	private static final int PRECISION = 2;
	private static final int PRECISIONOUTPUT = 4;
	private static final boolean TEST_COS = true;
	private static final boolean TEST_SIN = true;
	private static final boolean TEST_PI = true;
	private static final boolean TEST_ALPHA = true;
	static CheersTest test;
	static CheersMath_I1 mathObj;
	
	public CheersTest(double radius, int precision,int precisionOutput) throws CheersException_I1 {
		super(radius, precision,precisionOutput);
		mathObj = new CheersMath_I1(RADIUS, PRECISION, PRECISIONOUTPUT);
	}
	
	private static void compareCos(double angdeg) {
		System.out.println("Test - Comparing Cos("+angdeg+") in Cheers and Native\n");
		double rad = test.convertDegreeToRadian(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaCos   = " + mathObj.roundIntermediate(Math.cos(rad)));
		System.out.println("cheersCos = " + mathObj.getCos(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void compareSin(double angdeg) {
	
		System.out.println("Test - Comparing Sin("+angdeg+") in Cheers and Native\n");
		double rad = test.convertDegreeToRadian(angdeg);
		System.out.println("rad       = " + rad);
		System.out.println("deg       = " + angdeg);
		System.out.println("javaSin   = " + mathObj.roundIntermediate(Math.sin(rad)));
		System.out.println("cheersSin = " + mathObj.getSin(rad));
		System.out.println("=======================================\n");
	}	
	
	private static void comparePi() {
		System.out.println("Test - Comparing PI in Cheers and Native\n");
		System.out.println("javaPi   = " + mathObj.roundIntermediate(Math.PI));
		System.out.println("cheersPi = " + mathObj.getPi());
		System.out.println("=======================================\n");
	}
	
	private static void showAlpha() {
		System.out.println("Test - Compute alpha value in Cheers\n");
		System.out.println("cheersAlpha = " + mathObj.getAlpha());
		System.out.println("=======================================\n");
	}

	public static void main(String args[]) throws CheersException_I1 {

		test = new CheersTest(RADIUS, PRECISION,PRECISIONOUTPUT);
		try {
			if(TEST_COS)
					compareCos(66);
			if(TEST_SIN)
					compareSin(132);
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
