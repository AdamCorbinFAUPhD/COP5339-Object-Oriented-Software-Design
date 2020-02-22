import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestComplex {

    /**
     * Creating 2 complex numbers with the same real and imaginary to test the equals
     */
    @Test
    public void testEquals() {
        System.out.println("Run test equals");
        Complex a = new Complex(1,2);
        Complex b = new Complex(1,2);
        assertTrue(a.equals(b));
    }

    /**
     * Computing internally what an Add would do, and then using 2 complex numbers to do the same to compare.
     */
    @Test
    public void testAdd() {
        System.out.println("run test add");
        double r1 = 1, i1 = 2, r2 = -3, i2 = 4;
        double rResult = r1 + r2, iResult = i1 + i2;
        Complex x = new Complex(r1,i1);
        Complex y = new Complex(r2,i2);
        Complex w = x.add(y);
        Complex z = new Complex(rResult,iResult);
        // test condition using the Complex equals() method:
        assertTrue(z.equals(w));
    }

    /**
     * Computing internally what an subtract would do, and then using 2 complex numbers to do the same to compare.
     */
    @Test
    public void testSub() {
        System.out.println("run test sub");
        double r1 = 1, i1 = 2, r2 = -3, i2 = 4;
        double rResult = r1 - r2, iResult = i1 - i2;
        Complex x = new Complex(r1,i1);
        Complex y = new Complex(r2,i2);
        Complex w = x.sub(y);
        Complex z = new Complex(rResult,iResult);
        // test condition using the Complex equals() method:
        assertTrue(z.equals(w));
    }

    /**
     * Computing internally what an multiply would do, and then using 2 complex numbers to do the same to compare.
     */
    @Test
    public void testMult() {
        System.out.println("run test mult");
        double r1 = 1, i1 = 2, r2 = -3, i2 = 4;
        double rResult = r1*r2 - i1*i2, iResult = i1*r2 + r1 * i2;
        Complex x = new Complex(r1,i1);
        Complex y = new Complex(r2,i2);
        Complex w = x.mult(y);
        Complex z = new Complex(rResult,iResult);
        // test condition using the Complex equals() method:
        assertTrue(z.equals(w));
    }

    /**
     * Computing internally what an divide would do, and then using 2 complex numbers to do the same to compare.
     */
    @Test
    public void testDiv() {
        System.out.println("run test div");
        double r1 = 1, i1 = 2, r2 = -3, i2 = 4;
        double divisor = r2*r2 + i2*i2;
        double rResult = (r1*r2 + i1*i2)/divisor, iResult = (i1*r2 - r1*i2) / divisor;
        Complex x = new Complex(r1,i1);
        Complex y = new Complex(r2,i2);
        Complex w = x.div(y);
        Complex z = new Complex(rResult,iResult);
        // test condition using the Complex equals() method:
        assertTrue(z.equals(w));
    }

}