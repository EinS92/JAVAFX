package com.myjavafx.javafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class StackPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        // Create shapes
        Rectangle rectangle = new Rectangle(100, 100, Color.LIGHTBLUE); // Bottom layer
        Circle circle = new Circle(50, Color.LIGHTCORAL);               // Middle layer

        // StackPane
        StackPane stackPane = new StackPane();

        // Add shapes to StackPane
        stackPane.getChildren().addAll(rectangle, circle);


        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(new Rectangle(50, 50), new Label("Overlay"));


        // Scene
        Scene scene = new Scene(stackPane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("StackPane Example");
        stage.show();

        Scene scene1 = new Scene(stackPane2,300, 300);
        stage.setScene(scene1);
        stage.setTitle("StackPane Example_2");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
