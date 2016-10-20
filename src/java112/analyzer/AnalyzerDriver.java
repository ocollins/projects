package java112.analyzer;

import java.io.*;

/**
*  Project 1
*  @author Olena Collins
*  Text file analyzer application:
*      Read each line from the input file;
*      Split each line into words/tokens;
*      Produce Summary Report;
*      Produce Unique Tokens Report;  
* 
*  AnalyzerDriver Class 
*/

public class AnalyzerDriver {
    /**
    *  Main method
    *  @param args command line arguments
    */
    public static void main(String[] args) {
        AnalyzeFile analyzeFile = new AnalyzeFile();
        //Call Analyzer main processor
        analyzeFile.runAnalysis(args);
    }


}