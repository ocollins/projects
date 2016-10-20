package java112.analyzer;

import  java.util.*;
import  java.text.DateFormat;
import  java.text.SimpleDateFormat;
import  java.io.*;

/**
*  Java 112
*  @author Olena Collins
*  Text file analyzer application
*  SummaryReport Class 
*/

public class SummaryReport implements Analyzer{
    private static int totalTokensCount = 0;
    private Properties properties;

    /**
    *  Empty constructor
    */
    public SummaryReport() {

    }

    /**
    *  Class constructor with one parameter.
    *  store properties data. 
    *  @param propertiesIn properties
    */
    public SummaryReport(Properties propertiesIn) {
        properties = propertiesIn;
    }
    
    /**
    *  Get Total number of tokens 
    *  @return totalTokensCount
    */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
    *  Count total number of tokens if it is not an empty string 
    *  @param token - a word
    */
    public void processToken(String token) {
        totalTokensCount++;
    }

    /**
    *  Produce Summary Report Output File.
    *  @param inputFilePath name of the input file
    */
    public void writeOutputFile(String inputFilePath) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //Get name of the output file from the properties file
        String outputFilePath = properties.getProperty("output.file.summary");
        
        //Get name of the output directory
        String outputDirectory = properties.getProperty("output.dir");

        try(BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter(outputDirectory + outputFilePath));
                PrintWriter printWriter = 
                new PrintWriter(bufferedWriter)) {
            //Create File object to be used for retreiving file path 
            File absoluteName = new File(inputFilePath);

            //Create Summary file lines
            printWriter.println("Application: " + properties.getProperty("application.name"));
            printWriter.println("Author:      " + properties.getProperty("author"));
            printWriter.println("Email:       " + properties.getProperty("author.email.address"));
            printWriter.println("Input file:  " + absoluteName.getAbsolutePath());
            printWriter.println("Analyzed on: " + dateFormat.format(date));
            printWriter.print("Total token count:"); 
            printWriter.format("%, d", totalTokensCount);

        } catch (IOException iOException) {
            System.out.println("Cannot write Summary Report file");
            iOException.printStackTrace();  
        } catch (Exception exception) {
            System.out.println("Error processig Summary Report file");
            exception.printStackTrace();
        }
    }
    
}