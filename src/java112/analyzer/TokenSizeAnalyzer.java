package java112.analyzer;

import  java.util.*;
import  java.io.*;

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
        //mimimumWordLenth = Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
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
    *  Write the list into a file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file
        String outputFilePath = properties.getProperty("output.file.token.size");

        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
        
        //Build token length histogram
        Map<Integer, String> histoMap = buildHistogram();

        //Write token sizes into a file    
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            //Write out the token lengths/count part of the report
            for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
                printWriter.println( entry.getKey() + " " + entry.getValue());
            }
    
            //Write out the histogram part of the report
            for (Map.Entry <Integer, String> entry : histoMap.entrySet()) {
                printWriter.println(entry.getKey() + " " + entry.getValue());
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
        //Get maximum line length
        int maxLineLength = Integer.parseInt(properties.getProperty("maximum.line.length"));
        int numberAsterisks = 0;
        String asterisks = null;

        //Get number of occurences for each length from a Map container;
        //Calculate how many asterisks should be built in proportion to the max
        //number of asterisks.
        for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            numberAsterisks = (maxLineLength * entry.getValue()) / maximumSize;
            if (numberAsterisks < 1) {
                numberAsterisks = 1;
            }
            asterisks = buildAsterisks(numberAsterisks);
            workMap.put(entry.getKey(), asterisks);   
        }
        return workMap;    
    }

    /**
    *  Build a string of asterisks for each number of occurences
    *  @param numberAsterisksIn number of asterisks to string together
    *  @return string of asterisks to be placed on the histogram
    */
    public String buildAsterisks(int numberAsterisksIn) {
        String asterisksOut = "";
        
        for(int i = 0; i < numberAsterisksIn; i++) {
            asterisksOut = asterisksOut + "*";      
        } 
        return asterisksOut;  
    }    
     
}