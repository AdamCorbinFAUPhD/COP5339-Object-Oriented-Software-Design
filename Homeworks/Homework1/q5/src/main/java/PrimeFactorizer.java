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
     */
    public void compute() {

        //Start with 2 and keep dividing until we have whole numbers. then restart at 2 again
        int left = n;
        while (left > 0) {
            System.out.println("Left:" + left);

            for (int i = 2; i <= left; i++) {
                double test = ((double) left / (double) i);
                if (test % 1 == 0) {

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

    private void addPrimeToList(int i) {
        int primeIndex = internalPrimes.indexOf(i);
        if (primeIndex == -1) {
            internalPrimes.add(i);
            internalExponents.add(1);
        } else {
            internalExponents.set(primeIndex, internalExponents.get(primeIndex) + 1);
        }
    }

    /**
     * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the constructor.
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
        if (n == this.n && this.internalPrimes.size() > 0) {
            primes = this.internalPrimes;
            exponents = this.internalExponents;
        }
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