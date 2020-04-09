import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueTest {
    public static void main(String[] args) {
        LQueue<Integer> lQueue = new LQueue<>();

        try{
            lQueue.dequeue();
        }catch(NoSuchElementException e){
            System.out.println("1. Success: Testing dequeue with no elements");
        }

        try{
            lQueue.head();
        }catch(NoSuchElementException e){
            System.out.println("2. Success: Testing head with no elements");
        }

        //Testing enqueue and head
        lQueue.enqueue(1);
        if(lQueue.head() == 1) {
            System.out.println("3. Success: Testing enqueue with 1 and that the head returns 1");
        }

        //Testing dequeue removes the old element and is empty after removing the only item
        if(lQueue.size() == 1){
            System.out.println("4. Success: size is equal to 1");
        }

        lQueue.dequeue();
        if(lQueue.isEmpty()){
            System.out.println("5. Success: empty after removing the only item");
        }

        //Testing adding collection
        lQueue.addAll(Arrays.asList(7,2,3,4,5,6));
        if(lQueue.size() == 6){
            System.out.println("6. Success: Adding 6 items using the addAll method");
        }

        // Testing dequeue and return item removed
        Integer elementRemoved = lQueue.dequeue();
        if(lQueue.size() == 5 && elementRemoved == 7){
            System.out.println("7. Success: dequeue removed the head making size 5, and returned the element value 7");
        }


    }
}
