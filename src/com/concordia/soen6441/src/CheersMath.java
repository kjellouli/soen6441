package com.concordia.soen6441.src;

public class CheersMath {
	
	private int precision;
	private double pi;
	private double alpha = 2.304129659127962;
	
	public CheersMath(int precision){
		this.precision = precision; // TODO: cast precision to long only, no double, string or float allowed
		this.pi = pi();
	}
	
	// Computing square root using Bablonian 
	protected double sqrt(double number) {
	    double x = number;
	    double y = 1;
	    double e = 0.000000000001; // for accuracy level
	    while (x - y > e) {
	        x = (x + y) / 2;
	        y = number / x;
	    }
	    return x;
	}
	
	protected int factorial(int n){
	    if(n == 0)
	        return 1;
	    else 
	        return n * factorial(n-1);
	}
	
	protected double degToRad(double deg) {
		return deg / 180.0 * pi;
	}
	
	protected double round(double nb){
		double prec = 10^this.precision;
//		if(precision != null)
//			prec = 2;
		nb *= prec;
		nb = (int) nb;
		nb /= prec;
		return nb;
	}
	
	// 1 - x^2/2! + x^4/4! - x^6/6! + ...
	// Computing cos(x) using Taylor Series
	protected double cos(double x) {
	    double cosValue = 1.0, power = 1.0;
	    int n = 2, factorial = 1;
	    while (n <= this.precision) {
	        power = power * x * x * -1;
	        factorial = factorial * n * (n-1);
	        cosValue = cosValue + (power / factorial);
	        n = n + 2;
	    }
	    return cosValue;
	}
	
	// 4(1 - 1/3 + 1/5 - 1/7 + ...)
	// Gregory–Leibniz
	// http://functions.wolfram.com/Constants/Pi/02/
	protected double pi() {
	    double piValue = 0, flip = -1, prec = 1000000000;
	    int n = 1;
	    while (n <= prec) {
	    	flip = -1 * flip;
	        piValue = piValue + (flip / n);
	        n = n + 2;
	    }
	    return 4 * piValue;
	}
	
	// http://mathcentral.uregina.ca/QQ/database/QQ.09.00/roble1.html
	// using Newton's method, we can solve f(x) = sin(alpha) - alpha + pi/2 when f(x) = 0
	// Wolfram alpha gives 2.3098814600100572609 https://www.wolframalpha.com/input/?i=alpha+-+sin+alpha+%3D+pi+%2F2
	protected double alpha(){
		double alpha = 1.0;
		for(int i=0; i<100; i++){ // after 78th iteration, it converges to 2.304129659127962
			alpha = alpha - ((pi/2 - alpha + sin(alpha))/(-1 + cos(alpha)));
		}
		return alpha; // 2.304129659127962
	}
	
	// Computing sin(x) using Taylor Series
	protected double sin(double x){		
        double term = 1.0;
        double sum  = 0.0;
        x = x % (2 * pi); //converts value to an angle between negative 2 pi to positive 2 pi

        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) sum += term;
            if (i % 4 == 3) sum -= term;
        }
        return round(sum);
	}
	
	//	L = 2R(1 – cos(α/2))
	//	α – sin(α) = π/2.
	public double length(double radius){
		this.precision = 2;
		return round(2 * radius * (1 - cos(alpha/2))); 
	}
}
