package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    private static StringBuilder validationWarning = new StringBuilder();

    /** This method returns the Validation Warning StringBuilder to a String.
     *
     * @return the string of the Validation Warning
     */
    public static String getValidationWarning() {
        return validationWarning.toString();
    }

    /** This method adds to the private Validation Warning StringBuilder.
     *
     * @param warning a String
     */
    public static void addValidationWarning(String warning) {
        validationWarning.append(warning);
    }

    /** This method confirms if the Validation Warnings are empty.
     *
     * @return a boolean
     */
    public static boolean noWarnings() {
        if (validationWarning.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /** This method checks the validity of inputs
     *
     * @param name
     * @param inventory
     * @param price
     * @param min
     * @param max
     */
    public static void inputValidator(
            TextField name,
            TextField inventory,
            TextField price,
            TextField min,
            TextField max) {

        int minInput = -1;
        int maxInput = -1;
        int invInput = -1;
        double priceInput = -1.0;

        validationWarning.delete(0, validationWarning.length());

        if (name.getText() == null || name.getText().trim().isEmpty()) {
            validationWarning.append("Name field cannot be blank.\n");
        }

        if (inventory.getText() == null || inventory.getText().trim().isEmpty()) {
            validationWarning.append("Inventory field cannot be blank.\n");
        }
        else {
            try {
                // gotta add .trim() to parseInt parameters
                invInput = Integer.parseInt(inventory.getText().trim());

            } catch (NumberFormatException e) {
                validationWarning.append("Inventory must be an integer.\n");
            }
        }

        if (price.getText() == null || price.getText().trim().isEmpty()) {
            validationWarning.append("Price field cannot be blank.\n");
        }
        else {
            try {
                priceInput = Double.parseDouble(price.getText());

                if (priceInput < 0) {
                    validationWarning.append("Price must not be negative.\n");
                }

            } catch (NumberFormatException e) {
                validationWarning.append("Price must be a number.\n");
            }
        }

        if (min.getText() == null || min.getText().trim().isEmpty()) {
            validationWarning.append("Minimum field cannot be blank.\n");
        }
        else {
            try {
                minInput = Integer.parseInt(min.getText().trim());

                if (minInput < 0) {
                    validationWarning.append("Minimum field must be an integer of zero or larger.\n");
                }
            } catch (NumberFormatException e) {
                validationWarning.append("Minimum must be an integer.\n");
            }
        }
        if (max.getText() == null || max.getText().trim().isEmpty()) {
            validationWarning.append("Maximum field cannot be blank.\n");
        }
        else {
            try {
                maxInput = Integer.parseInt(max.getText().trim());

                if (maxInput < minInput) {
                    validationWarning.append("Maximum must be greater than or equal to Minimum.\n");
                }
                else if (invInput < minInput || invInput > maxInput) {
                    validationWarning.append("Inventory must be between Minimum and Maximum\n");
                }
            } catch (NumberFormatException e) {
                validationWarning.append("Maximum must be an integer.\n");
            }
        }
    }

}
