package views.body;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.models.JModelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainToolBar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JModelButton jbadd,jbSetItem,jbSearch, jbdelete, jbmodifity, jbUpdate ;
	
	public JMainToolBar(ActionListener actionListener) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(50, 3,5, 10));
		setBackground(Constant.COLOR_LIGHT_GREEN);
		setFloatable(false);
		initComponents(actionListener);
		this.setVisible(false);
	}

	private void initComponents(ActionListener actionListener) {
		jbadd = new JModelButton(Constant.IMG_ADD_PRODUCT,25,25);
		jbadd.setActionCommand(Command.ADD_PRODUCT.toString());
		jbadd.addActionListener(actionListener);
		this.add(jbadd);

		this.add(Utilities.spaceLabel(Constant.COLOR_LIGHT_GREEN,Constant.COLOR_LIGHT_GREEN));

		jbSetItem = new JModelButton(Constant.IMG_BUY_PRODUCT, 25,25);
		jbSetItem.setActionCommand(Command.SET_PRODUCT.toString());
		jbSetItem.addActionListener(actionListener);
		this.add(jbSetItem);
		this.add(Utilities.spaceLabel(Constant.COLOR_LIGHT_GREEN,Constant.COLOR_LIGHT_GREEN));

		jbSearch = new JModelButton(Constant.IMG_SEARCH, 25,25);
		jbSearch.setActionCommand(Command.SEARCH_PRODUCT.toString());
		jbSearch.addActionListener(actionListener);
		this.add(jbSearch);
		this.add(Utilities.spaceLabel(Constant.COLOR_LIGHT_GREEN,Constant.COLOR_LIGHT_GREEN));
		
		jbdelete = new JModelButton(Constant.IMG_DELETE,25,25);
		jbdelete.setActionCommand(Command.DELETE_PRODUCT.toString());
		jbdelete.addActionListener(actionListener);
		this.add(jbdelete);
		this.add(Utilities.spaceLabel(Constant.COLOR_LIGHT_GREEN,Constant.COLOR_LIGHT_GREEN));
		
		jbmodifity = new JModelButton(Constant.IMG_WRITE,25,25);
		jbmodifity.setActionCommand(Command.MODIFY_PRODUCT.toString());
		jbmodifity.addActionListener(actionListener);
		this.add(jbmodifity);
		this.add(Utilities.spaceLabel(Constant.COLOR_LIGHT_GREEN,Constant.COLOR_LIGHT_GREEN));
		
		jbUpdate = new JModelButton(Constant.IMG_UPDATE,25,25);
		jbUpdate.setActionCommand(Command.UPDATE_PRODUCT.toString());
		jbUpdate.addActionListener(actionListener);
		this.add(jbUpdate);

	}

	public void setVisibleEast(boolean validate){
		this.setVisible(validate);
	}
}
