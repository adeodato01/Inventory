package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    InventoryTestMethod newPage = new InventoryTestMethod();

    @FXML
    private TextField idField;

    @FXML
    private RadioButton inHouseRBtn;

    @FXML
    private TextField inventoryField;

    @FXML
    private TextField machIdField;

    @FXML
    private Label machineIdOrCompanyName;

    @FXML
    private TextField maxField;

    @FXML
    private TextField minField;

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton outsourcedRBtn;

    @FXML
    private ToggleGroup partTG;

    @FXML
    private TextField priceField;

    @FXML
    private Label addPartWarning;

    @FXML
    void inHouseSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Machine ID");
    }

    @FXML
    void outsourcedSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Company Name");
    }


    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

        addPartWarning.setText("testing\ntesting\ntesting\ntesting\ntesting\ntesting\n");

//        newPage.switchStage(event, "/view/MainMenu.fxml");
    }

    @FXML
    void onActionCancelAdd(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("@ the Add Part screen");
    }
}
