package de.hilling.chess;

/**
 * Represents a position on the board.
 * Objects of this class are immutable, correct coordinates are checked when the constructor is called.
 */
// TODO: Use static accessor to singletons
public class Position {
    public final int x;
    public final int y;
    final char[] xCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%c%d", xCharacters[x], y + 1);
    }
}
