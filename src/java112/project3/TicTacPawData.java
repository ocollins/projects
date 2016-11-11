package java112.project3;

import java.io.Serializable;

/**
 * This is a java bean class holds multiple HttpRequestParameters
 * @author Eric Monforte
 */
public class TicTacPawData implements Serializable {

    private String[] square;
    private String message;
    private int moves;

    /**
     * This is a constructor
     */
    public TicTacPawData() {

    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets square.
     *
     * @return Value of square.
     */
    public String[] getSquare() {
        return square;
    }

    /**
     * Gets moves.
     *
     * @return Value of moves.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Sets new moves.
     *
     * @param moves New value of moves.
     */
    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * Sets new square.
     *
     * @param square New value of square.
     */
    public void setSquare(String[] square) {
        this.square = square;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }
}
