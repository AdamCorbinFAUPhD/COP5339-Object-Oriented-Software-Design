import java.util.ArrayList;

public class Inventory {
    public ArrayList<Product> products = new ArrayList<>();
    public Inventory(){

    }

    /**
     * Adds a new product to the inventory
     * @param product new product to be added to the inventory
     */
    public void add(Product product){
        products.add(product);
    }

}
