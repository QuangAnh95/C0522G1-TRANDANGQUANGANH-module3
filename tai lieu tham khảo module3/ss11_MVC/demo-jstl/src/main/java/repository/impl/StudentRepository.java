package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository  implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh",true,"12-12-2022",5,"chanhtv1",1,"chanhtv@gmail.com"));
        studentList.add(new Student(2,"Tiên",false,"12-12-2022",7,"chanhtv3",2,"chanhtv@gmail.com"));
        studentList.add(new Student(3,"Ân",true,"12-12-2022",3,"chanhtv4",2,"chanhtv@gmail.com"));
        studentList.add(new Student(4,"Ái",false,"12-12-2022",8,"chanhtv4",2,"chanhtv@gmail.com"));
        studentList.add(new Student(5,"Bảo",true,"12-12-2022",6,"chanhtv5",1,"chanhtv@gmail.com"));
    }
    @Override
    public List<Student> findByAll() {
        // keets noi db
        return studentList;
    }

    @Override
    public void add(Student student) {
        // ket noi db roi them moi
       studentList.add(student);
    }
}
