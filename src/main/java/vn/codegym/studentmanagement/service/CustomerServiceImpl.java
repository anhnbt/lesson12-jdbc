package vn.codegym.studentmanagement.service;

import vn.codegym.studentmanagement.dao.CustomerDAO;
import vn.codegym.studentmanagement.model.Customer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/29
 * Time: 14:34
 */
public class CustomerServiceImpl {
    private CustomerDAO customerDAO = new CustomerDAO();

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public Customer getCustomerById(Integer id) {
        return customerDAO.getCustomerById(id);
    }

    public boolean deleteCustomerById(Integer id) {
        return customerDAO.deleteById(id);
    }
}
