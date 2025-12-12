package de.hilling.codingintro.math;

public interface Shape {
    /**
     * Move given shape to the new position.
     * @param newPosition the new position
     */
    void moveTo(Position newPosition);

    Position getPosition();
}
