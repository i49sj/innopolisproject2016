package ru.innopolis.studentproject.server.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.studentproject.server.repository.StudentRepository;
import ru.innopolis.studentproject.server.entity.Student;

import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
@Service("studentService")
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
