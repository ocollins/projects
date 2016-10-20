package java112.labs2;

import java.io.*;
import java.util.*;

/**
*   Class Student
*   @author Olena Collins
*/

public class Student {
    private int id;
    private String fName;
    private String lName;

    /**
    *   Set student info method
    *   @param  
    */
    public Student(int idIn, String fNameIn, String lNameIn) {
        id = idIn;
        fName = fNameIn;
        lName = lNameIn;
        
    }
    
    /**
    *   Get student ID method
    *   @return id 
    */
    public int getId() {
        return id;
    }

    /**
    *   Get student first name method
    *   @return fName 
    */
    public String getFName() {
        return fName;
    }

    /**
    *   Set student first name method
    *   @param fNameIn 
    */
    public void setFName(String fNameIn) {
        fName = fNameIn;
    }
        

    /**
    *   Get student last name method
    *   @return lName 
    */
    public String getLName() {
        return lName;
    }

}