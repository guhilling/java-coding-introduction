package de.hilling.chess;

/**
 * A (not so) small example for a chessboard maybe understanding Long algebraic notation (@see <a
 * href="https://en.wikipedia.org/wiki/Algebraic_notation_(chess)#Long_algebraic_notation">Wikipedia</a>).
 */
public class ChessGame {
    ChessPiece[][] board = new ChessPiece[8][8];

    public ChessGame() {
        for(int x=0; x<8; x++) {
            setPawn(x, 1, Color.WHITE);
            setPawn(x, 6, Color.BLACK);
        }
        setPiece(PieceType.KING, Color.WHITE, 4, 0);
        setPiece(PieceType.KING, Color.BLACK, 4, 7);
    }

    private void setPiece(PieceType pieceType, Color color, int x, int y) {
        board[x][y] = new ChessPiece(pieceType, color);
    }

    private void setPawn(int x, int y, Color color) {
        setPiece(PieceType.PAWN, color, x, y);
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
}
