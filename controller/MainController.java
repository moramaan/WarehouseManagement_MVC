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
import model.WarehouseModel;
import view.FormView;
import view.MainView;

/**
 *
 * @author moraman
 */
public class MainController {

    private boolean initLoadFile;
    private String fileName;
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
                this.fileName = "example.obj";
            } else {
                this.fileName = "userData.obj";
            }

            File f = new File("BD" + File.separator + this.fileName);

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
            this.fileName = "userData.obj";
            initComponents(initLoadFile);
        }

    }

    /**
     * This method sets the different variables, instances and so on of the Main
     * Controller. It is called within Main Controller constructor.
     *
     * @param initLoadDone Flag to know if user loaded file or not.
     */
    public void initComponents(boolean initLoadDone) {
        this.mainView = new MainView(this);
        this.addCtrl = new AddController(this);
        this.dataCtrl = new DataController(wh, mainView, initLoadDone);
        this.delCtrl = new DeleteController(dataCtrl);
        mainView.setDelCtrl(delCtrl);
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

    public void saveFile() {
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

    /**
     * This method creates a new form view instance, as an Add item form, and
     * set its own variables and necessary related ones.
     */
    public void showAddView() {
        formView = new FormView(mainView, true, this, 1);
        formView.setAddCtrl(addCtrl);
        formView.setDataCtrl(dataCtrl);
        dataCtrl.setAddView(formView);
        dataCtrl.setFormComboItems(formView.getComboBox());
        addCtrl.setDataCtrl(dataCtrl);
        formView.setVisible(true);

    }

    /**
     * This method creates a new form view instance, as an Update item form, and
     * set its own variables and necessary related ones.
     *
     * @param selectedCode the code of the element to update provided by Main
     * View.
     */
    public void showUpdateView(String selectedCode) {
        formView = new FormView(mainView, true, this, 2);
        upCtrl = new UpdateController(formView, selectedCode, wh, dataCtrl);
        formView.setUpCtrl(upCtrl);
        formView.setDataCtrl(dataCtrl);
        dataCtrl.setAddView(formView);
        dataCtrl.setFormComboItems(formView.getComboBox());
        upCtrl.loadFormData();
        formView.setVisible(true);
    }

    public void setMainViewVisible() {
        dataCtrl.setNewMainViewTableModel();
        mainView.setVisible(true);
    }
}
