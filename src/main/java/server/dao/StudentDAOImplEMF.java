package server.dao;

import server.dao.Exception.student.*;
import server.db.EntityManagerUtil;
import server.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 07.11.2016.
 */
public class StudentDAOImplEMF implements StudentDAO{
    public StudentDAOImplEMF(){

    }

    @Override
    public Student get(int id) throws GetStudentException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Student student = entityManager.find(Student.class, id);
        entityTransaction.commit();
        return student;
    }

    @Override
    public Student add(Student student) throws AddStudentException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(student);
        entityTransaction.commit();
        return student;
    }

    @Override
    public List<Student> list() throws GetStudentListException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query q = entityManager.createQuery(
                "select s from Student s", Student.class);
        List<Student> list = q.getResultList();
        entityTransaction.commit();
        return list;
    }

    @Override
    public void delete(int id) throws DeleteStudentException {
        EntityManager entitymanager = EntityManagerUtil.getEm();
        Student student = entitymanager.find(Student.class, id);
        entitymanager.remove(student);
    }

    @Override
    public Student update(Student student) throws UpdateStudentException, GetStudentException {
        EntityManager entitymanager = EntityManagerUtil.getEm();
        entitymanager.merge(student);
        return student;
    }
}
