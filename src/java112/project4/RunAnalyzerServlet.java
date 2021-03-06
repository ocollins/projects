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
        name = "analyzeFileServlet",
        urlPatterns = { "/analyzeFileServlet" }
)
public class RunAnalyzerServlet extends HttpServlet {

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

        //Create a ServletContext object
        ServletContext context = getServletContext();

        //Array of strings to pass to AnalyzeFile
        String[] inputToAnalyzer = new String[2];

        //Get analyzer properties from the servlet context container
        Properties properties = new Properties();

        //Get the input file name from the form and
        //save it in the Array to be passed to the AnalyzeFile class
        inputToAnalyzer[0] = request.getParameter("filename");

        //Get analyzer properties file name and store it in the Array to be passed
        //to the AnalyzeFile class
        inputToAnalyzer[1] = (String) context.getAttribute("analyzerPropertiesFile");

        //Create a new AnalyzeFile object
        AnalyzeFile analyzeFile = new AnalyzeFile();

        //Call Analyzer main processor
        analyzeFile.runAnalysis(inputToAnalyzer);

        //Get analyzer properties file from the context
        properties = (Properties) context.getAttribute("analyzerProperties");

        //Get output directory name
        String outputDirectory = properties.getProperty("output.dir");
        //Get Summary file name
        String summaryFile = properties.getProperty("output.file.summaryh");

        //Save Summary file name in the context container
        context.setAttribute("SummaryFile", "/java112/" + outputDirectory + summaryFile);

        //Get Unique words file name
        String uniqueFile = properties.getProperty("output.file.uniqueh");
        //Save Unique words file name in the context container
        context.setAttribute("UniqueFile", "/java112/" + outputDirectory + uniqueFile);

        //Get Big words file name
        String bigFile = properties.getProperty("output.file.bigwordsh");
        //Save Big words file name in the context container
        context.setAttribute("BigFile", "/java112/" + outputDirectory + bigFile);

        //Get Token Count file name
        String tokenCountFile = properties.getProperty("output.file.token.counth");
        //Save Token Count file name in the context container
        context.setAttribute("TokenCountFile", "/java112/" + outputDirectory + tokenCountFile);

        //Get Lexical Report file name
        String lexicalFile = properties.getProperty("output.file.lexical.reporth");
        //Save Lexical report file name in the context container
        context.setAttribute("LexicalFile", "/java112/" + outputDirectory + lexicalFile);

        //Get Token Size Report file name
        String tokenSizeFile = properties.getProperty("output.file.token.sizeh");
        //Save Token Size report file name in the context container
        context.setAttribute("TokenSizeFile", "/java112/" + outputDirectory + tokenSizeFile);

        //Get Keywords Report file name
        String keywordsFile = properties.getProperty("output.file.keyword");
        //Save Keywords report file name in the context container
        context.setAttribute("KeywordsFile", "/java112/" + outputDirectory + keywordsFile);

        //Display results
        String url = "/java112/DisplayAnalyzerReports.jsp";
        response.sendRedirect(url);


    }
}