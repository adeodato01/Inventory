package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.InHouse;
import model.Inventory;
import model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This class represents the Add Part controller.
 *
 */
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

    /** On Radio Button press, this method changes the text field label to "Machine ID."
     *
     * @param event the click event
     */
    @FXML
    void inHouseSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Machine ID");
    }

    /** On Radio Button press, this method changes the text field label to "Company Name."
     *
     * @param event the click event
     */
    @FXML
    void outsourcedSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Company Name");
    }

    /** On Button Press, this method will verify input and save the Part to the allParts list and return the user to the Main Menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

        InventoryTestMethod.inputValidator(nameField, inventoryField, priceField, minField, maxField);

        if (outsourcedRBtn.isSelected()) {
            if (machIdField.getText() == null || machIdField.getText().trim().isEmpty()) {
                InventoryTestMethod.addValidationWarning("Company Name field cannot be blank.\n");
            }
        }

        if (inHouseRBtn.isSelected()) {
            if (machIdField.getText() == null || machIdField.getText().trim().isEmpty()) {
                InventoryTestMethod.addValidationWarning("Machine ID field cannot be blank.\n");
            }
            else {
                try {
                    Integer.parseInt(machIdField.getText().trim());

                } catch (NumberFormatException e) {
                    InventoryTestMethod.addValidationWarning("Machine ID must be an integer.\n");
                }
            }
        }

        addPartWarning.setText(InventoryTestMethod.getValidationWarning());

        if (InventoryTestMethod.noWarnings()) {

            if (outsourcedRBtn.isSelected()) {
                Outsourced newPart = new Outsourced(
                        InventoryTestMethod.increasePartCounter(),
                        nameField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(inventoryField.getText()),
                        Integer.parseInt(minField.getText()),
                        Integer.parseInt(maxField.getText()),
                        machIdField.getText());

                Inventory.addPart(newPart);
            }

            if (inHouseRBtn.isSelected()) {
                InHouse newPart = new InHouse(
                        InventoryTestMethod.increasePartCounter(),
                        nameField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(inventoryField.getText()),
                        Integer.parseInt(minField.getText()),
                        Integer.parseInt(maxField.getText()),
                        Integer.parseInt(machIdField.getText()));

                Inventory.addPart(newPart);
            }

            newPage.switchStage(event, "/view/MainMenu.fxml");

        }

    }



    /** On Button Press, this method will cancel part creation and return the user to the Main Menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionCancelAdd(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");
    }

    /** This method displays the Add Part page.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("@ the Add Part screen");
    }
}
