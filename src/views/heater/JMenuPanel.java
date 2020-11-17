package views.heater;

import controllers.Command;
import views.Constant;
import views.models.JModelMenu;
import views.models.JModelMenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMenuPanel extends JMenuBar{


	private JModelMenuItem jmHome,jmAddStore,jmOpenStore,jmUpdateStore,jmExit;

	public JMenuPanel(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setBackground(Constant.COLOR_WHITE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {

		jmHome = new JModelMenuItem("Inicio",Constant.IMG_HOME,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		jmHome.setActionCommand(Command.HOME_STORE.toString());
		jmHome.addActionListener(actionListener);
		this.add(jmHome);

		jmAddStore = new JModelMenuItem("Agregar Tienda",Constant.IMG_FILE,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		jmAddStore.setActionCommand(Command.ADD_STORE.toString());
		jmAddStore.addActionListener(actionListener);
		this.add(jmAddStore);

		jmOpenStore = new JModelMenuItem("Abrir Tienda",Constant.IMG_ADD_STORE,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		jmOpenStore.setActionCommand(Command.OPEN_STORE.toString());
		jmOpenStore.addActionListener(actionListener);
		this.add(jmOpenStore);

//		jmUpdateStore = new JModelMenuItem("Actualizar",Constant.IMG_UPDATE,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
//		jmUpdateStore.setActionCommand(Command.UPDATE_STORE.toString());
//		jmUpdateStore.addActionListener(actionListener);
//		this.add(jmUpdateStore);

		jmExit = new JModelMenuItem("Salir",Constant.IMG_EXIT,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		jmExit.setActionCommand(Command.EXIT.toString());
		jmExit.addActionListener(actionListener);
		this.add(jmExit);
	}

}
