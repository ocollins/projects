package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Run Analyzer file process Servlet Java112 Project 4
 * @author Olena Collins
 */
@WebServlet(
        name = "analyzeFileServlet",
        urlPatterns = { "/analyzeFileServlet" }
)
public class RunAnalyzerServlet extends HttpServlet {

    public void init() throws ServletException {
        Debug debug = new Debug();
        debug.writeDebug("Init method In the Run Analyzer servlet");

    }
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
        //response.setContentType("text/html");
        //Create session variable
        HttpSession session = request.getSession(true);

        Debug debug = new Debug();
        debug.writeDebug("In the Run analyzer servlet");

        //Create a ServletContext object
        ServletContext context = getServletContext();

        //Get analyzer properties from the servlet context container
        Properties properties = new Properties();

        //Get output files' paths
        properties = (Properties) context.getAttribute("analyzerProperties");
        String summaryFile = properties.getProperty("output.file.summary");
        String outputDirectory = properties.getProperty("output.dir");
        debug.writeDebug("In Analyzer Servlet Summary file " + outputDirectory + summaryFile);

        session.setAttribute("SummaryReport", summaryFile);
        //Get EmployeeDirectory from ServletContext object's attribute
       // AnalyzeFile analyzeFile = new AnalyzeFile();
        //Call Analyzer main processor
        //analyzeFile.runAnalysis(args);
         //directory = (EmployeeDirectory) context.getAttribute("pr4EmployeeDirectory");
        //Get name of the file to analyze
        String fileName = request.getParameter("filename");
        debug.writeDebug("file name from jsp " + fileName);


        String url = "/java112/DisplayAnalyzerReports.jsp";
        response.sendRedirect(url);


    }
}