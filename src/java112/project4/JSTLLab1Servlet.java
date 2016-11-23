package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * JSTL Servlet Java112 Unit 4 JSTL Lab
 * @author Olena Collins
 */
@WebServlet(
        name = "JSTLLab1Servlet",
        urlPatterns = { "/JSTLLab1Servlet" }
)
public class JSTLLab1Servlet extends HttpServlet {
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
        String name1 = "Coco";
        String name2 = "Buddy";
        String name3 = "Rax";
        String name4 = "Jerik";
        ArrayList<String> names= new ArrayList<String>();

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);

        request.setAttribute("names", names);

        String url = "/jstl-lab2.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}