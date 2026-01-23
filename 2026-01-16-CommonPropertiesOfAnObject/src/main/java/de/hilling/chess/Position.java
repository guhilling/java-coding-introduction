package de.hilling.chess;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents a position on the board.
 * Objects of this class are immutable, correct coordinates are checked when the constructor is called.
 */
// TODO: Use static accessor to singletons
public class Position extends Object{
    private static final Pattern POSITION_PATTERN = Pattern.compile("[a-h][1-8]");

    public final int x;
    public final int y;
    final char[] xCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public Position(int x, int y) {
        if(x<0 || y<0 || x>7 || y>7) {
            throw new IllegalArgumentException("x and y need to be between 0 and 7");
        }
        this.x = x;
        this.y = y;
    }

    public static Position from(String positionString) {
        if(POSITION_PATTERN.matcher(positionString).find()) {
            return new Position(positionString.charAt(0) - 'a',
                                Integer.parseInt(positionString.substring(1, 2)) - 1);
        } else {
            throw new IllegalArgumentException("Illegal position: " + positionString);
        }
    }

    @Override
    public String toString() {
        return String.format("%c%d", xCharacters[x], y + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        } else {
            Position other = (Position) obj;
            return x == other.x && y == other.y;
        }
    }

    @Override
    public int hashCode() {
        return x + y * 8;
    }
}
