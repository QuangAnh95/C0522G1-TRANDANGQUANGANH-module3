package service.impl;

import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findByAll() {
        return studentRepository.findByAll();
    }

    @Override
    public void add(Student student) {
        // can kiem ta du lieu o day

         studentRepository.add(student);
    }
}
