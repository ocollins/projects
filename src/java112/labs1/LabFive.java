package java112.labs1;
import java.io.*;

/** Lab 5 Unit 1
*   @author Olena Collins    
*/

public class LabFive {
    /**
    *  Main method
    *  @param args command line arguments
    */
    public static void main (String[] args) {
        if (args.length == 2) {
            LabFive labFive = new LabFive ();
            labFive.run(args[0], args[1]);
        } else {
            System.out.println("Please enter two arguments on the command line," +
                    " a file name and a message");
        }
        
    }

    /**
    *  run method
    *  @param fileName input file name
    *  @param message a message
    */
    public void run (String fileName, String message) {
        try (PrintWriter printWriter = 
            new PrintWriter (new BufferedWriter(new FileWriter(fileName)))) {
            printWriter.println(message);
        //FileNotFound is not needed
        // } catch (FileNotFoundException fileNotFound) {
            // System.out.println("File does not exist");
            // fileNotFound.printStackTrace();
        } catch (IOException iOException) {
            System.out.println("Error writing file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error occured");
            exception.printStackTrace();
        }          
        
    }

}