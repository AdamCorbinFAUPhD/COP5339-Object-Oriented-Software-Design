public class Stdout {
    private static Stdout instance = new Stdout();

    /**
     * Making the construor private so no more instances can be created
     */
    private Stdout() {

    }


    /**
     * @return the singleton instance
     */
    public static Stdout getInstance() {
        return instance;
    }

    /**
     * @param s string to be displayed by the console
     */
    public void printline(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Stdout instanceRef1 = Stdout.getInstance();
        Stdout instanceRef2 = Stdout.getInstance();
        instanceRef1.printline("Using reference 1");
        instanceRef2.printline("Using reference 2");

    }
}
