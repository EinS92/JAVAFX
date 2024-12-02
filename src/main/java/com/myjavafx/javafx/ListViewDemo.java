package com.myjavafx.javafx; import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ListViewDemo extends Application {
    //Declare an array of Strings for flag titles
    private String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    Image image0 = new Image("C:\\Users\\mques\\Downloads\\CanadaFlag.png", 100, 100, true, true);
    Image image1 = new Image("C:\\Users\\mques\\Downloads\\ChinaFlag.png", 100, 100, true, true);
    Image image2 = new Image("C:\\Users\\mques\\Downloads\\DenmarkFlag.png", 100, 100, true, true);
    Image image3 = new Image("C:\\Users\\mques\\Downloads\\FranceFlag.png", 100, 100, true, true);
    Image image4 = new Image("C:\\Users\\mques\\Downloads\\GermanyFlag.png", 100, 100, true, true);
    Image image5 = new Image("C:\\Users\\mques\\Downloads\\IndiaFlag.png", 100, 100, true, true);
    Image image6 = new Image("C:\\Users\\mques\\Downloads\\NorwayFlag.png", 100, 100, true, true);
    Image image7 = new Image("C:\\Users\\mques\\Downloads\\UKFlag.png", 100, 100, true, true);
    Image image8 = new Image("C:\\Users\\mques\\Downloads\\USAFlag.jpg", 100, 100, true, true);

    //Declare an ImageView array for the national flags of 9 countries
    private ImageView[] ImageViews = {
            new ImageView(image0),
            new ImageView(image1),
            new ImageView(image2),
            new ImageView(image3),
            new ImageView(image4),
            new ImageView(image5),
            new ImageView(image6),
            new ImageView(image7),
            new ImageView(image8)
    };

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>
          (FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Create a pane to hold image views
        FlowPane imagePane  = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);

        lv.getSelectionModel().selectedItemProperty().addListener(
        ov -> {
          imagePane.getChildren().clear();
          for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
            imagePane.getChildren().add(ImageViews[i]);
          }
        });

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}