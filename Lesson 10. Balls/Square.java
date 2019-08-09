package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Base{

    public Square(GraphicsContext gc) {
        super(gc);
    }

    public void move() {
        super.move();
    }

    public void draw() {
        super.draw(Color.BLUE, "Rect");
    }
}