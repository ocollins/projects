package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Add Employee Display Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "addEmployeeDispServlet",
        urlPatterns = { "/addEmplDispServlet" }
)
public class AddEmployeeDisplayServlet extends HttpServlet {
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

        //Remove the old session
        HttpSession session = request.getSession(true);
        session.invalidate();

        String url = "/AddEmployee.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}