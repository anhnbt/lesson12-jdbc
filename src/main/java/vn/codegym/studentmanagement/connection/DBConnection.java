package vn.codegym.studentmanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/29
 * Time: 13:38
 */
public class DBConnection {

    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver => Cung cap driver cua CSDL tuong ung
            if (connection == null || connection.isClosed()) {
                // DriverManager: Thanh phan trong JDBC de dang ky quan ly cac driver
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "raisingthebar");
                System.out.println("Ket noi thanh cong");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
