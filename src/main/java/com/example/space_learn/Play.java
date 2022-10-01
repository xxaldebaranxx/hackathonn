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
        Label label = new Label("SELECT YOUR CHALLENGE!");
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
        buttonBack.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
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

        //adding button "LEVEL 1"
        Button buttonlev1 = new Button("LEVEL 1");
        buttonlev1.setLayoutX(70);
        buttonlev1.setLayoutY(100);
        buttonlev1.setPrefSize(120, 120);
        buttonlev1.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonlev1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                new Level1(stage);
            }
        });
        play.getChildren().add(buttonlev1);
        buttonlev1.setVisible(true);


        //adding button "LEVEL 2"
        Button buttonlev2 = new Button("LEVEL 2");
        buttonlev2.setLayoutX(230);
        buttonlev2.setLayoutY(100);
        buttonlev2.setPrefSize(120, 120);
        buttonlev2.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonlev2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                new Level2(stage);
            }
        });
        play.getChildren().add(buttonlev2);
        buttonlev2.setVisible(true);

        //adding button "LEVEL 3"
        Button buttonlev3 = new Button("LEVEL 3");
        buttonlev3.setLayoutX(390);
        buttonlev3.setLayoutY(100);
        buttonlev3.setPrefSize(120, 120);
        buttonlev3.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonlev3.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                new Level3(stage);
            }
        });
        play.getChildren().add(buttonlev3);
        buttonlev3.setVisible(true);
        stage.show();
    }
}
