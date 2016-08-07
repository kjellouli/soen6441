package com.concordia.soen6441.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.concordia.soen6441.incarnation1.TestCheersMath_I1;
import com.concordia.soen6441.incarnation2.TestCheersMath_I2;
import com.concordia.soen6441.incarnation2.TestCheersXML_I2;

/**
 * The Class AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestCheersMath_I2.class, TestCheersXML_I2.class, TestCheersMath_I1.class})
public class AllTests {
	
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		
	      Result result = JUnitCore.runClasses(TestCheersMath_I2.class, TestCheersXML_I2.class, TestCheersMath_I1.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }
	
}
