package de.hilling.codingintro.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle testRectangle = new Rectangle();

    @BeforeEach
    void prepareTestData() {
        testRectangle.setWidth(100);
        testRectangle.setHeight(50);
    }

    @Test
    void createRectangle() {
        assertEquals(50, testRectangle.getHeight());
        assertEquals(100, testRectangle.getWidth());
    }

    @Test
    void printRectangle() {
        assertEquals("rectangle width 100, height 50 at x: 0 y: 0", testRectangle.toString());
    }

}