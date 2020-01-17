
import java.util.ArrayList;
import java.util.Scanner;

class PrimeFactorizerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer input = null;
        try{
            System.out.print("Please enter an integer to compute the Prime Factorization: ");
            input = sc.nextInt();
        }catch (Exception e) {
            System.out.println("ERROR: Parsing input error. Please be sure to enter integers as inputs");
            System.exit(0);
        }
        PrimeFactorizer pf = new PrimeFactorizer(input);
        pf.compute();
        System.out.println(pf.toString());
        System.out.println("---");
        try{
            System.out.print("Please enter an integer to compute the Prime Factorization: ");
            input = sc.nextInt();
        }catch (Exception e) {
            System.out.println("ERROR: Parsing input error. Please be sure to enter integers as inputs");
            System.exit(0);
        }
        ArrayList<Integer> p = new ArrayList();
        ArrayList<Integer> e = new ArrayList();
        pf.getFactorsAndExponents(input,p,e);
        System.out.println(pf.toString());
        System.out.println("Primes: ");
        for (Integer integer : p) {
            System.out.print(integer + " ");
        }
        System.out.println("\nExponents");
        for (Integer integer : e) {
            System.out.print(integer + " ");
        }
    }
}
