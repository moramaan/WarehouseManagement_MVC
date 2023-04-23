/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author moraman
 */
public class ProductModel implements Serializable {

    private int id;
    private String name;
    private TypeModel type;
    private String location;
    private String group;
    private int quantity;
    private boolean selfSell;
    private double unitPrice;
    private double total;

    public ProductModel() {
    }

    public ProductModel(int id, String name, TypeModel type, String location, String group, int quantity, boolean selfSell, double unitPrice) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.group = group;
        this.quantity = quantity;
        this.selfSell = selfSell;
        this.unitPrice = unitPrice;
        this.total = CALC_TOTAL(unitPrice, quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSelfSell() {
        return selfSell;
    }

    public void setSelfSell(boolean selfSell) {
        this.selfSell = selfSell;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public final double CALC_TOTAL(double unitPrice, int quantity) {
        double result = unitPrice * quantity;
        DecimalFormat df = new DecimalFormat("#.##");
        result = Double.parseDouble(df.format(result).replace(",", "."));
        
        return result;
    }
}
