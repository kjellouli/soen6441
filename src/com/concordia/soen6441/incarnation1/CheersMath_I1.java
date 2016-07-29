package com.concordia.soen6441.incarnation1;
import com.concordia.soen6441.incarnation1.CheersConfig_I1;
import com.concordia.soen6441.incarnation2.CheersException_I2;

/**
 * The Class CheersMath_I1.
 */
public class CheersMath_I1 {

	private int precision;
	private int precisionOutput;
	private double radius;
	private double pi;

	/**
	 * Instantiates a new cheers math I 1.
	 *
	 * @param radius
	 *            the radius
	 * @param precision
	 *            the precision
	 * @param precisionOutput
	 *            the precision output
	 * @throws CheersException_I1
	 *             the cheers exception I 1
	 */
	public CheersMath_I1(double radius, int precision, int precisionOutput) throws CheersException_I1 {
		if(radius < CheersConfig_I1.RADIUS_MIN || radius > CheersConfig_I1.RADIUS_MAX)
			throw new CheersException_I1("The Radius value must be between "+CheersConfig_I1.RADIUS_MIN+" and "+CheersConfig_I1.RADIUS_MAX+".");
		if(precision < 0)
			throw new CheersException_I1("The Precision value cannot be negative.");
		if(precisionOutput < CheersConfig_I1.PRECISION_OUTPUT_MIN || precisionOutput > CheersConfig_I1.PRECISION_OUTPUT_MAX)
			throw new CheersException_I1("The Precision value must be between "+CheersConfig_I1.PRECISION_OUTPUT_MIN+" and "+CheersConfig_I1.PRECISION_OUTPUT_MAX+".");
		try{
			this.precision = precision; // TODO: cast precision to long only, no double, string or float allowed
			this.precisionOutput = precisionOutput;
			this.radius = radius;
			this.pi = getPi();
		} catch (NumberFormatException e) {
			System.out.println("The Radius or Precision have the wrong number format.");
		}
	}

	/**
	 * Convert degree to radian.
	 *
	 * @param deg
	 *            the deg
	 * @return the converted double value
	 */
	protected double convertDegreeToRadian(double deg) {
		return deg / CheersConfig_I1.STRAIGHT_ANGLE_SIZE * pi;
	}

	/**
	 * Round intermediate calculations to precision required by user.
	 *
	 * @param value
	 *            the value
	 * @return the rounded value of type double
	 */
	protected double roundIntermediate(double nb) {
		double prec = 1;
		for(int i=1;i<=this.precision;i++){
			prec = prec * 10;
		}
		nb =nb * prec;
		nb = (int) nb;
		nb = nb / prec;
		return nb;
	}
	
	/**
	 * Round output value to precision required by user.
	 *
	 * @param value
	 *            the value
	 * @return the rounded value of ype double
	 */
	protected double roundOutput(double nb){
		double prec = 1;
		for(int i=1;i<=precisionOutput;i++){
			prec = prec * 10;
		}
		nb = nb * prec;
		nb = (int) nb;
		nb = nb / prec;
		return nb;
	}

	/**
	 * Computes the cosine value.
	 *
	 * @param x
	 *            the x
	 * @return the rounded cos value
	 */
	// 1 - x^2/2! + x^4/4! - x^6/6! + ...
	// Computing cos(x) using Taylor Series
	protected double getCos(double x) {
		int i = 1;
		double sum = 1.0, term = 1.0;
		do {
			term = (term * (x / i));
			if (i % 2 == 0) {
				if (i % 4 == 0) {
					sum = sum + term;

				} else {
					sum = sum - term;
				}
			}
			i++;
		} while (i <= CheersConfig_I1.COS_ITERATIONS);
		return roundIntermediate(sum);
	}

	/**
	 * Computes the pi value.
	 *
	 * @return the rounded pi value
	 */
	// 4(1 - 1/3 + 1/5 - 1/7 + ...)
	// Gregory-Leibniz
	// http://functions.wolfram.com/Constants/Pi/02/
	protected double getPi() {
		double piValue = 0, flip = -1, prec = CheersConfig_I1.PI_PRECISION;
		int n = 1;
		while (n <= prec) {
			flip = -1 * flip;
			piValue = piValue + (flip / n);
			n = n + 2;
		}
		return roundIntermediate(4 * piValue);
	}

	/**
	 * Computes the alpha value.
	 *
	 * @return the rounded alpha value
	 */
	// http://mathcentral.uregina.ca/QQ/database/QQ.09.00/roble1.html
	// using Newton's method, we can solve f(x) = sin(alpha) - alpha + pi/2 when
	// f(x) = 0
	protected double getAlpha() {
		double alpha = 1.0;
		for (int i = 0; i < CheersConfig_I1.ALPHA_ITERATIONS; i++) { // after 78th iteration, it converges to
										// 2.304129659127962
			alpha = alpha - ((pi / 2 - alpha + getSin(alpha)) / (-1 + getCos(alpha))); // next x = current x - fx/fx'
		}
		return roundIntermediate(alpha); // 2.304129659127962
	}

	/**
	 * Computes the sin value.
	 *
	 * @param x
	 *            the x
	 * @return the rounded sin value
	 */
	// Computing sin(x) using Taylor Series
	protected double getSin(double x) {
		double term = 1.0;
		int i = 0;
		double sum = 0.0;
		x = x % (2 * pi); // converts value to an angle between negative 2 pi to
							// positive 2 pi

		for (i = 1; term != 0.0; i++) {
			term *= (x / i);
			if (i % 4 == 1)
				sum = sum + term;
			if (i % 4 == 3)
				sum = sum - term;
		}
		return roundIntermediate(sum);
	}

	/**
	 * Computes the length of overlap between two coasters.
	 *
	 * @return the length
	 * @throws CheersException_I2
	 *             the cheers exception I 2
	 */
	//l = 2R(1 – cos(α/2)), 
	// α – sin(α) = π/2.
	public double getLength() throws CheersException_I1{
		double cosValue = getCos(CheersConfig_I1.ALPHA / 2);
		return roundOutput(2 * radius * (1 - cosValue));
	}
}
