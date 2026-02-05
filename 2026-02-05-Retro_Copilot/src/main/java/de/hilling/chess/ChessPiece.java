package de.hilling.chess;

/**
 * Represents a chess piece with a type and color.
 */
public class ChessPiece {
    public final PieceType type;
    public final Color     color;

    public ChessPiece(PieceType type, Color color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return switch (color) {
            case WHITE -> type.shortcut().toUpperCase();
            case BLACK -> type.shortcut();
        };
    }
}
