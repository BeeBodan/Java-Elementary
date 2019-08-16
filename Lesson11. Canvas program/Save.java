package com.bogdan;

import java.util.ArrayList;
import java.util.List;

public class Save {

    private String shape;
    private List<Shape> shapes = new ArrayList<>();

    public Save(String shape) {
        this.shape = shape;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Save{");
        sb.append("shape='").append(shape).append('\'');
        sb.append(", shapes=").append(shapes);
        sb.append('}');
        return sb.toString();
    }
}
