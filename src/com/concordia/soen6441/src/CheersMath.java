package com.concordia.soen6441.src;

public class CheersMath {

	private int precision;
	private double radius;
	private double pi;
	
	private final static double alpha = 2.304129659127962;
	private final static int RADIUS_MIN = 2;
	private final static int RADIUS_MAX = 5;
	private final static double STRAIGHT_ANGLE_SIZE = 180.0;
	
	private final static double SQRT_PRECISION = 0.000000000001;
	private final static int PI_PRECISION = 1000000000;
	
	private final static int COS_ITERATIONS = 25;
	private final static int ALPHA_ITERATIONS = 100;

	public CheersMath(double radius, int precision) throws CheersException {
		if(precision < 0)
			throw new CheersException("The Precision value cannot be negative.");
		if(radius < RADIUS_MIN || radius > RADIUS_MAX)
			throw new CheersException("The Radius must be between 2 and 5.");
		try{
			this.precision = precision; // TODO: cast precision to long only, no double, string or float allowed
			this.radius = radius;
			this.pi = pi();
		} catch (NumberFormatException e) {
			System.out.println("The Radius or Precision have the wrong number format.");
		}
	}

	// Computing square root using the Babylonian method
	protected double sqrt(double number) {
		double x = number;
		double y = 1;
		double e = SQRT_PRECISION; // for accuracy level
		while (x - y > e) {
			x = (x + y) / 2;
			y = number / x;
		}
		return x;
	}

	protected int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	protected double convertDegreeToRadian(double deg) {
		return deg / STRAIGHT_ANGLE_SIZE * pi;
	}

	protected double round(double nb) {
		double prec = 10 ^ this.precision;
		nb *= prec;
		nb = (int) nb;
		nb /= prec;
		return nb;
	}
	
	protected double roundToTwo(double nb){
		int prec = 2;
		nb *= prec;
		nb = (int) nb;
		nb /= prec;
		return nb;
	}

	// 1 - x^2/2! + x^4/4! - x^6/6! + ...
	// Computing cos(x) using Taylor Series
	protected double cos(double x) {
		int i = 1;
		double sum = 1.0, term = 1.0;
		do {
			term = (term * (x / i));
			if (i % 2 == 0) {
				if (i % 4 == 0) {
					sum += term;

				} else {
					sum -= term;
				}
			}
			i++;
		} while (i <= COS_ITERATIONS);
		return sum;
	}

	// 4(1 - 1/3 + 1/5 - 1/7 + ...)
	// Gregory–Leibniz
	// http://functions.wolfram.com/Constants/Pi/02/
	protected double pi() {
		double piValue = 0, flip = -1, prec = PI_PRECISION;
		int n = 1;
		while (n <= prec) {
			flip = -1 * flip;
			piValue = piValue + (flip / n);
			n = n + 2;
		}
		return 4 * piValue;
	}

	// http://mathcentral.uregina.ca/QQ/database/QQ.09.00/roble1.html
	// using Newton's method, we can solve f(x) = sin(alpha) - alpha + pi/2 when
	// f(x) = 0
	protected double alpha() {
		double alpha = 1.0;
		for (int i = 0; i < ALPHA_ITERATIONS; i++) { // after 78th iteration, it converges to
										// 2.304129659127962
			alpha = alpha - ((pi / 2 - alpha + sin(alpha)) / (-1 + cos(alpha))); // next x = current x - fx/fx'
		}
		return alpha; // 2.304129659127962
	}

	// Computing sin(x) using Taylor Series
	protected double sin(double x) {
		double term = 1.0;
		int i = 0;
		double sum = 0.0;
		x = x % (2 * pi); // converts value to an angle between negative 2 pi to
							// positive 2 pi

		for (i = 1; term != 0.0; i++) {
			term *= (x / i);
			if (i % 4 == 1)
				sum += term;
			if (i % 4 == 3)
				sum -= term;
		}
		return round(sum);
	}

	// L = 2R(1 – cos(α/2))
	// α – sin(α) = π/2.
	public double getLength() throws CheersException{
		this.precision = 2;
		double cosValue = cos(alpha / 2);
		return roundToTwo(2 * radius * (1 - cosValue));
	}
}
