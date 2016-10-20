package java112.analyzer;

import  java.util.*;
import  java.io.*;
import  java.text.NumberFormat;
import  java.text.ParsePosition;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  Lexical Density Analyzer Class 
*/

public class LexicalDensityAnalyzer implements Analyzer{
    private int totalTokensCount = 0;
    private int totalLexicalCount = 0; 
    private int densityPercent = 0;   
    private Properties properties;
    private ArrayList<String> nonLexicalList;    

    /**
    *  Empty class constructor.
    *  Create an instance of the TreeMap. 
    */
    public LexicalDensityAnalyzer() {
        
    }

    /**
    *  Class constructor with one parameter.
    *  store properties data. 
    *  @param propertiesIn properties
    */
    public LexicalDensityAnalyzer(Properties propertiesIn) {
        properties = propertiesIn; 
        loadNonLexicalWords();
    }

    /**
    *  Load non lexical words from a file
    */
    public void loadNonLexicalWords() {
        nonLexicalList = new ArrayList();
        String lineIn = null;
        
        try (BufferedReader bufferedReader = 
                new BufferedReader
               (new FileReader(properties.getProperty("input.file.nonlexical.words")))) {
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();
                nonLexicalList.add(lineIn);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Non Lexical Words file not found");
            ex.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Problem reading the Non Lexical Words file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processing the Non Lexical Words file");
            exception.printStackTrace();
        }    

    }

    /**
    *  Process tokens: 
    *  1. Check if token is numeric;
    *  2. Check if length of the token is greater than 2 characters
    *  3. Check if it is on the list of non lexical words
    *  If none of the conditions above is true, add the token to 
    *  total count of lexical words.
    *  @param token type String
    */
    public void processToken(String token) {
        totalTokensCount++;
        boolean lexicalValue = true;

        if(isNumeric(token)) {
            lexicalValue = false;    
        }

        if(lexicalValue) {
            if(token.length() < 3) {
                lexicalValue = false;    
            }
        }

        if(lexicalValue) {
            if(nonLexicalList.contains(token)) {
                lexicalValue = false;    
            }
        }
        
        if(lexicalValue) {
            totalLexicalCount++;
        }

    }

    /**
    *  Check if the string is numeric
    *  @param testString string to be checked
    *  @return true or false identifying if string is numeric
    */
    public static boolean isNumeric(String testString) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(testString, pos);
        return testString.length() == pos.getIndex();
    }

    /**
    *  Caluculate % of lexical density
    *  Write the report to the output file 
    *  @param inputFilePath name of input file
    */
    public void writeOutputFile(String inputFilePath) {
        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.lexical.report");
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");
        
        int lexicalDensity = getDensityPercent();
            
        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            printWriter.println("Lexical density of " + inputFilePath + " " +
                                lexicalDensity + "%");
        } catch (IOException iOException) {
            System.out.println("Cannot write Lexical Density Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Lexical Density Report file");
            exception.printStackTrace();
        }    
    }

    /**
    *  Calculate % Lexical Density
    *  @return density percent
    */
    public int getDensityPercent() {
        densityPercent = totalLexicalCount * 100 / totalTokensCount;
        return densityPercent;
    }
     
     
}