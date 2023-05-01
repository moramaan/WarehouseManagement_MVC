/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author moraman
 */
public class DeleteController {

    private DataController dataCtrl;

    public DeleteController(DataController dataCtrl) {
        this.dataCtrl = dataCtrl;
    }

    public void deleteProduct(int productId) {
        dataCtrl.deleteProduct(productId);
    }
}
