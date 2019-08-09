package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Base{

    public Ball(GraphicsContext gc) {
        super(gc);
    }

    public void move() {
        super.move();
    }

    public void draw() {
        super.draw(Color.RED, "Oval");
    }
}
