package com.bogdan;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Base implements Shape{

    private final double SCREEN_X;
    private final double SCREEN_Y;
    private List<Shape> shapes;
    protected double SHAPE_SIZE = 50;
    protected GraphicsContext gc;
    protected double x;
    protected double y;
    boolean check = false;

    public Base(GraphicsContext gc, List<Shape> shapes, double x, double y) {
        this.gc = gc;
        this.shapes = shapes;
        this.x = x;
        this.y = y;

        SCREEN_X = gc.getCanvas().getWidth();
        SCREEN_Y = gc.getCanvas().getHeight();
    }

    @Override
    public void moveRight() {
        meet();
        if (!(x + SHAPE_SIZE > SCREEN_X)){
            if (!meet()) {
                x += 2;
            } else {
                x -= 3;
            }
        }
    }

    @Override
    public void moveLeft() {
        meet();
        if (!(x < 0)){
            if (!meet()) {
                x -= 2;
            } else {
                x += 3;
            }
        }
    }

    @Override
    public void moveDown() {
        meet();
        if (!(y + SHAPE_SIZE > SCREEN_Y)){
            if (!meet()) {
                y += 2;
            }
        }
    }

    @Override
    public void moveUp() {
        meet();
        if (!(y < 0)){
            if (!meet()) {
                y -= 2;
            }
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

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean meet(){
        Base baseShape1 = (Base) shapes.get(0);
        for (int j = 1; j < shapes.size(); j++) {
            Base baseShape2 = (Base) shapes.get(j);

            double deltaX = Math.abs(baseShape1.getX() - baseShape2.getX());
            double deltaY = Math.abs(baseShape1.getY() - baseShape2.getY());
            double dist = deltaX + deltaY;

            if (dist <= (baseShape1.SHAPE_SIZE / 2 + baseShape2.SHAPE_SIZE / 2) + 5){
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }
}
