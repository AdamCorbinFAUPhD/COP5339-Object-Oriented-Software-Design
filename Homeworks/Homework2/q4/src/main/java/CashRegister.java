import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The Cash Register has access to the UPCScanner and the Inventory
 */
class CashRegister{
    ArrayList<Product> checkedOutItems = new ArrayList<>();
    Inventory inventory = new Inventory();
    UPCScanner upcScanner = new UPCScanner();
    public CashRegister(){

    }

    /**
     * This method will use the scanner to scan the object and look for the UPC in the inventory.
     * It will notify the user if the UPC was not found in the inventory
     * If the item was found, then it will display it to the screen
     */
    public void scanItem(){
        int newItem = upcScanner.scanProduct();
        boolean found = false;
        for(Product item : inventory.products){
            if(item.upc == newItem){
                checkedOutItems.add(item);
                displayLastScannedItem(item);
                found = true;
            }
        }

        if(!found){
            System.out.println("Item " + newItem + " not found");
        }

    }

    /**
     * @return total price of checked out items
     */
    public double getTotal(){
        double total = 0.0;
        for(Product product : this.checkedOutItems){
            total += product.price;
        }
        return total;
    }


    /**
     * This method will validate if the customer provided enough cash to pay the bill.
     * @param cash input amount from the customer
     * @return true == enough cash, false == short on cash
     */
    public boolean payBill(double cash){
        if(getTotal() > cash){
            System.out.println("Not enough cash. You provided " + cash + " where the balance was " + getTotal());
            return false;
        }
        else{
            double remainingBalance = cash - getTotal();
            printReceipt();
            System.out.println("Balance paid! Returning change: " + String.format("%3.2f", remainingBalance));
            return true;
        }
    }

    /**
     * @param product the item to display to the screen
     */
    public void displayLastScannedItem(Product product){
        System.out.println(product);
    }

    /**
     * Displays the total of the checked out items to the screen
     */
    public void displayTotal(){
        System.out.println("Total: " + String.format("%3.2f", getTotal()));
    }

    /**
     * Displays all the checked out items ot the screen
     */
    public void displayAllItems(){
        System.out.println("UPC\tItem\tPrice");
        for(Product product: checkedOutItems){
            System.out.println(product);
        }
    }

    public void printReceipt(){
        System.out.println("--------------");
        displayAllItems();
        displayTotal();
        System.out.println("Paid!");
    }
}