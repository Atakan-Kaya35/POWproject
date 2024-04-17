package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLTest {
    // Database connection details
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6698722";
    static final String USER = "sql6698722";
    static final String PASS = "uS5iWg7v1N";

    public static void main(String[] args) {
        // Örnek kullanım
        int id = 0;
        String newVarcharValue = coder(0, 0, "aaaggghhhh");

        // Metodu çağırarak varchar değerini güncelle
        boolean success = updateVarcharColumn(id, newVarcharValue);
        
        // Sonucu kontrol et
        if (success) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Data could not be updated.");
        }
    }

    // Varchar değeri güncelleyen metot
    public static boolean updateVarcharColumn(int id, String newVarcharValue) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query - Update the data
            String sql = "UPDATE nurse SET info = ? WHERE idNum = ?";
            stmt = conn.prepareStatement(sql);

            // Specify the new value and id number as parameters
            stmt.setString(1, newVarcharValue);
            stmt.setInt(2, id);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Return whether the update was successful
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException se) {
            // Handle JDBC errors and class loading errors
            se.printStackTrace();
            return false;
        } finally {
            // Close the connection and statement object
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static String coder(int x, int y, String ... vars){

        String answer = "";
        answer = answer + x + "$" + y + "$";
        for (String var : vars) {
            answer += var;
        }
        return answer;
    }
}
