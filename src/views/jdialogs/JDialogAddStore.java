package views.jdialogs;

import controllers.Command;
import models.ManagerStore;
import models.Store;
import views.Constant;
import views.JMainWindows;
import views.models.JModelButton;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogAddStore extends JDialog {

    private JButton jBCreate,jBCancel;
    private JModelTextField jTFNameStore,jTFAddress;
    private JPanel jpContainer;


    public JDialogAddStore(ActionListener actionListener, JMainWindows jMainWindows) {
        setModal(true);
        setTitle("Agregar una Tienda");
        setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_FILE)).getImage());
        setSize(new Dimension(350, 500));
        getContentPane().setBackground(Constant.COLOR_WHITE);
        setLocationRelativeTo(jMainWindows);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jpContainer = new JPanel();
        jpContainer.setBackground(Constant.COLOR_WHITE);
        GridLayout grid = new GridLayout(4, 1);
        jpContainer.setBorder(new EmptyBorder(25, 25, 0, 25));
        grid.setVgap(15);
        jpContainer.setLayout(grid);

        jTFNameStore = new JModelTextField("Nombre de la Tienda", "Ingrese el nombre", Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jpContainer.add( jTFNameStore );

        jTFAddress = new JModelTextField("Direccion de la tienda", "Ingrese la direccion", Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jpContainer.add( jTFAddress );

        jBCreate = new JModelButton(15, 15,"Crear", Constant.COLOR_BLUE_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.CREATE_STORE.toString(), actionListener );
        jpContainer.add(jBCreate);
        jBCancel = new JModelButton( 15, 15,"Cancelar", Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.CANCEL_STORE.toString(), actionListener );
        jpContainer.add( jBCancel );
        this.add( jpContainer );

    }

    public void showDialogStore() {
        jTFNameStore.setText("");
        jTFAddress.setText("");
    }

    public boolean isValidateDatas(String JTFName, String JTFNit) {
        if (JTFName.isEmpty() || JTFNit.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public Store createStore(ManagerStore managerStore){
        if(!isValidateDatas(jTFNameStore.getText(),jTFAddress.getText())){
            return new Store(jTFNameStore.getText(),jTFAddress.getText());
        }else{
            JOptionPane.showMessageDialog(null, "Debes Selecionar todos los Espacios");
            return null;
        }
    }
}
