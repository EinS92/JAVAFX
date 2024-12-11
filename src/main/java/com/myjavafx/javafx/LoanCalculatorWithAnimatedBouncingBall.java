package com.myjavafx.javafx;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import kotlin.io.ConstantsKt;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LoanCalculatorWithAnimatedBouncingBall extends Application {

    private TextField annualInterestRate = new TextField();
    private TextField numberOfYears = new TextField();
    private TextField loanAmount = new TextField();
    private TextField monthlyPayment = new TextField();
    private TextField totalPayment = new TextField();
    private Button calculate = new Button("Calculate");

    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setPrefSize(400,100);

        Image image0 = new Image("C:\\Users\\mques\\OneDrive\\Documents\\SDCCD\\CISC 191\\auto.png", 100, 100, true, true);
        Image image1 = new Image("C:\\Users\\mques\\OneDrive\\Documents\\SDCCD\\CISC 191\\mortgage.png", 100, 100, true, true);
        Image image2 = new Image("C:\\Users\\mques\\OneDrive\\Documents\\SDCCD\\CISC 191\\personal.png", 100, 100, true, true);
        Image image3 = new Image("C:\\Users\\mques\\OneDrive\\Documents\\SDCCD\\CISC 191\\Student.png", 100, 100, true, true);
        Image image4 = new Image("C:\\Users\\mques\\OneDrive\\Documents\\SDCCD\\CISC 191\\business.png", 100, 100, true, true);

        ImageView imageView0 = new ImageView(image0);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        Button typeAuto = new Button("Auto Loan", imageView0);
        Button typeMortgage = new Button("Mortgage Loan", imageView1);
        Button typePersonal = new Button("Personal Loan", imageView2);
        Button typeStudent = new Button("Student Loan", imageView3);
        Button typeBusiness = new Button("Business Loan", imageView4);
        Text text = new Text("Choose Your Loan!");

        hBox.getChildren().addAll(typeAuto,typeMortgage, typePersonal, typeStudent, typeBusiness);
        hBox.setAlignment(Pos.CENTER);

        BallPane ballPane = new BallPane();
        ballPane.setPrefSize(400,100);
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        ballPane.setOnMouseClicked(e->{
            if (e.getButton() == MouseButton.SECONDARY) {
                ballPane.setColorRandom();
            }
        });

        ClockPane clockPane = new ClockPane();
        clockPane.setPrefSize(150,150);
        EventHandler<ActionEvent> eventHandler = e -> {
            clockPane.setCurrentTime(); //Set a new clock time
        };

        //Create an animation for a running clock
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();   //Start animation

        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(400,300);

        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Label label0 = new Label("Annual Interest Rate:");
        label0.setStyle("-fx-text-fill: blue");
        gridPane.add(label0, 0, 0);
        gridPane.add(annualInterestRate, 1, 0);      //gridPane.add(node, columnIndex, rowIndex, colspan, rowspan)

        Label label1 = new Label("Number of Years:");
        label1.setStyle("-fx-text-fill: green");
        gridPane.add(label1, 0, 1);
        gridPane.add(numberOfYears, 1, 1);

        Label label2 = new Label("Loan Amount:");
        label2.setStyle("-fx-text-fill: brown");
        gridPane.add(label2, 0, 2);
        gridPane.add(loanAmount, 1, 2);

        Label label3 = new Label("Monthly Payment:");
        label3.setStyle("-fx-text-fill: pink");
        gridPane.add(label3, 0, 3);
        gridPane.add(monthlyPayment,1,3);

        Label label4 = new Label("Total Payment:");
        label4.setStyle("-fx-text-fill: orange");
        gridPane.add(label4, 0, 4);
        gridPane.add(totalPayment,1, 4);

        gridPane.add(calculate, 1, 5);
        calculate.setStyle("-fx-text-fill: turquoise");

        //Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        annualInterestRate.setAlignment(Pos.BASELINE_LEFT);
        annualInterestRate.setEditable(true);
        annualInterestRate.setStyle("-fx-text-fill: green");
        annualInterestRate.setFont(Font.font("Goudy Stout"));

        numberOfYears.setAlignment(Pos.BASELINE_LEFT);
        numberOfYears.setEditable(true);
        numberOfYears.setStyle("-fx-text-fill: green");
        numberOfYears.setFont(Font.font("Goudy Stout"));

        loanAmount.setAlignment(Pos.BASELINE_LEFT);
        loanAmount.setEditable(true);
        loanAmount.setStyle("-fx-text-fill: green");
        loanAmount.setFont(Font.font("Goudy Stout"));

        monthlyPayment.setAlignment(Pos.BASELINE_LEFT);
        monthlyPayment.setEditable(true);
        monthlyPayment.setStyle("-fx-text-fill: green");
        monthlyPayment.setFont(Font.font("Goudy Stout"));

        totalPayment.setAlignment(Pos.BASELINE_LEFT);
        totalPayment.setEditable(true);
        totalPayment.setStyle("-fx-text-fill: green");
        totalPayment.setFont(Font.font("Goudy Stout"));
        GridPane.setHalignment(calculate, HPos.LEFT);

        //Process events
        calculate.setOnAction(e -> calculateLoanPayment());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setLeft(clockPane);
        borderPane.setBottom(hBox);
        borderPane.setTop(ballPane);
        borderPane.setRight(text);


        //Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 1000, 750);
        primaryStage.setTitle("LoanCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateLoanPayment() {
        //Get values from text fields
        double interest = Double.parseDouble((annualInterestRate.getText()));
        int year = Integer.parseInt(numberOfYears.getText());
        double loanDebt =
                Double.parseDouble(loanAmount.getText());

        //Create a loan object. Loan defined in Listing 10.2
        Loan loan = new Loan(interest, year, loanDebt);

        //Display monthly payment and total payment
        monthlyPayment.setText(String.format("$%.2f",
                loan.getMonthlyPayment()));
        totalPayment.setText(String.format("$%.2f",
                loan.getTotalPayment()));
    }
}

