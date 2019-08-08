package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    //Lesson Tenth

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;
    private double dx = 3, dy = 3;

    public static void main(String[] args) {

        /*
         * 2*) нарисовть шар который сам двигается и отбивается от краев экрана
         */

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Balls");

        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);

        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        Circle ball = new Circle(50, Color.RED);
        ball.relocate(5,5);
        group.getChildren().addAll(ball);

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (true){

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ball.setLayoutX(ball.getLayoutX() + dx);
                    ball.setLayoutY(ball.getLayoutY() + dy);

                    if(ball.getLayoutX() <= (0 + ball.getRadius()) || ball.getLayoutX() >= (BOARD_WIDTH - ball.getRadius())){
                        dx = -dx;
                    }

                    if((ball.getLayoutY() >= (BOARD_HEIGHT - ball.getRadius())) || (ball.getLayoutY() <= (0 + ball.getRadius()))){
                        dy = -dy;
                    }
                }
            }
        }).start();
    }
}