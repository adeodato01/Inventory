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

    /** This static method gets the Part Counter variable value
     *
     * @return the current value of the Part Counter
     */
    public static int getPartCounter() {
        return partCounter;
    }

    /** This is the Increase Counter static method.
     * This method increments the partCounter static variable.
     * @return Returns an increased partCoutner int.
     */
    public static int increaseCounter() {
        partCounter++;
        return partCounter;
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
