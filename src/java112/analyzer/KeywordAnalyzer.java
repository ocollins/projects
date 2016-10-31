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
        String lineIn = null;
        ArrayList<Integer> keywordPosition = null;
        
        try (BufferedReader bufferedReader = 
                new BufferedReader
               (new FileReader(properties.getProperty("file.path.keywords")))) {
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();
                keywordPosition = new ArrayList<Integer>();
                keywordMap.put(lineIn, keywordPosition);
                keywordPosition = null;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Keywords Input file not found");
            ex.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Problem reading the Keywords Input file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processing the Keywords Input file");
            exception.printStackTrace();
        }    

    }

    /**
    *  Process tokens: store a token
    *  @param token type String
    */
    public void processToken(String token) {
        List<Integer> tokenPositionArray = null;
        //bump up the token position count in the file
        tokenOccurence ++;

        //Check if the token is a keyword
        //If so, add 1 to number of occurnces, store it as position in the file
        //Put it back into the Map container
        if (keywordMap.containsKey(token)) {
            tokenPositionArray = new ArrayList<Integer>();

            //Get ArrayList of keyword positions from the Map container
            tokenPositionArray = keywordMap.get(token);
            //Add new position to the ArrayList
            tokenPositionArray.add(tokenOccurence);
            //Put keyword and ArrayList of positions back into the Map container
            keywordMap.put(token, tokenPositionArray);
        } 
        
    }

    /**
    *  Get Keyword Map method
    *  @return keywordMap
    */
    public Map<String, List<Integer>> getKeywordMap() {
        return keywordMap;
    }

    /**
    *  Produce a List of keywords and their positions in the file.
    *  Write the list into a file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.keyword.report");
        System.out.println("keyword file " + outputFilePath);
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
            
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            for (Map.Entry<String, List<Integer>> entry : keywordMap.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    writeOutputLines(entry);
                }
            }
        } catch (IOException iOException) {
            System.out.println("Cannot write Keyword Map Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig KeywordMap Report file");
            exception.printStackTrace();
        }    
    }

    /**
     *  Method that will eveluate number of members in the ArrayList in the Map for each keyword;
     *  Up to 10 members will be written per line into the output file;
     *  @param entryIn list of keywords and ArrayList of keyword locations in the input file;
     */
    public void writeOutputLines(Map.Entry<String, List<Integer>> entryIn) {
        int numberOfLocations = 0;
        int numberOfLocationsLeft = 0;
        int numberOfLines = 0;
        int arrayIndex = 0;

        List<Integer> locations = new ArrayList <Integer>();
        locations = entryIn.getValue();
        numberOfLocations = locations.size();
        numberOfLines = numberOfLocations / 10;
        numberOfLocationsLeft = numberOfLocations - numberOfLines * 10;

        if (numberOfLocations < 11) {
                printWriter.pri|ntln(entry.getKey() + "\t" + entry.getValue());
            } else {
                for (int x = 0; x < numberOfLines; x ++) {

                }

            }


    }

}