public class Summer implements Functor2<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer param1, Integer param2) {
        return param1 + param2;
    }
}
