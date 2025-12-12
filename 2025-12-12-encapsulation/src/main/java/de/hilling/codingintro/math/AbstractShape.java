package de.hilling.codingintro.math;

public class AbstractShape implements Shape {

    protected Position position;

    public AbstractShape() {
        position = new Position(0,0);
    }

    @Override
    public void moveTo(Position newPosition) {
        position = newPosition;
    }

    @Override
    public Position getPosition() {
        return position;
    }

}
