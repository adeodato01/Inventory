package inventorytestmain;

import controller.InventoryTestMethod;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Inventory;
import model.Outsourced;

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
    }

    /** This is the Main method. This method launches the Inventory app.
     *
     * @param args
     */
    public static void main(String [] args) {

        System.out.println("before launch");

        Outsourced part1 = new Outsourced(
                InventoryTestMethod.increaseCounter(),
                "Seat",
                29.99,
                5,
                1,
                10,
                "WinCo");

        Inventory.addPart(part1);

        System.out.println("part1 ID is: " + part1.getId());

        System.out.println("The part counter is now: " + InventoryTestMethod.getPartCounter());

        launch(args);

        System.out.println("do we get to this line?");
    }
}
