/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import model.ProductModel;
import model.TypeModel;
import model.WarehouseModel;
import view.FormView;
import view.MainView;

/**
 *
 * @author moraman
 */
public class MainController {

    private boolean initLoadFile;
    private AddController addCtrl;
    private DataController dataCtrl;
    private UpdateController upCtrl;
    private DeleteController delCtrl;
    private WarehouseModel wh;
    private MainView mainView;
    private FormView formView;

    public MainController() {
        int option = JOptionPane.showOptionDialog(
                null,
                "Do you want to load a File?",
                "Load File Question",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Yes", "No"},
                "Yes");
        if (option == 0) {
            String fileToLoad;

            int whichFile = JOptionPane.showOptionDialog(
                    null,
                    "Do you want to load your File or the example one?",
                    "Choose File",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Example", "Mine"},
                    "Example");

            if (whichFile == 0) {
                fileToLoad = "example.obj";
            } else {
                fileToLoad = "userData.obj";
            }

            File f = new File("BD" + File.separator + fileToLoad);

            if (f.exists()) {
                uploadFile(f);
                initLoadFile = true;
            } else {
                showMessageDialog(null, "The BD doesn't exist");
                initLoadFile = false;
                this.wh = new WarehouseModel("PC PARTS Ltd.", "Hardware", "Peripherals");
                initComponents(initLoadFile);

            }
        } else {
            this.wh = new WarehouseModel("PC PARTS Ltd.", "Hardware", "Peripherals");
            initComponents(initLoadFile);
        }

    }

    public void initComponents(boolean initLoadDone) {
        this.mainView = new MainView(this, initLoadDone);
        this.addCtrl = new AddController(this);
        this.dataCtrl = new DataController(wh, mainView, initLoadDone);
        this.delCtrl = new DeleteController(mainView, dataCtrl);
        setMainViewControllers();
        mainView.setVisible(true);
    }

    public void uploadFile(File f) {

        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            wh = (WarehouseModel) ois.readObject();
            initComponents(true);

        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveFile(boolean initLoadDone) {
        String fileName;

        if (initLoadDone) {
            fileName = "example.obj";
        } else {
            fileName = "userData.obj";
        }

        try {
            File f = new File("BD" + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wh);
            oos.close();
            showMessageDialog(null, "Warehouse data saved correctly");

        } catch (IOException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void setMainViewControllers() {
        mainView.setDataCtrl(dataCtrl);
        mainView.setDelCtrl(delCtrl);
    }

    public void showAddView(boolean initLoadDone) {
        formView = new FormView(mainView, true, this, 1, initLoadDone);
        addCtrl.setWh(wh);
        formView.setAddCtrl(addCtrl);
        formView.setDataCtrl(dataCtrl);
        dataCtrl.setAddView(formView);
        dataCtrl.setFormComboItems(formView.getComboBox());
        formView.setVisible(true);

    }

    public void showUpdateView(String selectedCode, boolean initLoadDone) {
        formView = new FormView(mainView, true, this, 2, initLoadDone);
        upCtrl = new UpdateController(formView, selectedCode, wh, dataCtrl);
        formView.setUpCtrl(upCtrl);
        formView.setDataCtrl(dataCtrl);
        dataCtrl.setAddView(formView);
        dataCtrl.setFormComboItems(formView.getComboBox());
        upCtrl.loadFormData();
        formView.setVisible(true);
    }

    public void setDataCtrl() {
        addCtrl.setDataCtrl(dataCtrl);
    }

    public void setMainViewVisible() {
        dataCtrl.setNewMainViewTableModel();
        mainView.setVisible(true);
    }

    public WarehouseModel getWh() {
        return wh;
    }
}
