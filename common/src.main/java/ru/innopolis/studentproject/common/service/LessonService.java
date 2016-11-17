package ru.innopolis.studentproject.common.service;



import ru.innopolis.studentproject.common.entity.Lesson;

import java.util.List;

/**
 * Created by innopolis on 10.11.16.
 */
public interface LessonService {
    Lesson add(Lesson t);
    Lesson get(int id);
    List<Lesson> list();
    Lesson update(Lesson t);
    void delete(int id);
}
