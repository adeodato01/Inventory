package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        System.out.println("Add Part");

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        //stage.setTitle(pageTitle);
        stage.show();

    }

    @FXML
    void onActionAddProduct(ActionEvent event) {
        System.out.println("Add Product");
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        System.out.println("Delete Selected Part");
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        System.out.println("Delete Selected Product");
    }

    @FXML
    void onActionExitApp(ActionEvent event) {
        System.out.println("Exit App");
    }

    @FXML
    void onActionModifyPart(ActionEvent event) {
        System.out.println("Modify Part");
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) {
        System.out.println("Modify Product");
    }

    @FXML
    void onActionSearchParts(ActionEvent event) {
        System.out.println("Searching Parts");
    }

    @FXML
    void onActionSearchProducts(ActionEvent event) {
        System.out.println("Searching Products");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main Menu is Initialized");
    }
}
