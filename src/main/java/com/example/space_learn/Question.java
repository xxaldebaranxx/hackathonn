package com.example.space_learn;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;

public class Question extends Application {

    private String quizQuestion;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;

    private int questionNumber;
    private int trueAnswer;
    private int questionIndex = 1;


    public Question(Stage stage) {

        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        Group play = new Group();
        Font labelFont = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        Font textFont = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 30);
        Font answerFont = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 20);


        String[] questionsArray = {"","First","Second","Third","Forth","Fifth","Sixth"};





        //Creating the Scene
        Scene scene = new Scene(play, 600, 400);
        stage.setTitle("Quiz Game!");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //Adding background
        scene.setFill(new RadialGradient(
                2, 1, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //Adding main label for the question
        Label label = new Label("Question number 1!");
        label.setFont(labelFont);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(83);
        label.setTranslateY(40);
        play.getChildren().add(label);

        //Adding the question itself and it's attributes
        Text questionText = new Text(questionsArray[questionIndex]);
        questionText.setFont(textFont);
        questionText.setFill(Color.WHITE);
        questionText.setTranslateX(83);
        questionText.setTranslateY(100);
        play.getChildren().add(questionText);

        // Adding answer options:
        final ToggleGroup answerGroup = new ToggleGroup();

        RadioButton answer1 = new RadioButton(firstAnswer);
        RadioButton answer2 = new RadioButton(secondAnswer);
        RadioButton answer3 = new RadioButton(thirdAnswer);

        answer1.setTextFill(Color.WHITE);
        answer2.setTextFill(Color.WHITE);
        answer3.setTextFill(Color.WHITE);

        answer1.setFont(answerFont);
        answer2.setFont(answerFont);
        answer3.setFont(answerFont);


        answer1.setToggleGroup(answerGroup);
        answer2.setToggleGroup(answerGroup);
        answer3.setToggleGroup(answerGroup);

        VBox groupOfAnswers = new VBox(answer1, answer2, answer3);
        groupOfAnswers.setLayoutX(83);
        groupOfAnswers.setLayoutY(110);
        groupOfAnswers.setSpacing(5);

        Label l2 = new Label("nothing selected");


        // Adding a event listener

        answerGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton)answerGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();

                    System.out.println(s);
                }
            }
        });

        play.getChildren().add(groupOfAnswers);

        //Adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(60);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 20px 'Pixeboy';-fx-background-radius: 15px;");
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.close();
                try {
                    new HelloApplication().closingWindow(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        play.getChildren().add(buttonBack);
        buttonBack.setVisible(true);

        //Adding button "NEXT"
        Button buttonNext = new Button("NEXT");
        buttonNext.setLayoutX(490); // X pos
        buttonNext.setLayoutY(330); // Y pos
        buttonNext.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 20px 'Pixeboy';-fx-background-radius: 15px;");
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                if(questionIndex<9) {
                    questionIndex++;
                    label.setText("Question number " + questionIndex + "!");
                    System.out.println(questionIndex);
                } else stage.close();


            }
        });
        play.getChildren().add(buttonNext);
        buttonNext.setVisible(true);

    }


}
