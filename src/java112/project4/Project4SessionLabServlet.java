package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.analyzer.*;

/**
 * Run Analyzer file process Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "project4SessionServlet",
        urlPatterns = { "/project4SessionServlet" }
)
public class Project4SessionLabServlet extends HttpServlet {

//    public void init() throws ServletException {
//
//    }
    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create session variable
        HttpSession session = request.getSession(true);
        int sessionCounter = 0;

        if (session.getAttribute("project4SessionCounter") == null) {
            sessionCounter = 1;
        } else {
            sessionCounter = (int) session.getAttribute("project4SessionCounter");
            sessionCounter ++;
        }
        session.setAttribute("project4SessionCounter", sessionCounter);

        String url = "/project4Session.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}