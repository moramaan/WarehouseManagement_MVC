/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ProductModel;
import model.WarehouseModel;
import view.FormView;

/**
 *
 * @author moraman
 */
public class UpdateController {

    private FormView updateView;
    private String selectedCode;
    private WarehouseModel wh;
    private DataController dataCtrl;

    public UpdateController(FormView updateView, String selectedCode, WarehouseModel wh, DataController dataCtrl) {
        this.updateView = updateView;
        this.selectedCode = selectedCode;
        this.wh = wh;
        this.dataCtrl = dataCtrl;
    }

    /**
     * This method loads the product data, which comes from the selected item in
     * the main view, into the form view.
     */
    public void loadFormData() {
        ProductModel selectedProduct = dataCtrl.getProduct(Integer.parseInt(selectedCode));

        updateView.getCodeTextField().setText(Integer.toString(selectedProduct.getId()));
        updateView.getCodeTextField().setEnabled(false);
        updateView.getNameTextField().setText(selectedProduct.getName());
        updateView.getComboBox().getModel().setSelectedItem(selectedProduct.getType().getName());
        updateView.getLocationTextField().setText(selectedProduct.getLocation());
        updateView.getQtyTextField().setText(Integer.toString(selectedProduct.getQuantity()));
        updateView.getPriceTextField().setText(Double.toString(selectedProduct.getUnitPrice()));
        updateView.getSelfSellCheckBox().setSelected(selectedProduct.isSelfSell());

        switch (selectedProduct.getGroup()) {
            case "New Arrival":
                updateView.getNewArrivalRadioBtn().setSelected(true);
                break;
            case "Top Seller":
                updateView.getTopSellerRadioBtn().setSelected(true);
                break;
            default:
                updateView.getNormalRadioBtn().setSelected(true);
        }
    }

    /**
     * This method saves the updated item in the Warehouse product list instead
     * of the outdated one.
     *
     * @return true or false depending on the save action is done or not.
     */
    public boolean saveUpdatedItem() {
        boolean saved = true;
        ProductModel updatedProduct, storedProduct;

        updatedProduct = dataCtrl.craftNewProductModel();
        storedProduct = wh.getProduct(updatedProduct.getId());
        try {
            dataCtrl.deleteProduct(storedProduct.getId());

            if (!dataCtrl.productExists(storedProduct.getId())) {
                dataCtrl.addProduct(updatedProduct);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            saved = false;
            System.out.println("Internal error, not saved.");
        }
        return saved;
    }
}
