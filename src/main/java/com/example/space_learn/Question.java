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


    private int questionIndex = 1;
    private int pointCounter = 0;

    private Boolean questionSelected = false;

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


        // Array for storing questions
        String[][] questionsArray = {{"", "", "", ""},
                {"At which distance from Earth does the James Webb Space Telescope orbit?", "1,5 million kilometres", "3 billion kilometres", "200 thousand kilometres"},
                {"What is the scientific target of JWST?", "All answers are correct", "Beyond our Solar System", "Our Solar System"},
                {"What was the main thing that astronomers did for capturing Mars with extreme brightness?", "By using very short exposure", "By reducing sensors` sensitivity", "By wearing specially designed glasses"},
                {"Why JWST is using infrared spectrum for capturing photos?", "For capturing distant objects which are in infrared \nspectrum due to Doppler effect (redshift)", "For measuring temperatures of solar system bodies", "For detecting alien life"},
                {"What are the reasons to use infrared light?","For researching objects that are behind clouds of dust","For making the research more effective", "For the sake of testing new technology"},
                {"In which country was James Webb's telescope created?", "The Netherlands", "USA", "China"},
                {"What was the Webb called before it was named after James Webb?", "Next Generation Space Telescope", "Swift Gamma Ray Burst Explorer", "Fermi Gamma-ray Space Telescope"},
                {"With what JWST has something in common?", "All answers are correct", "Origami", "Honeycomb"},
                {"Why JWST is cooled to temperatures close to absolute zero (-273 C°)?", "Because warm objects emits infrared light", "Because instruments would overheat", "Cold temperatures protect from high energy cosmic rays"},
                {"How much \"back in time\" can JWST see?", "13.7 billion years", "1 year", "10 thousand years"}};


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

        //Adding points to the UI

        Label pointLabel = new Label(""+pointCounter);
        pointLabel.setFont(labelFont);
        pointLabel.setTextFill(Color.WHITE);
        pointLabel.setTranslateX(550);
        pointLabel.setTranslateY(40);
        play.getChildren().add(pointLabel);

        //Adding the question itself and it's attributes
        Text questionText = new Text(questionsArray[questionIndex][0]);
        questionText.setFont(textFont);
        questionText.setFill(Color.WHITE);
        questionText.setTranslateX(83);
        questionText.setTranslateY(100);
        questionText.setWrappingWidth(500);
        play.getChildren().add(questionText);

        // Adding answer options:
        final ToggleGroup answerGroup = new ToggleGroup();

        RadioButton answer1 = new RadioButton(questionsArray[1][1]);
        RadioButton answer2 = new RadioButton(questionsArray[1][2]);
        RadioButton answer3 = new RadioButton(questionsArray[1][3]);

        answer1.setTextFill(Color.WHITE);
        answer2.setTextFill(Color.WHITE);
        answer3.setTextFill(Color.WHITE);

        answer1.setFont(answerFont);
        answer2.setFont(answerFont);
        answer3.setFont(answerFont);

        answer1.setStyle("-fx-end-margin: 10px");


        answer1.setToggleGroup(answerGroup);
        answer2.setToggleGroup(answerGroup);
        answer3.setToggleGroup(answerGroup);

        VBox groupOfAnswers = new VBox(answer1, answer2, answer3);
        groupOfAnswers.setLayoutX(83);
        groupOfAnswers.setLayoutY(180);
        groupOfAnswers.setSpacing(5);




        //Adding button "BACK"
        Button buttonBack = new Button("EXIT QUIZ");
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

                if(questionIndex < questionsArray.length-1) {
                    questionIndex++;
                    label.setText("Question number " + questionIndex + "!");
                    questionText.setText(questionsArray[questionIndex][0]);
                    answer1.setText(questionsArray[questionIndex][1]);
                    answer2.setText(questionsArray[questionIndex][2]);
                    answer3.setText(questionsArray[questionIndex][3]);

                    if(answer1.isSelected()) {
                        pointCounter++;
                        pointLabel.setText(String.valueOf(pointCounter));
                    } else {
                        if(pointCounter <= 0) {
                            //TODO You have lost screen
                            stage.close();
                        }
                        pointCounter--;
                        pointLabel.setText(String.valueOf(pointCounter));

                    }

                    // Resetting things after a quesiton
                    answerGroup.selectToggle(null);
                    buttonNext.setDisable(true);

                    //TODO implement point visibility
                    System.out.println(pointCounter);
                } else stage.close();
                //TODO implement quiz end screen


            }
        });
        play.getChildren().add(buttonNext);
        buttonNext.setDisable(true);
        buttonNext.setVisible(true);


        // Adding a event listener

        answerGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton rb = (RadioButton)answerGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    buttonNext.setDisable(false);
//                    System.out.println(s);
                }
            }
        });

        play.getChildren().add(groupOfAnswers);



    }


}
