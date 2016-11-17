package ru.innopolis.studentproject.server.dao;

import server.src.main.java.dao.Exception.student.*;
import ru.innopolis.studentproject.server.entity.Student;


import java.util.List;

/**
 * Created by User on 31.10.2016.
 */

public interface StudentDAO {
    public Student get(int id) throws GetStudentException;
    public Student add(Student student)throws AddStudentException;
    public List<Student> list() throws GetStudentListException;
    public void delete(int id) throws DeleteStudentException;
    public Student update(Student student)throws UpdateStudentException, GetStudentException;
}
