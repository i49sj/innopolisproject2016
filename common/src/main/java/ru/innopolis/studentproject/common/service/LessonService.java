package ru.innopolis.studentproject.common.service;



import ru.innopolis.studentproject.common.entity.LessonEntity;

import java.util.List;

/**
 * Created by innopolis on 10.11.16.
 */
public interface LessonService {
    LessonEntity add(LessonEntity t);
    LessonEntity get(int id);
    List<LessonEntity> list();
    LessonEntity update(LessonEntity t);
    void delete(int id);
}
