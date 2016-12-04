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

        response.setContentType("text/html");
        //Create session variable
        HttpSession session = request.getSession(true);
        //Create an EmployeeDirectory variable
        EmployeeDirectory employeeDirectory = null;
        //Create a Search object
        Search search = new Search();
        //Get search type
        String searchType = null;
        String searchTerm = null;

        ServletContext context = getServletContext();
        //Get SearchDirectory object from the ServletContext container
        employeeDirectory = (EmployeeDirectory) context.getAttribute("pr4EmployeeDirectory");

        //Get search type and search criteria from the EmployeeSearch form
        if(request.getParameter("searchType") != null && request.getParameter("searchTerm") != null) {
            searchType = request.getParameter("searchType");
            searchTerm = request.getParameter("searchTerm");
            search.setSearchType(searchType);
            search.setSearchTerm(searchTerm);

            if (searchType.equals("I")) {
                //Call searchById method in the EmployeeDirectory class
                employeeDirectory.searchById(search);

            } else if (searchType.equals("N")) {
                employeeDirectory.searchByLastName(search);

            }

            //Store Search data in the session
            session.setAttribute("searchResult", search);

        }

        String url = "/EmployeeSearchResults.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}