package java112.labs2;

import java.io.*;
import java.util.*;

/**
*   LabTwoFour class
*   @author Olena Collins
*/

public class LabTwoFour {
    Map<String, Integer> lab4Map;
    Map<String, Integer> mapWithMap;    
    public static void main(String[] args) {
        LabTwoFour lab4 = new LabTwoFour();
        
        lab4.run();    
    
    }
 
    /**
    *   run method
    *   
    */   
    public void run() {
        lab4Map = new HashMap<String, Integer>();

        String LIT_THREE = "Three";
        lab4Map.put("One", 1);
        lab4Map.put("Two", 2);
        lab4Map.put("Three", 3);
        lab4Map.put("Four", 4);
        lab4Map.put("Five", 5);
        //Display all key/value pairs    
        System.out.println("Original map " + lab4Map);
        
        //Loop a Map
        for (Map.Entry <String, Integer> entry : lab4Map.entrySet()) {
            System.out.println("The key " + entry.getKey() + " Value " + entry.getValue().toString());
        }

        //Check if a key is in the Map
        if (lab4Map.containsKey(LIT_THREE)) {
            System.out.println("The value for key " + LIT_THREE + " is " + lab4Map.get(LIT_THREE));
        } else {
            System.out.println("The value for key " + LIT_THREE + " is not there");
        }  
        
        mapWithMap = new TreeMap<String, Integer>(lab4Map);
        System.out.println("Map with a map " + mapWithMap); 
        //mapWithMap.put("map1", lab4Map);

    }

}