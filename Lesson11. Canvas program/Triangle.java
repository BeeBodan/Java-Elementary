package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Base{

    public Triangle(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        gc.setFill(Color.GREEN);
        gc.fillPolygon(new double[]{x, x + SHAPE_SIZE / 2, x + SHAPE_SIZE}, new double[]{y + SHAPE_SIZE, y, y + SHAPE_SIZE}, 3);
    }
}