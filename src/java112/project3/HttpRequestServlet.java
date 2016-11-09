package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * HttpRequest Servlet Java112
 * @author Olena Collins
 */
@WebServlet(
        name = "httpRequestServlet",
        urlPatterns = { "/httpServlet" }
)
public class HttpRequestServlet extends HttpServlet {
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
        HttpRequestData httpData = new HttpRequestData();

        httpData.setRemoteComputerName(request.getRemoteHost());
        httpData.setRemoteComputerAddress(request.getRemoteAddr());
        httpData.setHttpMethod(request.getMethod());
        httpData.setRequestURI(request.getRequestURI());
        httpData.setRequestURL(request.getRequestURL().toString());
        httpData.setProtocol(request.getProtocol());
        httpData.setServerName(request.getServerName());
        httpData.setServerPort(Integer.toString(request.getServerPort()));
        httpData.setCurrLocale(request.getLocale().toString());
        httpData.setQueryString(request.getQueryString());
        httpData.setQueryParam(request.getParameter("queryParameter"));
        httpData.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("HttpRequstData", httpData);

        String url = "/HttpRequestData.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }
}