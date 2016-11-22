package ru.innopolis.studentproject.common.service;



import ru.innopolis.studentproject.common.entity.StudentEntity;

import java.util.List;

/**
 * Created by innopolis on 10.11.16.
 */
public interface StudentService{
    StudentEntity add(StudentEntity t);
    StudentEntity get(int id);
    List<StudentEntity> list();
    StudentEntity update(StudentEntity t);
    void delete(int id);
}
