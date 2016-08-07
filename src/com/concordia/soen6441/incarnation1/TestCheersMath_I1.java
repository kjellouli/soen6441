package com.concordia.soen6441.incarnation1;

import org.junit.*;
import org.junit.Test;

import com.concordia.soen6441.incarnation2.CheersConfig_I2;


/**
 * The Class TestCheersMath_I1.
 */
public class TestCheersMath_I1 {

	/** The b. */
	CheersMath_I1 obj;
	
	
	/**
	 * Initialize.
	 *
	 * @throws CheersException_I1
	 *             the cheers exception I 1
	 */
	@Before
	public void initialize() throws CheersException_I1
	{
		obj = new CheersMath_I1(3, 1, 2);
	}
	
	/**
	 * Test convert degree to radian.
	 *
	 * @throws CheersException_I1
	 *             the cheers exception I 1
	 */
	@Test
	public void testConvertDegreeToRadian() throws CheersException_I1 {
		Assert.assertEquals(1.7, obj.convertDegreeToRadian(100),0);
		Assert.assertNotNull(obj.convertDegreeToRadian(100));
		Assert.assertNotEquals(obj.convertDegreeToRadian(90), obj.convertDegreeToRadian(40), 0);
	}
	
	/**
	 * Test rounding intermediate calculations.
	 */
	@Test
	public void testroundIntermediate()
	{
		Assert.assertEquals(1.0, obj.roundIntermediate(1.012568),0);
		Assert.assertNotNull(obj.roundIntermediate(1.012568));
	}
	
	/**
	 * Test rounding output value.
	 */
	@Test
	public void testRoundOutput()
	{
		Assert.assertEquals(3.0, obj.roundOutput(3.00001),0);
		Assert.assertNotNull(obj.roundOutput(3.00001));
	}
	
	/**
	 * Test the cos value.
	 *
	 * @return the cos value
	 */
	@Test
	public void testGetCos()
	{
		Assert.assertEquals(0.4,obj.getCos(CheersConfig_I2.ALPHA / 2),0);
		Assert.assertNotNull(obj.getCos(CheersConfig_I2.ALPHA / 2));
		Assert.assertEquals(-0.6,obj.getCos(CheersConfig_I2.ALPHA),0);
		Assert.assertNotNull(obj.getCos(CheersConfig_I2.ALPHA));
	}
	
	/**
	 * Test the pi value.
	 *
	 * @return the pi value
	 */
	@Test
	public void testGetPi()
	{
		Assert.assertEquals(3.1, obj.getPi(),0);
		Assert.assertNotNull(obj.getPi());
	}
	
	/**
	 * Test the alpha value.
	 *
	 * @return the alpha value
	 */
	@Test
	public void testGetAlpha()
	{
		Assert.assertEquals(2.2, obj.getAlpha(),0);
		Assert.assertNotNull(obj.getPi());
	}
	
	/**
	 * Test the sin value.
	 *
	 * @return the sin value
	 */
	@Test
	public void testGetSin()
	{
		Assert.assertEquals(0.7, obj.getSin(CheersConfig_I1.ALPHA),0);
		Assert.assertNotNull(obj.getSin(CheersConfig_I1.ALPHA));
	}
	
	/**
	 * Test the length of overlap between the two coasters.
	 *
	 * @return the length
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetLength() throws Exception
	{
		Assert.assertEquals(3.59, obj.getLength(),0);
		Assert.assertNotNull(obj.getLength());
	}
	
	
}
