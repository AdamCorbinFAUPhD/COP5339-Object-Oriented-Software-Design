public class Paper implements Tool {
    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public void use() {
        System.out.println("Using " + getName());
    }
}
