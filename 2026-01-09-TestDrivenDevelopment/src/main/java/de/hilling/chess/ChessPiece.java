package de.hilling.chess;

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
