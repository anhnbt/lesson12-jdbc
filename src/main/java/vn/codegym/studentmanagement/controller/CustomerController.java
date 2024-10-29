package vn.codegym.studentmanagement.controller;

import vn.codegym.studentmanagement.model.Customer;
import vn.codegym.studentmanagement.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/29
 * Time: 13:51
 */

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                // TODO: create customer
                break;
            case "update":
                // TODO: update customer
                break;
            case "view":
                customerDetail(req, resp);
                break;
            case "delete":
                deleteCustomer(req, resp);
                break;
            default:
                customerList(req, resp);
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = req.getParameter("customerNumber") != null ? Integer.valueOf(req.getParameter("customerNumber")) : null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer-list.jsp");
        String msg;
        if (customerService.deleteCustomerById(id)) {
            msg = "Xóa sản phẩm thành công";
        } else {
            msg = "Không xóa được sản phẩm";
        }
        req.setAttribute("message", msg);
        req.setAttribute("customers", customerService.getAllCustomers());
        dispatcher.forward(req, resp);
    }

    private void customerDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Integer id = req.getParameter("customerNumber") != null ? Integer.valueOf(req.getParameter("customerNumber")) : null;
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            resp.sendRedirect("/error-page.jsp");
        } else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("customer-detail.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void customerList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer-list.jsp");
        req.setAttribute("customers", customerService.getAllCustomers());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
