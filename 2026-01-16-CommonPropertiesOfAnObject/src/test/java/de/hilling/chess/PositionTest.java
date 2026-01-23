package de.hilling.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void setUpValidPositions() {
        assertEquals("a1", new Position(0, 0).toString());
        assertEquals("e5", new Position(4, 4).toString());
        assertEquals("h8", new Position(7, 7).toString());
    }

    @Test
    void compareDifferentPositions() {
        Position p1 = new Position(0, 0);
        Position p2 = new Position(1, 0);
        assertNotEquals(p1, p2);
    }

    @Test
    void compareEqualPositions() {
        Position p1 = new Position(0, 0);
        Position p2 = new Position(0, 0);
        assertEquals(p1, p2);
    }

    @Test
    void compareDifferentPositionHash() {
        assertNotEquals(new Position(0, 1).hashCode(), new Position(0, 0).hashCode());
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