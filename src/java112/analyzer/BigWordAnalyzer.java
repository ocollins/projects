package java112.analyzer;

import  java.util.*;
import  java.io.*;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Big Word Analyzer Class 
*/

public class BigWordAnalyzer implements Analyzer{
    private Set<String> bigWords;
    private Properties properties;
    private int mimimumWordLenth;

    /**
    *  Empty class constructor.
    *  Create an instance of the Tree Set. 
    */
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data 
    *  @param propertiesIn properties
    */
    public BigWordAnalyzer(Properties propertiesIn) {

        //Call empty constructor
        this();
        //Get minimum word length from .properties file
        properties = propertiesIn; 
        mimimumWordLenth = Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
    }

    /**
    *  Process tokens: store a token if it is greater or equal than min length
    *  @param token type String
    */
    public void processToken(String token) {
        if (token.length() >= mimimumWordLenth) {
            bigWords.add(token);
        }
    }

    /**
    *  Get Big words method
    *  @return bigWords
    */
    public Set<String> getBigWords() {
        return bigWords;
    }

    /**
    *  Produce a List of Big Words.
    *  Write the list into a file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file
        String outputFilePath = properties.getProperty("output.file.bigwords");

        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");

        //Write big words into a file    
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            for (String aToken : bigWords) {
                printWriter.println(aToken);
            }
        } catch (IOException iOException) {
            System.out.println("Cannot write Big Words Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Big Words Report file");
            exception.printStackTrace();
        }    
    }
     
}