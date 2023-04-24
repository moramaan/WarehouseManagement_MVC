/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import javax.swing.*;
import model.TypeModel;
import model.WarehouseModel;
import view.AddView;

/**
 *
 * @author moraman
 */
public class AddController {

    private AddView addView;
    private MainController mainCtrl;
    private WarehouseModel wh;


    public AddController(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
        
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
     * Reset all fields of the Add View to our default values.
     */
    public void resetFields() {
        Component[] components = addView.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText("");
            } else if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                checkBox.setSelected(false);
            } else if (component instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) component;
                comboBox.setSelectedIndex(0);
            }
        }
        addView.getBtnGroup().clearSelection();
    }

}
