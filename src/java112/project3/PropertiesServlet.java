package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Properties Servlet Java112
 *  @author Olena Collins
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet {
    Properties projectProperties;    

    /**
    *  Servlet init method
    *  @exception ServletException 
    */
    public void init() throws ServletException {
        projectProperties = new Properties();
        loadProperties("/project3.properties");
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
            log("Cannot load the project3 properties file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            log("Error loading the project3 properties file");
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

        request.setAttribute("Project3_Properties", projectProperties);
        String url = "/java112/Project3_Properties.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

