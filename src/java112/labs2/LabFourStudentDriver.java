package java112.labs2;

import java.io.*;
import java.util.*;

/**
*   LabFour Student driver class
*   @author Olena Collins
*/

public class LabFourStudentDriver {

    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new TreeMap<Integer, Student>();
        Student student1 = new Student(111, "Maria", "Sharapova");
        studentMap.put(student1.getId(), student1);

        Student student3 = new Student(333, "Christina", "Agulera");
        studentMap.put(student3.getId(), student3);

        Student student2 = new Student(222, "Joe", "Smith");
        studentMap.put(student2.getId(), student2);

        Student student4 = new Student(222, "Joe", "Clark");

        studentMap.replace(222, student4);

        System.out.println("Students Map direct access " + studentMap);  
        
        System.out.println("Students using getters: ");
        for (Map.Entry <Integer, Student> entry : studentMap.entrySet()) {
            System.out.print(entry.getKey().toString());
            System.out.println(entry.getValue().getFName() + " " + entry.getValue().getLName());
        }  
    
    }
}
 
