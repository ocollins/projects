package java112.labs1;

/**
*Lab2 Project 1
*@author Olena collins
*MysteryClassOne class
*/

public class MysteryClassOne {
    /**
    *  @param args command line arguments
    */
    public static void main (String [] args) {
        MysteryClassOne myMystery = new MysteryClassOne(); 
        System.out.println("The number is " + myMystery.mysteryMethodOne());
        System.out.println("Argument passed to program " + args[0]);
    
    }    

    /**mysteryMethodOne method
    *  @return number
    */
    public int mysteryMethodOne() {
        int x = 1;
        return x;
    }

}