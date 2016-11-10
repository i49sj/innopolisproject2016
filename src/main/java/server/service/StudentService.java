package server.service;

import server.entity.Student;

import java.util.List;

/**
 * Created by innopolis on 10.11.16.
 */
public interface StudentService{
    Student add(Student t);
    Student get(int id);
    List<Student> list();
    Student update(Student t);
    void delete(int id);
}
