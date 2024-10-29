package vn.codegym.studentmanagement.controller;

import vn.codegym.studentmanagement.model.Student;
import vn.codegym.studentmanagement.service.StudentService;
import vn.codegym.studentmanagement.service.StudentServiceImpl;

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
 * Date: 2024/10/28
 * Time: 13:49 PM
 */
@WebServlet(name = "StudentController", urlPatterns = "/students")
public class StudentController extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", studentService.findAll());
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createStudent(req, resp);
                break;
            case "view":
                studentDetail(req, resp);
                break;
            case "update":
                // TODO: Update
//                studentUpdate(req, resp);
                break;
            case "delete":
                // TODO: Delete
                break;
            default:
                studentList(req, resp);
                break;
        }
    }

    private void studentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/list.jsp");
        req.setAttribute("students", studentService.findAll());
        dispatcher.forward(req, resp);
    }

    private void studentDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/detail.jsp");
        String id = req.getParameter("id");
        if (id == null) {
            // TODO: Tra ve trang loi khong tim thay
        } else {
            Student student = studentService.findById(Integer.valueOf(id));
            req.setAttribute("student", student);
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
