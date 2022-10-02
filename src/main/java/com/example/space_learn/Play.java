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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Play extends Application {
    public Play(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        //   setting parameters for "RULES" window
        Group play = new Group();
        Scene scene = new Scene(play, 600, 400);
        stage.setTitle("PUZZLE");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene.setFill(new RadialGradient(
                2, 1, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //adding label
        Label label = new Label("Welcome to the puzzle game!");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(83);
        label.setTranslateY(40);
        play.getChildren().add(label);

        //adding button "BACK"
        Button buttonBack = new Button("BEGIN");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.2em;-fx-font: normal bold 17px 'Pixeboy';-fx-background-radius: 15px;");

        buttonBack.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                new Level1(stage);
            }
        });

        play.getChildren().add(buttonBack);
        buttonBack.setVisible(true);

        stage.show();
    }
}
