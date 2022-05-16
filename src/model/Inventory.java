package model;

import javafx.collections.ObservableList;

/** This is a class that contains static lists of
 * all the Parts and all the Products along with their
 * static associated methods.
 */
public class Inventory {

    private static ObservableList<Part> allParts;
    private static ObservableList<Product> allProducts;

    /** This static method adds a part to the allParts list.
     *
     * @param newPart a Part
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /** This static method adds a product to the allProducts list.
     *
     * @param newProduct a Product
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /** This is an overloaded static method that
     * looks up a Part in the allParts list.
     * @// FIXME: 5/15/2022 You've got to create this!
     * @param partId an integer of the Part ID.
     * @return the requested part
     */
/*
    public static Part lookupPart(int partId) {

    }
*/

    /** This is an overloaded static method that
     * looks up Parts in the allParts list.
     * @// FIXME: 5/15/2022 You've got to create this!
     * @param partName a String to look up parts
     * @return an Observable List containing all matching parts
     */
/*
    public static ObservableList<Part> lookupPart(String partName) {

    }
*/


    /** This is an overloaded static method that
     * looks up a Product in the allProducts list.
     * @// FIXME: 5/15/2022 Make me!!
     * @param productId an integer of the Product ID
     * @return the requested product
     */
/*
    public static Product lookupProduct(int productId) {

    }
*/

    /** This is an overloaded static method that
     * looks up Products in the allProducts list.
     * @// FIXME: 5/15/2022 Make me!!
     * @param productName a String that to look up Products
     * @return an Observable List containing all matching Products
     */
/*
    public static ObservableList<Product> lookupProduct(String productName) {

    }
*/

    /** This method updates an existing part in the allParts list with new information.
     * @// FIXME: 5/15/2022 Make me!
     * @param index the index position of the part in the allParts list
     * @param selectedPart the Part object that'll be updated
     */
    public static void updatePart(int index, Part selectedPart) {

    }

    /** This method updates an existing part in the allProducts list with new information.
     * @// FIXME: 5/15/2022 Make me!
     * @param index the index position of the product in the allProducts list
     * @param newProduct the new Product information
     */
    public static void updateProduct(int index, Product newProduct) {

    }

    /** This method removes a Part from the allParts list.
     * @// FIXME: 5/15/2022 Make me!
     * @param selectedPart a part selected from the GUI
     * @return a boolean; Was the part removed? True or False
     */
    public static boolean deletePart(Part selectedPart) {
        return true;
    }

    /** This method removes a Product from the allProducts list.
     * @// FIXME: 5/15/2022 Make me!
     * @param selectedProduct a product selected from the GUI
     * @return a boolean; Was the product removed? True or False
     */
    public static boolean deleteProduct(Product selectedProduct) {
        return true;
    }


    /** This is the allParts getter
     *
     * @return the allParts list
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /** This is the allProducts getter
     *
     * @return the allProducts list
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
