import java.util.ArrayList;

public class PrimeFactorizer {

    private int n = 0;
    private ArrayList<Integer> internalPrimes = new ArrayList();
    private ArrayList<Integer> internalExponents = new ArrayList();

    /**
     * Initialize the object with target number n.
     */
    public PrimeFactorizer(int n) {
        this.n = n;
    }

    /**
     * Return n, the target number.
     */
    public int getN() {
        return n;
    }

    /**
     * Compute factorization. Do not repeat operation if it was called before.
     * Algorithm:
     * The objective here is to find all the prime numbers that multiple together to to reach n. To do this
     * we will start with 2 and try to find if it can evenly divide into N with only hole numbers remaining.
     * When then happens we will save that number off and reset this divisor back to 2 and try over again.
     * When the number doesnt meet the division criteria then this divisor gets incremented by 1.
     */
    public void compute() {

        //Start with 2 and keep dividing until we have whole numbers. then restart at 2 again
        int left = n;
        while (left > 0) {
            for (int i = 2; i <= left; i++) {
                //Check to see if we have ant decimal places. If no decimal places then we have found a valid number
                double test = ((double) left / (double) i);
                if (test % 1 == 0) {
                    //Corner case where we have come to the end of the for loop and we can evenly divide whats left
                    // meaning we have found the last possible divider
                    if (left == i) {
                        addPrimeToList(left);
                        left = 0;
                    } else {
                        addPrimeToList(i);
                        left = left / i;
                    }
                    break;
                }
            }
        }
    }

    /**
     * This helper function is used to effectively store the factors and ensuring that the exponents have been correctly
     * set or incremented.
     *
     * @param factor prime factor to be added to lists
     */
    private void addPrimeToList(int factor) {
        int primeIndex = internalPrimes.indexOf(factor);
        if (primeIndex == -1) {
            internalPrimes.add(factor);
            internalExponents.add(1);
        } else {
            internalExponents.set(primeIndex, internalExponents.get(primeIndex) + 1);
        }
    }


    /**
     * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the constructor.
     *
     * @param n the number that is requested to find the prime factorization
     * @param primes list of primes that can evenly be multiplied to create N. This list is populated and returned
     * @param exponents list of exponents that that would be used in conjunction with the primes list to create N.
     *                  This list is populated and returned
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
        //Only compute if n is different or if Compute hasnt happen yet
        if (n != this.n || this.internalPrimes.size() <= 0) {
            this.n = n;
            internalPrimes.clear();
            internalExponents.clear();
            compute();
        }
        primes.addAll(this.internalPrimes);
        exponents.addAll(this.internalExponents);
    }


    /**
     * Return a string with the "pretty" representation of the prime factorization.
     * For instance, if n is 60, then toString() for the PrimeFactorizer(60) object
     * should be "60 = 2^2*3*5". Call compute() if not done before.
     */
    public String toString() {
        StringBuilder primeFactorStr;
        primeFactorStr = new StringBuilder();
        primeFactorStr.append(n).append(" = ");
        for (int i = 0; i < internalPrimes.size(); i++) {
            primeFactorStr.append(internalPrimes.get(i).toString());
            if (internalExponents.get(i) > 1) {
                primeFactorStr.append("^").append(internalExponents.get(i).toString());
            }

            if (i != internalPrimes.size() - 1) {
                primeFactorStr.append("*");
            }

        }
        return primeFactorStr.toString();
    }

    // other code, helper functions, etc.
}