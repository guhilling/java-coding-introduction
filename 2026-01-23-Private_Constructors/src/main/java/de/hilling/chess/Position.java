package de.hilling.chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.jspecify.annotations.NonNull;

/**
 * Represents a position on the board.
 * Objects of this class are immutable, correct coordinates are checked when the constructor is called.
 */
// TODO:
//  * implement accessors.
//  * collections of valid positions in static initializer.
//  * then remove hashCode() and equals().

public class Position extends Object{
    private static final Pattern POSITION_PATTERN = Pattern.compile("[a-h][1-8]");
    private static final char[] X_CHARACTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final Map<String, Position> VALID_POSITIONS = new HashMap<>();

    public final int x;
    public final int y;
    public final String formattedPosition;

    static {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                Position position = new Position(x, y);
                VALID_POSITIONS.put(position.formattedPosition, position);
            }
        }
    }

    private Position(int x, int y) {
        validatePosition(x, y);
        this.x = x;
        this.y = y;
        formattedPosition = getFormattedPosition(x, y);
    }

    private static void validatePosition(int x, int y) {
        if(x <0 || y <0 || x >7 || y >7) {
            throw new IllegalArgumentException("x and y need to be between 0 and 7");
        }
    }

    private static @NonNull String getFormattedPosition(int x, int y) {
        return String.format("%c%d", X_CHARACTERS[x], y + 1);
    }

    /**
     * Access Position object via position string (chess notation).
     *
     * @param positionString position between "a1 and h8".
     * @return Position element
     *
     * @throws IllegalArgumentException if positionString is invalid.
     */
    public static @NonNull Position of(@NonNull String positionString) {
        Position position = VALID_POSITIONS.get(positionString);
        if(position == null) {
            throw new IllegalArgumentException("Illegal position: " + positionString);
        }
        return position;
    }

    /**
     * Access Position object via offset.
     *
     * @param x x-offset, starting at 0.
     * @param y y-offset, starting at 0
     * @return Position element
     *
     * @throws IllegalArgumentException if x or y are not between 0 and 7.
     */
    public static @NonNull Position of(int x, int y) {
        validatePosition(x, y);
        return of(getFormattedPosition(x, y));
    }

    @Override
    public String toString() {
        return formattedPosition;
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
