package de.hilling.codingintro.math;

/**
 * Representation of a rectangle in a coordinate system.
 */
public class Rectangle extends AbstractShape implements Shape {
    private int width;
    private int height;

    public void setHeight(int i) {
        height = i;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int i) {
        width = i;
    }
    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "rectangle width " + width + ", height " + height + " at " + position;
    }
}
