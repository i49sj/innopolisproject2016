package server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import server.dao.Exception.student.*;
import server.dao.StudentDAO;
import server.entity.Student;

import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
public class StudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentDAO studentDAO;

    public Student add(Student student){
        try {
            studentDAO.add(student);
        } catch (AddStudentException e) {
            logger.error("Ошибка добавления объекта Student. ", e);
        }
        return null;
    }

    public Student get(int id){
        try {
            return studentDAO.get(id);
        }catch(GetStudentException e){
            logger.error("Ошибка получения объекта Student. ", e);
        }
        return null;
    }
    public List<Student> list()  {
        try {
            return studentDAO.list();
        } catch (GetStudentListException e) {
            logger.error("Ошибка получения коллекции Student. ", e);
        }
        return null;
    }

    public Student update(Student student){
        try {
            return studentDAO.update(student);
        } catch (UpdateStudentException e) {
            logger.error("Ошибка обновления Student. ", e);
        } catch (GetStudentException e) {
            logger.error("Ошибка обновления Student. ", e);
        }
        return null;
    }

    public void delete(int id){
        try {
            studentDAO.delete(id);
        } catch (DeleteStudentException e) {
            logger.error("Ошибка удаления Student. ", e);
        }
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
