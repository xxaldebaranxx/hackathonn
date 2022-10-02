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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class Information extends Application {
    public Information(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) throws Exception {
        //   setting parameters for "RULES" window
        Group info = new Group();
        Scene scene = new Scene(info, 600, 400);
        stage.setTitle("Information");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
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

        Image image5 = new Image(new FileInputStream("src/main/resources/IMG_2289.PNG"));
        ImageView imageView5 = new ImageView(image5);
        imageView5.setX(180);
        imageView5.setY(180);
        imageView5.setFitHeight(390);
        imageView5.setFitWidth(390);
        info.getChildren().add(imageView5);

        //adding description about contributors
        Text t = new Text();
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 25);
        t.setFont(font);
        t.setText("HI THERE!\nMY NAME IS FROGGY I WAS DEVELOPED BY A TEAM OF FOLKS: \n" +
                "\nDARIA TOVSTOHAN \n" +
                "DEIVIS ZOLBA\n" +
                "DEIVIDAS BENDARAVICIUS\n" +
                "ANDRIUS SVILYS\n" +
                "LUKAS JONUSIS");
        t.setLayoutX(20);
        t.setLayoutY(100);
        t.setFill(Color.WHITE);
        info.getChildren().add(t);



        //adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
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
        info.getChildren().add(buttonBack);
        buttonBack.setVisible(true);
    }
}

