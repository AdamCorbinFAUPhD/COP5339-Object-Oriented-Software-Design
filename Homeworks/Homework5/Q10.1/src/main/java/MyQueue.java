import java.util.Collection;
import java.util.NoSuchElementException;

interface MyQueue <E> {
    // return the top of the queue element or throw NoSuchElementException if empty
    E head();

    // remove and return the top of the queue element or throw NoSuchElementException if empty
    E dequeue() throws NoSuchElementException;

    // add an element to the queue
    void enqueue(E e);

    // returns the size of the queue
    int size();

    // returns true if the queue is empty
    boolean isEmpty();

    // add elements to this queue from a collection c of E references:
    void addAll(Collection<? extends E> c);
}