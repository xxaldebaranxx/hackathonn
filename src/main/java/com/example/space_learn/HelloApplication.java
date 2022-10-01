package com.example.space_learn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.WindowEvent;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class HelloApplication extends Application {

    public void closingWindow(Stage stage) throws Exception {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //setting parameters for the main menu
    public void start(Stage stage) throws IOException {
        Group groupRoot = new Group();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(groupRoot, 600, 400);
        stage.setTitle("Space Learn");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene.setFill(new RadialGradient(
                10, 0, 1, 1, 1.25, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //adding label
        Label label = new Label("Space Learn");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(180);
        label.setTranslateY(40);
        groupRoot.getChildren().add(label);

        //setting parameters for button 'START'
        Button buttonStart = new Button("     PLAY     ");
        buttonStart.setFont(font);
        buttonStart.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em; -fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonStart.setLayoutX(240);
        buttonStart.setLayoutY(90);
        groupRoot.getChildren().add(buttonStart);
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Play(stage);
            }
        });

//        //setting parameters for button 'RULES'
//        Button buttonRules = new Button("    RULES    ");
//        buttonRules.setStyle("-fx-background-color: #000f46; -fx-text-fill: #00ff00;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
//        buttonRules.setLayoutX(240);
//        buttonRules.setLayoutY(145);
//        groupRoot.getChildren().add(buttonRules);
//        buttonRules.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//                new Rules(stage);
//            }
//        });
//
//        //setting parameters for button 'SETTINGS'
//        Button buttonSettings = new Button("SETTINGS");
//        buttonSettings.setStyle("-fx-background-color: #000f46; -fx-text-fill: #00ff00;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
//        buttonSettings.setLayoutX(240);
//        buttonSettings.setLayoutY(200);
//        groupRoot.getChildren().add(buttonSettings);
//        buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//                new Settings(stage);
//            }
//        });

        //setting parameters for button 'QUIT'
        Button buttonQuit = new Button("     QUIT     ");
        buttonQuit.setStyle("-fx-background-color: #000f46; -fx-text-fill: #00ff00;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonQuit.setLayoutX(240);
        buttonQuit.setLayoutY(145);
        groupRoot.getChildren().add(buttonQuit);
        buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                {
                    System.exit(0);
                }
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}