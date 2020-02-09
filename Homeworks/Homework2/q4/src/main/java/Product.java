/**
 * The product class holds information related to the product
 */
class Product{
    public Integer upc = 0;
    public String name = "";
    public Double price = 0.0;

    public Product(Integer upc, String name, Double price){
        this.upc = upc;
        this.name = name;
        this.price = price;
    }

    /**
     * @return formatted string to display a product
     */
    public String toString(){
        return upc.toString() + "\t" + name + "\t$" + String.format("%3.2f", price);
    }

}