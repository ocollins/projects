package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;


/**
 *  Properties Servlet Java112
 *@author Olena Collins
 */
@WebServlet(
    name = "PropertiesServlet", 
    urlPatterns = { "/properties" }
)
public class PropertiesServlet extends HttpServlet {
    Properties projectProperties;    

    /**
    *  Servlet init method
    *  @exception ServletException 
    */
    public void init() throws ServletException {
        projectProperties = new Properties();
        loadProperties("/project2.properties");
    }

     /**
    *  This method will load .properties file
    *  @param propertiesFilePath name of .properties file         
    */
    public void loadProperties(String propertiesFilePath) {
        InputStream propertiesStream = 
                this.getClass().getResourceAsStream(propertiesFilePath);
        try {
            projectProperties.load(propertiesStream);
        } catch (IOException iOException) {
            log("Cannot load the project properties file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            log("Error loading the project properties file");
            exception.printStackTrace();
        }

    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param      request the HttpServletRequest object
     *@param      response the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // set the response type before sending data
        PrintWriter  out  = response.getWriter();

        out.print("<HTML>");
        out.print("<HEAD><TITLE>Properties Servlet</TITLE></HEAD>");
        out.print("<link href=\"css/properties_style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.print("<body>");
        out.print("<h1 align = \"center\" style = \"line-height: 155px\">Properties Servlet</h1>");
        
        out.print(buildPropertiesTable());
       
        out.print("<p align = \"center\"><a href=\"/java112\">INDEX</a></p>");
 
        out.print("<footer><p align = \"center\" style = \"line-height: 155px\"> Current date " 
                  + getTime() + "</p></footer>");

        out.print("</body>");
        out.print("</HTML>");
        out.close();
    }

    /**
    *  Build properties table to display project properties
    *  @return StringBuffer containing an HTML string to build a
    *  table with project properties
    */ 
    public StringBuffer buildPropertiesTable() {
        StringBuffer propertiesBuffer = new StringBuffer();
        Set<String> myPropertiesList = projectProperties.stringPropertyNames();
        TreeSet<String> propertiesTreeSet = new TreeSet<String>();
        propertiesTreeSet.addAll(myPropertiesList);
    
        propertiesBuffer.append("<table class=\"prop-table\">");
        for(String keyValue : myPropertiesList) {
            propertiesBuffer.append("<tr><td>" + projectProperties.getProperty(keyValue) + "</td></tr>");
        }
        propertiesBuffer.append("</table>");
    
        return propertiesBuffer;
    }   

    /**
    *  Get Time method
    *  @return current time
    */ 
    public String getTime() {
        Date date = new Date();
        SimpleDateFormat fd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return fd.format(date);
    }
   

}

