package de.hilling.chess;

import java.util.LinkedList;
import java.util.List;

/**
 * A (not so) small example for a chessboard maybe understanding Long algebraic notation (@see <a
 * href="https://en.wikipedia.org/wiki/Algebraic_notation_(chess)#Long_algebraic_notation">Wikipedia</a>).
 */
public class ChessGame {
    private ChessPiece[][] board = new ChessPiece[8][8];
    private List<String> moves = new LinkedList<>();

    public ChessGame() {
        for(int x=0; x<8; x++) {
            setPieceForWhiteAndBlack(PieceType.PAWN, x, 1);
        }
        setPieceForWhiteAndBlack(PieceType.KING, 4, 0);
        setPieceForWhiteAndBlack(PieceType.ROOK, 0, 0);
        setPieceForWhiteAndBlack(PieceType.ROOK, 7, 0);
        setPieceForWhiteAndBlack(PieceType.KNIGHT, 1, 0);
        setPieceForWhiteAndBlack(PieceType.KNIGHT, 6, 0);
        setPieceForWhiteAndBlack(PieceType.BISHOP, 2, 0);
        setPieceForWhiteAndBlack(PieceType.BISHOP, 5, 0);
        setPieceForWhiteAndBlack(PieceType.QUEEN, 3, 0);
    }

    private void setPiece(PieceType pieceType, Color color, int x, int y) {
        board[x][y] = new ChessPiece(pieceType, color);
    }

    private void setPieceForWhiteAndBlack(PieceType pieceType, int x, int y) {
        setPiece(pieceType, Color.WHITE, x, y);
        setPiece(pieceType, Color.BLACK, x, 7-y);
    }

    public ChessPiece get(Position position) {
        return board[position.x][position.y];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------\n");
        for(int y=7; y>=0; y--) {
            sb.append('|');
            for(int x=0; x<8; x++) {
                ChessPiece piece = board[x][y];
                if(piece != null) {
                    sb.append(piece.toString());
                } else  {
                    sb.append(' ');
                }
                if(x<7) {
                    sb.append(' ');
                }
            }
            sb.append("|\n");
        }
        sb.append("-----------------");
        return sb.toString();
    }

    public void move(String move) {
        if(move.length() != 4) {
            throw new IllegalArgumentException("Move must be 4 characters long");
        }
        Position from = Position.from(move.substring(0,2));
        Position to = Position.from(move.substring(2,4));
        ChessPiece fromPiece = board[from.x][from.y];
        if(fromPiece != null) {
            board[to.x][to.y] = fromPiece;
            board[from.x][from.y] = null;
        } else {
            throw new IllegalArgumentException("no piece on " + from);
        }
    }
}
