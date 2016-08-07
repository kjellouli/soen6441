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
	
	CheersMath_I2 a,b;
	
	/**
	 * Test cheers math I 2.
	 *
	 * @throws CheersException_I2
	 *             the cheers exception I 2
	 */
	@Before
	public void testCheersMath_I2() throws CheersException_I2 {
		
		a = new CheersMath_I2(2.725, 2, 4);
		b = new CheersMath_I2(2.725, 2, 4);
	}

	/**
	 * Test convert degree to radian.
	 */
	@Test
	public void testConvertDegreeToRadian() {
		assertEquals(1.57, b.convertDegreeToRadian(90),0);
		assertNotNull(a.convertDegreeToRadian(90));
		assertNotEquals(a.convertDegreeToRadian(90), b.convertDegreeToRadian(91));
	}

	/**
	 * Test rounding intermediate calculations.
	 */
	@Test
	public void testRoundIntermediate() {
		assertEquals(2.98, b.roundIntermediate(2.977756622),0);
		Assert.assertNotEquals(a.roundIntermediate(2.989), b.roundIntermediate(2.982));
	}

	/**
	 * Test rounding output value.
	 */
	@Test
	public void testRoundOutput() {
		assertEquals(1.7438, b.roundOutput(1.743760128),0);
		assertNotEquals(a.roundOutput(2.98910452), b.roundOutput(2.988086291));
	}

	/**
	 * Test get cos.
	 */
	@Test
	public void testGetCos() {
		assertEquals(0.41, b.getCos(CheersConfig_I2.ALPHA/2),0);
		assertNotNull(a.getCos(CheersConfig_I2.ALPHA/2));
		assertEquals(-0.67, b.getCos(CheersConfig_I2.ALPHA),0);
		assertNotNull(a.getCos(CheersConfig_I2.ALPHA));
	}

	/**
	 * Test get pi.
	 */
	@Test
	public void testGetPi() {
		assertEquals(3.14, a.getPi(),0);
		assertNotNull(a.getPi());
	}

	/**
	 * Test get alpha.
	 */
	@Test
	public void testGetAlpha() {
		assertEquals(2.31, a.getAlpha(),0);
		assertNotNull(a.getAlpha());
	}

	/**
	 * Test get sin.
	 */
	@Test
	public void testGetSin() {
		assertEquals(0.74, b.getSin(CheersConfig_I2.ALPHA),0);
		assertNotNull(a.getSin(CheersConfig_I2.ALPHA));
		assertNotEquals(a.getSin(CheersConfig_I2.ALPHA/2), b.getSin(CheersConfig_I2.ALPHA));
	}

	/**
	 * Test get length of overlap between two coasters.
	 *
	 * @throws CheersException_I2
	 *             the cheers exception I 2
	 */
	@Test
	public void testGetLength() throws CheersException_I2 {
		assertEquals(3.2155, b.getLength(),0);
		assertNotNull(a.getLength());
		
	}

}
