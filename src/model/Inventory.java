package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** This is a class that contains static lists of
 * all the Parts and all the Products along with their
 * static associated methods.
 * <p>
 * RUNTIME ERROR<br>
 * Missing code after <i><b><code>allParts</code></b></i> and <i><b><code>allProducts</code></b></i> attributes
 * created an InvocationTargetException on 5/16/2022
 * <p>
 * This was repaired by adding <b><code>" = FXCollections.observableArrayList()"</code></b> to <i><b><code>allParts</code></b></i> and <i><b><code>allProducts</code></b></i> attributes.
 */
public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This static method adds a part to the allParts list.
     * @param newPart a Part
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /** This static method adds a product to the allProducts list.
     * @param newProduct a Product
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /** This is an overloaded static method that
     * looks up a Part in the allParts list.
     * @param partId an integer of the Part ID.
     * @return the requested part
     */
    public static Part lookupPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    /** This is an overloaded static method that
     * looks up Parts in the allParts list.
     * This method STRIPS the incoming string of whitespace and sets it to lower case.
     * @param partName a String to look up parts
     * @return an Observable List containing all matching parts
     */
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        String search = partName.toLowerCase().strip();

        for (Part part : allParts) {
            if (part.getName().toLowerCase().contains(search)) {
                filteredParts.add(part);
            }
        }
        if (filteredParts.isEmpty()) {
            return null;
        }
        else {
            return filteredParts;
        }
    }


    /** This is an overloaded static method that
     * looks up a Product in the allProducts list.
     * @param productId an integer of the Product ID
     * @return the requested product
     */
    public static Product lookupProduct(int productId) {
        for (Product product : allProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /** This is an overloaded static method that
     * looks up Products in the allProducts list.
     * This method STRIPS the incoming string of whitespace and sets it to lower case.
     * @param productName a String that to look up Products
     * @return an Observable List containing all matching Products
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
        String search = productName.toLowerCase().strip();

        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(search)) {
                filteredProducts.add(product);
            }
        }
        if (filteredProducts.isEmpty()) {
            return null;
        }
        else {
            return filteredProducts;
        }
    }

    /** This method updates an existing part in the allParts list with new information.
     * @param index the index position of the part in the allParts list
     * @param selectedPart the Part object that'll be updated
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.remove(index);
        allParts.add(index, selectedPart);
    }

    /** This method updates an existing part in the allProducts list with new information.
     * @param index the index position of the product in the allProducts list
     * @param newProduct the new Product information
     */
    public static void updateProduct(int index, Product newProduct) {
        allProducts.remove(index);
        allProducts.add(index, newProduct);
    }

    /** This method removes a Part from the allParts list.
     * @param selectedPart a part selected from the GUI
     * @return a boolean; Was the part removed? True or False
     */
    public static boolean deletePart(Part selectedPart) {
        int id = selectedPart.getId();
        for (Part part : allParts) {
            if (part.getId() == id) {
                return allParts.remove(part);
            }
        }
        return false;
    }

    /** This method removes a Product from the allProducts list.
     * @param selectedProduct a product selected from the GUI
     * @return a boolean; Was the product removed? True or False
     */
    public static boolean deleteProduct(Product selectedProduct) {
        int id = selectedProduct.getId();
        for (Product product : allProducts) {
            if (product.getId() == id) {
                return allProducts.remove(product);
            }
        }
        return false;
    }


    /** This is the allParts getter
     * @return the allParts list
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /** This is the allProducts getter
     * @return the allProducts list
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
