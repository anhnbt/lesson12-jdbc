package vn.codegym.studentmanagement.dao;

import vn.codegym.studentmanagement.connection.DBConnection;
import vn.codegym.studentmanagement.model.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/29
 * Time: 13:43
 */
public class CustomerDAO {
    public static final String SQL_SELECT_ALL = "SELECT * FROM customers";
    DBConnection dbConnection = new DBConnection();

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        // Cac thanh phan trong JDBC
        Connection connection = null; // (1) Connection => Tao ra ket noi toi CSDL
        Statement stmt = null; // (2) Statement => Dung de thuc thi query sql
        ResultSet rs = null; // (3) ResultSet => Tap hop du lieu
        try {
            connection = dbConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customers;
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = null;
        Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            con = dbConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM customers WHERE customerNumber = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pStmt != null) {
                try {
                    pStmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customer;
    }

    public boolean deleteById(Integer id) {
        Connection con = null;
        PreparedStatement pStmt = null;
        int number = 0;
        try {
            con = dbConnection.getConnection();
            pStmt = con.prepareStatement("DELETE FROM customers WHERE customerNumber = ?");
            pStmt.setInt(1, id);
            number = pStmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Khong duoc phep xoa khach hang da mua san pham");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pStmt != null) {
                try {
                    pStmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return number > 0;
    }
}
