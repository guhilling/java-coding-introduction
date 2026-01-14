package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void setUpValidPositions() {
        assertEquals("a1", new Position(0, 0).toString());
        assertEquals("e5", new Position(4, 4).toString());
        assertEquals("h8", new Position(7, 7).toString());
    }

    @Test
    void denyNegativePositions() {
        try {
            new Position(-1, 0);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException ile) {
            // success
        }
    }

    @Test
    void denyOverflowPositions() {
        try {
            new Position(0, 8);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException ile) {
            // success
        }
    }

}