package java112.analyzer;

/**
*  Project 1
*  @author Olena Collins
*  Text file analyzer application
*  Analyzer Interface
*/

public interface Analyzer {
    /**
    *  processToken method
    *  @param token a word
    */
    void processToken(String token);

    /**
    *  writeOutputFile method   
    *  @param inputFilePath input file name
    */
    void writeOutputFile(String inputFilePath);
}