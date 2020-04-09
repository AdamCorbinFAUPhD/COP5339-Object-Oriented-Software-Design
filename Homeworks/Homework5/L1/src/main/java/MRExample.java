public class MRExample {

    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Adam");
        myList.add("James");
        myList.add("Bond");
        myList.add("Gold");

        LengthFun lengthFun = new LengthFun();
        Summer summer = new Summer();
        Integer mapReduceVal = myList.map(lengthFun).reduce(summer,0);

        System.out.println("L1.D MRExample");
        System.out.println("Org list:");
        for (String i : myList) {
            System.out.print(i + ", ");
        }
        System.out.println("\nMap Reduce result:" + mapReduceVal);
    }
}
