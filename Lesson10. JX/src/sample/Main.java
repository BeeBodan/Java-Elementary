package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    //Lesson Tenth

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

    public static void main(String[] args) {

        /*
         * 1) Нарисовать простую сцену - домик, солнце
         */

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Home");

        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);

        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        test(gc);
    }

    private void test(GraphicsContext gc) {

        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,BOARD_WIDTH, BOARD_HEIGHT);

        gc.setFill(Color.LAWNGREEN);
        gc.fillRect(0,400,BOARD_WIDTH, 200);

        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.LIGHTGOLDENRODYELLOW);
        gc.setLineWidth(20);
        gc.fillOval(30, 50, 80, 80);
        gc.strokeOval(30, 50, 80, 80);

        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(400,300,250,180);
        gc.setFill(Color.BROWN);
        gc.fillRect(460,390,50,90);
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillRect(550,380,50,50);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeOval(120, 330, 40, 40);
        gc.setFill(Color.BLACK);
        gc.fillRect(140, 370, 3, 60);
        gc.strokeLine(140,430,90,480);
        gc.strokeLine(140,430,180,480);
        gc.strokeLine(143,390,180,420);
        gc.strokeLine(143,390,90,420);

        gc.setFill(Color.CORAL);
        gc.fillPolygon(new double[]{700, 550, 350}, //(<- or ->)
                new double[]{310, 210, 310}, 3);
    }
}
