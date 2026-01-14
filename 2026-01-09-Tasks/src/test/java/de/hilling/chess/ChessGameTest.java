package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChessGameTest {
    private static final String STARTPOSITION = """
    -----------------
    |r n b q k b n r|
    |p p p p p p p p|
    |               |
    |               |
    |               |
    |               |
    |P P P P P P P P|
    |R N B Q K B N R|
    -----------------""";
    private static final String E2E4_POSITION = """
    -----------------
    |r n b q k b n r|
    |p p p p p p p p|
    |               |
    |               |
    |        P      |
    |               |
    |P P P P   P P P|
    |R N B Q K B N R|
    -----------------""";

    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        chessGame = new ChessGame();
    }

    // TODO: test more pieces, refactoring
    @Test
    void testSetup() {
        ChessPiece whitePawn = chessGame.get(new Position(1, 1));
        assertEquals(PieceType.PAWN, whitePawn.type);
        assertEquals(Color.WHITE, whitePawn.color);
        ChessPiece blackPawn = chessGame.get(new Position(7, 6));
        assertEquals(PieceType.PAWN, blackPawn.type);
        assertEquals(Color.BLACK, blackPawn.color);
    }

    @Test
    void testSetupToString() {
        assertEquals(STARTPOSITION, chessGame.toString());
    }

    @Test
    void illegalMoveLength() {
        try {
            chessGame.move("a2a4bb");
            fail("Illegal move exception");
        } catch (IllegalArgumentException iae) {
            // nothing to do
        }
    }

    @Test
    void illegalMoveCharacters() {
        try {
            chessGame.move("a2z4");
            fail("Illegal move exception");
        } catch (IllegalArgumentException iae) {
            assertEquals("Illegal move: a2z4", iae.getMessage());
        }
    }

    @Test
    void movePawn() {
        chessGame.move("a2a4");
        assertEquals(E2E4_POSITION, chessGame.toString());
    }
}