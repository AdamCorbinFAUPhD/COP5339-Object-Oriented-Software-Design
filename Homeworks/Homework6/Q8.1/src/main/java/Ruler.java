public class Ruler implements Tool {
    @Override
    public String getName() {
        return "Ruler";
    }

    @Override
    public void use() {
        System.out.println("Using " + getName());
    }
}
