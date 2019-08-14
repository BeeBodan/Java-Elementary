package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();
    private int index = 0;

    public Board(GraphicsContext gc) {
        this.gc = gc;

        Shape ball = new Ball(gc, 100, 100);
        shapes.add(ball);
        for (Shape shapes : shapes) {
            shapes.draw();
        }
    }

    public void keyBoard(KeyEvent keyEvent){

        gc.clearRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        Shape shape = shapes.get(index);

        switch (keyEvent.getCode()){
            case LEFT:
                shape.moveLeft();
                break;
            case RIGHT:
                shape.moveRight();
                break;
            case UP:
                shape.moveUp();
                break;
            case DOWN:
                shape.moveDown();
                break;
            case MINUS:
                shape.sizeMinus();
                break;
            case EQUALS:
                shape.sizePlus();
                break;
            case DIGIT1:
                Shape ball = new Ball(gc, 100, 100);
                shapes.add(ball);
                break;
            case DIGIT2:
                Shape square = new Square(gc, 100, 100);
                shapes.add(square);
                break;
            case DIGIT3:
                Shape triangle = new Triangle(gc, 100, 100);
                shapes.add(triangle);
                break;
            case DIGIT9:
                selectNextShape();
                break;
            case DIGIT8:
                selectPreviousShape();
                break;
        }
        for (Shape shapes : shapes) {
            shapes.draw();
        }
    }

    private void selectNextShape() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
    }

    private void selectPreviousShape() {
        index--;
        if(index < 0) {
            index = shapes.size() - 1;
        }
    }
}
