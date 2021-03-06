public class Fib {

    // constructor
    public Fib(int f0, int f1) {
        this.f0 = f0;
        this.f1 = f1;
    }


    /**
     * Here are the following steps this function will do:
     * 1. This main function expects to read in 3 arguments from the command line which will be f(0), f(1), and n.
     * 2. Fib object will be created passing in f(0) and f(1)
     * 3. Then using the f method, the fibonacci number will be computed for 0..n and printed out to the screen
     * 4. Then using the fRec method, the fibonacci number will be computed for 0..n and printed out to the screen
     *
     * @param args Expecting a list of 3 integers.
     *             1. will be f(0) which should be 0
     *             2. will be f(1) which should be 1
     *             3. will be n for the nth item that is desired to be computed
     */
    public static void main(String[] args) {

        // get numbers F(0) and F(1) from args[0] and args[1].
        // use either the Scanner class or Integer.parseInt(args[...])
        // you must handle possible exceptions !
        if (args.length != 3) {
            System.out.println("ERROR: Expecting to have 3 arguments[f(0),f(1),n]. You have only provided " + args.length + " arguments");
            System.exit(0);
        }

        int n = 0;
        int f0 = 0;
        int f1 = 0;
        try {
            f0 = Integer.parseInt(args[0]);
            f1 = Integer.parseInt(args[1]);

            // get n from args[2]:
            n = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("ERROR: Parsing Arguments error. Please be sure to enter 3 integers as inputs. Exiting");
            System.exit(0);
        }

        System.out.println(f0 + " " + f1 + " " + n);

        // create a Fib object with params F(0) and F(1)
        Fib fib = new Fib(f0, f1);


        // calculate F(0), ..., F(n) and display them with System.out.println(...) using
        // the iterative methode f(i)
        for (int i = 0; i < 11; i++) {
            System.out.println("Iterative fib for " + i + " is:" + fib.f(i));
        }
        System.out.println("---------------------");


        // calculate F(0), ..., F(n) and display them with System.out.println(...) using
        // the recursive methode fRec(i)
        for (int i = 0; i < 11; i++) {
            System.out.println("Recursive fib for " + n + " is:" + fib.fRec(i));
        }
    }

    /**
     * Computes F(n) using an ***iterative*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
     * Uses instance variables that store F(0) and F(1).
     *
     * @param n The nth Fib sequence that is desired to be computed
     * @return result of the nth fib sequence
     * @throws ArithmeticException when n less than 0
     */
    //
    // use instance variables that store F(0) and F(1).
    // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
    public int f(int n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("n less than 0");
        }

        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1;
        }

        int[] fibArray = new int[n + 1];
        fibArray[0] = f0;
        fibArray[1] = f1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[n];
    }

    /**
     * Computes F(n) using the ***recursive*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
     * Uses instance variables that store F(0) and F(1).
     *
     * @param n The nth Fib sequence that is desired to be computed
     * @return result of the nth fib sequence
     * @throws ArithmeticException when n less than 0
     */
    //
    // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
    public int fRec(int n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("n less than 0");
        }
        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1;
        } else {
            return fRec(n - 1) + fRec(n - 2);
        }
    }

    // instance variables store F(0) and F(1):
    public int f0;
    public int f1;
}