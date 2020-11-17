package views.body;

import views.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JContainerCenter extends JPanel {

    private JTableElements jTableElements;
    private JMainToolBar jMainToolBar;

    public JContainerCenter(ActionListener actionListener) {
        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jTableElements = new JTableElements(actionListener);
        this.add(jTableElements, BorderLayout.CENTER);

        jMainToolBar = new JMainToolBar(actionListener);
        this.add(jMainToolBar, BorderLayout.EAST);

    }

    public String getNameStore() {
        return jTableElements.getNameStore();
    }

    public void addElementToTable(ArrayList<Object[]> data) {
        jTableElements.addElementToTable(data);
    }

    public void addElementToTable(Object[] vector) {
        jTableElements.addElementToTable(vector);
    }

    public void addElementToTable(ArrayList<Object[]> matrix, String[] header) {
        jTableElements.addElementToTable(matrix, header);
    }

    public void setVisibleEast(boolean validate){
        jMainToolBar.setVisibleEast(validate);
    }
}
