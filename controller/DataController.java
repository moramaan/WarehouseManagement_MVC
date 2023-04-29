/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.ProductModel;
import model.TypeModel;
import model.WarehouseModel;
import view.FormView;
import view.MainView;

/**
 *
 * @author moraman
 */
public class DataController {

    private WarehouseModel warehouse;
    private MainView mainView;
    private FormView addView;

    public DataController() {
    }

    public DataController(WarehouseModel warehouse, MainView mainView, boolean initLoadDone) {
        this.warehouse = warehouse;
        this.mainView = mainView;
        this.mainView.setData(true, false, getWarehouseDataTable(initLoadDone),
                this.warehouse.getTypeList().get(0).getName(),
                this.warehouse.getTypeList().get(1).getName());
        this.mainView.setPreferredOptions();
    }

    public void setAddView(FormView addView) {
        this.addView = addView;
    }

    public TableModel getWarehouseDataTable(boolean initLoadDone) {

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

        if (initLoadDone) {

            for (Integer key : orderedProducts) {
                Object[] row = new Object[9];

                row[0] = warehouse.getProduct(key).getId();
                row[1] = warehouse.getProduct(key).getName();
                row[2] = warehouse.getProduct(key).getType().getName();
                row[3] = warehouse.getProduct(key).getLocation();
                row[4] = warehouse.getProduct(key).getGroup();
                row[5] = warehouse.getProduct(key).getQuantity();
                row[6] = warehouse.getProduct(key).isSelfSell();
                row[7] = warehouse.getProduct(key).getUnitPrice();
                row[8] = warehouse.getProduct(key).getTotal();

                // Se añade al modelo la fila completa.     
                tm.addRow(row);
            }
        }
        return tm;
    }

    public TableModel getWarehouseDataTableFiltered(String comboFilter) {
        if (comboFilter == null || comboFilter.isEmpty()) {
            return getWarehouseDataTable(true);
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
                    category = warehouse.getProduct(key).getType().getName();
//                System.out.println(category);
                    if (category.equalsIgnoreCase(comboFilter)) {
                        Object[] row = new Object[9];

                        row[0] = warehouse.getProduct(key).getId();
                        row[1] = warehouse.getProduct(key).getName();
                        row[2] = warehouse.getProduct(key).getType().getName();
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

    public void setNewMainViewTableModel() {
        mainView.getDataTable().setModel(getWarehouseDataTable(true));
        mainView.setPreferredOptions();
    }

    /**
     * Method to chech if userCode is valid or not.
     *
     * @param code item/productCode from the form textField.
     * @return int 0 to 2. 0 code is valid | 1 is not an Integer | 2 repeated
     * code, exists in warehouse products list.
     */
    public int checkCode(String code) {
        boolean validCode;
        int result = 0;

        validCode = isInteger(code);
        if (!validCode) {
            result = 1;
        } else {
            validCode = warehouse.productExists(Integer.parseInt(code));
            if (validCode) {
                result = 2;
            }
        }

        return result;
    }

    /**
     * This method does the validation of a given text length.
     *
     * @param txt given text to check.
     * @param max maximum length permitted.
     * @param min minimum length allowed.
     * @return 0 accepted, 1 > too small, 2 > too big.
     */
    public int checkLength(String txt, int max, int min) {
        boolean valid;
        int result = 0;
        valid = txt.length() >= min;
        if (!valid) {
            result = 1;
        } else {
            valid = txt.length() <= max;
            if (!valid) {
                result = 2;
            }
        }
        return result;
    }

    /**
     * Method to check if a given String is an Integer.
     *
     * @param txt String to check.
     * @return true if It is Integer.
     */
    public boolean isInteger(String txt) {
        boolean isInt = true;
        try {
            int parsed = Integer.parseInt(txt);
        } catch (Exception e) {
            isInt = false;
        }

        return isInt;
    }

    /**
     * Method to check if a given String is an Integer and also if is between
     * the setted bounds.
     *
     * @param txt value to be checked
     * @param min lowerBound
     * @param max upperBound
     * @return
     */
    public int isInteger(String txt, int min, int max) {
        boolean valid = true;
        int result, parsed;
        result = parsed = 0;
        try {
            parsed = Integer.parseInt(txt);
        } catch (Exception e) {
            valid = false;
            result = 1;
        }
        if (valid) {
            valid = parsed >= min;
            if (!valid) {
                result = 2; // too small
            } else {
                valid = parsed <= max;
                if (!valid) {
                    result = 3; // too big
                }
            }
        }
        return result;
    }

    public int isDouble(String txt, double min, double max) {
        boolean valid = true;
        int result = 0;
        double parsed = 0;
        try {
            parsed = Double.parseDouble(txt);
        } catch (Exception e) {
            valid = false;
            result = 1; // is not a double
        }
        if (valid) {
            valid = parsed >= min;
            if (!valid) {
                result = 2; // too small
            } else {
                valid = parsed <= max;
                if (!valid) {
                    result = 3; // too big
                }
            }
        }
        return result;
    }

    public void setFormComboItems(JComboBox cb) {
        for (TypeModel tm : warehouse.getTypeList()) {
            cb.addItem(tm.getName());
        }
    }

    public ProductModel craftNewProductModel() {
        TypeModel tm = null;
        ProductModel pm = null;
        boolean selfSell = false;
        double price = 0;
        ArrayList<Object> addViewDataList = addView.getFormViewData();
        String name, type, location, category;
        int code, qty;

        name = type = location = category = "";
        code = qty = 0;

        try {
            for (Object o : addViewDataList) {
                switch (addViewDataList.indexOf(o)) {
                    case 0:
                        code = Integer.parseInt(o.toString());
                        break;
                    case 1:
                        name = o.toString();
                        break;
                    case 2:
                        type = o.toString();
                        break;
                    case 3:
                        location = o.toString();
                        break;
                    case 4:
                        category = o.toString();
                        break;
                    case 5:
                        qty = Integer.parseInt(o.toString());
                        break;
                    case 6:
                        selfSell = Boolean.parseBoolean(o.toString());
                        break;
                    default:
                        price = Double.parseDouble(o.toString());

                }
            }
            tm = new TypeModel(type);
            pm = new ProductModel(code, name, tm, location, category, qty, selfSell, price);
        } catch (Exception e) {
            System.out.println("craftModel Method" + e.getMessage());
            e.printStackTrace();
        }

        return pm;
    }

    public boolean deleteProduct(int productId) {
        return warehouse.deleteProduct(productId);
    }
}
