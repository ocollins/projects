package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;


/**
 *  Servlet for Lab 2-5
 *@author Olena Collins
 */
/**
* @WebServlet - annotation, used to declare a servlet; Replaces web.xml file
* name is the name of the servlet;
* URL Pattern of the servlet;
*/
@WebServlet(
    name = "labTwoFiveServlet", 
    urlPatterns = { "/labtwofive" }
)
public class LabTwoFiveServlet extends HttpServlet {
    int hitCounter;
    String servletLoadTime;
    /**
    *  Servlet init method
    *  @exception ServletException 
    */
    public void init() throws ServletException {
        log("Testing log from init method");
        hitCounter = 0;
        servletLoadTime = getTime();
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

        hitCounter ++;
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Lab Two Five Servlet</TITLE></HEAD>");
        out.print("<BODY bgcolor = \"#64d9c2\">");
        out.print("<h1 align = \"center\">Lab Two Five Servlet</h1>");
        out.print("<p align = \"center\"> HIT COUNTER " + hitCounter + "</p>");
        out.print("<p align = \"center\"> First hit " + servletLoadTime + "</p>");  
        out.print("<p align = \"center\"> Current date " + getTime() + "</p>"); 

        out.println("<table border = 1>");
        out.print("<tr><td> HIT COUNTER " + hitCounter + "</td></tr>");
        out.print("<tr><td>First hit " + servletLoadTime + "</td></tr>");
        out.print("<tr><td>Current date " + getTime() + "</td></tr>");
        out.print("</table>");
        
        System.out.println("Logging message from println");
        log("Logging message from doGet method");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
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

