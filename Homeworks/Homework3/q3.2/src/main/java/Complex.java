class Complex{
    private double real = 0;
    private double imaginary = 0;

    /**
     * @param real setting the this.real
     * @param imaginary setting the this.imaginary
     */
    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Constructor that sets the real and leaves imaginary to zero.
     * @param real used to set this.real
     */
    public Complex(double real){
        this.real = real;
    }

    /**
     * @precondition: Expected to have initilized real and imaginary
     * @return formatted string with the real and imaginary parts of Complex. Considers handling the negative imaginary
     * to ensure correct formatting of 1 - 4i where 4 is negative
     */
    @Override
    public String toString() {
        if(imaginary >= 0){
            return real + " + " + imaginary + "i";
        }else{
            return real + " - " + (imaginary * -1) + "i";
        }
    }

    /**
     * @precondition: None
     * @postcondition: None
     * @return this private real
     */
    public double r(){
        return this.real;
    }

    /**
     * @Precondition: None
     * @Postcondition: None
     * @return the private imaginary
     */
    public double i(){
        return this.imaginary;
    }

    /**
     * Method to add this complex object with a passed in complex object and output a newly created complex object
     * @Precondition: None
     * @Postcondition: result of adding 2 complex object
     * @param complex object to be added to this.
     * @return result of adding 2 complex object
     */
    public Complex add(Complex complex){
        return new Complex(this.r() + complex.r(), this.i() + complex.i());
    }

    /**
     * Method to subtract this complex object with a passed in complex object and output a newly created complex object
     * @Precondition: None
     * @Postcondition: result of subtracting 2 complex object
     * @param complex object to be subtracted to this.
     * @return result of subtracting 2 complex object
     */
    public Complex sub(Complex complex){
        return new Complex(this.r() - complex.r(), this.i() - complex.i());
    }

    /**
     * Method to multiply this complex object with a passed in complex object and output a newly created complex object
     * @Precondition: None
     * @Postcondition: result of multiplying 2 complex object
     * @param complex object to be multiplied to this.
     * @return result of multiplying 2 complex object
     */
    public Complex mult(Complex complex){
        double newReal = this.r() * complex.r() - this.i() * complex.i();
        double newImaginary = this.i() * complex.r() + this.r() * complex.i();
        return new Complex(newReal, newImaginary);
    }

    /**
     * Method to divide this complex object with a passed in complex object and output a newly created complex object
     * Source on the formula for dividing:
     * https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:complex/x9e81a4f98389efdf:complex-div/v/dividing-complex-numbers
     * @Precondition: The passed in complex should have a real number and imaginary number both no equal to zero.
     * @Postcondition: result of dividing 2 complex object
     * @param complex object to be divided to this.
     * @return result of dividing 2 complex object
     * @throws : Raise ArithmeticException when passed in complex is 0 + 0i
     */
    public Complex div(Complex complex)throws ArithmeticException{
        if(complex.i() != 0.0 && complex.r() != 0.0) {
            // Multiply the conjugate to get a simpler version
            Complex numerator = this.mult(complex.conj());
            Complex denominator = complex.mult(complex.conj());
            //When you multiple a imaginary number with its conjegate, the imaginary part goes away leaving us with just the
            // real number. Then we can use that real number ot divide the numerator.
            return new Complex(numerator.r() / denominator.r(), numerator.i() / denominator.r());
        }else{
            throw new ArithmeticException("ERROR: Cant divide by zero. Passed in Complex number is 0 + 0i.");
        }
    }

    /**
     * Checks to see if the 2 Complex numbers have equivalent real and imaginary parts.
     * @param complex number to compare with this.
     * @Precondition: None
     * @Postcondition: boolean value of the evaluation between two Complex objects
     * @return true == they are the same, false == they are different
     */
    public boolean equals(Complex complex){
        return this.r() == complex.r() && this.i() == complex.i();
    }

    /**
     * This method creates a new Complex object with the conjugate.
     * To compute the conjugate by just multiple imaginary by -1
     * @Precondition: None
     * @Postcondition: new complex object created
     * @return new Complex object with conjugate
     */
    public Complex conj(){
        return new Complex(this.real, this.imaginary * -1.0);
    }

    public static void main(String[] args) {

        Complex a = new Complex(6,3);
        Complex b = new Complex(7,-5);

        System.out.println("A:\t\t" + a.toString());
        System.out.println("B:\t\t" + b.toString());
        System.out.println("Add:\t" + a.add(b));
        System.out.println("Sub:\t" + a.sub(b));
        System.out.println("Mult:\t" + a.mult(b));
        System.out.println("Div a/b:\t" + a.div(b));
        System.out.println("Div b/a:\t" + b.div(a));
        System.out.println("A Conj:\t" + a.conj().toString());
        System.out.println("B Conj:\t" + b.conj().toString());

    }
}