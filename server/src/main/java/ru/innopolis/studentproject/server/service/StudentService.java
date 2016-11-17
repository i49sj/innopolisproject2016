package ru.innopolis.studentproject.server.service;



import ru.innopolis.studentproject.server.entity.Student;

import java.util.List;

/**
 * Created by innopolis on 17.11.16.
 */
public interface StudentService {
    Student add(Student t);
    Student get(int id);
    List<Student> list();
    Student update(Student t);
    void delete(int id);
}
