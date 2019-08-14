package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Base{

    public Ball(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
    }
}
