package java112.project3;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

/**
 * This is a java servlet class which controls the operation.
 * @author Eric Monforte
 */
@WebServlet(
        name = "TicTacPawServlet",
        urlPatterns = { "/TicTacPaw" }
)


public class TicTacPawServlet extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!Starting new session!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

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

        System.out.println("In the servlet");
        HttpSession session = request.getSession(true);

        //Create an instance of a bean with local variables
        //TicTacPawData myData = new TicTacPawData();

        //Gets the box id that the player selected
        String testQuery = request.getQueryString();
        int selectedSquare = 0;
        String[] square = new String[9];

        //Get current bean values from the session object
        TicTacPawData myData = (TicTacPawData) session.getAttribute("myData");

        if (myData == null) {
            //Initialize java bean
            System.out.println("Player moves is null");
            //Create an instance of a bean with local variables
            myData = new TicTacPawData();
            createJavaBean(session, myData);
        } else {
//            if (playerMove.length() > 0) {
//                selectedSquare = 1;
//                square[0] = " ";
//            }
            System.out.println("Moves is not null " + myData.getMoves());

            //Update player moves with the latest move
            updateArrayOfSquares(request, myData);

            //Get current bean values from the session
           // myData = (TicTacPawData) session.getAttribute("myData");
            //Get values for each square in the array
            //String[] square = myData.getSquare();
            //square = myData.getSquare();

            System.out.println("Message from the bean " + myData.getMessage());
            //Update the bean with computer's move
            TicTacPawAI anAI = new TicTacPawAI(myData);
            anAI.process();
            System.out.println("square array out of AI " + Arrays.toString(myData.getSquare()));
            //myData.setSquare(square);
//            if (square[Integer.parseInt(playerMove)].equals(" ")) {
//
//                square[Integer.parseInt(playerMove)] = "1";
//                myData.setMoves(myData.getMoves()+1);

//

            //}
        }
        //Store the bean in the session
        session.setAttribute("myData", myData);
        // Forward to the JSP
        forwardControl(request, response);

    }

    /**
     *  This initializes a java bean.
     *
     *@param  session                   the HttpServletRequest object
     *@param  TicTacPaw           Java Beans object with request data.
     */

    private void createJavaBean(HttpSession session,
                                TicTacPawData TicTacPaw) {
        //set Java Bean
        System.out.println("initializing a bean");
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
        TicTacPaw.setMessage(" ");
        TicTacPaw.setMoves(0);

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
        System.out.println("forwarding control to jsp");
        String url = "/TicTacPaw.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  This interrogate request parameters from the jsp
     *  @param request HttpServletRequest
     *  @param myData TicTacPawData object
     */
    private void updateArrayOfSquares(HttpServletRequest request, TicTacPawData myData) {
        String[] square = new String[9];
        //Get current array of moves from the bean
        square = myData.getSquare();
        System.out.println("Square array before " + Arrays.toString(square));
        if (request.getParameter("sq0") != null) {
            if (request.getParameter("sq0").equals("X")) {
                square[0] = "X";
                System.out.println("Square 1 is X");
            }
        }
        if (request.getParameter("sq1") != null) {
            if (request.getParameter("sq1").equals("X")) {
                square[1] = "X";
                System.out.println("Square 2 is X");
            }
        }
        if (request.getParameter("sq2") != null) {
            if (request.getParameter("sq2").equals("X")) {
                square[2] = "X";
                System.out.println("Square 3 is X");
            }
        }
        if (request.getParameter("sq3") != null) {
            if (request.getParameter("sq3").equals("X")) {
                square[3] = "X";
                System.out.println("Square 4 is X");
            }
        }
        if (request.getParameter("sq4") != null) {
            if (request.getParameter("sq4").equals("X")) {
                square[4] = "X";
                System.out.println("Square 5 is X");
            }
        }
        if (request.getParameter("sq5") != null) {
            if (request.getParameter("sq5").equals("X")) {
                square[5] = "X";
                System.out.println("Square 6 is X");
            }
        }
        if (request.getParameter("sq6") != null) {
            if (request.getParameter("sq6").equals("X")) {
                square[6] = "X";
                System.out.println("Square 7 is X");
            }
        }
        if (request.getParameter("sq7") != null) {
            if (request.getParameter("sq7").equals("X")) {
                square[7] = "X";
                System.out.println("Square 8 is X");
            }
        }
        if (request.getParameter("sq8") != null) {
            if (request.getParameter("sq8").equals("X")) {
                square[8] = "X";
                System.out.println("Square 9 is X");
            }
        }

        myData.setSquare(square);
        System.out.println("Updated square array " + Arrays.toString(myData.getSquare()));
    }
}
