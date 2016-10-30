package java112.analyzer;

import  java.io.*;
import  java.util.*;

/**
*  Project 1
*  @author Olena Collins
*  Text file analyzer application
*  Analyze File Class 
*/

public class AnalyzeFile {
    private static final int    VALID_NUMBER_OF_ARGUMENTS = 2;
    private String              inputFilePath;
    private ArrayList <Analyzer>  analyzers;
    private Properties properties;

    /**
    *  runAnalysis method
    *  @param arguments array of strings
    */
    public void runAnalysis(String[] arguments) {
        String propertiesFilePath = null;
        properties = new Properties();
        
        if(arguments.length == VALID_NUMBER_OF_ARGUMENTS) {
            inputFilePath = arguments[0];
            propertiesFilePath = arguments[1];
            loadProperties(propertiesFilePath);
            
            processInputFile();
            writeAllOutputFiles();
            
        } else {
            System.out.println("Please enter one argument on the command line");
        }   
    }
    
    /**
    *  Load Properties from .properties file 
    *  @param propertiesFilePathIn name of the .properties file
    */
    public void loadProperties(String propertiesFilePathIn) {
        
        InputStream propertiesStream =  
                this.getClass().getResourceAsStream(propertiesFilePathIn);
        try {
            properties.load(propertiesStream);
            createAnalyzers(properties);
        } catch (IOException iOException) {
            System.out.println("Cannot load the properties file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error loading properties file");
            exception.printStackTrace();
        } 
    }

    /**
    *  Create Analyzer objects. 
    *  Create an instance of each analyzer and add it to ArrayList.
    *  @param propertiesParm properties file object
    */
    public void createAnalyzers(Properties propertiesIn) {
        analyzers = new ArrayList<Analyzer>();
        
        UniqueTokenAnalyzer uniqueTokenAnalyzer = new UniqueTokenAnalyzer(propertiesIn);
        analyzers.add(uniqueTokenAnalyzer);

        SummaryReport summaryReport = new SummaryReport(propertiesIn);
        analyzers.add(summaryReport);

        BigWordAnalyzer bigWordAnalyzer = new BigWordAnalyzer(propertiesIn);
        analyzers.add(bigWordAnalyzer);

        TokenCountAnalyzer tokenCountAnalyzer = new TokenCountAnalyzer(propertiesIn);
        analyzers.add(tokenCountAnalyzer);

        LexicalDensityAnalyzer lexicalDensityAnalyzer = new LexicalDensityAnalyzer(propertiesIn);
        analyzers.add(lexicalDensityAnalyzer);

        TokenSizeAnalyzer tokenSizeAnalyzer = new TokenSizeAnalyzer(propertiesIn);
        analyzers.add(tokenSizeAnalyzer);

        KeywordAnalyzer keywordAnalyzer = new KeywordAnalyzer(propertiesIn);
        analyzers.add(keywordAnalyzer);
    }
    
    /**
    *  Open Input File method. 
    *  Read the file line by line.
    */
    public void processInputFile() {
        String lineIn = null;
        String[] tokenArray = null;
        
        try (BufferedReader bufferedReader = 
                    new BufferedReader(new FileReader(inputFilePath))) {
            while (bufferedReader.ready()) {
                lineIn = bufferedReader.readLine();
                tokenArray = lineIn.split("\\W"); 
                storeTokens(tokenArray);  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Input file not found");
            ex.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Problem reading the input file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error processing the input file");
            exception.printStackTrace();
        }
    }

    /**
    *  Split array of tokens. 
    *  @param tokenArrayIn array of strings
    */
    public void storeTokens(String[] tokenArrayIn) {
        for (int i = 0; i < tokenArrayIn.length; i++) {
            if (!tokenArrayIn[i].isEmpty()) { 
                callProcessToken(tokenArrayIn[i]);
            }    
        }    
    }

    /**
    *  Call each Analyzer to process tokens 
    *  @param tokenIn a token to be processed
    */
    public void callProcessToken(String tokenIn) {
        for (Analyzer analyzer : analyzers) {       
            analyzer.processToken(tokenIn);
        }
    }

    /**
    *  Produce output reports. 
    */
    public void writeAllOutputFiles() {
        for (Analyzer analyzer : analyzers) {       
            analyzer.writeOutputFile(inputFilePath);
        }
    }    

}