package server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import server.dao.Exception.lesson.*;
import server.dao.LessonDAO;
import server.entity.Lesson;

import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
public class LessonService {
    private static Logger logger = LoggerFactory.getLogger(LessonService.class);
    @Autowired
    private LessonDAO lessonDAO;

    public Lesson add(Lesson lesson){
        try {
            lessonDAO.add(lesson);
        } catch (AddLessonException e) {
            logger.error("Ошибка добавления объекта Lesson. ", e);
        }
        return null;
    }

    public Lesson get(int id){
        try {
            return lessonDAO.get(id);
        }catch(GetLessonException e){
            logger.error("Ошибка получения объекта Lesson. ", e);
        }
        return null;
    }
    public List<Lesson> list()  {
        try {
            return lessonDAO.list();
        } catch (GetLessonListException e) {
            logger.error("Ошибка получения коллекции Lesson. ", e);
        }
        return null;
    }

    public Lesson update(Lesson lesson){
        try {
            return lessonDAO.update(lesson);
        } catch (UpdateLessonException e) {
            logger.error("Ошибка обновления Lesson. ", e);
        } catch (GetLessonException e) {
            logger.error("Ошибка обновления Lesson. ", e);
        }
        return null;
    }

    public void delete(int id){
        try {
            lessonDAO.delete(id);
        } catch (DeleteLessonException e) {
            logger.error("Ошибка удаления Lesson. ", e);
        }
    }

    public void setLessonDAO(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }
}
