package com.concordia.soen6441.src;

public class CheersMath {
	
	private int precision;
	private double pi;
	
	public CheersMath(int precision){
		this.precision = precision; // TODO: cast precision to long only, no double, string or float allowed
		this.pi = pi();
	}
	
	// Computing square root using Bablonian 
	protected double sqrt(double number) {
	    double x = number;
	    double y = 1;
	    double e = 0.000000000001; /* for accuracy level*/
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
//	    while (power/factorial != 0) {
	        power = power * x * x * -1;
//	        factorial = factorial(n);
	        factorial = factorial * n * (n-1);
//	        System.out.println(power/factorial);
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
	
	protected double alpha(){
//		for(double alpha = 0; alpha < 10000; alpha+=1){
		double alpha = 0.0;
		double piOverTwo = pi/2.0;
		double prec = 0.00001;
//		double rad = degToRad(alpha);
		while(alpha - sin(alpha) - piOverTwo != prec){
			System.out.println(alpha+" - sin("+alpha+")="+ (alpha - sin(alpha)) +", pi/2="+piOverTwo);
			if(alpha!= 0.0 && alpha - sin(alpha) - piOverTwo != prec){
				return alpha;
			}
			alpha += prec;
		}
		return 0;
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
	
	public double length(double radius){
//		L = 2R(1 – cos(α/2))
//		α – sin(α) = π/2.
		
		return 1; 
	}
}
