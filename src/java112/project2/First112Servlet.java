package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;


/**
 *  First Servlet Java112
 *@author Olena Collins
 */
@WebServlet(
    name = "first112Servlet", 
    urlPatterns = { "/first112" }
)
public class First112Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>First 112 Servlet</TITLE></HEAD>");
        out.print("<BODY bgcolor = \"#f9ce84\">");
        out.print("<h1 align = \"center\" style = \"line-height: 155px\">First 112 Servlet</h1>");
        out.print("<h2 align = \"center\">Author: Olena Collins</h2>");
        out.print("<h3 align = \"center\">Advanced Java</h3>");
       
        out.print("<p align = \"center\"><a href=\"/java112\">INDEX</a></p>");
        out.print("<p align = \"center\"> " +
                  "<img src=\"images/books.jpg\" alt=\"Photo\"/>" + "</p>");
 
        out.print("<footer><p align = \"center\" style = \"line-height: 155px\"> Current date " 
                  + getTime() + "</p></footer>");

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

