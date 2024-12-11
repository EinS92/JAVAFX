package com.myjavafx.javafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLights extends Application {

    private Circle circle0 = new Circle(10);
    private Circle circle1 = new Circle(10);
    private Circle circle2 = new Circle(10);
    private Rectangle rec1 = new Rectangle(30,110);

    protected BorderPane getPane() {
        //BORDER PANE
        BorderPane borderPane = new BorderPane();
        StackPane stack = new StackPane();

        //HBOX
        HBox hBox = new HBox(20);

        //RADIO BUTTONS
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        hBox.getChildren().addAll(rbRed, rbYellow,rbGreen);

        //BORDER PANE SET
        borderPane.setBottom(hBox);
        hBox.setAlignment(Pos.BASELINE_CENTER);

        //TOGGLE GROUP
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        //VBOX
        VBox signalBox = new VBox(20);
        signalBox.setAlignment(Pos.CENTER);
        signalBox.getChildren().addAll(rec1);
        borderPane.setCenter(signalBox);


        VBox trafficLights = new VBox(20);
        trafficLights.setAlignment(Pos.CENTER);
        trafficLights.getChildren().addAll(circle0,circle1,circle2);
        borderPane.setCenter(trafficLights);

        //Default FILL - TRANSPARENT
        rec1.setFill(Color.TRANSPARENT);
        rec1.setStroke(Color.BLACK);
        circle0.setFill(Color.TRANSPARENT);
        circle0.setStroke(Color.BLACK);
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);

        stack.getChildren().addAll(signalBox,trafficLights);

        //BORDER PANE
        borderPane.setCenter(stack);


        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                circle0.setFill(Color.RED);
                circle1.setFill(Color.TRANSPARENT);
                circle2.setFill(Color.TRANSPARENT);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                circle1.setFill(Color.YELLOW);
                circle2.setFill(Color.TRANSPARENT);
                circle0.setFill(Color.TRANSPARENT);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                circle2.setFill(Color.GREEN);
                circle1.setFill(Color.TRANSPARENT);
                circle0.setFill(Color.TRANSPARENT);
            }
        });

        return borderPane;
    }

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Create a scene and place it in the stage
        Scene scene = new Scene(getPane(),215,175);
        primaryStage.setTitle("Traffic Lights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}