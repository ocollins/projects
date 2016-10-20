package java112.labs1;
import java.io.*;
import java.util.*;

/** Lab 8 Unit 1
*   @author Olena Collins    
*/

public class LabEight {
    Set<String> mySet;
    /**
    *  Main method
    *  @param args command line arguments
    */
    public static void main (String[] args) {
        if(args.length == 1) {
            LabEight labEight = new LabEight();
            labEight.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the " +
                    "command line, an output file name");
        }

    }

    /**
    *  Run method
    *  @param outputFileName output file name
    */
    public void run (String outputFileName) {
        mySet = new TreeSet<String>();
        mySet.add("one");
        mySet.add("one");
        mySet.add("five");
        mySet.add("two");
        mySet.add("four");
        mySet.add("two");
        mySet.add("three");
        mySet.add("three");
        mySet.add("four");
        mySet.add("three");
        writeSetToOutputFile(outputFileName);
    }    

    /**
    *  Write output file method
    *  @param outputFilePath file path
    */
    public void writeSetToOutputFile (String outputFilePath) {
        try (PrintWriter printWriter = 
            new PrintWriter (new BufferedWriter(new FileWriter(outputFilePath)))) {
            for(String stringOut : mySet) {
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