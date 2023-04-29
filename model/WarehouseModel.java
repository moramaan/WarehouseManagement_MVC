/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author moraman
 */
public class WarehouseModel implements Serializable {

    private String company;
    private ArrayList<TypeModel> typeList;
    private HashMap<Integer, ProductModel> productsList;

    public WarehouseModel() {
    }

    public WarehouseModel(String company) {
        this.company = company;
        this.typeList = new ArrayList<>();
        this.productsList = new HashMap<>();
    }

    public WarehouseModel(String company, String type1, String type2) {
        this.company = company;
        this.typeList = new ArrayList<>();
        this.productsList = new HashMap<>();
        
        TypeModel t1 = new TypeModel(type1);
        TypeModel t2 = new TypeModel(type2);
        addType(t1);
        addType(t2);
    }

    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<TypeModel> getTypeList() {
        return typeList;
    }

    public void setTypeList(ArrayList<TypeModel> TypeList) {
        this.typeList = TypeList;
    }

    public void addType(TypeModel t) {
        typeList.add(t);
    }

    public HashMap<Integer, ProductModel> getProductsList() {
        return productsList;
    }

    public void setProductsList(HashMap<Integer, ProductModel> productsList) {
        this.productsList = productsList;
    }

    public ProductModel getProduct(Integer key) {
        return productsList.get(key);
    }

    public boolean productExists(int code) {
        return this.productsList.containsKey(code);
    }

    public void addProduct(ProductModel p) {
        this.productsList.put(p.getId(), p);
    }

    public boolean deleteProduct(int productKey) {
        boolean removed = false;
        ProductModel p = productsList.remove(productKey);
        if (p != null) {
            removed = true;
        }

        return removed;
    }
}
