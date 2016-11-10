package server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import server.dao.Exception.lesson.*;
import server.dao.LessonDAO;
import server.entity.Lesson;
import server.repository.LessonRepository;

import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
public class LessonServiceImpl implements LessonService{

    private static Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson add(Lesson lesson){
        lessonRepository.save(lesson);
        return null;
    }

    public Lesson get(int id){
            return lessonRepository.findOne(id);
    }
    public List<Lesson> list()  {
            return (List<Lesson>)lessonRepository.findAll();
    }

    public Lesson update(Lesson lesson){
            return lessonRepository.save(lesson);
    }

    public void delete(int id){
        lessonRepository.delete(id);
    }

}
