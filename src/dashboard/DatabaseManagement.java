
package dashboard;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManagement {
    private Connection conn;

    public void createConnection() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
            System.out.println("Connection Successful");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Product> fetchData() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT ID, NAME, QTY, PRICE FROM mytable";

        try (Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(query)) {

            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("NAME");
                int qty = result.getInt("QTY");
                double price = result.getDouble("PRICE");
                products.add(new Product(id, name, qty, price));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return products;
    }

    public double getTotalProductValue() {
        String query = "SELECT SUM(QTY * PRICE) AS total_value FROM mytable";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet result = ps.executeQuery()) {

            if (result.next()) {
                return result.getDouble("total_value");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0.0;
    }

    public int getProductCount() {
        String query = "SELECT COUNT(*) AS countPro FROM mytable";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet result = ps.executeQuery()) {

            if (result.next()) {
                return result.getInt("countPro");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public boolean deleteProduct(int id) {
        String query = "DELETE FROM mytable WHERE ID = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
