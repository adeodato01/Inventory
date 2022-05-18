package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
     * @// FIXME: 5/16/2022 Build me!
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {


        StringBuilder test2 = new StringBuilder("test");

        test2.append("   what");
        test2.append("\n");
        test2.append("who?");
        test2.append("\n");
        test2.append("where?");
        test2.append("\n");

        addPartWarning.setText(test2.toString());

        System.out.println("Is test2 empty? " + test2.isEmpty());

        test2.delete(0, test2.length());

        System.out.println("Is test2 empty? " + test2.isEmpty());





//        addPartWarning.setText("testing\ntesting\ntesting\ntesting\ntesting\ntesting\n");

//        newPage.switchStage(event, "/view/MainMenu.fxml");
    }

    /** On Button Press, this method will cancel part creation and return the user to the Main Menu.
     * @// FIXME: 5/16/2022 Build me!
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
