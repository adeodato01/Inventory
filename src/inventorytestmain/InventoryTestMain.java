package inventorytestmain;

import controller.InventoryTestMethod;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Product;

/** This is the Main class. The app runs from this class.
 *
 */
public class InventoryTestMain extends Application {

    /** This is the start method. It sets the Stage so the Main Menu scene can be displayed on it.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        stage.setScene(new Scene(root, 1124, 418));
        stage.show();

        // lines 33 - 43 create a pop-up window to confirm force closing the app
        stage.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Close App");
            alert.setHeaderText("You are forcing the Inventory app to close.");
            alert.setContentText("Are you sure you want to force close the Inventory app?");

            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
        });
    }

    /** This is the Main method. This method launches the Inventory app.
     *
     * @param args
     */
    public static void main(String [] args) {

        System.out.println("before launch");

        Outsourced part1 = new Outsourced(
                InventoryTestMethod.increasePartCounter(),
                "Seat",
                29.99,
                5,
                1,
                10,
                "WinCo");

        InHouse part2 = new InHouse(
                InventoryTestMethod.increasePartCounter(),
                "Wheel",
                59.99,
                12,
                1,
                90,
                24);

        Inventory.addPart(part1);
        Inventory.addPart(part2);

        Product product1 = new Product(
                InventoryTestMethod.increaseProductCounter(),
                "Speed Bike",
                699.00,
                5,
                1,
                20);
        product1.addAssociatedPart(part1);

        Product product2 = new Product(
                InventoryTestMethod.increaseProductCounter(),
                "Commuter Bike",
                599.00,
                4,
                1,
                25);
        product2.addAssociatedPart(part2);

        Inventory.addProduct(product1);
        Inventory.addProduct(product2);

        if (InventoryTestMethod.getValidationError() == 0) {
            System.out.println("Yup, it's zero");
        }

        System.out.println("The part error number is: " + InventoryTestMethod.getValidationError());

        InventoryTestMethod.increaseValidationError();

        System.out.println("The part error number is: " + InventoryTestMethod.getValidationError());

        String test = "khkljh";

        String what = "What?";

/*
        String test2 = test.concat(what);
        test.concat("\n");
        test.concat("who?");
        test.concat("\n");
        test.concat("where?");
        test.concat("\n");
*/

        StringBuilder test2 = new StringBuilder(test);

        test2.append(what);
        test2.append("\n");
        test2.append("who?");
        test2.append("\n");
        test2.append("where?");
        test2.append("\n");

        System.out.println("Is the test empty? " + test2.isEmpty());

        System.out.println(test2);

        // This line launches the GUI. Any pre-setting can be coded before this line.
        launch(args);

        //Code after this point runs if the "Red X" is clicked at the top right of the app.
        System.out.println("You forced closed the app");
    }
}
