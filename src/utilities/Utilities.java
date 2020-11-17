package utilities;

import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilities {


    public static void getModelColumn(JTable jTable, int numCol, int minWidth, int maxWidth, int preferWidth) {
        TableColumn column;
        column = jTable.getColumnModel().getColumn(numCol);
        column.setPreferredWidth(preferWidth);
        column.setMaxWidth(maxWidth);
        column.setMinWidth(minWidth);
    }

    public static String toFormatNumber(int number) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern( "####,##" );
        String strValue = df.format(number);
        return strValue;
    }

    public static JLabel spaceLabel(Color bg, Color fg){
        JLabel space = new JModelLabel("<html>s<p>s<p>s<p><html>",bg,fg);
        return  space;
    }

    public static boolean isValidateTable(JTable jtElements) {
        if (jtElements.getColumnCount() == 4 && jtElements.getSelectedRow() != -1){
            return true;
        }else{
            return false;
        }
    }
}
