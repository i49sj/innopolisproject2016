package server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import server.dao.Exception.student.*;
import server.dao.StudentDAO;
import server.entity.Student;
import server.repository.StudentRepository;

import java.util.List;

/**
 * Created by User on 09.11.2016.
 */
public class StudentServiceSpringData {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceSpringData.class);

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Student get(int id) {
        return studentRepository.findOne(id);
    }

    public List<Student> list() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student update(Student student) {
        return studentRepository.save(student);

    }

    public void delete(int id) {
        studentRepository.delete(id);
    }


}
