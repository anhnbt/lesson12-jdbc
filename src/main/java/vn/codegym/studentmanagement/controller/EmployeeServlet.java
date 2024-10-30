package vn.codegym.studentmanagement.controller;

import vn.codegym.studentmanagement.dao.EmployeeDAO;
import vn.codegym.studentmanagement.model.Employee;

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
 * Date: 2024/10/30
 * Time: 13:40
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createEmployee(req, resp);
                break;
            default:
                listEmployee(req, resp);
        }
    }

    private void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/employees/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/employees/list.jsp");
        String jobTitle = req.getParameter("jobTitle");
        req.setAttribute("employees", employeeDAO.getAllEmployees(jobTitle));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // Ho tro tieng Viet
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.equals("create")) {
            // TODO: Xu ly create o day
            Integer employeeNumber = req.getParameter("employeeNumber") != null ? Integer.valueOf(req.getParameter("employeeNumber")) : null;
            String lastName = req.getParameter("lastName");
            String firstName = req.getParameter("firstName");
            String extension = req.getParameter("extension");
            String email = req.getParameter("email");
            String officeCode = req.getParameter("officeCode");
            String reportToFromReq = req.getParameter("reportsTo");
            Integer reportsTo = (reportToFromReq != null && !reportToFromReq.equals("")) ? Integer.valueOf(reportToFromReq) : null;
            String jobTitle = req.getParameter("jobTitle");
            Employee employee = new Employee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
            if (employeeDAO.save(employee)) {
                resp.sendRedirect("/employees");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("employees/create.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
}
