/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer { // Custom Table Cell
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        // Default rendering
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Example: Highlight rows where quantity (column 2) is less than 10
        int qtyColumn = 2; // Assuming "QTY" is the 3rd column
        int qty = (int) table.getValueAt(row, qtyColumn);

        if (!isSelected) { // Do not override the selection color
            if (qty < 10) {
                cell.setBackground(Color.PINK); // Highlight in pink
            } else {
                cell.setBackground(Color.WHITE); // Default background
            }
        }
        return cell;
    }
}