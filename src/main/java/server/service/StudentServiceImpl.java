package server.service;


import common.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import server.entity.Student;
import server.repository.StudentRepository;

import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student){
        studentRepository.save(student);
        return student;
    }
    public Student get(int id){
            return studentRepository.findOne(id);
    }
    public List<Student> list()  {
            return (List<Student>)studentRepository.findAll();
    }
    public Student update(Student student){
             return studentRepository.save(student);
    }
    public void delete(int id){
             studentRepository.delete(id);
    }

}
