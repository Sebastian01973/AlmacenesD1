package views.body;

import utilities.Utilities;
import views.Constant;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class JTableElements extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jScrollPane;

	public JTableElements(ActionListener actionListener){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Constant.COLOR_WHITE);
		dtmElements = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}

		};
		dtmElements.setColumnIdentifiers(Constant.TITLE_HEADERS);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.setIntercellSpacing(new Dimension(0, 0));
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setBackground(Constant.COLOR_RED_LIGHT);
		jtElements.getTableHeader().setForeground(Constant.COLOR_WHITE);
		jtElements.getTableHeader().setPreferredSize(new Dimension(0, 50));
		jtElements.getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);
		jtElements.getTableHeader().setResizingAllowed(false);

		jtElements.setFont(Constant.FONT_ARIAL_ROUNDER_15);
		jtElements.setBackground(Constant.COLOR_WHITE);
		jtElements.setFillsViewportHeight(false);
		jtElements.setRowHeight( 35 );
		jtElements.setBorder(null);

		jScrollPane = new JScrollPane(jtElements);
		jScrollPane.setForeground(Color.white);
		jScrollPane.setBorder(null);
		jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jScrollPane, BorderLayout.PAGE_END);
		this.setBorder(null);
	}

	public int getSelectRow() {
		return jtElements.getSelectedRow();
	}

	public String getNameStore(){
		if (Utilities.isValidateTable(jtElements)){
			return String.valueOf(dtmElements.getValueAt(jtElements.getSelectedRow(),0));
		}else{
			return "";
		}
	}

	private void centerText() {
		DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
		centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < jtElements.getColumnCount(); i++) {
			jtElements.getColumnModel().getColumn(i).setCellRenderer(centeRenderer);
		}
	}
	
	public void addElementToTable(Object[] vector){
		dtmElements.addRow(vector);
	}
	
	public void cleanRowsTable() {
		dtmElements.setNumRows(0);
	}

	public void addElementToTable(ArrayList<Object[]> data) {
		cleanRowsTable();
		dtmElements.setColumnIdentifiers(Constant.TITLE_HEADERS);
		for (Object[] objects : data) {
			addElementToTable(objects);
		}
	}

	public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
		cleanRowsTable();
		dtmElements.setColumnIdentifiers(header);
		this.centerText();
		for (Object[] objects : matrix) {
			addElementToTable(objects);
		}
	}
	
}
