import java.util.ArrayList;

public class PrimeFactorizer {

    private int n = 0;
    private ArrayList<Integer> primes = new ArrayList();
    private ArrayList<Integer> exponents = new ArrayList();

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
        int primeIndex = primes.indexOf(i);
        if (primeIndex == -1) {
            primes.add(i);
            exponents.add(1);
        } else {
            exponents.set(primeIndex, exponents.get(primeIndex) + 1);
        }
    }

    /**
     * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the constructor.
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {

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
        for (int i = 0; i < primes.size(); i++) {
            primeFactorStr.append(primes.get(i).toString());
            if (exponents.get(i) > 1) {
                primeFactorStr.append("^").append(exponents.get(i).toString());
            }

            if (i != primes.size() - 1) {
                primeFactorStr.append("*");
            }

        }
        return primeFactorStr.toString();
    }

    // other code, helper functions, etc.
}