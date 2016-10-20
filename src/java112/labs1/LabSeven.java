package java112.labs1;
import java.io.*;
import java.util.*;

/** Lab 7 Unit 1
*   @author Olena Collins    
*/

public class LabSeven {
    List<String> myList;
    /**
    *  Main method
    *  @param args command line arguments
    */
    public static void main (String[] args) {
        if(args.length == 1) {
            LabSeven labSeven = new LabSeven();
            labSeven.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the " +
                    "command line, an output file name");
        }

    }

    /**
    *  Run method
    *  @param outputFileName file name
    */
    public void run (String outputFileName) {
        myList = new ArrayList<String>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");
        myList.add("six");
        myList.add("seven");
        myList.add("eight");
        myList.add("nine");
        myList.add("ten");
        writeListToOutputFile(outputFileName);
    }    

    /**
    *  Write output file method
    *  @param outputFilePath name of output file
    */
    public void writeListToOutputFile (String outputFilePath) {
        try (PrintWriter printWriter = 
            new PrintWriter (new BufferedWriter(new FileWriter(outputFilePath)))) {
            for(String stringOut : myList) {
                printWriter.println(stringOut);
            }
        } catch (IOException iOException) {
            System.out.println("Error writing file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error occured");
            exception.printStackTrace();
        }              
    }

}