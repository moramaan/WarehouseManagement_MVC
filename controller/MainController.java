/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ProductModel;
import model.TypeModel;
import model.WarehouseModel;
import view.MainView;

/**
 *
 * @author moraman
 */
public class MainController {

    private AddController addCtrl;
    private ShowDataController showCtrl;
    private UpdateController upCtrl;
    private DeleteController delCtrl;
    private WarehouseModel wh;
    private MainView mainView;

    public MainController() {
        this.wh = initWarehouse();
        this.mainView = new MainView(this);
        this.addCtrl = new AddController();
        this.showCtrl = new ShowDataController(wh, mainView);
        this.upCtrl = new UpdateController();
        this.delCtrl = new DeleteController();
        setMainViewControllers();
        mainView.setVisible(true);
    }

    public WarehouseModel initWarehouse() {
        //IDEA = here we will ask for load file or not >> if yes, next part will be "only" loading file code | if not we only charge
        WarehouseModel warehouse = new WarehouseModel("PC PARTS Ltd.");
        TypeModel type1 = new TypeModel("Hardware");
        TypeModel type2 = new TypeModel("Peripherals");
        warehouse.addCategory(type1);
        warehouse.addCategory(type2);

        ProductModel p1 = new ProductModel(1, "Asus B550-F WI-FI", type1, "S1P2", "Top Seller", 354, true, 170.99);
        ProductModel p2 = new ProductModel(2, "AMD Ryzen 9 5900X", type1, "S1P3", "Top Seller", 78, true, 549.99);
        ProductModel p3 = new ProductModel(3, "MSI RTX 3080 Gaming X Trio", type1, "S2P1", "Top Seller", 32, true, 1099.99);
        ProductModel p4 = new ProductModel(4, "Logitech MX Master 3 Wireless Mouse", type2, "S3P1", "New Arrival", 185, true, 99.99);
        ProductModel p5 = new ProductModel(5, "Samsung CHG90 49-Inch Ultrawide Monitor", type2, "S2P2", "New Arrival", 23, true, 1499.99);
        ProductModel p6 = new ProductModel(6, "Corsair RM850x PSU", type1, "S1P1", "Top Seller", 134, true, 149.99);
        ProductModel p7 = new ProductModel(7, "Intel Core i7-11700K", type1, "S4P1", "Normal", 122, true, 399.99);
        ProductModel p8 = new ProductModel(8, "Gigabyte AORUS RTX 3080 XTREME", type1, "S2P1", "Top Seller", 22, true, 1299.99);
        ProductModel p9 = new ProductModel(9, "Razer DeathAdder V2 Pro Wireless Mouse", type2, "S3P1", "Normal", 67, true, 129.99);
        ProductModel p10 = new ProductModel(10, "Acer Predator X27 27-Inch Monitor", type2, "S2P2", "New Arrival", 45, true, 1999.99);
        ProductModel p11 = new ProductModel(11, "AMD Radeon RX 6600 XT", type1, "S2P2", "Top Seller", 89, true, 399.99);
        ProductModel p12 = new ProductModel(12, "Ducky One 2 Mini Mechanical Keyboard", type2, "S3P1", "Normal", 112, true, 99.99);
        ProductModel p13 = new ProductModel(13, "ASUS TUF Gaming VG249Q 24-Inch Monitor", type2, "S2P2", "Normal", 77, true, 249.99);
        ProductModel p14 = new ProductModel(14, "G.SKILL Ripjaws V 16GB DDR4 RAM", type1, "S1P2", "Top Seller", 278, true, 79.99);
        ProductModel p15 = new ProductModel(15, "Gigabyte B550 AORUS PRO", type1, "S1P2", "Top Seller", 167, true, 179.99);
        ProductModel p16 = new ProductModel(16, "HyperX Cloud II Wireless Gaming Headset", type2, "S3P3", "Normal", 43, true, 149.99);
        ProductModel p17 = new ProductModel(17, "Nvidia Founders RTX 3080", type1, "S3P2", "Top Seller", 52, true, 899.99);
        ProductModel p18 = new ProductModel(18, "Intel Core i9-11900K", type1, "S4P1", "New Arrival", 100, true, 539.99);
        ProductModel p19 = new ProductModel(19, "AMD Ryzen 9 7950X", type1, "S4P4", "Top Seller", 75, true, 649.99);
        ProductModel p20 = new ProductModel(20, "Samsung Odyssey G9 Monitor", type2, "S2P2", "New Arrival", 25, true, 1499.99);

        //test
        ProductModel p21 = new ProductModel(21, "HyperX Cloud II Wireless Gaming Headset", type2, "S3P3", "Normal", 43, true, 149.99);
        ProductModel p22 = new ProductModel(22, "Nvidia Founders RTX 3080", type1, "S3P2", "Top Seller", 52, true, 899.99);
        ProductModel p23 = new ProductModel(23, "Intel Core i9-11900K", type1, "S4P1", "New Arrival", 100, true, 539.99);
        ProductModel p24 = new ProductModel(24, "AMD Ryzen 9 7950X", type1, "S4P4", "Top Seller", 75, true, 649.99);
        ProductModel p25 = new ProductModel(25, "Samsung Odyssey G9 Monitor", type2, "S2P2", "New Arrival", 25, true, 1499.99);
        ProductModel p26 = new ProductModel(26, "HyperX Cloud II Wireless Gaming Headset", type2, "S3P3", "Normal", 43, true, 149.99);
        ProductModel p27 = new ProductModel(27, "Nvidia Founders RTX 3080", type1, "S3P2", "Top Seller", 52, true, 899.99);
        ProductModel p28 = new ProductModel(28, "Intel Core i9-11900K", type1, "S4P1", "New Arrival", 100, true, 539.99);
        ProductModel p29 = new ProductModel(29, "AMD Ryzen 9 7950X", type1, "S4P4", "Top Seller", 75, true, 649.99);
        ProductModel p30 = new ProductModel(30, "Samsung Odyssey G9 Monitor", type2, "S2P2", "New Arrival", 25, true, 1499.99);
        //test
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        warehouse.addProduct(p3);
        warehouse.addProduct(p4);
        warehouse.addProduct(p5);
        warehouse.addProduct(p6);
        warehouse.addProduct(p7);
        warehouse.addProduct(p8);
        warehouse.addProduct(p9);
        warehouse.addProduct(p10);
        warehouse.addProduct(p11);
        warehouse.addProduct(p12);
        warehouse.addProduct(p13);
        warehouse.addProduct(p14);
        warehouse.addProduct(p15);
        warehouse.addProduct(p16);
        warehouse.addProduct(p17);
        warehouse.addProduct(p18);
        warehouse.addProduct(p19);
        warehouse.addProduct(p20);
        warehouse.addProduct(p21);
        warehouse.addProduct(p22);
        warehouse.addProduct(p23);
        warehouse.addProduct(p24);
        warehouse.addProduct(p25);
        warehouse.addProduct(p26);
        warehouse.addProduct(p27);
        warehouse.addProduct(p28);
        warehouse.addProduct(p29);
        warehouse.addProduct(p30);

        return warehouse;
    }

    public void setMainViewControllers() {
        mainView.setShowCtrl(showCtrl);
        mainView.setAddCtrl(addCtrl);
        mainView.setUpCtrl(upCtrl);
        mainView.setDelCtrl(delCtrl);
    }

//    public AddController getAddCtrl() {
//        return addCtrl;
//    }
//
//    public ShowDataController getShowCtrl() {
//        return showCtrl;
//    }
//
//    public UpdateController getUpCtrl() {
//        return upCtrl;
//    }
//
//    public DeleteController getDelCtrl() {
//        return delCtrl;
//    }

    public WarehouseModel getWh() {
        return wh;
    }
}
