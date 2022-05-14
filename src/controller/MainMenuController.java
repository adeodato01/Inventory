package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    InventoryTestMethod newPage = new InventoryTestMethod();

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        System.out.println("Add Part");

        newPage.switchStage(event, "/view/AddPart.fxml");
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

        System.out.println("Part Counter is: " + InventoryTestMethod.partCounter);

        System.out.println("Part Counter is now: " + InventoryTestMethod.increaseCounter());

        System.out.println("Part Counter is: " + InventoryTestMethod.partCounter);

    }
}
