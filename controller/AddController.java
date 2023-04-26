/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;
import model.ProductModel;
import model.TypeModel;
import model.WarehouseModel;
import view.AddView;

/**
 *
 * @author moraman
 */
public class AddController {

    private MainController mainCtrl;
    private WarehouseModel wh;
    private AddView addView;
    private DataController dataCtrl;

    public AddController(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;

    }

    public void setDataCtrl(DataController dataCtrl) {
        this.dataCtrl = dataCtrl;
    }

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void setWh(WarehouseModel wh) {
        this.wh = wh;
    }

    public void setAddViewComboItems(JComboBox cb) {
        for (TypeModel tm : wh.getTypeList()) {
            cb.addItem(tm.getName());
        }
    }

    /**
     * It picks all form info, create a new ProductModel instance with it and
     * put product into Warehouse productsList.
     */
    public boolean saveNewItem() {
        mainCtrl.setDataCtrlToAddCtrl();
        boolean done = false;
        ProductModel item = new ProductModel();
        item = dataCtrl.craftNewProductModel();

        if (item != null) {
            done = true;
            wh.addProduct(item);
        }

        return done;
    }
}
