package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This class represents the Modify Part controller.
 *
 */
public class ModifyPartController implements Initializable {

    InventoryTestMethod newPage = new InventoryTestMethod();

    private int partIndex = -1;

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

    /** This is the Send Part method.
     * It takes the selected Part from the Main Menu to display on the Modify Part page.
     * @param part the selected part
     * @param index the part's index in the allParts list.
     */
    public void sendPart(Part part, int index) {
        partIndex = index;

        if (part instanceof InHouse) {
            inHouseRBtn.setSelected(true);
            machIdField.setText(String.valueOf(((InHouse) part).getMachineId()));
            machineIdOrCompanyName.setText("Machine ID");
        }
        if (part instanceof Outsourced) {
            outsourcedRBtn.setSelected(true);
            machIdField.setText(String.valueOf(((Outsourced) part).getCompanyName()));
            machineIdOrCompanyName.setText("Company Name");
        }

        idField.setText(String.valueOf(part.getId()));
        nameField.setText(String.valueOf(part.getName()));
        inventoryField.setText(String.valueOf(part.getStock()));
        priceField.setText(String.valueOf(part.getPrice()));
        minField.setText(String.valueOf(part.getMin()));
        maxField.setText(String.valueOf(part.getMax()));
    }

    /** On Radio Button press, this method changes the text field label to "Machine ID."
     * @param event the click event
     */
    @FXML
    void inHouseSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Machine ID");
    }

    /** On Radio Button press, this method changes the text field label to "Company Name."
     * @param event the click event
     */
    @FXML
    void outsourcedSelected(ActionEvent event) {
        machineIdOrCompanyName.setText("Company Name");
    }

    /** On Button Press, this method will verify input and save the Part to the allParts list and return the user to the Main Menu.
     * @param event button press
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
                        Integer.parseInt(idField.getText()),
                        nameField.getText().trim(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(inventoryField.getText().trim()),
                        Integer.parseInt(minField.getText().trim()),
                        Integer.parseInt(maxField.getText().trim()),
                        machIdField.getText().trim());

                Inventory.updatePart(partIndex, newPart);
            }

            if (inHouseRBtn.isSelected()) {
                InHouse newPart = new InHouse(
                        Integer.parseInt(idField.getText()),
                        nameField.getText().trim(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(inventoryField.getText().trim()),
                        Integer.parseInt(minField.getText().trim()),
                        Integer.parseInt(maxField.getText().trim()),
                        Integer.parseInt(machIdField.getText().trim()));

                Inventory.updatePart(partIndex, newPart);
            }

            newPage.switchStage(event, "/view/MainMenu.fxml");

        }

    }



    /** On Button Press, this method will cancel part creation and return the user to the Main Menu.
     * @param event button press
     * @throws IOException
     */
    @FXML
    void onActionCancelAdd(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");
    }

    /** This method displays the Modify Part page.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("@ the Add Part screen");
    }
}
