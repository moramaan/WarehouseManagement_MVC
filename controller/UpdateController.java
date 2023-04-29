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

    public void loadFormData() {
        ProductModel selectedProduct = wh.getProduct(Integer.valueOf(selectedCode));

        System.out.println(selectedCode);
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

    public boolean saveUpdatedItem() {
        boolean saved = true;
        ProductModel updatedProduct, storedProduct, test;

        updatedProduct = dataCtrl.craftNewProductModel();
        storedProduct = wh.getProduct(updatedProduct.getId());
        try {
            wh.deleteProduct(storedProduct.getId());
            if (!wh.productExists(storedProduct.getId())) {
                wh.addProduct(updatedProduct);
            } else {
                throw new Exception("Deletion of the map, previous to update, not works fine");
            }
//            storedProduct = updatedProduct;
        } catch (Exception e) {
            saved = false;
            System.out.println(e.getMessage());
        }

        return saved;
    }
}
