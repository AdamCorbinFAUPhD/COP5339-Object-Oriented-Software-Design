class q3_2{
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