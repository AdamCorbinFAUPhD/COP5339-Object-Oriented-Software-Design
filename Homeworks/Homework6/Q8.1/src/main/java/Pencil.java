public class Pencil implements Tool {
    @Override
    public String getName() {
        return "Pencil";
    }

    @Override
    public void use() {
        System.out.println("Using " + getName());
    }
}
