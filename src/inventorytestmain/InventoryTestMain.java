package inventorytestmain;

import controller.InventoryTestMethod;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
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



        // This line launches the GUI. Any pre-setting can be coded before this line.
        launch(args);

        //Code after this point runs if the "Red X" is clicked at the top right of the app.
        System.out.println("do we get to this line?");
    }
}
