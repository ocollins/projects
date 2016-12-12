package java112.analyzer;

import  java.util.*;
import  java.io.*;
import  java.lang.Integer;
import  java.util.Arrays;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Token Sze Analyzer Class 
*/

public class TokenSizeAnalyzer implements Analyzer{
    private Map<Integer, Integer> tokenSizes;
    private Properties properties;
    private static int maximumSize;
    private String[][] verticalHistogram = new String[25][72];

    /**
    *  Empty class constructor.
    *  Create an instance of the Tree Set. 
    */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
        maximumSize = 0;
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data 
    *  @param propertiesIn properties
    */
    public TokenSizeAnalyzer(Properties propertiesIn) {

        //Call empty constructor
        this();
        //Get minimum word length from .properties file
        properties = propertiesIn; 
    }

    /**
    *  Process tokens: determine length of each token;
    *  store it in the Map container;
    *  check if that length is already in the Map container;
    *  if so, increase the counter number of tokens with this length;
    *  if it is a new length, set the counter to 1;
    *  @param token type String
    */
    public void processToken(String token) {
        int tokenLength = token.length();
        int lengthCount = 0;

        //Check if token length is already in the Map container
        if(tokenSizes.containsKey(tokenLength)) {
            lengthCount = tokenSizes.get(tokenLength);
            lengthCount ++;
        } else {
            lengthCount = 1;
        }
        tokenSizes.put(tokenLength, lengthCount);

        if (lengthCount > maximumSize) {
            maximumSize = lengthCount;
        }
    }

    /**
    *  Get Token Sizes method
    *  @return tokenSizes
    */
    public Map<Integer, Integer> getTokenSizes() {

        return tokenSizes;
    }

    /**
    *  Get Maximum Size method
    *  @return maximumSize
    */
    public int getMaximumSize() {

        return maximumSize;
    }

    /**
    *  Produce a List of Token Sizes.
    *  Write the list into a txt file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file
        String outputFilePath = properties.getProperty("output.file.token.sizet");

        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
        
        //Build token lengths histogram
        Map<Integer, String> histoMap = buildHistogram();

        //Write token sizes into a file    
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            //Write out the token lengths/count part of the report
            for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
                printWriter.println( entry.getKey() + "\t" + entry.getValue());
            }

            printWriter.println("\n" + "Horizontal histogram of the results" + "\n");
            //Write out the horizontal histogram part of the report
            for (Map.Entry <Integer, String> entry : histoMap.entrySet()) {
                printWriter.println(entry.getKey() + " " + entry.getValue());
            }

            printWriter.println("\n" + "Vertical histogram of the results" + "\n");
            //Write out the vertical histogram part of the report
            for (int y = 71; y >= 0; y --) {
                //System.out.println("y " + y);
                for (int x = 0; x < 25; x ++) {
                    if (verticalHistogram[x][y] == null) {
                        printWriter.print("   ");
                    } else {
                        printWriter.print(verticalHistogram[x][y] + " ");
                    }
                }
                printWriter.println();
            }
            writeOutputHTMLFile(inputFilePath);
            
        } catch (IOException iOException) {
            System.out.println("Cannot write Token Sizes file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Token Sizes file");
            exception.printStackTrace();
        }    
    }

    /**
     *  Produce a List of Token Sizes.
     *  Write the list into an HTML file.
     *  @param inputFilePath name of input file
     */
    public void writeOutputHTMLFile(String inputFilePath) {
        //Get name of the output file
        String outputFilePath = properties.getProperty("output.file.token.sizeh");

        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir.web");

        //Build token lengths histogram
        Map<Integer, String> histoMap = buildHistogram();

        //Write token sizes into a file
        try(BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
            PrintWriter printWriter =
                    new PrintWriter(bufferedWriter)) {
            //Write out the token lengths/count part of the report
            for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
                printWriter.println( entry.getKey() + "\t" + entry.getValue() + "<br>");
            }

            printWriter.println("\n" + "Horizontal histogram of the results" + "\n" + "<br>");
            //Write out the horizontal histogram part of the report
            for (Map.Entry <Integer, String> entry : histoMap.entrySet()) {
                printWriter.println(entry.getKey() + "&nbsp;" + entry.getValue() + "<br>");
            }

            printWriter.println("<br>" + "\n" + "Vertical histogram of the results" + "\n" + "<br>");
            //Write out the vertical histogram part of the report
            for (int y = 71; y >= 0; y --) {
                for (int x = 0; x < 25; x ++) {
                    if (verticalHistogram[x][y] == null) {
                        printWriter.print("&nbsp; &nbsp; &nbsp;");
                    } else {
                        if (y == 0) {
                            printWriter.print(verticalHistogram[x][y] + "&nbsp;");
                        } else {
                            printWriter.print(verticalHistogram[x][y] + "&nbsp;&nbsp;");
                        }
                    }

                }
                printWriter.println("<br>");
            }


        } catch (IOException iOException) {
            System.out.println("Cannot write Token Sizes file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processig Token Sizes file");
            exception.printStackTrace();
        }
    }

    /**
    *  Build a histogram of the token lengths/occurences
    *  @return Map container of token lengths/occurences in form of a histogram
    */
    public TreeMap buildHistogram() {
        TreeMap<Integer, String> workMap = new TreeMap<Integer, String>();
        int maxLineLength = 70;
        int numberAsterisks = 0;
        Integer tokenLength = 0;
        String asterisks = null;
        //X and Y coordinates for vertical histogram
        int verticalX = 0;
        int verticalY = 0;

        //Get number of occurences for each length from a Map container;
        //Calculate how many asterisks should be built in proportion to the max
        //number of asterisks.
        for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            numberAsterisks = (maxLineLength * entry.getValue()) / maximumSize;

            if (numberAsterisks < 1) {
                numberAsterisks = 1;
            }
            tokenLength = entry.getKey();
            //Store token lengths in the array for printing on vertical histogram.
            //They will be stored in to the 0 row of the array.
            //If token length is one byte, add a space to allign them with two-byte
            //values.
            if (tokenLength.toString().length() == 1) {
                verticalHistogram[verticalX][0] = tokenLength.toString() + " ";
            } else {
                verticalHistogram[verticalX][0] = tokenLength.toString();
            }
            //Build rows of asterisks for the horizontal histogram
            //Build array of asterisks for the vertical histogram
            asterisks = buildAsterisks(numberAsterisks, verticalX);

            verticalX ++;
            workMap.put(tokenLength, asterisks);
        }
        return workMap;    
    }

    /**
    *  Build a string of asterisks for each number of occurences
    *  @param numberAsterisksIn number of asterisks to string together
     * @param verticalX X-coordinate for vertical histogram
    *  @return string of asterisks to be placed on the histogram
    */
    public String buildAsterisks(int numberAsterisksIn, int verticalX) {
        String asterisksOut = "";
        //Y coordinate for vertical histogram
        int verticalY = 1;
        
        for(int i = 0; i < numberAsterisksIn; i++) {
            asterisksOut = asterisksOut + "*";
            verticalHistogram[verticalX][verticalY] = "* ";
            verticalY ++;
        } 
        return asterisksOut;  
    }    
     
}