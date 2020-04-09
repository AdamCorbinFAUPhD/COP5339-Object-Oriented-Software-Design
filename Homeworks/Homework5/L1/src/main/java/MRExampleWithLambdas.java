public class MRExampleWithLambdas {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Adam");
        myList.add("James");
        myList.add("Bond");
        myList.add("Gold");

        Integer mapReduceValLambdas = myList.map(s -> s.length()).reduce((i1,i2) -> i1+i2,0);

        System.out.println("L1.D MRExampleWithLambdas");
        System.out.println("Org list:");
        for (String i : myList) {
            System.out.print(i + ", ");
        }
        System.out.println("\nMap Reduce result using lambdas:" + mapReduceValLambdas);
    }
}
