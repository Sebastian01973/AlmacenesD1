package views;

import models.ManagerStore;
import models.Product;
import models.Store;
import views.jdialogs.JDialogAddProduct;
import views.jdialogs.JDialogAddStore;
import views.jdialogs.JDialogSetUnit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainWindows extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMainPanel jMainPanel;
	JDialogAddProduct addProduct;
	JDialogAddStore addStore;
	JDialogSetUnit jDialogSetUnit;
	
	public JMainWindows(ActionListener actionListener) {

		this.setTitle(Constant.TITTLE_APP);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_APP)).getImage());
		this.addProduct = new JDialogAddProduct(actionListener, this);
		this.addStore = new JDialogAddStore(actionListener,this);
		this.jDialogSetUnit = new JDialogSetUnit(actionListener,this);
		initComponents(actionListener);
		this.setVisible(true);
	}
	private void initComponents(ActionListener actionListener) {
		jMainPanel = new JMainPanel(actionListener);
		this.getContentPane().add(jMainPanel,BorderLayout.CENTER);
	}

	public String getNameProduct(){
		return jDialogSetUnit.getNameProduct();
	}

	public int getUnitValue(){
		return jDialogSetUnit.getSetUnit();
	}

	public String getNameStore(){
		return jMainPanel.getNameStore();
	}

	public Product createProduct(ManagerStore managerStore, String nameStore) {
		return addProduct.createProduct(managerStore,nameStore);
	}

	public Store createStore(ManagerStore managerStore){
		return addStore.createStore(managerStore);
	}

	public void showDialogCreateStore() {
		addStore.setVisible(true);
		addStore.showDialogStore();
	}

	public void showDialogUnit(){
		jDialogSetUnit.setVisible(true);
		jDialogSetUnit.showDialogUnit();
	}

	public void showDialogCreateProduct() {
		addProduct.setVisible(true);
		addProduct.showDialog();
	}

	public void makeInvisibleDialogAddProduct() {
		addProduct.setVisible(false);
	}

	public void makeInvisibleDialogSetUnit() {
		jDialogSetUnit.setVisible(false);
	}

	public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
		jMainPanel.addElementToTable(matrix,header);
	}

	public void setVisibleEast(boolean validate){
		jMainPanel.setVisibleEast(validate);
	}

	public void addElementToTable(ArrayList<Object[]> data) {
		jMainPanel.addElementToTable(data);
	}

	public void addElementToTable(Object[] vector) {
		jMainPanel.addElementToTable(vector);
	}

	public void makeInvisibleDialogAddStore() {
		addStore.setVisible(false);
	}
}
