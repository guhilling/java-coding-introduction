package de.hilling.codingintro.math;

import java.util.ArrayList;
import java.util.List;

public class CoordinateSystem {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public String toString(){
        String result = null;
        for(Shape shape: shapes) {
            if(result == null) {
                result = shape.toString();
            } else {
                result = result + " " + shape.toString();
            }
        }
        if(result == null) {
            return "";
        } else {
            return result;
        }
    }
}
