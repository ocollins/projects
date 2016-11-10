package java112.analyzer;

import java.util.*;

/**
*Project 2
*Tester class for Lexical Density Analyzer Class
*Use runLexAnalyzer.sh to run this class
*@author Olena Collins
*/

public class LexicalDensityTester{
    private static LexicalDensityTester myTester;
    private static LexicalDensityAnalyzer myAnalyzer;
    
    /**
    *  @param args command line arguments
    */
    public static void main (String [] args) {
        //Create properties object to be used to call LexicalDensityAnalyzer
        Properties testProperties = new Properties();
        //Load name of the list of non lexical words file into the Properties object
        testProperties.setProperty("input.file.nonlexical.words", "nonLexicalWords.txt");
        myTester = new LexicalDensityTester();
        myAnalyzer = new LexicalDensityAnalyzer(testProperties); 

        String testString1 = 
            "john smith intensely loves going to the huge cinema everyday";
        myTester.testWithString(testString1, 80);
        
        myAnalyzer = null;
        myAnalyzer = new LexicalDensityAnalyzer(testProperties);
        String testString2 = 
            "the quick brown fox jumped swiftly over the lazy dog";
        myTester.testWithString(testString2, 70);
        
        myAnalyzer = null;
        myAnalyzer = new LexicalDensityAnalyzer(testProperties);
        String testString3 = 
            "she told him that she loved him";
        myTester.testWithString(testString3, 28);

        myAnalyzer = null;
        myAnalyzer = new LexicalDensityAnalyzer(testProperties);
        String testString4 = 
            "he loves going to the cinema";
        myTester.testWithString(testString4, 50);
    }    

     /** Test lexical density analyzer. Compare returned value to the
     *   expected value. If they do not match, display an error.
     *  @param testStringIn string that will be tested
     *  @param expectedPercent lexical density percent
     */
    public void testWithString(String testStringIn, int expectedPercent) {
        String[] tokenArray = null;
        int calculatedPercent = 0;

        for (String token : testStringIn.split("\\W")) {
                myAnalyzer.processToken(token);
        }

        //Get actual lexical density from the Analyzer
        calculatedPercent = myAnalyzer.getDensityPercent();

        //Compare the actual percentage to the test percentage
        //and display a message
        if (calculatedPercent == expectedPercent) {
            System.out.println("Test string " + "\"" + testStringIn + "\"" + " - passed");
        } else {
            System.out.println("Test string " + "\"" + testStringIn + "\"" + " - failed");
            System.out.println("  Expected lexical density " + expectedPercent);
            System.out.println("  Calculated lexical density " + calculatedPercent);
        }
    }

}