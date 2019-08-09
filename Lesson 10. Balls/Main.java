package com.bogdan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 800;

    private boolean closed = false;
    private Board board;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Ball");

        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);

        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();

        board = new Board(gc);
        startMoving(gc);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        closed = true;
    }

    private void startMoving(GraphicsContext gc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!closed) {

                    gc.clearRect(0,0, BOARD_WIDTH, BOARD_HEIGHT);
                    board.move();
                    board.draw();

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}