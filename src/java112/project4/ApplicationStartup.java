package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Employee Management Application Startup Servlet for Project 4
 *  @author Olena Collins
 */

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {
    Properties properties;

    /**
    *  Servlet init method
    *  @exception ServletException 
    */
    public void init() throws ServletException {
        properties = new Properties();

        String propertiesFilePath = "/project4.properties";
        //Create ServletContext object
        ServletContext context = getServletContext();
        EmployeeDirectory newEmployeeDirectory = null;

        InputStream propertiesStream =
                this.getClass().getResourceAsStream(propertiesFilePath);
        try {
            properties.load(propertiesStream);
            //Store properties object in the ServletContext container
            context.setAttribute("project4Properties", properties);

            newEmployeeDirectory = new EmployeeDirectory(properties);
            //Store new EmployeeDirectory object in the ServletContext container
            context.setAttribute("pr4EmployeeDirectory", newEmployeeDirectory);
        } catch (IOException iOException) {
            System.out.println("Cannot load the properties file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error loading properties file");
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

        out.close();
    }



}

