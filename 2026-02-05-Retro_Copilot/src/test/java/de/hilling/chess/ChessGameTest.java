package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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
    private static final String E2E4E7E5_POSITION = """
    -----------------
    |r n b q k b n r|
    |p p p p   p p p|
    |               |
    |        p      |
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

    @Test
    void testSetup() {
        ChessPiece whitePawn = chessGame.get(Position.of(1, 1));
        assertEquals(PieceType.PAWN, whitePawn.type);
        assertEquals(Color.WHITE, whitePawn.color);
        ChessPiece blackPawn = chessGame.get(Position.of(7, 6));
        assertEquals(PieceType.PAWN, blackPawn.type);
        assertEquals(Color.BLACK, blackPawn.color);
    }

    @Test
    void testSetupToString() {
        assertEquals(STARTPOSITION, chessGame.toString());
    }

    @Test
    void illegalMoveLength() {
        assertThrows(IllegalArgumentException.class, () -> chessGame.move("a2a4bb"));
    }

    @Test
    void illegalMoveCharacters() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> chessGame.move("a2z4"));
        assertEquals("Illegal position: z4", iae.getMessage());
    }

    @Test
    void illegalMoveMoveNotPossibleForPawn() {
        try {
            chessGame.move("a2a5");
            fail("Illegal move exception");
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid pawn move", iae.getMessage());
        }
    }

    @Test
    void movePawn() {
        chessGame.move("e2e4");
        assertEquals(E2E4_POSITION, chessGame.toString());
    }
    @Test

    void movePawns() {
        chessGame.move("e2e4");
        chessGame.move("e7e5");
        assertEquals(E2E4E7E5_POSITION, chessGame.toString());
        assertEquals("e2e4\ne7e5\n", chessGame.getMoves());
    }
}