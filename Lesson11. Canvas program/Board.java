package com.bogdan;

import com.google.gson.Gson;
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

        Shape ball = new Ball(gc, shapes, 100, 100);
        shapes.add(ball);
        for (Shape shapes : shapes) {
            shapes.draw();
            shapes.enterDraw();
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
                Shape ball = new Ball(gc, shapes, 100, 100);
                shapes.add(ball);
                selectNextShape();
                break;
            case DIGIT2:
                Shape square = new Square(gc, shapes, 70, 180);
                shapes.add(square);
                selectNextShape();
                break;
            case DIGIT3:
                Shape triangle = new Triangle(gc, shapes, 180, 70);
                shapes.add(triangle);
                selectNextShape();
                break;
            case DIGIT4:
                Shape pacman = new Pacman(gc, shapes, 240, 240);
                shapes.add(pacman);
                selectNextShape();
                break;
            case TAB:
                selectNextShape();
                break;
            case DELETE:
                remove();
                break;
        }
        for (Shape shapes : shapes) {
            shapes.draw();
        }
        shape.enterDraw();
    }

    private void selectNextShape() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
        Shape shape = shapes.get(index);
        shape.enterDraw();
    }

    private void remove(){
        if (shapes.size() > 1){
            shapes.remove(index);
            System.out.println(index);
            if (index != 0){
                index--;
            }
        }
    }
}
