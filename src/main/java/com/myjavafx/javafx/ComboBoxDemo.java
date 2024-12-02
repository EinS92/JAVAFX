package com.myjavafx.javafx; import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ComboBoxDemo extends Application {
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
    private ImageView[] flagImage = {new ImageView(image0),
            new ImageView(image1),
            new ImageView(image2),
            new ImageView(image3),
            new ImageView(image4),
            new ImageView(image5),
            new ImageView(image6),
            new ImageView(image7),
            new ImageView(image8)};

    //Declare an array of strings for flag descriptions
    private String[] flagDescription = new String[9];

    //Declare and create a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();

    //Create a combo box for selecting countries
    private ComboBox<String> cbo = new ComboBox<>();

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Set text description
        flagDescription[0] = "The Canadian national flag ...";
        flagDescription[1] = "The China national flag ...";
        flagDescription[2] = "The Denmark national flag ...";
        flagDescription[3] = "The France national flag ...";
        flagDescription[4] = "The Germany national flag ...";
        flagDescription[5] = "The India national flag ...";
        flagDescription[6] = "The Norway national flag ...";
        flagDescription[7] = "The United Kingdom national flag ...";
        flagDescription[8] = "The United States national flag ...";

        //Set the first country (Canada) for display
        setDisplay(0);

        //Add combo box and description pane to the border pane
        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items =
                FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        //Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**Set display information on the description pane */
    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }
}


