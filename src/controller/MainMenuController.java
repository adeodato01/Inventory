package controller;

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
        } catch (NullPointerException ignored){ }
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
        } catch (NullPointerException ignored){ }
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

        } catch (NullPointerException ignored) { }
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

        } catch (NullPointerException ignored) { }
    }

    /** After hitting "Enter" key in the search field, this method will search and display parts.
     * @// FIXME: 5/16/2022 Build me!
     * @param event the click event
     */
    @FXML
    void onActionSearchParts(ActionEvent event) {
        System.out.println("Searching Parts");
    }

    /** After hitting "Enter" key in the search field, this method will search and display products.
     * @// FIXME: 5/16/2022 Build me!
     * @param event the click event
     */
    @FXML
    void onActionSearchProducts(ActionEvent event) {
        System.out.println("Searching Products");
    }

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
