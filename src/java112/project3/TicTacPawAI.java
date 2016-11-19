package java112.project3;
 
import java.io.Serializable;
 
/**
 * This is a java bean class holds multiple HttpRequestParameters
 * @author Eric Monforte
 */
public class TicTacPawAI  {
    TicTacPawData myData = null;
    int winner = 0;
 
    public TicTacPawAI() {
    }
 
    public TicTacPawAI(TicTacPawData aParameter) {
        this();
        myData = aParameter;
        convertToNumber(myData.getSquare());
 
    }
 
    public void process() {
 
        if (checkWin("1")) {
            winner = 1;
        } else if (moveToWin()) {
            if (checkWin("0")) {
                winner = 2;
            }
        } else if (block()) {
            if (checkWin("0")) {
                winner = 2;
            }
        } else {
            move();
        }
 
        convertToXO(myData.getSquare());
    }
 
    private boolean checkWin(String player) {
        String[] square = myData.getSquare();
 
        boolean square0 = square[0].equals(player);
        boolean square1 = square[1].equals(player);
        boolean square2 = square[2].equals(player);
        boolean square3 = square[3].equals(player);
        boolean square4 = square[4].equals(player);
        boolean square5 = square[5].equals(player);
        boolean square6 = square[6].equals(player);
        boolean square7 = square[7].equals(player);
        boolean square8 = square[8].equals(player);
 
        if (square0 && square1 && square2) {
            return true;
        } else if (square3 && square4 && square5) {
            return true;
        } else if (square6 && square7 && square8) {
            return true;
        } else if (square0 && square3 && square6) {
            return true;
        } else if (square1 && square4 && square7) {
            return true;
        } else if (square2 && square5 && square8) {
            return true;
        } else if (square0 && square4 && square8) {
            return true;
        } else if (square2 && square4 && square6) {
            return true;
        }
 
        return false;
 
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
 
    private boolean moveToWin() {
        String[] square = myData.getSquare();
 
        boolean square0 = square[0].equals("0");
        boolean square1 = square[1].equals("0");
        boolean square2 = square[2].equals("0");
        boolean square3 = square[3].equals("0");
        boolean square4 = square[4].equals("0");
        boolean square5 = square[5].equals("0");
        boolean square6 = square[6].equals("0");
        boolean square7 = square[7].equals("0");
        boolean square8 = square[8].equals("0");
 
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
        } else {
            myData.setMoves(myData.getMoves()-1);
        }
    }
 
    public int getWinner() {
        return winner;
    }
 
    private void convertToNumber(String[] square) {
        for (int loop = 0; loop < square.length; loop++) {
            if (square[loop].equals("X")) {
                square[loop] = "1";
            } else if (square[loop].equals("O")){
                square[loop] = "0";
            }
        }
    }
 
    private void convertToXO(String[] square) {
        for (int loop = 0; loop < square.length; loop++) {
            if (square[loop].equals("1")) {
                square[loop] = "X";
            } else if (square[loop].equals("0")){
                square[loop] = "O";
            }
        }
    }
}