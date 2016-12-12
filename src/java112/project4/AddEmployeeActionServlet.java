package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Add employee action Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "addEmployeeActionServlet",
        urlPatterns = { "/addNewEmplServlet" }
)
public class AddEmployeeActionServlet extends HttpServlet {

    public void init() throws ServletException {

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
        boolean addEmployeeSuccess = false;
        String message = " ";

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

        //Call EmployeeDirectory to add the new employee to the DB
        addEmployeeSuccess = directory.addNewEmployee(firstName,
                                   lastName, sSN, department, room, phone);
        if (addEmployeeSuccess) {
            message = "New Employee Added";
            session.setAttribute("feedbackMessage", message);
        } else {
            message = "Error Adding New Employee";
            session.setAttribute("feedbackMessage", message);
        }

        String url = "/java112/AddEmployee.jsp";
        response.sendRedirect(url);


    }
}