import java.util.*;

public class Utils {
    /**
     * taking an input list and sorting that list and returning a new list thats sorted based on the K part of the Pair
     * @param col collection/list of objected used to sort
     * @param <K> extending used to compare the list with
     * @param <V> other generic type used in pair
     * @return new sorted list
     */
    public static <K extends Comparable<K>,V> Collection<Pair<K,V>> sortPairCollection(Collection <Pair<K,V>> col){
        ArrayList<Pair<K, V>> list = new ArrayList<>(col);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("testing", 425);
        Pair<String,Integer> pair2 = new Pair<>("Brother", 222);
        Pair<String,Integer> pair3= new Pair<>("Adam", 42);

        List<Pair<String,Integer>> list = Arrays.asList(pair1,pair2,pair3);

        System.out.println("List before sort");
        for(Pair<String,Integer> pair : list){
            System.out.println(pair);
        }

        Collection<Pair<String,Integer>> newList = sortPairCollection(list);
        System.out.println("\nList after sort");
        for(Pair<String,Integer> pair : newList){
            System.out.println(pair);
        }

        System.out.println(pair1.getClass() == pair2.getClass());
//        System.out.println(pair1 instanceof pair2.getClass());
        System.out.println(pair1.getClass().equals(pair2.getClass()));

    }
}
