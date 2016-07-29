package com.concordia.soen6441.incarnation2;

/**
 * The Class CheersXML_I2 responsible to generate XML format of output.
 * @author m_japa
 *
 */
public class CheersXML_I2 {

	/**
	 * Generate XML.
	 *
	 * @param radius
	 *            the radius
	 * @param precision
	 *            the precision
	 * @param precisionOutput
	 *            the precision output
	 * @param output
	 *            the output
	 * @return true, if successful
	 */
	public static boolean generateXML(double radius, int precision, int precisionOutput, String output) {
		boolean x = false;
		try {
			System.out.println("<?xml version=" + "\"1.0\"" + " encoding=" + "\"UTF-8\"" + "?>");
			System.out.println("<!DOCTYPE cheers [");
			System.out.println("<!ELEMENT cheers (input,output)>");
			System.out.println("<!ELEMENT input (radius,intermediateprecision,lengthprecision)>");
			System.out.println("<!ELEMENT output (length)>");
			System.out.println("<!ELEMENT radius (#PCDATA)>");
			System.out.println("<!ELEMENT intermediateprecision (#PCDATA)> ");
			System.out.println("<!ELEMENT lengthprecision (#PCDATA)> ");
			System.out.println("<!ELEMENT length (#PCDATA)>");
			System.out.println("<!ATTLIST radius type CDATA #IMPLIED>");
			System.out.println("<!ATTLIST intermediateprecision type CDATA #IMPLIED>");
			System.out.println("<!ATTLIST lengthprecision type CDATA #IMPLIED>");
			System.out.println("<!ATTLIST length type CDATA #IMPLIED>");
			System.out.println("]>");
			System.out.println("<cheers>");
			System.out.println("\t<input>");
			System.out.println("\t\t<radius type=" + "\"double\"" + ">" + radius + "</radius>");
			System.out.println(
					"\t\t<intermediateprecision  type=" + "\"int\"" + ">" + precision + "</intermediateprecision>");
			System.out
					.println("\t\t<lengthprecision  type=" + "\"int\"" + ">" + precisionOutput + "</lengthprecision>");
			System.out.println("\t</input>");
			System.out.println("\t<output>");
			System.out.println("\t\t<length  type=" + "\"double\"" + ">" + output + "</length>");
			System.out.println("\t</output>");
			System.out.println("</cheers>");
			x = true;
		} catch (Exception e) {
			System.out.println("XML cannot be generated. Please try again..!");
		}
		return x;
	}
}
