/**
 * A class for producing simple greetings.
 */

public class Greeter {
   private String name;

   /**
    * Constructs a Greeter object that can greet a person or
    * entity.
    *
    * @param aName the name of the person or entity who should
    *              be addressed in the greetings.
    */
   public Greeter(String aName) {
      name = aName;
   }

   /**
    * Greet with a "Hello" message.
    *
    * @return a message containing "Hello" and the name of
    * the greeted person or entity.
    */
   public String sayHello() {
      return "Hello, " + name + "!";
   }

   /**
    * Swaps out the member "name" between the current Greeter object and the other Greeter object passed in.
    *
    * @param other Greeter object that will be used to swap out the name
    */
   public void swapNames(Greeter other) {
      String tempName = other.name;
      other.name = this.name;
      this.name = tempName;
   }

   /**
    * Creates a new Greeter object with its name being the qualifier string followed by
    * " " and the executing greeter's name (i.e. this.name).
    * For example:
    * Greeter g = new Greeter("world");
    * Greeter g2 = g.createQualifiedGreeter("beautiful");
    *
    * @param qualifier The string used in the creation of the new Greeter object
    * @return New Greeter object with the new name
    */
   public Greeter createQualifiedGreeter(String qualifier) {
      return new Greeter(qualifier + " " + this.name);
   }
}
