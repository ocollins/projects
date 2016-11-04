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
    private Map<String, ArrayList<Integer>> keywordMap;
    private Properties properties;
    //store keyword position in the file    
    private int tokenOccurence;

    /**
    *  Empty class constructor.
    *  Create an instance of the TreeMap. 
    */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, ArrayList<Integer>>();
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
        ArrayList<Integer> tokenPositionArray = null;
        //bump up the token position count in the file
        tokenOccurence ++;

        //Check if the token is a keyword
        //If so, store its position in the file
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
    public Map<String, ArrayList<Integer>> getKeywordMap() {

        return keywordMap;
    }

    /**
    *  Produce a List of keywords and their positions in the file.
    *  Write the list into a file.
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.keyword");
        System.out.println("keyword file " + outputFilePath);
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
        System.out.println("output directory " + outputDirectory);
            
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            for (Map.Entry<String, ArrayList<Integer>> entry : keywordMap.entrySet()) {
                writeOutputLines(entry, printWriter);
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
     *  Method that will evaluate number of members in the ArrayList in the Map for each keyword;
     *  Up to 10 members will be written per line into the output file;
     *  @param entry list of keywords and ArrayList of keyword locations in the input file;
     */
    public void writeOutputLines(Map.Entry<String, ArrayList<Integer>> entry, PrintWriter printWriter) {
        int numberOfLocations = 0;
        int numberOfLocationsLeft = 0;
        int numberOfLines = 0;
        int arrayIndex = 0;
        int startIndex = 0;
        int numberOfIterations = 0;
        int nextIndex = 0;
        String eol = System.getProperty("line.separator");
        boolean printComma = false;

        String keyword = entry.getKey();
        ArrayList<Integer> locations = new ArrayList <Integer>();
        locations = entry.getValue();
        numberOfLocations = locations.size();
        numberOfLines = numberOfLocations / 10;
        numberOfLocationsLeft = numberOfLocations - numberOfLines * 10;

        //This will control printing a comma at the end of the line
        if (numberOfLocationsLeft > 0) {
            printComma = true;
        }

        //If the are only 10 or less locations for a keyword, print the whole ArrayList of locations
        if (numberOfLocations < 11) {
                printWriter.println(keyword + " = " + eol + locations);
        //If there are more than 10 locations to print, split the locations into more lines
        } else {
            //Produce all complete lines
            startIndex = 0;
            numberOfIterations = 10;
            printWriter.println(keyword + " = ");
            printWriter.print("[");
            for (int x = 0; x < numberOfLines; x ++) {
                nextIndex = printALine(startIndex, numberOfIterations, locations, printWriter, printComma);
                startIndex = nextIndex;
            }
            //Produce a partial line if needed to print the locations that are left
            if (numberOfLocationsLeft > 0) {
                printComma = false;
                nextIndex = printALine(startIndex, numberOfLocationsLeft, locations, printWriter, printComma);
            }
            printWriter.println("]");
        }

    }

    /**
     *  Iterate over members of ArrayList of locations up to 10 times, and produce a line
     *  @param startIndex Starting index in the ArrayList
     *  @param numIterations Number of times to iterate over ArrayList members
     *  @param locationIn ArrayList of token locations
     *  @param printComma a flag, which will control if a comma will be printed at the end of line
     *  @return next Index to be processed in the ArrayList of token locations
     */
    public int printALine(int startIndex, int numOfIterations, ArrayList<Integer> locations,
                          PrintWriter printWriter, boolean printComma) {
        int nextIndex = 0;
        //index to access members of ArrayList
        int index = startIndex;
        for(int x = 0; x < numOfIterations; x ++) {
            if (x == numOfIterations - 1) {
                printWriter.print(Integer.toString(locations.get(index)));
            } else {
                printWriter.print(Integer.toString(locations.get(index)) + ", ");
            }
            index ++;
        }
        if (printComma) {
            printWriter.println(",");
        }

        nextIndex = index;
        return nextIndex;

    }

}