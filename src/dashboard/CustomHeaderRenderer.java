
package dashboard;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer; // calls for create header table
public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public CustomHeaderRenderer() {
        setHorizontalAlignment(CENTER); // Center-align header text
        setFont(new Font("Arial", Font.BOLD, 16)); // Bold font
        setBackground(Color.DARK_GRAY); // Dark gray background
        setForeground(Color.WHITE); // White text
    }
}
