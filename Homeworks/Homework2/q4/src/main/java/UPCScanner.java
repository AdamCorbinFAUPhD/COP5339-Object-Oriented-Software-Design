import java.util.Scanner;

class UPCScanner{
    public UPCScanner(){
    }

    /**
     * The method is used to capture the scanned UPC
     * @return UPC from user input
     * Exception: The scanner will keep trying if the user enters in an invalid integer
     */
    public int scanProduct(){
        while(true) {
            try {
                System.out.print("Item UPC: ");
                Scanner sc = new Scanner(System.in);
                return Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.out.println("ERROR: Parsing int error. Please enter in valid int for the UPC");
            }
        }
    }
}