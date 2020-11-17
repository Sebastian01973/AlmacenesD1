package views.heater;

import views.body.JMainToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerHeader extends JPanel{

	private JMenuPanel jMenuPanel;
	
	public JContainerHeader(ActionListener actionListener) {
		this.setLayout(new BorderLayout(0,0));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		
		jMenuPanel = new JMenuPanel(actionListener);
		this.add(jMenuPanel,BorderLayout.NORTH);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
