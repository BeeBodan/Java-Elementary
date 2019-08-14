package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Base{

    public Square(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
    }
}