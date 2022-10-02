package com.example.space_learn;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle_1 {

    private GridPane gridPane;
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<ArrayList<Background>> backgrounds = new ArrayList<>();
    private ArrayList<Integer> buttonState = new ArrayList<>();
    private String[] strs = {
            "file:src/main/resources/puzzle/1.jpg",
            "file:src/main/resources/puzzle/2.jpg",
            "file:src/main/resources/puzzle/3.jpg",
            "file:src/main/resources/puzzle/4.jpg",
            "file:src/main/resources/puzzle/5.jpg",
            "file:src/main/resources/puzzle/6.jpg",
            "file:src/main/resources/puzzle/7.jpg",
            "file:src/main/resources/puzzle/8.jpg",

   };

    private int boxSize = 100;
    private int gridSize = 300;
    private int imageArraySize = 4;
    private int gridWidth = 3;
    private int deadCellCount = 2;

    private int clickCounter = 0;
    private int counter = 0;
    private Group parent;

    public Puzzle_1(){
        gridPane = createGridPane();
    }

    public Puzzle_1(int x, int y, Group parent){
        this.parent = parent;
        createBackgrounds(strs);
        gridPane = new GridPane();
        gridPane = createGridPane();
        gridPane.setLayoutX(x);
        gridPane.setLayoutY(y);
    }

    private GridPane createGridPane(){;

        for (int i = 0; i < gridWidth*gridWidth; i++) {

            buttons.add(new Button());
            Button button = buttons.get(i);
            String boxSizeStr = "-fx-min-height:" + boxSize + "; -fx-min-width:" + boxSize;
            button.setStyle(boxSizeStr);

            int randomNb = randomizePictureSeed(imageArraySize -1 ) + 1;
            buttonState.add(randomNb);

            int finalI = i;

            button.setOnAction(value ->  {
                int id = finalI;
                Integer currentState = buttonState.get(finalI);
                Integer nextBgId = (Integer)( (currentState+1) % imageArraySize);
                buttonState.set(finalI, nextBgId);
                buttons.get(finalI).setBackground(backgrounds.get(nextBgId).get(finalI));
                checkIfWin();
            });

            int rowIndex = (i - (i%gridWidth)) / gridWidth;
            Background background = backgrounds.get(randomNb).get(i);

            button.setBackground(background);

            gridPane.add(button, i % gridWidth, rowIndex, 1, 1);
        }

        setDeadCells(deadCellCount);

        return gridPane;
    }

    private int randomizePictureSeed(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound);
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

    private void setDeadCells(int deadCellCount){
        int counter = 0;
        while(counter < deadCellCount){
            int index = randomizePictureSeed(buttons.size());
            if(buttonState.get(index) == 0)
                continue;
            buttonState.set(index, 0);
            String boxSizeStr = "-fx-min-height:" + boxSize + "; -fx-min-width:" + boxSize;
            Button button = buttons.get(index);
            button.setStyle(boxSizeStr + "; -fx-border-color: white;");
            Background background = backgrounds.get(0).get(index);
            button.setBackground(background);
            button.setOnAction(value ->  {
                return;
            });
            ++counter;
        }
    }

    private void checkIfWin(){
        int winStateCounter = 0;
        for (int currentState:buttonState) {
            if (currentState == 0)
                ++winStateCounter;
        }
        if(winStateCounter == buttonState.size()){

            buttons = new ArrayList<>();
            backgrounds = new ArrayList<>();
            buttonState = new ArrayList<>();
            calcNextLevel();
            this.gridPane.getChildren().removeAll(buttons);
            parent.getChildren().remove(this.getGridPane());
            createBackgrounds(strs);
            gridPane = createGridPane();
            parent.getChildren().add(this.getGridPane());

        }
    }

    private void calcNextLevel(){
        --deadCellCount;
        if(deadCellCount == 1){
            deadCellCount = gridWidth*gridWidth - 1;
            imageArraySize = ((imageArraySize+1)%(imageArraySize-3))+4;

//            ++gridWidth;
//            deadCellCount = gridWidth*gridWidth - 1;
//            boxSize = gridSize / gridWidth;
        }

        clickCounter = 0;
    }

    public GridPane getGridPane(){
        return gridPane;
    }

}
