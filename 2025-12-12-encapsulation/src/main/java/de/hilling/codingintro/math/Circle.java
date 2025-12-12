package de.hilling.codingintro.math;

public class Circle extends AbstractShape implements Shape {

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "circle radius " + radius +  " at " + position;
    }
    }
