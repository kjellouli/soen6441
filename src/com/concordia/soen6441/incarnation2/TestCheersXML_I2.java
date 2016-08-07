package com.concordia.soen6441.incarnation2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class TestCheersXML_I2.
 */
public class TestCheersXML_I2 {
	
	/**
	 * Test generate XML.
	 */
	@Test
	public void testGenerateXML() {
		assertTrue(CheersXML_I2.generateXML(2.725, 2, 4,"3.2155"));
		assertEquals(true, CheersXML_I2.generateXML(2.725, 2, 4,"3.2155"));
	}

}
