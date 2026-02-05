package de.hilling.chess;

import uk.org.webcompere.testgadgets.testdatafactory.TestData;
import uk.org.webcompere.testgadgets.testdatafactory.TestDataFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

@TestDataFactory
class ChessGameTest {
    @TestData("startposition.txt")
    private String STARTPOSITION;
    @TestData("e2e4position.txt")
    private String E2E4_POSITION;
    @TestData("e2e4e7e5position.txt")
    private String E2E4E7E5_POSITION;

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
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> chessGame.move("a2a5"));
        assertEquals("Invalid pawn move", iae.getMessage());
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