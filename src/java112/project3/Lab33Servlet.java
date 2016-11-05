package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Lab 3-3 Servlet Java112
 *@author Olena Collins
 */
@WebServlet(
    name = "Lab33Servlet",
    urlPatterns = { "/lab33" }
)
public class Lab33Servlet extends HttpServlet {

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

        Map map = new HashMap();
        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is an h2</h2>");
        map.put("aDate", new Date());
        request.setAttribute("myMap", map);

        String url = "/Lab33.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        out.print("<HTML>");
        out.print("<HEAD><TITLE> Lab 33 Servlet</TITLE></HEAD>");
        out.print("<BODY bgcolor = \"#f9ce84\">");
        out.print("<h1 align = \"center\" style = \"line-height: 155px\">Lab 33 Servlet</h1>");


        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }



}

