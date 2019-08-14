package com.bogdan;

import javafx.scene.canvas.GraphicsContext;

public abstract class Base implements Shape{

    private final double SCREEN_X;
    private final double SCREEN_Y;
    protected double SHAPE_SIZE = 50;
    protected GraphicsContext gc;
    protected double x;
    protected double y;

    public Base(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;

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
        if (SHAPE_SIZE != 700){
            SHAPE_SIZE += 2;
        }
    }

    @Override
    public void sizeMinus() {
        if (SHAPE_SIZE != 10){
            SHAPE_SIZE -= 2;
        }
    }
}
