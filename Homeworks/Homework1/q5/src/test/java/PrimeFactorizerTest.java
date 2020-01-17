import java.util.ArrayList;

class PrimeFactorizerTest {
    public static void main(String[] args) {
        PrimeFactorizer primeFactorizer = new PrimeFactorizer(9);
        primeFactorizer.compute();
        System.out.println(primeFactorizer.toString());

        System.out.println("---");
        PrimeFactorizer p2 = new PrimeFactorizer(90);
        p2.compute();
        System.out.println(p2.toString());

        System.out.println("---");
        PrimeFactorizer p3 = new PrimeFactorizer(330);
        p3.compute();
        System.out.println(p3.toString());

        System.out.println("---");
        PrimeFactorizer p4 = new PrimeFactorizer(48);
        p4.compute();
        System.out.println(p4.toString());

        System.out.println("---");
        PrimeFactorizer p5 = new PrimeFactorizer(60);
        p5.compute();
        System.out.println(p5.toString());
        System.out.println("---");
        ArrayList<Integer> p = new ArrayList();
        ArrayList<Integer> e = new ArrayList();
        p5.getFactorsAndExponents(78,p,e);
        System.out.println(p5.toString());
        for (Integer integer : p) {
            System.out.println(integer);
        }


    }
}
