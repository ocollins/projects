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

    public void init() throws ServletException {
        Debug debug = new Debug();
        debug.writeDebug("Init method In the Add Employee Action servlet");

    }
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
        //response.setContentType("text/html");
        //Create session variable
        HttpSession session = request.getSession(true);
        Debug debug = new Debug();
        debug.writeDebug("In the Add Employee Action servlet");

        //Create a ServletContext object
        ServletContext context = getServletContext();
        //Get EmployeeDirectory from ServletContext object's attribute
        EmployeeDirectory directory = (EmployeeDirectory) context.getAttribute("pr4EmployeeDirectory");

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String sSN = request.getParameter("ssn");
        String department = request.getParameter("department");
        String room = request.getParameter("room");
        String phone = request.getParameter("phone");
        debug.writeDebug(firstName + lastName + sSN);

        String message = "New Employee Added";
        session.setAttribute("feedbackMessage", message);

        String url = "/java112/AddEmployee.jsp";
        response.sendRedirect(url);


    }
}