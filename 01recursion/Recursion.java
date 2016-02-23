public class Recursion{
    public String name() {
		return "Agarwala, Vandana";
    }

    public double sqrt(double n) {
		if (n < 0) {
		    throw new IllegalArgumentException();
		}
		return betterGuess(n,1);
    }


    public double betterGuess(double n, double guess) {
		if (n == 0) {
		    return 0;
		}
		if (Math.abs((n-guess*guess))/n < 0.00001) {
		    return guess;
		}
		guess = (n/guess+guess)/2;
		return betterGuess(n,guess);
    }

}