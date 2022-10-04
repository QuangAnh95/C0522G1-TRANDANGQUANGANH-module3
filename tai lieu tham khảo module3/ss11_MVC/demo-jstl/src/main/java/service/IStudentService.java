package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByAll();
    void add(Student student);
}
