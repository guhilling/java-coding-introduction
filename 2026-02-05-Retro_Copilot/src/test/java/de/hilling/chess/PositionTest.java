package de.hilling.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void setUpValidPositions() {
        assertEquals("a1", Position.of(0, 0).toString());
        assertEquals("e5", Position.of(4, 4).toString());
        assertEquals("h8", Position.of(7, 7).toString());
    }

    @Test
    void compareDifferentPositions() {
        Position p1 = Position.of(0, 0);
        Position p2 = Position.of(1, 0);
        assertNotEquals(p1, p2);
    }

    @Test
    void compareEqualPositions() {
        Position p1 = Position.of(0, 0);
        Position p2 = Position.of(0, 0);
        assertEquals(p1, p2);
    }

    @Test
    void compareDifferentPositionHash() {
        assertNotEquals(Position.of(0, 1).hashCode(), Position.of(0, 0).hashCode());
    }

    @Test
    void accessPositionObject() {
        Position positionA = Position.of("a1");
        assertSame(positionA, Position.of("a1"));
    }

    @Test
    void denyNegativePositions() {
        try {
            Position.of(-1, 0);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException ile) {
            // success
        }
    }

    @Test
    void denyOverflowPositions() {
        try {
            Position.of(0, 8);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException ile) {
            // success
        }
    }

    @Test
    void denyIllegalStringPositions() {
        try {
            Position.of("a9");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException ile) {
            // success
        }
    }

}