
package final_pro;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Price", "Quantity", "Amount"};
    private final ArrayList<product> productList;

    public ProductTableModel(ArrayList<product> productList) {
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
        product prod = productList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return prod.getName();
            case 1:
                return prod.getPrice();
            case 2:
                return prod.getQty();
            case 3:
                return prod.getAmount();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    public product getProductAt(int rowIndex) {
        return productList.get(rowIndex);
    }
}

