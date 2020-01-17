import org.junit.Assert;
import org.junit.Test;

public class GreeterTester {
   /**
    * This main method will test the createQualifiedGreeter & swapNames methods
    * <p>
    * For createQualifiedGreeter one Greeter object will be created with a name, then the createQualifiedGreeter
    * method will called with string. Then the sayHello will be used to ensure that we have added the new string before
    * the name. Some caveat is since name is private we need to use sayHello to read the name from the built string.
    * that means the string test has the "Hello,.*!" built in.
    * <p>
    * For the swapNames we take a similar approach to createQualifiedGreeter as we will use the sayHello to test the name
    * 2 Greeter objects will be created with different names. Then one of the objects will call swapNames with passing
    * in the other Greeter object. To ensure the names are swapped, the sayHello values are tested.
    *
    * @param args Not expected to use any incoming arguments
    */
   public static void main(String[] args) {

      Greeter worldGreeter = new Greeter("World");
      Greeter helloWorldGreeter = worldGreeter.createQualifiedGreeter("Hello");
      if (helloWorldGreeter.sayHello().equals("Hello, Hello World!")) {
         System.out.println("createQualifiedGreeter passes");
      } else {
         System.out.println("createQualifiedGreeter Fails");
      }

      Greeter jamesGreeter = new Greeter("James");
      Greeter adamGreeter = new Greeter("Adam");
      jamesGreeter.swapNames(adamGreeter);

      if (jamesGreeter.sayHello().equals("Hello, Adam!") && adamGreeter.sayHello().equals("Hello, James!")) {
         System.out.println("swapNames passes");
      } else {
         System.out.println("swapNames Fails");
      }

   }

   /**
    * Using JUnit to create 1 Greeter object and call the createQualifiedGreeter to create a new Greeter object.
    * This new Greeter object is tested using the sayHello with the Assert.assertEquals method
    */
   @Test
   public void createQualifiedGreeter_Test() {
      Greeter worldGreeter = new Greeter("World");
      Greeter helloWorldGreeter = worldGreeter.createQualifiedGreeter("Hello");
      Assert.assertEquals(helloWorldGreeter.sayHello(), "Hello, Hello World!");
   }

   /**
    * Using JUnite to create 2 Greeter objects, then using swapNames with these 2 objects. To test swapNames by using
    * sayHello on both objects to test the returned string that names are swapped
    */
   @Test
   public void swapNames_Test() {
      Greeter jamesGreeter = new Greeter("James");
      Greeter adamGreeter = new Greeter("Adam");
      jamesGreeter.swapNames(adamGreeter);

      Assert.assertEquals(jamesGreeter.sayHello(), "Hello, Adam!");
      Assert.assertEquals(adamGreeter.sayHello(), "Hello, James!");
   }
}
