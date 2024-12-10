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
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import kotlin.io.ConstantsKt;
import javafx.scene.layout.StackPane;

public class LoanCalculatorWithAnimatedBouncingBall extends Application {

    private TextField annualInterestRate = new TextField();
    private TextField numberOfYears = new TextField();
    private TextField loanAmount = new TextField();
    private TextField monthlyPayment = new TextField();
    private TextField totalPayment = new TextField();
    private Button calculate = new Button("Calculate");

    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        BorderPane borderPane = new BorderPane();
        BallPane ballPane = new BallPane();
        ballPane.setPrefSize(100,100);
        ClockPane clockPane = new ClockPane();
        clockPane.setPrefSize(150,150);
        pane.getChildren().add(ballPane);
        //Create a handler for animation
        EventHandler<ActionEvent> eventHandler = e -> {
            clockPane.setCurrentTime(); //Set a new clock time
        };

        //Create an animation for a running clock
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();   //Start animation

        GridPane gridPane = new GridPane();
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

        numberOfYears.setAlignment(Pos.BASELINE_LEFT);

        loanAmount.setAlignment(Pos.BASELINE_LEFT);


        Label label7 = new Label(String.valueOf(monthlyPayment));
        label7.setFont(Font.font("Goudy Stout",FontWeight.NORMAL,FontPosture.ITALIC, 20));
        monthlyPayment.setAlignment(Pos.BASELINE_LEFT);
        monthlyPayment.setEditable(true);
        monthlyPayment.setStyle("-fx-text-fill: pink");

        Label label8 = new Label(String.valueOf(totalPayment));
        label8.setFont(Font.font("Goudy Stout", FontWeight.BOLD, FontPosture.ITALIC, 10));
        totalPayment.setAlignment(Pos.BASELINE_LEFT);
        totalPayment.setEditable(true);
        totalPayment.setStyle("-fx-text-fill: pink");

        GridPane.setHalignment(calculate, HPos.LEFT);

        //Process events
        calculate.setOnAction(e -> calculateLoanPayment());
        borderPane.setCenter(gridPane);
        borderPane.setLeft(clockPane);
        borderPane.setTop(pane);

        //Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 250);
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

