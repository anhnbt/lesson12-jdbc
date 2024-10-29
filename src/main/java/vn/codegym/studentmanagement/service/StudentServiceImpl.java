package vn.codegym.studentmanagement.service;

import vn.codegym.studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/28
 * Time: 14:02
 */
public class StudentServiceImpl implements StudentService {
    static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student(1, "Hau", "hau@gmail.com", "123456789"));
        list.add(new Student(2, "Tung", "tung@gmail.com", "123456789"));
        list.add(new Student(3, "Loc", "loc@gmail.com", "123456789"));
    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    @Override

    public Student findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

}
