package java112.project3;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is a java servlet class which controls the operation.
 * @author Eric Monforte
 */
@WebServlet(
        name = "TicTacPawServlet",
        urlPatterns = { "/TicTacPaw" }
)

public class TicTacPawServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);

        //local variables
        TicTacPawData myData = new TicTacPawData();

        String playerMove = request.getParameter("square");
        if (playerMove == null) {
            //java bean creation
            createJavaBean(session, myData);
        } else {

            myData = (TicTacPawData) session.getAttribute("myData");
            String[] square = myData.getSquare();

            if (square[Integer.parseInt(playerMove)].equals(" ")) {

                square[Integer.parseInt(playerMove)] = "1";
                myData.setMoves(myData.getMoves()+1);

                TicTacPawAI anAI = new TicTacPawAI(myData);
                anAI.process();

            }

            myData.setSquare(square);
            session.setAttribute("myData", myData);
        }

        // Forward
        forwardControl(request, response);

    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     */

    /**
     *  This creates java beans.
     *
     *@param  session                   the HttpServletRequest object
     *@param  TicTacPaw           Java Beans object with request data.
     */

    private void createJavaBean(HttpSession session,
                                TicTacPawData TicTacPaw) {

        //set Java Bean
        String[] square = new String[9];
        square[0] = " ";
        square[1] = " ";
        square[2] = " ";
        square[3] = " ";
        square[4] = " ";
        square[5] = " ";
        square[6] = " ";
        square[7] = " ";
        square[8] = " ";

        TicTacPaw.setSquare(square);

        //add java bean
        session.setAttribute("myData", TicTacPaw);

    }

    /**
     *  This forwards control to RequestData.jsp
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     */
    private void forwardControl(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException {

        String url = "/TicTacPaw.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
