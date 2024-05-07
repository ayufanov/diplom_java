package com.example.demo;

import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CloseWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox big_hbox_close;

    @FXML
    private VBox big_vbox_close;

    @FXML
    private Button button_save_quite;

    @FXML
    private Button cancel_button;

    @FXML
    private HBox close_hbox5;

    @FXML
    private HBox close_hbox6;

    @FXML
    private HBox hbox_close1;

    @FXML
    private HBox hbox_close2;

    @FXML
    private HBox hbox_close3;

    @FXML
    private Button nosave_button;

    @FXML
    private TextField text_field_close;

    @FXML
    void cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void quite_nosave(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        HelloController.close(event);
    }

    @FXML
    void save_quite(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert big_hbox_close != null : "fx:id=\"big_hbox_close\" was not injected: check your FXML file 'close_window.fxml'.";
        assert big_vbox_close != null : "fx:id=\"big_vbox_close\" was not injected: check your FXML file 'close_window.fxml'.";
        assert button_save_quite != null : "fx:id=\"button_save_quite\" was not injected: check your FXML file 'close_window.fxml'.";
        assert cancel_button != null : "fx:id=\"cancel_button\" was not injected: check your FXML file 'close_window.fxml'.";
        assert close_hbox5 != null : "fx:id=\"close_hbox5\" was not injected: check your FXML file 'close_window.fxml'.";
        assert close_hbox6 != null : "fx:id=\"close_hbox6\" was not injected: check your FXML file 'close_window.fxml'.";
        assert hbox_close1 != null : "fx:id=\"hbox_close1\" was not injected: check your FXML file 'close_window.fxml'.";
        assert hbox_close2 != null : "fx:id=\"hbox_close2\" was not injected: check your FXML file 'close_window.fxml'.";
        assert hbox_close3 != null : "fx:id=\"hbox_close3\" was not injected: check your FXML file 'close_window.fxml'.";
        assert nosave_button != null : "fx:id=\"nosave_button\" was not injected: check your FXML file 'close_window.fxml'.";
        assert text_field_close != null : "fx:id=\"text_field_close\" was not injected: check your FXML file 'close_window.fxml'.";

    }

}
