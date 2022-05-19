package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This class represents the Add Product controller.
 *
 */
public class AddProductController implements Initializable {

    InventoryTestMethod newPage = new InventoryTestMethod();

    @FXML
    private TableColumn<Part, Integer> availPartIdCol;

    @FXML
    private TableColumn<Part, Integer> availPartInventoryCol;

    @FXML
    private TableColumn<Part, String> availPartNameCol;

    @FXML
    private TableColumn<Part, Double> availPartPriceCol;

    @FXML
    private TableView<Part> availPartsTableView;

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
    private Label addProductWarning;

    /** On Button Press, this method will add a part to the Product's Parts list.
     * @// FIXME: 5/16/2022 Still must include Adding Parts!
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {


    }

    /** On Button Press, this method will cancel product creation and return the user to the Main Menu.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionCancelProductCreation(ActionEvent event) throws IOException {

        newPage.switchStage(event, "/view/MainMenu.fxml");

    }

    /** On Button Press, this method will remove a part to the Product's Parts list.
     * @// FIXME: 5/16/2022 Build me!
     * @param event the click event
     */
    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    /** On Button Press, this method will verify input and save the Product to the allProducts list and return the user to the Main Menu.
     * @// FIXME: 5/16/2022 Still must add parts!!
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {

        InventoryTestMethod.inputValidator(productNameTxt, productInvTxt, productPriceTxt, productMinTxt, productMaxTxt);
        addProductWarning.setText(InventoryTestMethod.getValidationWarning());

        if (InventoryTestMethod.noWarnings()) {
            Product newProduct = new Product(
                    InventoryTestMethod.increaseProductCounter(),
                    productNameTxt.getText(),
                    Double.parseDouble(productPriceTxt.getText()),
                    Integer.parseInt(productInvTxt.getText().trim()),
                    Integer.parseInt(productMinTxt.getText().trim()),
                    Integer.parseInt(productMaxTxt.getText().trim()));

            Inventory.addProduct(newProduct);

            newPage.switchStage(event, "/view/MainMenu.fxml");
        }

    }

    /** After hitting "Enter" key in the search field, this method will search and display parts.
     * @// FIXME: 5/16/2022 Build me!
     * @param event the click event
     */
    @FXML
    void onActionSearchAvailableParts(ActionEvent event) {

    }

    /** This method displays the Add Product page.
     * @// FIXME: 5/18/2022 deal with the added parts list
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        availPartsTableView.setItems(Inventory.getAllParts());
        availPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        availPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        availPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        availPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}
