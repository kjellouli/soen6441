package com.concordia.soen6441.incarnation2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class TestCheersMath_I2.
 */
public class TestCheersMath_I2 {
	
	CheersMath_I2 obj1,obj2;
	
	/**
	 * Test cheers math I 2.
	 *
	 * @throws CheersException_I2
	 *             the cheers exception I 2
	 */
	@Before
	public void testCheersMath_I2() throws CheersException_I2 {
		
		obj1 = new CheersMath_I2(2.725, 2, 4);
		obj2 = new CheersMath_I2(2.725, 2, 4);
	}

	/**
	 * Test convert degree to radian.
	 */
	@Test
	public void testConvertDegreeToRadian() {
		assertEquals(1.57, obj2.convertDegreeToRadian(90),0);
		assertNotNull(obj1.convertDegreeToRadian(90));
		assertNotEquals(obj1.convertDegreeToRadian(90), obj2.convertDegreeToRadian(91));
	}

	/**
	 * Test rounding intermediate calculations.
	 */
	@Test
	public void testRoundIntermediate() {
		assertEquals(2.98, obj2.roundIntermediate(2.977756622),0);
		Assert.assertNotEquals(obj1.roundIntermediate(2.989), obj2.roundIntermediate(2.982));
	}

	/**
	 * Test rounding output value.
	 */
	@Test
	public void testRoundOutput() {
		assertEquals(1.7438, obj2.roundOutput(1.743760128),0);
		assertNotEquals(obj1.roundOutput(2.98910452), obj2.roundOutput(2.988086291));
	}

	/**
	 * Test get cos value.
	 */
	@Test
	public void testGetCos() {
		assertEquals(0.41, obj2.getCos(CheersConfig_I2.ALPHA/2),0);
		assertNotNull(obj1.getCos(CheersConfig_I2.ALPHA/2));
		assertEquals(-0.67, obj2.getCos(CheersConfig_I2.ALPHA),0);
		assertNotNull(obj1.getCos(CheersConfig_I2.ALPHA));
	}

	/**
	 * Test get pi value.
	 */
	@Test
	public void testGetPi() {
		assertEquals(3.14, obj1.getPi(),0);
		assertNotNull(obj1.getPi());
	}

	/**
	 * Test get alpha value.
	 */
	@Test
	public void testGetAlpha() {
		assertEquals(2.31, obj1.getAlpha(),0);
		assertNotNull(obj1.getAlpha());
	}

	/**
	 * Test get sin value.
	 */
	@Test
	public void testGetSin() {
		assertEquals(0.74, obj2.getSin(CheersConfig_I2.ALPHA),0);
		assertNotNull(obj1.getSin(CheersConfig_I2.ALPHA));
		assertNotEquals(obj1.getSin(CheersConfig_I2.ALPHA/2), obj2.getSin(CheersConfig_I2.ALPHA));
	}

	/**
	 * Test get length of overlap between two coasters.
	 *
	 * @throws CheersException_I2
	 *             the cheers exception I 2
	 */
	@Test
	public void testGetLength() throws CheersException_I2 {
		assertEquals(3.2155, obj2.getLength(),0);
		assertNotNull(obj1.getLength());
		
	}

}
