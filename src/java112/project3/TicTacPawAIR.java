package java112.project3;

import java.io.Serializable;

/**
 * This is a java bean class holds multiple HttpRequestParameters
 * @author Eric Monforte
 */
public class TicTacPawAIR  {
    TicTacPawData myData = null;

    public TicTacPawAIR() {
    }

    public TicTacPawAIR(TicTacPawData aParameter) {
        this();
        myData = aParameter;

    }

    public void process() {

        if (!block()) {
            move();
        }
    }

    private boolean block() {
        String[] square = myData.getSquare();

        boolean square0 = square[0].equals("1");
        boolean square1 = square[1].equals("1");
        boolean square2 = square[2].equals("1");
        boolean square3 = square[3].equals("1");
        boolean square4 = square[4].equals("1");
        boolean square5 = square[5].equals("1");
        boolean square6 = square[6].equals("1");
        boolean square7 = square[7].equals("1");
        boolean square8 = square[8].equals("1");

        if (square0 && square1 && square[2].equals(" ")) {
            square[2] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square3 && square4 && square[5].equals(" ")) {
            square[5] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square6 && square7 && square[8].equals(" ")) {
            square[8] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square2 && square[0].equals(" ")) {
            square[0] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square4 && square5 && square[3].equals(" ")) {
            square[3] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square7 && square8 && square[6].equals(" ")) {
            square[6] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square2 && square[1].equals(" ")) {
            square[1] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square3 && square5 && square[4].equals(" ")) {
            square[4] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square6 && square8 && square[7].equals(" ")) {
            square[7] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square3 && square[6].equals(" ")) {
            square[6] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square4 && square[7].equals(" ")) {
            square[7] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square5 && square[8].equals(" ")) {
            square[8] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square[3].equals(" ") && square6) {
            square[3] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square1 && square[4].equals(" ") && square7) {
            square[4] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square[5].equals(" ") && square8) {
            square[5] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[0].equals(" ") && square3 && square6) {
            square[0] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[1].equals(" ") && square4 && square7) {
            square[1] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[2].equals(" ") && square5 && square8) {
            square[2] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[0].equals(" ") && square4 && square8) {
            square[0] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square[2].equals(" ") && square4 && square6) {
            square[2] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square[4].equals(" ") && square8) {
            square[4] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square[4].equals(" ") && square6) {
            square[4] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square0 && square4 && square[8].equals(" ")) {
            square[8] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        } else if (square2 && square4 && square[6].equals(" ")) {
            square[6] = "0";
            myData.setMoves(myData.getMoves() + 1);
            return true;
        }

        return false;

    }

    private void move() {
        String[] square = myData.getSquare();
        myData.setMoves(myData.getMoves()+1);

        if (square[4].equals(" ")) {
            square[4] = "0";
        } else if (square[0].equals(" ")) {
            square[0] = "0";
        } else if (square[8].equals(" ")) {
            square[8] = "0";
        } else if (square[5].equals(" ")) {
            square[5] = "0";
        } else if (square[1].equals(" ")) {
            square[1] = "0";
        } else if (square[7].equals(" ")) {
            square[7] = "0";
        } else if (square[2].equals(" ")) {
            square[2] = "0";
        } else if (square[6].equals(" ")) {
            square[6] = "0";
        } else if (square[3].equals(" ")) {
            square[3] = "0";
        }
    }
}
