package java112.project4;
import java.io.*;
import java.util.*;

/** Class to write out a log for debuging
*   @author Olena Collins    
*/

public class Debug {
    ArrayList<String> messages;

    /**
    *  Write output file method
    *  @param outputFilePath file path
    */
    public void writeDebug (String message) {
        String outputFilePath = "output/DebugLogs.txt";
        try (PrintWriter printWriter = 
            new PrintWriter (new BufferedWriter(new FileWriter(outputFilePath, true)))) {
            printWriter.println(message);
        } catch (IOException iOException) {
            System.out.println("IO Error writing Debug log file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error occured while writing Debug log file");
            exception.printStackTrace();
        }              
    }

}