/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.MainView;

/**
 *
 * @author moraman
 */
public class DeleteController {

    private MainView mainView;
    private DataController dataCtrl;

    public DeleteController(MainView mainView, DataController dataCtrl) {
        this.mainView = mainView;
        this.dataCtrl = dataCtrl;
    }

    public void deleteProduct(int productId) {
        dataCtrl.deleteProduct(productId);
    }
}
