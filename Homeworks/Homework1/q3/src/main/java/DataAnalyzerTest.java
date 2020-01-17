import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

class DataAnalyzerTest {
    /**
     * a. reads from the terminal a sequence of numbers (integers)
     * b. saves them to a file with the name given from the command line
     * c. calculates,then displays on the terminal, and also saves to that file
     * the maximum,  minimum, and average.
     *
     * @param args list of numbers with file name being at the end of the list
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Please a list of numbers separated by spaces and end with a .txt filename:");
        input = sc.nextLine();
        System.out.println(input);
        String[] list = input.split(" ");

        if (list.length < 2) {
            System.out.println("Expecting at a list of integers and a file name. At minimum 1 int and 1 filename. Exiting");
            System.exit(0);
        }
        String fileName = list[list.length - 1];
        if (!fileName.contains(".txt")) {
            System.out.println("Last input was expected to have \".txt\" in the argument list");
            System.exit(0);
        }

        LinkedList<Integer> inputList = new LinkedList();
        FileWriter out = new FileWriter(fileName);
        try {
            for (int i = 0; i < list.length - 1; i++) {
                Integer num = Integer.parseInt(list[i]);
                inputList.add(num);
                out.write(num + " \n");
                System.out.println(num);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Parsing Arguments error. Please be sure to enter integers as inputs from 1 to n-1. Exiting");
            System.exit(0);
        }

        DataAnalyzer data = new DataAnalyzer(inputList);
        out.write("\n");
        out.write("Max: " + data.max().toString() + "\n");
        out.write("Min: " + data.min().toString() + "\n");
        out.write("Average: " + data.average().toString() + "\n");
        out.close();

        System.out.println("Max: " + data.max().toString());
        System.out.println("Min: " + data.min().toString());
        System.out.println("Average: " + data.average().toString());
    }

}
