public class Protractor implements Tool {
    @Override
    public String getName() {
        return "Protractor";
    }

    @Override
    public void use() {
        System.out.println("Using " + getName());
    }
}
