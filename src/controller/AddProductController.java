package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    InventoryTestMethod newPage = new InventoryTestMethod();

    @FXML
    private TableColumn<?, ?> availPartIdCol;

    @FXML
    private TableColumn<?, ?> availPartInventoryCol;

    @FXML
    private TableColumn<?, ?> availPartNameCol;

    @FXML
    private TableColumn<?, ?> availPartPriceCol;

    @FXML
    private TableView<?> availPartsTableView;

    @FXML
    private TextField productIdTxt;

    @FXML
    private TextField productInvTxt;

    @FXML
    private TextField productMaxTxt;

    @FXML
    private TextField productMinTxt;

    @FXML
    private TextField productNameTxt;

    @FXML
    private TableColumn<?, ?> productPartIdCol;

    @FXML
    private TableColumn<?, ?> productPartInventoryCol;

    @FXML
    private TableColumn<?, ?> productPartNameCol;

    @FXML
    private TableColumn<?, ?> productPartPriceCol;

    @FXML
    private TableView<?> productPartsTableView;

    @FXML
    private TextField productPriceTxt;

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

    }

    @FXML
    void onActionCancelProductCreation(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");

    }

    @FXML
    void onActionSearchAvailableParts(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
