public class LengthFun implements Functor<Integer, String> {
    /**
     * @param param input string to get the length from
     * @return size of the input string length
     */
    @Override
    public Integer apply(String param) {
        return param.length();
    }


    public static void main(String[] args) {
        String stringTester = "138jdhafh38-fushf";
        LengthFun lengthFun = new LengthFun();
        Integer length = lengthFun.apply(stringTester);

        System.out.println("L1.a");
        System.out.println("Testing out the LengthFun");
        System.out.println(stringTester + " has length: " + length + " and is equal to stringTester.length() == " + (stringTester.length() == length));

        System.out.println("Testing out lambda version");
        Functor<Integer, String> lambda = (String s) -> {
            return s.length();
        };
        Integer lambdaLen = lambda.apply(stringTester);
        System.out.println(stringTester + " has length: " + lambdaLen + " and is equal to using LengthFun == " + (lambdaLen == length));
    }
}
