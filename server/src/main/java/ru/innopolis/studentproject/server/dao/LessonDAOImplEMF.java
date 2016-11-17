package ru.innopolis.studentproject.server.dao;

import ru.innopolis.studentproject.server.entity.Lesson;
import server.src.main.java.dao.Exception.lesson.*;
import ru.innopolis.studentproject.server.db.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 07.11.2016.
 */
public class LessonDAOImplEMF implements LessonDAO{

    public LessonDAOImplEMF(){

    }

    @Override
    public Lesson get(int id) throws GetLessonException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityTransaction.commit();
        return lesson;
    }

    @Override
    public Lesson add(Lesson lesson) throws AddLessonException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(lesson);
        entityTransaction.commit();
        return lesson;
    }

    @Override
    public List<Lesson> list() throws GetLessonListException {
        EntityManager entityManager = EntityManagerUtil.getEm();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query q = entityManager.createQuery(
                "select l from Lesson l", Lesson.class);
        List<Lesson> list = q.getResultList();
        entityTransaction.commit();
        return list;
    }

    @Override
    public void delete(int id) throws DeleteLessonException {
        EntityManager entitymanager = EntityManagerUtil.getEm();
        Lesson lesson = entitymanager.find(Lesson.class, id);
        entitymanager.remove(lesson);
    }

    @Override
    public Lesson update(Lesson lesson) throws UpdateLessonException, GetLessonException {
        EntityManager entitymanager = EntityManagerUtil.getEm();
        entitymanager.merge(lesson);
        return lesson;
    }
}
