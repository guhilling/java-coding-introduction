package de.hilling.chess;

public interface ChessPiece {
    void move(int x, int y);
    void capture(int x, int y);
}
