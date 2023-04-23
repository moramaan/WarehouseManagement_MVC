/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.WarehouseModel;
import view.MainView;

/**
 *
 * @author moraman
 */
public class ShowDataController {

    private WarehouseModel warehouse;
    private MainView mainView;

    public ShowDataController() {
    }

    public ShowDataController(WarehouseModel warehouse, MainView mainView) {
        this.warehouse = warehouse;
        this.mainView = mainView;
        this.mainView.setInfo(getWarehouseDataTable(),
                this.warehouse.getCategoryList().get(0).getCategory(),
                this.warehouse.getCategoryList().get(1).getCategory());
        this.mainView.setPreferredOptions();
    }

    public TableModel getWarehouseDataTable() {
        TreeSet<Integer> orderedProducts = new TreeSet<>();
        Set<Integer> products = warehouse.getProductsList().keySet();
        orderedProducts.addAll(products);

        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Id");
        tm.addColumn("Name");
        tm.addColumn("Type");
        tm.addColumn("Location");
        tm.addColumn("Category");
        tm.addColumn("Quantity");
        tm.addColumn("Self Sell");
        tm.addColumn("Unit Price");
        tm.addColumn("Total");

        for (Integer key : orderedProducts) {
            Object[] row = new Object[9];

            row[0] = warehouse.getProduct(key).getId();
            row[1] = warehouse.getProduct(key).getName();
            row[2] = warehouse.getProduct(key).getType().getCategory();
            row[3] = warehouse.getProduct(key).getLocation();
            row[4] = warehouse.getProduct(key).getGroup();
            row[5] = warehouse.getProduct(key).getQuantity();
            row[6] = warehouse.getProduct(key).isSelfSell();
            row[7] = warehouse.getProduct(key).getUnitPrice();
            row[8] = warehouse.getProduct(key).getTotal();

            // Se añade al modelo la fila completa.     
            tm.addRow(row);
        }
        return tm;
    }

    public TableModel getWarehouseDataTableFiltered(String comboFilter) {
        if (comboFilter == null || comboFilter.isEmpty()) {
            return getWarehouseDataTable();
        } else {

            DefaultTableModel tm = new DefaultTableModel();
            tm.addColumn("Id");
            tm.addColumn("Name");
            tm.addColumn("Type");
            tm.addColumn("Location");
            tm.addColumn("Category");
            tm.addColumn("Quantity");
            tm.addColumn("Self Sell");
            tm.addColumn("Unit Price");
            tm.addColumn("Total");
            try {

                String category;
                TreeSet<Integer> orderedProducts = new TreeSet<>();
                Set<Integer> products = warehouse.getProductsList().keySet();
                orderedProducts.addAll(products);

                for (Integer key : orderedProducts) {
                    category = warehouse.getProduct(key).getType().getCategory();
//                System.out.println(category);
                    if (category.equalsIgnoreCase(comboFilter)) {
                        Object[] row = new Object[9];

                        row[0] = warehouse.getProduct(key).getId();
                        row[1] = warehouse.getProduct(key).getName();
                        row[2] = warehouse.getProduct(key).getType().getCategory();
                        row[3] = warehouse.getProduct(key).getLocation();
                        row[4] = warehouse.getProduct(key).getGroup();
                        row[5] = warehouse.getProduct(key).getQuantity();
                        row[6] = warehouse.getProduct(key).isSelfSell();
                        row[7] = warehouse.getProduct(key).getUnitPrice();
                        row[8] = warehouse.getProduct(key).getTotal();

                        tm.addRow(row);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
            return tm;
        }
    }
    
    public void dummyMethod (String num) {
        System.out.println("Dummy test show data controller" + num);
    }
}
