package views.jdialogs;

import controllers.Command;
import views.Constant;
import views.JMainWindows;
import views.models.JModelButton;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogSetUnit extends JDialog {

    private JButton jBCreate,jBCancel;
    private JModelTextField jtFNameProduct;
    private JSpinner jsUnit;
    private JPanel jpContainer;


    public JDialogSetUnit(ActionListener actionListener, JMainWindows jMainWindows) {
        setModal(true);
        setTitle("Settear Un producto");
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

        jtFNameProduct = new JModelTextField("Nombre de la Tienda", "Ingrese el nombre", Constant.FONT_ARIAL_ROUNDER_15, Constant.COLOR_WHITE);
        jpContainer.add(jtFNameProduct);


        jsUnit = new JSpinner(new SpinnerNumberModel(3, 0, Integer.MAX_VALUE, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor) jsUnit.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsUnit.setBorder(BorderFactory.createTitledBorder("Unidades"));
        jsUnit.setBackground(Constant.COLOR_WHITE);
        jpContainer.add(jsUnit);

        jBCreate = new JModelButton(15, 15,"Vender", Constant.COLOR_BLUE_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.SET_UNIT.toString(), actionListener );
        jpContainer.add(jBCreate);

        jBCancel = new JModelButton( 15, 15,"Cancelar", Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_COMPONENTS_DIALOG_COST, Command.CANCEL_UNIT.toString(), actionListener );
        jpContainer.add( jBCancel );
        this.add( jpContainer );

    }

    public void showDialogUnit() {
        jtFNameProduct.setText("");
    }

    public boolean isValidateDatas(String JTFName, int value) {
        if (JTFName.isEmpty() || value <= 0) {
            return true;
        }else {
            return false;
        }
    }

    public String getNameProduct(){
        return jtFNameProduct.getText();
    }

    public int getSetUnit(){
        return (!isValidateDatas(jtFNameProduct.getText(),(int)jsUnit.getValue())) ? (int)jsUnit.getValue():-1;
    }

}
