package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Base implements Shape{

    private double SHAPE_SIZE = 50;
    private final double SCREEN_X;
    private final double SCREEN_Y;
    private final GraphicsContext gc;
    private double x = 100, y = 100;

    public Base(GraphicsContext gc) {
        this.gc = gc;
        SCREEN_X = gc.getCanvas().getWidth();
        SCREEN_Y = gc.getCanvas().getHeight();
    }

    @Override
    public void moveRight() {
        if (!(x + SHAPE_SIZE > SCREEN_X)){
            x += 4;
        }
    }

    @Override
    public void moveLeft() {
        if (!(x < 0)){
            x -= 4;
        }
    }

    @Override
    public void moveDown() {
        if (!(y + SHAPE_SIZE > SCREEN_Y)){
            y += 4;
        }
    }

    @Override
    public void moveUp() {
        if (!(y < 0)){
            y -= 4;
        }
    }

    @Override
    public void sizePlus() {
        SHAPE_SIZE += 2;
    }

    @Override
    public void sizeMinus() {
        SHAPE_SIZE -= 2;
    }

    @Override
    public void enterDraw() {
        gc.setFill(Color.DARKBLUE);
        gc.fillOval(x,y, SHAPE_SIZE, SHAPE_SIZE);
    }

    public void draw(Color color, String shape) {
        gc.setFill(color);
        if (shape == "Oval"){
            gc.fillOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
        } else if (shape == "Rect"){
            gc.fillRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
        } else if (shape == "Triangle"){
            gc.fillPolygon(new double[]{x, x + SHAPE_SIZE / 2, x + SHAPE_SIZE}, new double[]{y + SHAPE_SIZE, y, y + SHAPE_SIZE}, 3);
        }
    }
}
