package java112.labs1;
import java.io.*;

/**
*   Lab 6 Unit 1
*   @author Olena Collins
*/
public class LabSix {
    /**
    *   Main method
    *   @param args command line arguments
    */
    public static void main (String [] args) {
        LabSix labSix = null;
        String messagePart1 = "Please enter two arguments ";
        String messagePart2 = "on the command line, an input file name ";
        String messagePart3 = "and an output file name";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messagePart1);
        stringBuilder.append(messagePart2);
        stringBuilder.append(messagePart3);

        if (args.length == 2) {
            labSix = new LabSix();
            labSix.run(args[0], args[1]);
        } else {
            System.out.println(stringBuilder);
        }
    }

    /**
    *   Run method
    *   @param inputFileName name of input file
    *   @param outputFileName name of output file
    */  
    public void run (String inputFileName, String outputFileName) {
        String lineIn = "";
        try (BufferedReader bufferedReader = 
                    new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bufferedWriter = 
                    new BufferedWriter(new FileWriter(outputFileName));
             PrintWriter printWriter = 
                    new PrintWriter(bufferedWriter)) {
            
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();
                System.out.println(lineIn);
                printWriter.println(lineIn);  
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            System.out.println("Cannot open file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Trouble!");
            exception.printStackTrace();
        } 
    } 
    
}