package de.hilling.chess;

/**
 * Describe the type and include the shortcut for the piece.
 */
public enum PieceType {
    PAWN,
    KNIGHT,
    ROOK,
    QUEEN,
    KING,
    BISHOP;

    public String shortcut() {
        if(this == KNIGHT) {
            return "n";
        } else {
            return name().substring(0, 1).toLowerCase();
        }
    }
}
