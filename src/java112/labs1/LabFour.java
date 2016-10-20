package java112.labs1;
import java.io.*;

/** Lab 4 Unit 1
*   @author Olena Collins    
*/

public class LabFour {
    /**
    *  Main method
    *  @param args command line arguments
    */
    public static void main (String[] args) {
        LabFour lFour = new LabFour ();
        if (args.length == 1) {
            lFour.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line");
        }
    }

    /**
    *  run method
    *  @param fileName input file name
    */
    public void run (String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader myReader = new BufferedReader (fileReader)) {
            while (myReader.ready()) {
                System.out.println(myReader.readLine());  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Problem reading the file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("You are in trouble!!");
            exception.printStackTrace();
        }
    }

}