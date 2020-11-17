package controllers;

import models.ManagerStore;
import models.Product;
import models.Store;
import views.Constant;
import views.JMainWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements ActionListener {


    private JMainWindows jMainWindows;
    private ManagerStore managerStore;
    private String store;


    public Controller(){
        jMainWindows = new JMainWindows(this);
        managerStore = new ManagerStore();
        store = "";
        refreshData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case HOME_STORE: refreshData(); break;
            case EXIT: exitApp(); break;
            case CREATE_PRODUCT: this.createProduct(); break;
            case ADD_PRODUCT: this.showDialog(); break;
            case ADD_STORE: this.showDialogStore(); break;
            case CREATE_STORE: this.createStore(); break;
            case CANCEL_PRODUCT: jMainWindows.makeInvisibleDialogAddProduct(); break;
            case CANCEL_STORE: jMainWindows.makeInvisibleDialogAddStore(); break;
            case OPEN_STORE: this.openTableStore(); break;
            case SET_UNIT: this.setProduct(); break;
            case SEARCH_PRODUCT:this.searchProduct(); break;
            case CANCEL_UNIT: jMainWindows.makeInvisibleDialogSetUnit(); break;
            case SET_PRODUCT: this.showDialogUnit(); break;
            case UPDATE_PRODUCT: this.refreshDataProduct(); break;
            default:
                break;
        }
    }

    private void searchProduct() {
        String code = JOptionPane.showInputDialog("Por favor digite el codigo del producto");
        if (managerStore.getStore(store).isValidateCode(code)){
            Product product = managerStore.getStore(store).getProduct(code);
            jMainWindows.addElementToTable(product.toObjectVector());
        }else{
            JOptionPane.showMessageDialog(null,"Ese codigo no existe.");
        }
    }

    private void setProduct() {
        int value = jMainWindows.getUnitValue();
        String code = jMainWindows.getNameProduct();
        if (managerStore.getStore(store).isValidateCode(code) && value > 0){
            managerStore.getStore(store).refreshAmount(code,value);
            refreshDataProduct();
            jMainWindows.makeInvisibleDialogSetUnit();
        }else{
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
            showDialogUnit();
        }
    }

    private void showDialogUnit(){
        jMainWindows.showDialogUnit();
    }

    private void showDialogStore() {
        jMainWindows.showDialogCreateStore();
    }

    private void createStore() {
        Store store = jMainWindows.createStore(managerStore);
        if (store != null){
            managerStore.addStore(store);
            jMainWindows.addElementToTable(store.toObjectVectorStore());
            jMainWindows.makeInvisibleDialogAddStore();
        }else{
           showDialogStore();
        }
    }

    private void openTableStore() {
        if (!jMainWindows.getNameStore().isEmpty()){
            store = jMainWindows.getNameStore();
            jMainWindows.addElementToTable(managerStore.getMatrixData(store),Constant.TITTLE_PRODUCTS);
            jMainWindows.setVisibleEast(true);
        }else{
            showMessageDialog(null, "No has seleccionado ninguna tienda");
            refreshData();
        }
    }

    private void showDialog() {
        jMainWindows.showDialogCreateProduct();
    }



    private void createProduct() {
            Product auxProduct = jMainWindows.createProduct(managerStore,store);
            if (auxProduct != null){
               managerStore.getStore(store).addProduct(auxProduct);
               jMainWindows.addElementToTable(auxProduct.toObjectVector());
               refreshDataProduct();
            }else{
                showMessageDialog(null, "Hay datos Vacios por favor llenarlos todos");
                showDialog();
            }
    }



    private void refreshDataProduct() {
        jMainWindows.addElementToTable(managerStore.getMatrixData(store),Constant.TITTLE_PRODUCTS);
        jMainWindows.setVisibleEast(true);
    }

    private void refreshData() {
		jMainWindows.addElementToTable(managerStore.getMatrizStore());
        jMainWindows.setVisibleEast(false);
    }

    private void exitApp() {
        int option = JOptionPane.showConfirmDialog(null, "Deseas salir");
        if (option == 0) {
            System.exit(0);
        }
    }

}
