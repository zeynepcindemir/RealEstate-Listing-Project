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

public class Controller6 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> myListView6;

    @FXML
    private Label myLabel6;
    String[] manzaralar = {"Şehir", "Deniz", "Orman", "Park", "Göl", "Dağ"};

    String seciliManzara;


    public void switchToScene7(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene7.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView6.getItems().addAll(manzaralar);

        myListView6.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                seciliManzara = myListView6.getSelectionModel().getSelectedItem();

                myLabel6.setText(seciliManzara);
                SceneController.getInstance().getDataList().add(seciliManzara);
                SceneController.getInstance().addStringToKey("Manzara",seciliManzara);


            }
        });
    }

}

