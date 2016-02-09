import java.math.*;
public class Recursion{
	public String name(){
		return "Agarwala,Vandana";
	}
	public static double GetSquareRoot(double n, double low, double high) {
	    double errorMargin = 0.0000001;
	    double sqrt = (low + high) / 2;
	    double diff = sqrt*sqrt - n;
	    if ( diff > errorMargin)
	        return GetSquareRoot(n, low, sqrt);
	    if ( -diff > errorMargin)
	        return GetSquareRoot(n, sqrt, high);
	    return sqrt;
	}
	public double sqrt(double n){
		if (n < 0){
			throw new IllegalArgumentException();
		}
		return GetSquareRoot(n, 0, n);
	}
}