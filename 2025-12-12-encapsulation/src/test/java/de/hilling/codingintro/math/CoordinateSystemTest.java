package de.hilling.codingintro.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateSystemTest {
    private CoordinateSystem systemUnderTest;

    @BeforeEach
    void createTestData() {
        systemUnderTest = new CoordinateSystem();
    }

    @Test
    void printEmptySystem() {
        assertEquals("", systemUnderTest.toString());
    }

    @Test
    void addShapesRectangle() {
        systemUnderTest.addShape(new Rectangle());
        assertEquals("rectangle width 0, height 0 at x: 0 y: 0", systemUnderTest.toString());
    }

    @Test
    void addShapesCircle() {
        systemUnderTest.addShape(new Circle());
        assertEquals("circle radius 0 at x: 0 y: 0", systemUnderTest.toString());
    }
    @Test
    void moveCircle() {
        Circle circle = new Circle();
        systemUnderTest.addShape(circle);
        assertEquals("circle radius 0 at x: 0 y: 0", systemUnderTest.toString());
        circle.moveTo(new Position(3, 4));
        assertEquals("circle radius 0 at x: 3 y: 4", systemUnderTest.toString());
    }


}