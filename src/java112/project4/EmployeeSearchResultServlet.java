package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Employee Search Process Result Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "employeeSearchResultServlet",
        urlPatterns = { "/employeeSearchResServlet" }
)
public class EmployeeSearchResultServlet extends HttpServlet {
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
        //Debug!!
        Debug debug = new Debug();
        debug.writeDebug("In the Search results servlet");
        response.setContentType("text/html");
        //Create session variable
        HttpSession session = request.getSession(true);
        //Create an EmployeeDirectory variable
        EmployeeDirectory employeeDirectory = null;
        //Create a Search variable
        Search search = new Search();

        ServletContext context = getServletContext();
        //Get SearchDirectory object from the ServletContext container
        employeeDirectory = (EmployeeDirectory) context.getAttribute("pr4EmployeeDirectory");
        debug.writeDebug("In the Search result searchType " + request.getParameter("searchType"));
        debug.writeDebug("In the Search result searchTerm " + request.getParameter("searchTerm"));

        //Get search type and search criteria from the EmployeeSearch form
        if(request.getParameter("searchType") != null && request.getParameter("searchTerm") != null) {
            search.setSearchType(request.getParameter("searchType"));
            search.setSearchTerm(request.getParameter("searchTerm"));
            //Store Search data in the session
            session.setAttribute("searchResult", search);

        }

        String url = "/EmployeeSearchResults.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}