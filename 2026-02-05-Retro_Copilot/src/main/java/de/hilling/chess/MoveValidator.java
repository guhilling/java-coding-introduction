package de.hilling.chess;

public class MoveValidator {
    private final ChessPiece[][] board;

    public MoveValidator(ChessPiece[][] board) {
        this.board = board;
    }

    public void validateMove(Position from, Position to, ChessPiece piece) {
        if (piece.type == PieceType.PAWN) {
            validatePawnMove(from, to, piece);
        }
    }

    private void validatePawnMove(Position from, Position to, ChessPiece piece) {
        int direction = piece.color == Color.WHITE ? 1 : -1;
        int startRow = piece.color == Color.WHITE ? 1 : 6;

        // Must move in same column (no capture implemented yet)
        if (from.x != to.x) {
            throw new IllegalArgumentException("Pawn must move straight forward");
        }

        // Check if target square is empty
        if (board[to.x][to.y] != null) {
            throw new IllegalArgumentException("Target square is occupied");
        }

        int yDiff = to.y - from.y;

        // Move one square forward
        if (yDiff == direction) {
            return;
        }

        // Move two squares forward from starting position
        if (from.y == startRow && yDiff == 2 * direction) {
            // Check if path is clear
            if (board[from.x][from.y + direction] == null) {
                return;
            }
            throw new IllegalArgumentException("Path is blocked");
        }

        throw new IllegalArgumentException("Invalid pawn move");
    }
}
