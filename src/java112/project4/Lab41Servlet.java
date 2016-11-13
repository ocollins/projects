package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *  Servlet for Lab 4-4
 *@author Olena Collins
 */
/**
* @WebServlet - annotation, used to declare a servlet; Replaces web.xml file
* name is the name of the servlet;
* URL Pattern of the servlet;
*/
@WebServlet(
    name = "Lab41Servlet",
    urlPatterns = { "/labfourone" }
)
public class Lab41Servlet extends HttpServlet {
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
        out.print("<HEAD><TITLE>Lab Four One Servlet</TITLE></HEAD>");
        out.print("<BODY bgcolor = \"#64d9c2\">");
        out.print("<h1 align = \"center\">Lab Four One Servlet</h1>");
        out.print("<p align = \"center\"> Owners name " + request.getParameter("ownername") + "</p>");

//        out.println("<table border = 1>");
//        out.print("<tr><td> HIT COUNTER " + hitCounter + "</td></tr>");
//        out.print("<tr><td>First hit " + servletLoadTime + "</td></tr>");
//        out.print("<tr><td>Current date " + getTime() + "</td></tr>");
//        out.print("</table>");
        
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }



}

