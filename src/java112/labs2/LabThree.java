package java112.labs2;

import java.io.*;
import java.util.*;
import java.util.TreeSet.*;

/**
* LabThree class
* @author Olena Collins
* Working with properties file
*/

public class LabThree {
    Properties properties;
    String propertiesFilePath;

    /**
    *  Main method for LabThree
    *  @param args command line arguments
    */
    public static void main(String[] args) {
        LabThree mylabThree = new LabThree();
        mylabThree.run(args[0]);
        
    }
    
    /**
    *  This method will load .properties file
    *  @param propertiesFilePath name of .properties file         
    */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        InputStream propertiesStream = this.getClass().getResourceAsStream(propertiesFilePath);
        try {
            properties.load(propertiesStream);
        } catch (IOException iOException) {
            System.out.println("Cannot load the properties file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error loading properties file");
            exception.printStackTrace();
        }
    }
    
    /**
    *  Run method. Calls a method to load properties file.
    *  Get a list of properties keys and store in HashSet.
    *  Display all keys, and all values.
    *  @param fileNameIn .properties file name 
    */
    public void run(String fileNameIn) {
        propertiesFilePath = fileNameIn;
        loadProperties(propertiesFilePath); 
        
        //display one property value for a key
        System.out.println("aplayer info " + properties.getProperty("aplayer")); 
  
        //Set<String> myPropertiesList = new TreeSet<String>();
        //myPropertiesList = properties.stringPropertyNames();
        Set<String> myPropertiesList = properties.stringPropertyNames();
        
        System.out.println("Original order of keys " + myPropertiesList);

        for (String keyValue : myPropertiesList) {
            System.out.println(properties.getProperty(keyValue));    
        }

        TreeSet<String> myTreeSet = new TreeSet<String>();
        myTreeSet.addAll(myPropertiesList);
        System.out.println("Ascending sort order " + myTreeSet);

        TreeSet<String> myDescTreeSet = new TreeSet<String>();
        myDescTreeSet = (TreeSet) myTreeSet.descendingSet();
        System.out.println("Descending sort order " + myDescTreeSet);
        //reereverse=(TreeSet)treeadd.descendingSet();

    }
    


}

