package ru.innopolis.studentproject.server.dao;

import ru.innopolis.studentproject.server.entity.Lesson;
import server.src.main.java.dao.Exception.lesson.*;


import java.util.List;

/**
 * Created by User on 01.11.2016.
 */
public interface LessonDAO {
    public Lesson get(int id)throws GetLessonException;
    public Lesson add(Lesson lessson)throws AddLessonException;
    public List<Lesson> list()throws GetLessonListException;
    public void delete(int id)throws DeleteLessonException;
    public Lesson update(Lesson lessson)throws UpdateLessonException, GetLessonException;
}
