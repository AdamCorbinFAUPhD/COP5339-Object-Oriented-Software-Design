import java.io.*;

public class PairTest {
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("testing", 425);
        Pair<String,Integer> pair2 = new Pair<>("Adam", 42);
        Pair<String,Integer> sameAsPair1 = new Pair<>("testing", 425);

        // Print out to string
        System.out.println("\nTesting printing to a string");
        System.out.println("pair1" + pair1);
        System.out.println("pair2" + pair2);
        System.out.println("sameAsPair1" + sameAsPair1);

        // Testing equality
        System.out.println("\nTesting equality");
        System.out.println("pair1 != pair2: " + (!pair1.equals(pair2)));
        System.out.println("pair1 == sameAsPair1: " + (pair1.equals(sameAsPair1)));

        //Cloning, compare to org
        System.out.println("\nTesting cloning");
        try {
            Pair<String, Integer> cloned = (Pair<String, Integer>) pair1.clone();
            System.out.println("pair1 == cloned: " + (pair1.equals(cloned)));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //Testing serialization
        System.out.println("\nTesting serialization");
        try {
            //Write 2 objects to a file
            ObjectOutputStream out
                    = new ObjectOutputStream(
                    new FileOutputStream("serial.dat"));
            out.writeObject(pair1);
            out.writeObject(pair2);
            out.close();

            //Read 2 objects from a file and test them with the previous objects
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("serial.dat"));
            Pair<String,Integer>serialObject = (Pair<String,Integer>)in.readObject();
            Pair<String,Integer>serialObject2 = (Pair<String,Integer>)in.readObject();
            System.out.println("pair1 == serialObject: " + (pair1.equals(serialObject)));
            System.out.println("pair2 == serialObject2: " + (pair2.equals(serialObject2)));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Testing hashCode
        System.out.println("\nTesting hashCode");
        System.out.println("pair1.hashCode() != pair2.hashCode(): " + (pair1.hashCode() != pair2.hashCode()));
        System.out.println("pair1.hashCode() == sameAsPair1.hashCode(): " + (pair1.hashCode() == sameAsPair1.hashCode()));


    }
}
