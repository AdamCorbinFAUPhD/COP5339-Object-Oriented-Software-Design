public class SummerTest {
    public static void main(String[] args) {
        Summer summer = new Summer();
        MyList<Integer> myList = new MyList<>();
        myList.add(3);
        myList.add(-1);
        myList.add(1);
        myList.add(4);
        Integer summerResult = myList.reduce(summer,0);
        System.out.println("L1.C");
        System.out.println("Using Summer object to run the myList.reduce. Result: " + summerResult);

        //Lambda
        Functor2<Integer, Integer, Integer> lambda =  (i1,i2) -> i1+i2;
        Integer lambdaResult = myList.reduce(lambda,0);
        System.out.println("Using lambda to run the myList.reduce. Result: " + lambdaResult);
        System.out.println(" Comparing lambdaResult == summerResult: " + (lambdaResult == summerResult));

    }
}
