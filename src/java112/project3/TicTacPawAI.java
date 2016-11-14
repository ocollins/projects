package java112.project3;

import java.io.Serializable;
import java.util.Arrays;

/**
 * This is a java bean class holds multiple HttpRequestParameters
 * @author Eric Monforte
 */
public class TicTacPawAI {
    TicTacPawData myData = null;
    private String[] square = null;

    public TicTacPawAI() {
    }

    public TicTacPawAI(TicTacPawData aParameter) {
        this();
        //get current values from the bean
        myData = aParameter;
        square = myData.getSquare();
    }

    public void process() {
        if (myData.getMoves() == 9 ) {
            myData.setMessage("IT IS A DRAW!!");
        } else if (!block()) {
            move();
            checkResults();
        }

    }

    private boolean block() {
        //String[] square = myData.getSquare();

        boolean square0 = square[0].equals("X");
        boolean square1 = square[1].equals("X");
        boolean square2 = square[2].equals("X");
        boolean square3 = square[3].equals("X");
        boolean square4 = square[4].equals("X");
        boolean square5 = square[5].equals("X");
        boolean square6 = square[6].equals("X");
        boolean square7 = square[7].equals("X");
        boolean square8 = square[8].equals("X");

        if (square0 && square1 && square[2].equals(" ")) {
            square[2] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square3 && square4 && square[5].equals(" ")) {
            square[5] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square6 && square7 && square[8].equals(" ")) {
            square[8] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square2 && square[0].equals(" ")) {
            square[0] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square4 && square5 && square[3].equals(" ")) {
            square[3] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square7 && square8 && square[6].equals(" ")) {
            square[6] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square2 && square[1].equals(" ")) {
            square[1] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square3 && square5 && square[4].equals(" ")) {
            square[4] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square6 && square8 && square[7].equals(" ")) {
            square[7] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square3 && square[6].equals(" ")) {
            square[6] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square4 && square[7].equals(" ")) {
            square[7] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square5 && square[8].equals(" ")) {
            square[8] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square[3].equals(" ") && square6) {
            square[3] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square[4].equals(" ") && square7) {
            square[4] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square[5].equals(" ") && square8) {
            square[5] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[0].equals(" ") && square3 && square6) {
            square[0] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[1].equals(" ") && square4 && square7) {
            square[1] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[2].equals(" ") && square5 && square8) {
            square[2] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[0].equals(" ") && square4 && square8) {
            square[0] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[2].equals(" ") && square4 && square6) {
            square[2] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square[4].equals(" ") && square8) {
            square[4] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square[4].equals(" ") && square6) {
            square[4] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square4 && square[8].equals(" ")) {
            square[8] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square4 && square[6].equals(" ")) {
            square[6] = "O";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        }

        return false;

    }

    private void move() {
        //String[] square = myData.getSquare();
        myData.setMoves(myData.getMoves()+1);

        if (square[0].equals(" ")) {
            square[0] = "O";
        } else if (square[1].equals(" ")) {
            square[1] = "O";
        } else if (square[2].equals(" ")) {
            square[2] = "O";
        } else if (square[3].equals(" ")) {
            square[3] = "O";
        } else if (square[4].equals(" ")) {
            square[4] = "O";
        } else if (square[5].equals(" ")) {
            square[5] = "O";
        } else if (square[6].equals(" ")) {
            square[6] = "O";
        } else if (square[7].equals(" ")) {
            square[7] = "O";
        } else if (square[8].equals(" ")) {
            square[8] = "O";
        }
    }

    private void checkResults() {

        boolean square0X = square[0].equals("X");
        boolean square1X = square[1].equals("X");
        boolean square2X = square[2].equals("X");
        boolean square3X = square[3].equals("X");
        boolean square4X = square[4].equals("X");
        boolean square5X = square[5].equals("X");
        boolean square6X = square[6].equals("X");
        boolean square7X = square[7].equals("X");
        boolean square8X = square[8].equals("X");

        boolean square0O = square[0].equals("O");
        boolean square1O = square[1].equals("O");
        boolean square2O = square[2].equals("O");
        boolean square3O = square[3].equals("O");
        boolean square4O = square[4].equals("O");
        boolean square5O = square[5].equals("O");
        boolean square6O = square[6].equals("O");
        boolean square7O = square[7].equals("O");
        boolean square8O = square[8].equals("O");
        System.out.println("Inside AI check results " + Arrays.toString(square));

        if (square0O && square1O && square0O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square3O && square4O && square5O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square6O && square7O && square8O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square0O && square4O && square8O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square2O && square4O && square6O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square0O && square3O && square6O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square1O && square4O && square7O) {
            myData.setMessage("You lose!! Try again!!");

        } else if (square2O && square5O && square8O) {
            myData.setMessage("You lose!! Try again!!");

        }

        if (square0X && square1X && square0X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square3X && square4X && square5X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square6X && square7X && square8X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square0X && square4X && square8X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square2X && square4X && square6X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square0X && square3X && square6X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square1X && square4X && square7X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        } else if (square2X && square5X && square8X) {
            myData.setMessage("WHOO HOO!! YOU WON!!");

        }

//        if (square0X && square1O && square2X) {
//            myData.setMessage("IT IS A DRAW!!");
//
//        }



    }
}
