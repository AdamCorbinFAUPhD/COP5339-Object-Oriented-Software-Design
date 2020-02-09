import java.util.Scanner;

class q4 {
    /**
     * This main method will load up the inventory
     * Then it will ask the user if they want to pay or scan an item
     * If the user incorrectly enters in an selection, it will ask the user to retry
     * @param args
     */
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();

        cashRegister.inventory.add(new Product(123,"Candy", 5.99));
        cashRegister.inventory.add(new Product(111,"Apple", 2.99));
        cashRegister.inventory.add(new Product(222,"Water", 1.99));
        System.out.println("Welcome to the Store.");
        System.out.println("Press 1  - to scan an item");
        System.out.println("Press 2  - to pay");
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            if(input.equals("1")){
                cashRegister.scanItem();
            }
            else if(input.equals("2")){
                if(cashRegister.getTotal() > 0.0) {
                    cashRegister.displayTotal();
                    cashRegister.displayAllItems();
                    while (true) {
                        try {
                            System.out.println("Enter payment");
                            input = sc.nextLine();
                            double cash = Double.parseDouble(input);
                            if (cashRegister.payBill(cash)) {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR: Parsing double error. Please enter in valid double");
                        }
                    }

                    break;
                }else {
                    System.out.println("You dont have any items to checkout");
                }
            }else{
                System.out.println("Incorrect entry.");
            }
            System.out.println("Press 1  - to scan an item");
            System.out.println("Press 2  - to pay");
        }
    }
}