package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Employee Search Display Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "addEmployeeActionServlet",
        urlPatterns = { "/addNewEmplServlet" }
)
public class AddEmployeeActionServlet extends HttpServlet {
    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //Create a ServletContext object
        ServletContext context = getServletContext();
        //Get EmployeeDirectory from ServletContext object's attribute
        EmployeeDirectory directory = (EmployeeDirectory) context.getAttribute("pr4EmployeeDirectory");

        String url = "/AddEmployee.jsp";
        response.sendRedirect(url);

    }
}