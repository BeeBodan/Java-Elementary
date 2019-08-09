package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Base{

    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    public void move() {
        super.move();
    }

    public void draw() {
        super.draw(Color.GREEN, "Triangle");
    }
}