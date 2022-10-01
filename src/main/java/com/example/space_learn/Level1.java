package com.example.space_learn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Level1 extends Application {

    public static int counter = 0;

    public Level1(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage lev1) throws Exception {
        //   setting parameters for "RULES" window
        Group play = new Group();
        Scene scene_lev1 = new Scene(play, 600, 400);
        lev1.setTitle("PLAY");
        lev1.setScene(scene_lev1);
        lev1.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene_lev1.setFill(new RadialGradient(
                2, 1, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //adding label
        Label label = new Label("Level 1");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(83);
        label.setTranslateY(40);
        play.getChildren().add(label);

        //adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 20px 'Pixeboy';-fx-background-radius: 15px;");
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lev1.close();
                try {
                    new HelloApplication().closingWindow(lev1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        play.getChildren().add(buttonBack);

        Puzzle_1 puzzle = new Puzzle_1(200, 100, play);
        play.getChildren().add(puzzle.getGridPane());

        buttonBack.setVisible(true);

    }
}
