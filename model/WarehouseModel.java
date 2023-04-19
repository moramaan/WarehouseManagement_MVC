/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author moraman
 */
public class WarehouseModel {

    private String company;
    private ArrayList<TypeModel> categoryList;
    private TreeMap<Integer, ProductModel> productsList;

    public WarehouseModel() {
    }

    public WarehouseModel(String company, ArrayList<TypeModel> categoryList, TreeMap<Integer, ProductModel> productsList) {
        this.company = company;
        this.categoryList = categoryList;
        this.productsList = productsList;
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

    public TreeMap<Integer, ProductModel> getProductsList() {
        return productsList;
    }

    public void setProductsList(TreeMap<Integer, ProductModel> productsList) {
        this.productsList = productsList;
    }

}
