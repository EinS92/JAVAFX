package com.myjavafx.javafx; import com.almasb.fxgl.cutscene.CutsceneCallback;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ResizableCircleRectangle extends Application {
    //Create a circle and a rectangle
    private Circle circle = new Circle(60);
    private Rectangle rectangle = new Rectangle(120, 120);

    //Place clock and label in border pane
    private StackPane pane = new StackPane();

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().addAll(circle, rectangle);

        //Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 140, 140);
        primaryStage.setTitle("ResizableCircleRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener((ov -> resize()));
        pane.heightProperty().addListener(ov -> resize());
    }

    private void resize() {
        double length = Math.min(pane.getWidth(), pane.getWidth());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }
}
