/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel {
    private final ArrayList<Product> productList;
    private final String[] columnNames = {"ID", "NAME", "QTY", "PRICE"};

    public MyTableModel(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);
        switch (columnIndex) {
            case 0: return product.getId();
            case 1: return product.getName();
            case 2: return product.getQty();
            case 3: return product.getPrice();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Product getProductAt(int rowIndex) {
        return productList.get(rowIndex);
    }
    
    
   
}
