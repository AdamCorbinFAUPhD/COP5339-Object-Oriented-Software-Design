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
     * @param args expect the file name to be entered in args[0]
     */
    public static void main(String[] args) throws IOException {

        // Retrieve the filename
        String fileName = "";
        if(args.length != 1 || (args.length == 1 && !args[0].contains(".txt"))){
            System.out.println("ERROR: Expected to have \".txt\" in the first argument");
            System.exit(0);
        }else{
            fileName = args[0];
        }

        //Parse the integers from the scanner
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Please a list of numbers separated by spaces");
        input = sc.nextLine();
        System.out.println(input);
        String[] list = input.split(" ");

        if (list.length < 1) {
            System.out.println("Expecting at a list of integers and a file name. At minimum 1 int. Exiting");
            System.exit(0);
        }

        LinkedList<Integer> inputList = new LinkedList();

        try {
            for (int i = 0; i < list.length - 1; i++) {
                Integer num = Integer.parseInt(list[i]);
                inputList.add(num);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Parsing integers error. Please be sure to enter integers as inputs. Exiting");
            System.exit(0);
        }

        //Compute stats, output to screen and file.
        DataAnalyzer data = new DataAnalyzer(inputList);
        FileWriter out = new FileWriter(fileName);
        out.write("Max: " + data.max().toString() + "\n");
        out.write("Min: " + data.min().toString() + "\n");
        out.write("Average: " + data.average().toString() + "\n");
        out.close();

        System.out.println("Max: " + data.max().toString());
        System.out.println("Min: " + data.min().toString());
        System.out.println("Average: " + data.average().toString());
    }

}
