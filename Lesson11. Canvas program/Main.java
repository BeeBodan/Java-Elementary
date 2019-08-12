package com.bogdan;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 800;
    private Board board;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Program");

        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);

        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();

        board = new Board(gc, 1);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                gc.clearRect(0,0, BOARD_WIDTH, BOARD_HEIGHT);

                if (keyEvent.getCode() == KeyCode.RIGHT){
                    board.moveRight();
                } else if (keyEvent.getCode() == KeyCode.LEFT){
                    board.moveLeft();
                } else if (keyEvent.getCode() == KeyCode.UP){
                    board.moveUp();
                } else if (keyEvent.getCode() == KeyCode.DOWN){
                    board.moveDown();
                } else if (keyEvent.getCode() == KeyCode.DIGIT1){
                    board = new Board(gc, 1);
                } else if (keyEvent.getCode() == KeyCode.DIGIT2){
                    board = new Board(gc, 2);
                } else if (keyEvent.getCode() == KeyCode.DIGIT3){
                    board = new Board(gc, 3);
                } else if (keyEvent.getCode() == KeyCode.EQUALS){
                    board.sizePlus();
                } else if (keyEvent.getCode() == KeyCode.MINUS){
                    board.sizeMinus();
                } else if (keyEvent.getCode() == KeyCode.ENTER){
                    board.enterDraw();
                }
            }
        });
    }
}