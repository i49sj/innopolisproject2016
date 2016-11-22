package ru.innopolis.studentproject.server.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ru.innopolis.studentproject.common.entity.LessonEntity;
import ru.innopolis.studentproject.common.entity.StudentEntity;
import ru.innopolis.studentproject.server.entity.Lesson;
import ru.innopolis.studentproject.server.entity.Student;

/**
 * Created by innopolis on 18.11.16.
 */
public class OrikaMapper {
    MapperFacade mf;
    public void getStudentMapperFactory() {
        final MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.classMap(Student.class, StudentEntity.class)
                .field("id", "id")
                .field("firstName", "firstName")
                .field("lastName", "lastName")
                .field("gender", "gender")
                .field("birthDate", "birthDate")
                .byDefault()
                .register();
        this.mf = factory.getMapperFacade();
    }

    public void getLessonMapperFactory() {
        final MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.classMap(Lesson.class, LessonEntity.class)
                .field("id", "id")
                .field("topic", "topic")
                .field("description", "description")
                .field("duration", "duration")
                .field("lessondate", "lessondate")
                .byDefault()
                .register();
        this.mf = factory.getMapperFacade();
    }


}
