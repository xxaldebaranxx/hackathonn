package com.example.space_learn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.util.Scanner;

public class Level2 extends Application {
    public Level2(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage lev2) throws Exception {


        Group play = new Group();
;

        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        Font textFont = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 30);


        Button nextQuestionButton = new Button("BEGIN!");
        nextQuestionButton.setLayoutX(240);
        nextQuestionButton.setLayoutY(210);
        nextQuestionButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){

                new Question(lev2);


            }
        });
        play.getChildren().add(nextQuestionButton);
        nextQuestionButton.setVisible(true);




        //   setting parameters for "Level 2" window
        Scene scene_lev2 = new Scene(play, 600, 400);
        lev2.setTitle("Quiz Game!");
        lev2.setScene(scene_lev2);
        lev2.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene_lev2.setFill(new RadialGradient(
                2, 1, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //adding label
        Label label = new Label("Welcome to the Quiz Game!");
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(83);
        label.setTranslateY(40);
        play.getChildren().add(label);

        //Text explaining the quiz

        Text quizInfo = new Text("asdasda");
        quizInfo.setFont(font);
        quizInfo.setFill(Color.WHITE);
        quizInfo.setTranslateX(83);
        quizInfo.setTranslateY(100);
        play.getChildren().add(quizInfo);

        //adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 20px 'Pixeboy';-fx-background-radius: 15px;");
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lev2.close();
                try {
                    new HelloApplication().closingWindow(lev2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        play.getChildren().add(buttonBack);
        buttonBack.setVisible(true);
    }

}
