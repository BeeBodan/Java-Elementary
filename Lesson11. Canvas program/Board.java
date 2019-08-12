package com.bogdan;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();
    private List<Shape> shapesNoActive = new ArrayList<>();
    private int numShape;

    public Board(GraphicsContext gc, int numShape) {
        this.gc = gc;
        this.numShape = numShape;

        if (numShape == 1){
            shapes.add(new Ball(gc));
        } else if (numShape == 2){
            shapes.add(new Square(gc));
        } else if (numShape == 3){
            shapes.add(new Triangle(gc));
        }
    }

    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
            shape.draw();
        }
        for (Shape shape : shapesNoActive) {
            shape.enterDraw();
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
            shape.draw();
        }
        for (Shape shape : shapesNoActive) {
            shape.enterDraw();
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            shape.moveUp();
            shape.draw();
        }
        for (Shape shape : shapesNoActive) {
            shape.enterDraw();
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            shape.moveDown();
            shape.draw();
        }
        for (Shape shape : shapesNoActive) {
            shape.enterDraw();
        }
    }

    public void sizePlus() {
        for (Shape shape : shapes) {
            shape.sizePlus();
            shape.draw();
        }
    }

    public void sizeMinus() {
        for (Shape shape : shapes) {
            shape.sizeMinus();
            shape.draw();
        }
    }

    public void enterDraw() {
        shapesNoActive.add(new Ball(gc));
        for (Shape shape : shapesNoActive) {
            shape.enterDraw();
        }
        System.out.println(shapesNoActive);
    }
}
