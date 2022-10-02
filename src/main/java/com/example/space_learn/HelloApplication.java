package com.example.space_learn;
import javafx.application.Application;
import javafx.fxml.FXML;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
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
        Scene scene = new Scene(groupRoot, 600, 400);
        stage.setTitle("Space Learn");
        stage.setResizable(false);
        stage.setScene(scene);

        String path = "src/main/resources/Komiku_-_01_-_Soundtrack.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();

        Image image1 = new Image(new FileInputStream("src/main/resources/IMG_2281.PNG"));
        ImageView imageView = new ImageView(image1);
        imageView.setX(40);
        imageView.setY(10);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        groupRoot.getChildren().add(imageView);

        Image image2 = new Image(new FileInputStream("src/main/resources/IMG_2285.PNG"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(310);
        imageView2.setY(100);
        imageView2.setFitHeight(390);
        imageView2.setFitWidth(390);
        groupRoot.getChildren().add(imageView2);

        Image image3 = new Image(new FileInputStream("src/main/resources/IMG_2281.PNG"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setX(40);
        imageView3.setY(170);
        imageView3.setFitHeight(200);
        imageView3.setFitWidth(200);
        groupRoot.getChildren().add(imageView3);

        Image image4 = new Image(new FileInputStream("src/main/resources/IMG_2281.PNG"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setX(360);
        imageView4.setY(10);
        imageView4.setFitHeight(200);
        imageView4.setFitWidth(200);
        groupRoot.getChildren().add(imageView4);
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
        Label label = new Label("Space Frog");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(205);
        label.setTranslateY(40);
        groupRoot.getChildren().add(label);

        //setting parameters for button 'START'
        Button buttonStart = new Button("     PUZZLE     ");
        buttonStart.setFont(font);
        buttonStart.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em; -fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonStart.setLayoutX(235);
        buttonStart.setLayoutY(90);
        groupRoot.getChildren().add(buttonStart);
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Play(stage);
            }
        });



        //setting parameters for button 'QUIZ'
        Button buttonRules = new Button("    QUIZ    ");
        buttonRules.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonRules.setLayoutX(250);
        buttonRules.setLayoutY(145);
        groupRoot.getChildren().add(buttonRules);
        buttonRules.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Level2(stage);
            }
        });


        //setting parameters for button 'INFO'
        Button buttonInfo = new Button("Information");
        buttonInfo.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000a28;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonInfo.setLayoutX(225);
        buttonInfo.setLayoutY(200);
        groupRoot.getChildren().add(buttonInfo);
        buttonInfo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new Information(stage);
            }
        });

        //setting parameters for button 'QUIT'
        Button buttonQuit = new Button("     QUIT     ");
        buttonQuit.setStyle("-fx-background-color: #000f46; -fx-text-fill: #00ff00;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonQuit.setLayoutX(245);
        buttonQuit.setLayoutY(255);
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