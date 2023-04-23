/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author moraman
 */
public class WarehouseModel {

    private String company;
    private ArrayList<TypeModel> categoryList;
    private HashMap<Integer, ProductModel> productsList;

    public WarehouseModel() {
    }

    public WarehouseModel(String company) {
        this.company = company;
        this.categoryList = new ArrayList<>();
        this.productsList = new HashMap<>();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<TypeModel> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<TypeModel> categoryList) {
        this.categoryList = categoryList;
    }

    public void addCategory(TypeModel t) {
        categoryList.add(t);
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
    
    public void addProduct (ProductModel p) {
        this.productsList.put(p.getId(), p);
    }
}
