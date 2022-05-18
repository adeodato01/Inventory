package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/** This public class contains additional variables and public methods to be used throughout the Inventory app.
 *
 */
public class InventoryTestMethod {

    private Stage stage;
    private Parent scene;

    private static int partCounter = 0;
    private static int productCounter = 1000;

    private static int validationError = 0;

    /** This method sets the Validation Error value.
     *
     * @param validationError an integer
     */
    public static void setValidationError(int validationError) {
        InventoryTestMethod.validationError = validationError;
    }


    /** This is the Increase Part Error static method.
     * This method increments the partError static variable.
     * @return Returns an increased partError int.
     */
    public static int increaseValidationError() {
        validationError++;
        return validationError;
    }


    /** This method returns the value of Validation Error.
     *
     * @return an integer
     */
    public static int getValidationError() {
        return validationError;
    }


    /** This static method retrieves the Part Counter variable value.
     *
     * @return the current value of the Part Counter
     */
    public static int getPartCounter() {
        return partCounter;
    }

    /** This is the Increase Part Counter static method.
     * This method increments the partCounter static variable.
     * @return Returns an increased partCounter int.
     */
    public static int increasePartCounter() {
        partCounter++;
        return partCounter;
    }

    /** This static method retrieves the Product Counter variable value.
     *
     * @return the current value of the Product Counter
     */
    public static int getProductCounter() {
        return productCounter;
    }

    /** This is the Increase Product Counter static method.
     * This method increments the productCounter static variable
     * @return Returns an increased productCounter int.
     */
    public static int increaseProductCounter() {
        productCounter++;
        return productCounter;
    }

    /** This is the Switch Stage method.
     * This method is overloaded with 3 parameters and generates a new scene unto the stage.
     * @param event The ActionEvent causing the change of scene
     * @param pageLocation a String of the fxml filename in the View
     * @param pageTitle a String of what the new Scene title should be
     */
    @FXML
    public void switchStage(ActionEvent event, String pageLocation, String pageTitle) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource(pageLocation));
        stage.setScene(new Scene(scene));
        stage.setTitle(pageTitle);
        stage.show();
    }

    /** This is the Switch Stage method.
     * This method is overloaded with 2 parameters and generates a new scene unto the stage.
     * @param event The ActionEvent causing the change of scene
     * @param pageLocation a String of the fxml filename in the View
     */
    @FXML
    public void switchStage(ActionEvent event, String pageLocation) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource(pageLocation));
        stage.setScene(new Scene(scene));
        stage.show();
    }

}
