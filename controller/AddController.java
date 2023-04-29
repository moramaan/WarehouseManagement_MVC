/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ProductModel;
import model.WarehouseModel;

/**
 *
 * @author moraman
 */
public class AddController {

    private MainController mainCtrl;
    private WarehouseModel wh;
    private DataController dataCtrl;

    public AddController(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;

    }

    public void setDataCtrl(DataController dataCtrl) {
        this.dataCtrl = dataCtrl;
    }

    public void setWh(WarehouseModel wh) {
        this.wh = wh;
    }

    /**
     * It picks all form info, create a new ProductModel instance with it and
     * put product into Warehouse productsList.
     * @return true if item is saved | false if anything goes wrong
     */
    public boolean saveNewItem() {
        mainCtrl.setDataCtrl();
        boolean done = false;
        ProductModel item;
        item = dataCtrl.craftNewProductModel();

        if (item != null) {
            done = true;
            wh.addProduct(item);
        }

        return done;
    }
}
