package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
/**
* @WebServlet - annotation, used to declare a servlet; Replaces web.xml file
* name is the name of the servlet;
* URL Pattern of the servlet;
*/
@WebServlet(
    name = "trivialServlet", 
    urlPatterns = { "/trivial", "/simple" }
)
public class TrivialServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<header>Testing page header</header>");
        out.print("<h1>TrivialServlet Here!</h1>");
        out.print("<h2>Testing header 2</h2>");
        out.print("<h3>Testing header 3</h3>");
        out.print("<img src=\"images/tennis.jpg\" alt=\"Photo\"/>");
        out.print("<ol><li>Cats</li><li>Dogs</li><li>Elefants</li></ol>");
        out.print("<hr />");

        out.print("<p><strong>@WebServlet</strong> is annotation, used to declare a servlet." +
                  " It can be used in place of web.xml file</p>");

        out.print("<p><strong>name</strong> is a name of the servlet</p>");
        out.print("<p><strong>urlPatterns</strong> is a URL for the servlet." + 
                  " They have to be unique</p>");
        
        out.print("<hr />");
        out.print("<a href=\"/java112\">INDEX</a>");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}

