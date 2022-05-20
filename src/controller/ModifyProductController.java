package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/** This class represents the Modify Product controller.
 *
 */
public class ModifyProductController implements Initializable {

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
    private TableColumn<Part, Integer> productPartIdCol;

    @FXML
    private TableColumn<Part, Integer> productPartInventoryCol;

    @FXML
    private TableColumn<Part, String> productPartNameCol;

    @FXML
    private TableColumn<Part, Double> productPartPriceCol;

    @FXML
    private TableView<Part> productPartsTableView;

    @FXML
    private TextField productPriceTxt;

    @FXML
    private Label addProductWarning;

    private ObservableList<Part> selectedParts = FXCollections.observableArrayList();

    private int productIndex = -1;

    /** This is the Send Product method.
     * This will transfer both the Selected Product from the Main Menu and its Index to the Modify Product page.
     * @param product the Product object selected from the main Menu
     * @param index the index of the original Product in the Main Menu
     */
    public void sendProduct(Product product, int index) {
        productIndex = index;
        productIdTxt.setText(String.valueOf(product.getId()));
        productNameTxt.setText(String.valueOf(product.getName()));
        productInvTxt.setText(String.valueOf(product.getStock()));
        productPriceTxt.setText(String.valueOf(product.getPrice()));
        productMinTxt.setText(String.valueOf(product.getMin()));
        productMaxTxt.setText(String.valueOf(product.getMax()));

        selectedParts.addAll(product.getAllAssociatedParts());
/*
        // this for loop was replaced by the ".addAll" method.
        for (Part part : product.getAllAssociatedParts()) {
            selectedParts.add(part);
        }
*/
    }


    /** This method adds a selected part to the Product Parts Table View
     * @param newPart the selected part
     */
    public void addSelectedPart(Part newPart) {
        selectedParts.add(newPart);
    }

    /** This method will return the Selected Parts Observable List
     * @return the selectedParts list
     */
    public ObservableList<Part> getSelectedParts() {
        return selectedParts;
    }

    /** This method removes a part from the Select Part list using the Part ID
     * @param id part ID
     * @return a boolean
     */
    public boolean removeSelectedPart(int id) {
        for (Part part : getSelectedParts()) {
            if (part.getId() == id) {
                return getSelectedParts().remove(part);
            }
        }
        return false;
    }

    /** This method removes a part from the Select Part list using its Index position in the list.
     * @param index desired index position
     */
    public void removeSelectedPartIndex(int index) {
        getSelectedParts().remove(index);
    }


    /** On Button Press, this method will add a part to the Selected Parts list.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) {
        System.out.println("I hit the Add Part button");

        System.out.println("The Index of the item is: " + availPartsTableView.getSelectionModel().getSelectedIndex());

        addSelectedPart(availPartsTableView.getSelectionModel().getSelectedItem());
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
     * @param event the click event
     * @see #removeSelectedPartIndex(int)
     */
    @FXML
    void onActionRemovePart(ActionEvent event) {

/*
        // Deletes using the Part ID -- removes the first part with matching ID
        try {
            removeSelectedPart(productPartsTableView.getSelectionModel().getSelectedItem().getId());

        } catch (NullPointerException e){

        }
*/

        // Deletes using the Index position
        try {
            removeSelectedPartIndex(productPartsTableView.getSelectionModel().getSelectedIndex());

        } catch (IndexOutOfBoundsException ignored){ }
    }

    /** On Button Press, this method will verify input and save the Product to the allProducts list and return the user to the Main Menu.
     * This actually replaces the chosen Product with a new Product object.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {

        InventoryTestMethod.inputValidator(productNameTxt, productInvTxt, productPriceTxt, productMinTxt, productMaxTxt);
        addProductWarning.setText(InventoryTestMethod.getValidationWarning());

        if (InventoryTestMethod.noWarnings()) {
            Product newProduct = new Product(
                    // replace the Increase Counter line
                    Integer.parseInt(productIdTxt.getText()),
                    productNameTxt.getText(),
                    Double.parseDouble(productPriceTxt.getText()),
                    Integer.parseInt(productInvTxt.getText().trim()),
                    Integer.parseInt(productMinTxt.getText().trim()),
                    Integer.parseInt(productMaxTxt.getText().trim()));

            //Add code to add parts to the parts list
            newProduct.setPartList(selectedParts);

            Inventory.updateProduct(productIndex, newProduct);

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

        productPartsTableView.setItems(getSelectedParts());
        productPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}
