package vn.codegym.studentmanagement.service;

import vn.codegym.studentmanagement.model.Student;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/28
 * Time: 14:21
 */
public interface StudentService {

    List<Student> findAll();

    Student findById(int id);
}
