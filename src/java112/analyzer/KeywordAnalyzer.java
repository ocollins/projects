package java112.analyzer;

import  java.util.*;
import  java.io.*;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Keyword Analyzer Class 
*/

public class KeywordAnalyzer implements Analyzer{
    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    //store keyword position in the file    
    private int tokenOccurence;

    /**
    *  Empty class constructor.
    *  Create an instance of the TreeMap. 
    */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List<Integer>>();
        tokenOccurence = 0;
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data. 
    *  @param propertiesIn properties
    */
    public KeywordAnalyzer(Properties propertiesIn) {

        //Call empty constructor
        this();
        properties = propertiesIn;
        loadKeywordsFile(); 
    }

    /**
    *  Load keywords from a file
    */
    public void loadKeywordsFile() {
        ArrayList keywordsList = new ArrayList();
        String lineIn = null;
        
        try (BufferedReader bufferedReader = 
                new BufferedReader
               (new FileReader(properties.getProperty("file.path.keywords")))) {
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();
                keywordsList.add(lineIn);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Keywords file not found");
            ex.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Problem reading the Keywords file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processing the Keywords file");
            exception.printStackTrace();
        }    

    }

    /**
    *  Process tokens: store a token
    *  @param token type String
    */
    public void processToken(String token) {
        //bump up position counter
        tokenOccurence++;

        //Check if the token is a keyword
        //If so, add 1 to number of occurnces and put it back to TreeMap
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