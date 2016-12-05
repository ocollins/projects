package java112.analyzer;

import  java.util.*;
import  java.io.*;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Unique Token Analyzer Class 
*/

public class UniqueTokenAnalyzer implements Analyzer{
    private Set<String> uniqueTokensList;
    private Properties properties;

    /**
    *  Empty class constructor.
    *  Create an instance of the Tree Set - the container to store list of 
    *  unique tokens. 
    */
    public UniqueTokenAnalyzer() {
        uniqueTokensList = new TreeSet<String>();
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data 
    *  @param propertiesIn properties
    */
    public UniqueTokenAnalyzer(Properties propertiesIn) {
        //Call empty constructor
        this();

        //Get properties data
        properties = propertiesIn; 
    }

    /**
    *  Gets the list of unique tokens
    *  @return uniqueTokensList list of tokens
    */
    public Set getUniqueTokensList() {

        return uniqueTokensList;
    } 

    /**
    *  Process tokens: store the token if it is not an empty string
    *  @param token type String
    */
    public void processToken(String token) {

        uniqueTokensList.add(token);
    }

    /**
    *  Produce a List of Unique tokens.
    *  Write the list into a txt file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.uniquet");
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");

        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            for (String aToken : uniqueTokensList) {
                printWriter.println(aToken);
            }
            //Create HTML file
            writeOutputHtmlFile();

        } catch (IOException iOException) {
            System.out.println("Cannot write Unique Tokens Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Unique Tokens Report file");
            exception.printStackTrace();
        }    
    }

    /**
     *  Produce a List of Unique tokens.
     *  Write the list into an HTML file.
     */
    public void writeOutputHtmlFile() {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.uniqueh");

        //Get output directory
        String outputDirectory = properties.getProperty("output.dir.web");

        try(BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
            PrintWriter printWriter =
                    new PrintWriter(bufferedWriter)) {
            for (String aToken : uniqueTokensList) {
                printWriter.println(aToken + "<br>");
            }
        } catch (IOException iOException) {
            System.out.println("Cannot write Unique Tokens Report HTML file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processig Unique Tokens Report HTML file");
            exception.printStackTrace();
        }
    }
     
}