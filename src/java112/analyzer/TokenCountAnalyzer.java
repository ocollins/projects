package java112.analyzer;

import  java.util.*;
import  java.io.*;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Token Count Analyzer Class 
*/

public class TokenCountAnalyzer implements Analyzer{
    private Map<String, Integer> tokenCounts;
    private Properties properties;

    /**
    *  Empty class constructor.
    *  Create an instance of the TreeMap. 
    */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data. 
    *  @param propertiesIn properties
    */
    public TokenCountAnalyzer(Properties propertiesIn) {

        //Call empty constructor
        this();
        properties = propertiesIn; 
    }

    /**
    *  Process tokens: store a token
    *  @param token type String
    */
    public void processToken(String token) {
        int tokenCounter = 0;

        //Check if the token is already stored
        //If so, add 1 to number of occurances and put it back to TreeMap
        if (tokenCounts.containsKey(token)) {
            tokenCounter = tokenCounts.get(token);
            tokenCounter ++;
        //If first occurance of the token make token counter = 1
        } else {   
            tokenCounter = 1;
        }
        tokenCounts.put(token, tokenCounter);
    }

    /**
    *  Get Tokens count method
    *  @return tokenCounts
    */
    public Map getTokenCounts() {
        return tokenCounts;
    }

    /**
    *  Produce a List of Unique tokens counts.
    *  Write the list into a file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.token.count");
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
            
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            for (Map.Entry<String, Integer> entry : tokenCounts.entrySet()) {
                printWriter.println(entry.getKey() + "\t" + entry.getValue());
            }
        } catch (IOException iOException) {
            System.out.println("Cannot write Unique Tokens Count Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Unique Tokens Count Report file");
            exception.printStackTrace();
        }    
    }
     
}