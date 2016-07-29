package com.concordia.soen6441.incarnation2;

public class CheersMath_I2 {

	private int precision;
	private int precisionOutput;
	private double radius;
	private double pi;

	public CheersMath_I2(double radius, int precision, int precisionOutput) throws CheersException_I2 {
		if(radius < 0)
			throw new CheersException_I2("The Radius cannot be negative.");
		if(precision < 0)
			throw new CheersException_I2("The Precision value cannot be negative.");
		if(precisionOutput < CheersConfig_I2.PRECISION_OUTPUT_MIN || precisionOutput > CheersConfig_I2.PRECISION_OUTPUT_MAX)
			throw new CheersException_I2("The Precision value must be between "+CheersConfig_I2.PRECISION_OUTPUT_MIN+" and "+CheersConfig_I2.PRECISION_OUTPUT_MAX+".");
		try{
			this.precision = precision; // TODO: cast precision to long only, no double, string or float allowed
			this.radius = radius;
			this.pi = getPi();
		} catch (NumberFormatException e) {
			System.out.println("The Radius or Precision have the wrong number format.");
		}
	}

	//Convertion of degree to radians
	protected double convertDegreeToRadian(double deg) {
		return (deg*Math.PI)/CheersConfig_I2.STRAIGHT_ANGLE_SIZE;
	}
	
	
	// Precision of intermediate calculations are rounded up to number of decimal places selected by user
	protected double roundIntermediate(double nb) {
		double prec = Math.pow(10, precision);
		nb *= prec;
		nb = (int) Math.round(nb);
		nb /= prec;
		return nb;
	}
	
	
	// Precision of Output value is rounded up to number of decimal places selected by user
	protected double roundOutput(double nb){
		int prec = 10^precisionOutput;
		nb *= prec;
		nb = (int) nb;
		nb /= prec;
		return nb;
	}

	// To get cosine value using built-in method
	protected double getCos(double x) {
		double sum = Math.cos(x);
		return sum;
	}

	//To get Pi value using java library
	protected double getPi() {
		double piValue =  Math.PI;
		return piValue;
	}

	// http://mathcentral.uregina.ca/QQ/database/QQ.09.00/roble1.html
	// using Newton's method, we can solve f(x) = sin(alpha) - alpha + pi/2 when
	// f(x) = 0
	protected double getAlpha() {
		double alpha = 1.0;
		for (int i = 0; i < CheersConfig_I2.ALPHA_ITERATIONS; i++) { // after 78th iteration, it converges to
										// 2.304129659127962
			alpha = alpha - ((Math.PI / 2 - alpha + getSin(alpha)) / (-1 + getCos(alpha))); // next x = current x - fx/fx'
		}
		return roundIntermediate(alpha); // 2.304129659127962
	}

	//To get sine value using built-in method
	protected double getSin(double x) {
		double sum = Math.sin(x);
		return roundIntermediate(sum);
	}

	//l = 2R(1 – cos(α/2)), 
	// α – sin(α) = π/2. 
	public double getLength() throws CheersException_I2{
		double cosValue = getCos(CheersConfig_I2.ALPHA / 2);
		return roundOutput(2 * radius * (1 - cosValue));
	}
}
