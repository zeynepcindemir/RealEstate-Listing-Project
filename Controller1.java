package com.example.myrealestateproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> myListView1;

    @FXML
    private Label myLabel1;
    String[] butceAraliklari = {"10000 - 1008999", "1009000 - 2007999", "2008000 - 3006999", "3007000 - 4005999", "4006000 - 5004999",
            "5005000 - 6003999", "6004000 - 7002999", "7003000 - 8001999", "8002000 - 9000999", "9001000 - 10000000"};

    String seciliButceAraligi;


    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView1.getItems().addAll(butceAraliklari);

        myListView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                seciliButceAraligi = myListView1.getSelectionModel().getSelectedItem();

                myLabel1.setText(seciliButceAraligi);
                SceneController.getInstance().getDataList().add(seciliButceAraligi);
                SceneController.getInstance().addStringToKey("Butce", seciliButceAraligi);


            }
        });
    }

}

