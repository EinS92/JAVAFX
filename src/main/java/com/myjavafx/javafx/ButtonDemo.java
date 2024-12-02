package com.myjavafx.javafx; import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

public class ButtonDemo extends Application {
    protected Text text= new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox(20);
        Image image = new Image("C:\\Users\\mques\\Downloads\\left-arrow.png",50, 50, true, true);
        ImageView imageView = new ImageView(image);
        Button btLeft = new Button("Left", imageView);

        Image image1 = new Image("C:\\Users\\mques\\Downloads\\right.png",50, 50, true, true);
        ImageView imageView1 = new ImageView(image1);
        Button btRight = new Button("Right", imageView1);

        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}