package views;

import views.body.JContainerCenter;
import views.body.JMainToolBar;
import views.body.JTableElements;
import views.footer.JContainerFooter;
import views.heater.JContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JContainerHeader jcontainerHeader;
	private JContainerFooter jcontainerFooter; 
	private JContainerCenter jContainerCenter;
	
	public JMainPanel(ActionListener actionListener) {
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Constant.COLOR_WHITE);
		initComponents( actionListener);
	}

	public String getNameStore(){
		return jContainerCenter.getNameStore();
	}

	private void initComponents(ActionListener actionListener) {

		jcontainerHeader = new JContainerHeader(actionListener);
		this.add(jcontainerHeader,BorderLayout.NORTH);

		jContainerCenter = new JContainerCenter(actionListener);
		this.add(jContainerCenter,BorderLayout.CENTER);
		
		jcontainerFooter = new JContainerFooter(actionListener);
		this.add(jcontainerFooter,BorderLayout.SOUTH);
		
	}

	public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
		jContainerCenter.addElementToTable(matrix,header);
	}
	
	public void addElementToTable(ArrayList<Object[]> data) {
		jContainerCenter.addElementToTable(data);
	}

	public void addElementToTable(Object[] vector) {
		jContainerCenter.addElementToTable(vector);
	}

	public void setVisibleEast(boolean validate){
		jContainerCenter.setVisibleEast(validate);
	}
}
