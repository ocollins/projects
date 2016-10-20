package java112.labs1;

/**
*Lab3 Project 1
*@author Olena collins
*/

public class LabThree {
    /**Main method to run LabThree
    *  @param args The command line arguments
    */
    public static void main (String[] args) {

        LabThree myLabThree = new LabThree();
        if (args.length !=1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            myLabThree.run(args[0]);
        }

    } 

    /** Run method
     *  @param myString The string passed in
     */
    public void run (String myString) {
        System.out.println("input: " + myString);
    } 

   
}