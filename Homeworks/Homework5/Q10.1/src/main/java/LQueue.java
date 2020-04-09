import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LQueue<T> implements MyQueue<T> {

    LinkedList<T> tLinkedList = new LinkedList<>();

    /**
     * @return the first element in the list
     * @throws NoSuchElementException - when the list is empty
     */
    @Override
    public T head() throws NoSuchElementException{
        if(size() > 0){
            return tLinkedList.getFirst();
        }else{
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes the first element in the list
     * @return the element that was removed
     * @throws NoSuchElementException - when the list is empty
     */
    @Override
    public T dequeue() throws NoSuchElementException {
        if(size() > 0){
            ;
            return tLinkedList.remove();
        }else{
            throw new NoSuchElementException();
        }
    }

    /**
     * @param t Adding element to the end of the list
     */
    @Override
    public void enqueue(T t) {
        tLinkedList.add(t);
    }

    /**
     * @return the size of the lize
     */
    @Override
    public int size() {
        return tLinkedList.size();
    }

    /**
     * @return true if the list is empty, false if 0< elements in the list
     */
    @Override
    public boolean isEmpty() {
        return tLinkedList.isEmpty();
    }

    /**
     * @param c new list to be added to the internal list
     */
    @Override
    public void addAll(Collection<? extends T> c) {
        tLinkedList.addAll(c);
    }
}
