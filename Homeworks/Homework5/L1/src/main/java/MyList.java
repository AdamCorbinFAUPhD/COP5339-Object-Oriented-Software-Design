import java.util.Iterator;
import java.util.LinkedList;

class MyList<T> extends LinkedList<T> {
    public <R> MyList<R> map(Functor<R, T> fo) {
        MyList<R> newList = new MyList<>();
        for (T t : this) {
            newList.add(fo.apply(t));
        }
        return newList;
    }

    public T reduce(Functor2<T, T, T> fo2, T initialValue) {
        Iterator<T> iterable = this.iterator();
        T accumlator = initialValue;
        while(iterable.hasNext()){
            accumlator = fo2.apply(accumlator,iterable.next());
        }
        return accumlator;
    }

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(-2);
        myList.add(1);
        myList.add(0);
        myList.add(4);

        MyList<Integer> newList = myList.map(new TimesTwoFun());

        System.out.println("L1.B");
        System.out.println("Testing MyList mapping using the TimeTwoFunction");
        System.out.println("Org list:");
        for (Integer i : myList) {
            System.out.print(i + ", ");
        }
        System.out.println("\n New list:");
        for (Integer i : newList) {
            System.out.print(i + ", ");
        }

        // lambda version
        Functor<Integer, Integer> functorTwoTimes = i -> i * 2;
        MyList<Integer> lambdaList = myList.map(functorTwoTimes);
        System.out.println("\n New list using lambda:");
        for (Integer i : lambdaList) {
            System.out.print(i + ", ");
        }

    }
}