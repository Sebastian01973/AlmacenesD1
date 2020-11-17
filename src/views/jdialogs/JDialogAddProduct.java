package views.jdialogs;

import controllers.Command;
import models.ManagerStore;
import models.Product;
import views.Constant;
import views.JMainWindows;
import views.models.JModelButton;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogAddProduct extends JDialog {

    private JSpinner jsUnit,jsValue;
    private JButton jBCreate,jBCancel;
    private JModelTextField jtfName,jtfCode;
    private JPanel jpContainer;

    public JDialogAddProduct(ActionListener actionListener, JMainWindows jMainWindows) {
        setModal(true);
        setTitle("Agregar un Producto");
        setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_FILE)).getImage());
        setSize(new Dimension(350, 550));
        getContentPane().setBackground(Constant.COLOR_WHITE);
        setLocationRelativeTo(jMainWindows);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jpContainer = new JPanel();
        jpContainer.setBackground(Constant.COLOR_WHITE);
        GridLayout grid = new GridLayout(6, 1);
        jpContainer.setBorder(new EmptyBorder(25, 25, 0, 25));
        grid.setVgap(15);
        jpContainer.setLayout(grid);

        jtfName = new JModelTextField("Nombre del producto", "Ingrese el nombre", Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jpContainer.add( jtfName );

        jtfCode = new JModelTextField("Nombre del codigo", "Ingrese el codigo", Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jpContainer.add( jtfCode );

        jsUnit = new JSpinner(new SpinnerNumberModel(3, 0, Integer.MAX_VALUE, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor) jsUnit.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsUnit.setBorder(BorderFactory.createTitledBorder("Unidades"));
        jsUnit.setBackground(Constant.COLOR_WHITE);
        jpContainer.add(jsUnit);

        jsValue = new JSpinner(new SpinnerNumberModel(1000, 10, Integer.MAX_VALUE, 100));
        ((DefaultFormatter) ((JSpinner.NumberEditor)jsValue.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsValue.setBorder(BorderFactory.createTitledBorder("Valor:"));
        jsValue.setBackground(Constant.COLOR_WHITE);
        jpContainer.add(jsValue);

        jBCreate = new JModelButton(15, 15,"Crear", Constant.COLOR_BLUE_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.CREATE_PRODUCT.toString(), actionListener );
        jpContainer.add(jBCreate);
        jBCancel = new JModelButton( 15, 15,"Cancelar", Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.CANCEL_PRODUCT.toString(), actionListener );
        jpContainer.add( jBCancel );
        this.add( jpContainer );
    }public void showDialog() {
        jtfName.setText("");
        jtfCode.setText("");
    }



    public boolean isValidateDatas(String JTFName, String JTFNit, int unit) {
        if (JTFName.isEmpty() || JTFNit.isEmpty() || unit == 0) {
            return true;
        }else {
            return false;
        }
    }

    public Product createProduct(ManagerStore managerStore,String nameStore){
        if (!isValidateDatas(jtfName.getText(),jtfCode.getText(),(int)jsUnit.getValue())){
            this.setVisible(false);
            return managerStore.getStore(nameStore).createProduct(jtfName.getText(),
                    jtfCode.getText(),(int) jsUnit.getValue(),Double.parseDouble(String.valueOf(jsValue.getValue())));
        }else{
            return null;
        }
    }
}
