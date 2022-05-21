package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This class represents the Main Menu controller.
 *
 */
public class MainMenuController implements Initializable {

    Stage stage;

    InventoryTestMethod newPage = new InventoryTestMethod();

    @FXML
    private Label deleteProductWarning;

    /** On Button Press, this method takes the user to the Add Part page.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        System.out.println("Add Part");

        newPage.switchStage(event, "/view/AddPart.fxml");
    }

    /** On Button Press, this method take the user to the Add Product page.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        System.out.println("Add Product");

        newPage.switchStage(event, "/view/AddProduct.fxml");
    }

    /** On Button Press, this method will delete the selected part from the Parts table
     * @param event the click event
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        System.out.println("Delete Selected Part");
        try {
            String partName = partTableView.getSelectionModel().getSelectedItem().getName();
            System.out.println(partName);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Part");
            alert.setContentText("Are you sure you want to delete the " + partName + " part?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                Inventory.deletePart(partTableView.getSelectionModel().getSelectedItem());
            }
        } catch (NullPointerException ignored){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Part");
            alert.setContentText("Please select a Part to delete.");
            alert.show();
        }

        partTableView.setItems(Inventory.getAllParts());
        partSearch.clear();
    }


    /** On Button Press, this method will delete the selected product from the Products table
     * @param event the click event
     */
    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        System.out.println("Delete Selected Product");

        try {
            if (productTableView.getSelectionModel().getSelectedItem().getAllAssociatedParts().isEmpty()) {
                String productName = productTableView.getSelectionModel().getSelectedItem().getName();
                System.out.println(productName);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete Product");
                alert.setContentText("Are you sure you want to delete the " + productName + " product?");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    Inventory.deleteProduct(productTableView.getSelectionModel().getSelectedItem());
                }
            }
            else {
                deleteProductWarning.setText("Cannot delete. Product has associated parts.");
            }
        } catch (NullPointerException ignored){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Product");
            alert.setContentText("Please select a Product to delete.");
            alert.show();
        }

        productTableView.setItems(Inventory.getAllProducts());
        productSearch.clear();
    }

    /** On Button Press, this method will close the app window.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    void onActionExitApp(ActionEvent event) throws IOException {
        //System.out.println("before exit");
        System.exit(0);
        //no code is run after the above line.
    }

    /** On Button Press, this method will take the user to the Modify Part page.
     * @param event the click event
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        System.out.println("Modify Part");

        try {

            FXMLLoader ModPartLoader = new FXMLLoader();
            ModPartLoader.setLocation(getClass().getResource("/view/ModifyPart.fxml"));
            ModPartLoader.load();
            ModifyPartController MPL = ModPartLoader.getController();
            MPL.sendPart(
                    partTableView.getSelectionModel().getSelectedItem(),
                    partTableView.getSelectionModel().getSelectedIndex());
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = ModPartLoader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NullPointerException ignored) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modify Part");
            alert.setContentText("Please select a Part to modify.");
            alert.show();
        }
    }

    /** On Button Press, this method will take the user to the Modify Product page.
     * @param event the click event
     */
    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        System.out.println("Modify Product");

        try {

            FXMLLoader MPCLoader = new FXMLLoader();
            MPCLoader.setLocation(getClass().getResource("/view/ModifyProduct.fxml"));
            MPCLoader.load();
            ModifyProductController MPC = MPCLoader.getController();
            MPC.sendProduct(
                    productTableView.getSelectionModel().getSelectedItem(),
                    productTableView.getSelectionModel().getSelectedIndex());
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = MPCLoader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NullPointerException ignored) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modify Product");
            alert.setContentText("Please select a Product to modify.");
            alert.show();
        }
    }

    /** After hitting "Enter" key in the search field, this method will search and display parts.
     * @param event the click event
     */
    @FXML
    void onActionSearchParts(ActionEvent event) {

        ObservableList<Part> searchedParts = FXCollections.observableArrayList();

        try {
            int tryId = Integer.parseInt(partSearch.getText().strip());
            if (Inventory.lookupPart(tryId) == null) {
                partTableView.setItems(Inventory.getAllParts());
                System.out.println("Didn't find with an INT");
                partSearch.clear();
                partTableView.getSelectionModel().selectFirst();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failed Search");
                alert.setContentText("Part ID number not found.");
                alert.show();
                return;
            }
            else {
                searchedParts.add(Inventory.lookupPart(tryId));
                partTableView.setItems(searchedParts);
                //return;
            }
        }  catch (NumberFormatException ignored) { }

        if (searchedParts.isEmpty()) {
            String tryName = partSearch.getText();
            if (Inventory.lookupPart(tryName) != null) {
                searchedParts.addAll(Inventory.lookupPart(tryName));
                partTableView.setItems(searchedParts);
            }
            else {
                partTableView.setItems(Inventory.getAllParts());
                System.out.println("Failed with a STRING");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failed Search");
                alert.setContentText("Matching part not found.");
                alert.show();
            }
        }
        partSearch.clear();
        partTableView.getSelectionModel().selectFirst();
    }

    /** After hitting "Enter" key in the search field, this method will search and display products.
     * @param event the click event
     */
    @FXML
    void onActionSearchProducts(ActionEvent event) {

        ObservableList<Product> searchedProducts = FXCollections.observableArrayList();

        try {
            int tryId = Integer.parseInt(productSearch.getText().strip());
            if (Inventory.lookupProduct(tryId) == null) {
                productTableView.setItems(Inventory.getAllProducts());
                System.out.println("Didn't find with an INT");
                productSearch.clear();
                productTableView.getSelectionModel().selectFirst();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failed Search");
                alert.setContentText("Product ID number not found.");
                alert.show();
                return;
            }
            else {
                searchedProducts.add(Inventory.lookupProduct(tryId));
                productTableView.setItems(searchedProducts);
            }
        }  catch (NumberFormatException ignored) { }

        if (searchedProducts.isEmpty()) {
            String tryName = productSearch.getText();
            if (Inventory.lookupProduct(tryName) != null) {
                searchedProducts.addAll(Inventory.lookupProduct(tryName));
                productTableView.setItems(searchedProducts);
            }
            else {
                productTableView.setItems(Inventory.getAllProducts());
                System.out.println("Failed with a STRING");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failed Search");
                alert.setContentText("Matching product name not found.");
                alert.show();
            }
        }
        productSearch.clear();
        productTableView.getSelectionModel().selectFirst();
    }

    @FXML
    private TextField partSearch;

    @FXML
    private TextField productSearch;

    @FXML
    private TableColumn<Part, Integer> partIdCol;

    @FXML
    private TableColumn<Part, Integer> partInvCol;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TableColumn<Part, Double> partPriceCol;

    @FXML
    private TableView<Part> partTableView;

    @FXML
    private TableColumn<Product, Integer> productIdCol;

    @FXML
    private TableColumn<Product, Integer> productInvCol;

    @FXML
    private TableColumn<Product, String> productNameCol;

    @FXML
    private TableColumn<Product, Double> productPriceCol;

    @FXML
    private TableView<Product> productTableView;


    /** This method displays the Main Menu.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main Menu is Initialized");

        partTableView.setItems(Inventory.getAllParts());
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        productTableView.setItems(Inventory.getAllProducts());
        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}
