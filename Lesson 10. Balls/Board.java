package com.bogdan;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext gc;

    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        for (int i = 0; i < 100; i++) {
            shapes.add(new Ball(gc));
            shapes.add(new Square(gc));
            shapes.add(new Triangle(gc));
        }
    }

    public void move() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
