package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public abstract class Base implements Shape{

    private static final double SHAPE_SIZE = 20;
    private final double SCREEN_X;
    private final double SCREEN_Y;
    private final GraphicsContext gc;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;

    public Base(GraphicsContext gc) {
        this.gc = gc;
        SCREEN_X = gc.getCanvas().getWidth();
        SCREEN_Y = gc.getCanvas().getHeight();

        Random random = new Random();

        xSpeed = random.nextInt(10) - 5;
        ySpeed = random.nextInt(10) - 5;

        x = random.nextInt(800) + 20;
        y = random.nextInt(800) + 20;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x + SHAPE_SIZE > SCREEN_X){
            xSpeed = -(Math.abs(xSpeed));
        }
        if (y + SHAPE_SIZE > SCREEN_Y){
            ySpeed = -(Math.abs(ySpeed));
        }
        if (x < 0){
            xSpeed = Math.abs(xSpeed);
        }
        if (y < 0){
            ySpeed = Math.abs(ySpeed);
        }
    }

    public void draw(Color color, String shape) {
        gc.setFill(color);
        if (shape == "Oval"){
            gc.fillOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
        } else if (shape == "Rect"){
            gc.fillRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
        } else if (shape == "Triangle"){
            gc.fillPolygon(new double[]{x, x + SHAPE_SIZE, x + SHAPE_SIZE * 2}, new double[]{y + SHAPE_SIZE, y, y + SHAPE_SIZE}, 3);
        }
    }
}
