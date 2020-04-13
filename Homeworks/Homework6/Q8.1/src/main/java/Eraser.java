public class Eraser implements Tool {
    @Override
    public String getName() {
        return "Eraser";
    }

    @Override
    public void use() {
        System.out.println("Using " + getName());
    }
}
