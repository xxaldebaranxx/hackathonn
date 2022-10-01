package com.example.space_learn;

import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle_1 {

    private GridPane gridPane;
    private ImageView imageView;
    private Image image;
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<ArrayList<Background>> backgrounds = new ArrayList<>();
    private ArrayList<Integer> buttonState = new ArrayList<>();
    private String[] strs = {"file:src/main/resources/images/image1.jpg",
            "file:src/main/resources/images/image2.jpg",
            "file:src/main/resources/images/image3.jpg",
            "file:src/main/resources/images/image4.jpg"};

    private int boxSize = 50;
    private int imageArraySize = 4;
    private int gridWidth = 4;

    public Puzzle_1(){
        gridPane = createGridPane();
    }

    public Puzzle_1(int x, int y){
        createBackgrounds(strs);
        gridPane = createGridPane();
        gridPane.setLayoutX(x);
        gridPane.setLayoutY(y);
    }

    private GridPane createGridPane(){;
        GridPane gridPane = new GridPane();

        for (int i = 0; i < gridWidth*gridWidth; i++) {

            buttons.add(new Button());
            Button button = buttons.get(i);
            String boxSizeStr = "-fx-min-height:" + boxSize + "; -fx-min-width:" + boxSize;
            button.setStyle(boxSizeStr);

            int randomNb = randomizePictureSeed();
            buttonState.add(randomNb);

            int finalI = i;

            if(randomNb != 0){
                button.setOnAction(value ->  {
                    int id = finalI;
                    Integer currentState = buttonState.get(finalI);
                    if(currentState == 0){
                        return;
                    }
                    Integer nextBgId = (Integer)( (currentState+1) % imageArraySize);
                    buttonState.set(finalI, nextBgId);
                    buttons.get(finalI).setBackground(backgrounds.get(nextBgId).get(finalI));
                });
            }

            int rowIndex = (i - (i%gridWidth)) / gridWidth;
            Background background = backgrounds.get(randomNb).get(i);

            button.setBackground(background);

            gridPane.add(button, i % gridWidth, rowIndex, 1, 1);
        }

        return gridPane;
    }

    private int randomizePictureSeed() {
        Random rand = new Random(); //instance of ran
        int upperbound = imageArraySize;
        return rand.nextInt(upperbound);
    }

    private void createBackground(String imagePath, int arrayIndex){
        if(backgrounds.size() == arrayIndex){
            backgrounds.add(new ArrayList<>());
        }
        for (int i = 0; i < gridWidth*gridWidth; i++) {

            int rowIndex = (i - (i%gridWidth)) / gridWidth;
            Image newImage_1 = new Image(imagePath, boxSize*gridWidth, boxSize*gridWidth, false, false);

            PixelReader reader = newImage_1.getPixelReader();
            WritableImage newImage = new WritableImage(reader, boxSize*(i%gridWidth), boxSize*rowIndex, boxSize, boxSize);

            BackgroundImage backgroundImage = new BackgroundImage( newImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

            Background background = new Background(backgroundImage);

            backgrounds.get(arrayIndex).add(background);
        }
    }

    private void createBackgrounds(String[] strs){
        for (int i = 0; i < strs.length; i++) {
            createBackground(strs[i], i);
        }
    }

    public GridPane getGridPane(){
        return gridPane;
    }

    private void onButtonClick(){

    }



}
