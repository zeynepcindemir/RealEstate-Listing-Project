package com.example.myrealestateproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.*;

public class Controller7 implements Initializable {

    @FXML
    private ListView<String> myListView7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KonutReader.updateData(); // update konutPriorityQueue
        int heapLen = SceneController.getInstance().konutPriorityQueue.getSize();

        for (int i = 0; i < heapLen; i++) {
            Konut k = SceneController.getInstance().konutPriorityQueue.delete();    // extract the Konut with the max point
            myListView7.getItems().add("Konut " + (i + 1) + " : " + k.toString() + ", Puan : " + k.getPuan());
        }
    }

}
