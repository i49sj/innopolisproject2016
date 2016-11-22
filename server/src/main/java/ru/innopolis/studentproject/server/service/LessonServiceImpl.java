package ru.innopolis.studentproject.server.service;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.innopolis.studentproject.common.entity.LessonEntity;
import ru.innopolis.studentproject.common.factory.MapperFactoryInterface;
import ru.innopolis.studentproject.common.service.LessonService;
import ru.innopolis.studentproject.server.entity.Lesson;
import ru.innopolis.studentproject.server.repository.LessonRepository;
import ru.innopolis.studentproject.server.util.TimeUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
@Service("lessonService")
public class LessonServiceImpl implements LessonService {

    private static Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
    @Autowired
    private LessonRepository lessonRepository;
    MapperFactoryInterface mapperFactory;
    MapperFacade mapperFacade;


    public void setMapperFactory(MapperFactoryInterface mapperFactory){
        this.mapperFactory = mapperFactory;
        MapperFactory mf = mapperFactory.getFactory();
        mf.classMap(LessonEntity.class, Lesson.class)
                .byDefault()
                .register();
        mf.classMap(Lesson.class, LessonEntity.class)
                .byDefault()
                .register();
        mapperFacade = mf.getMapperFacade();
    }

    public LessonEntity add(LessonEntity lessonEntity){
        lessonRepository.save(mapperFacade.map(lessonEntity, Lesson.class));
        return lessonEntity;
    }

    public LessonEntity get(int id){
        LessonEntity lessonEntity = mapperFacade.map(lessonRepository.findOne(id), LessonEntity.class);
        if(lessonEntity == null){
            lessonEntity = new LessonEntity();
            lessonEntity.setTopic("");
            lessonEntity.setDescription("");
            lessonEntity.setDuration(1);
            lessonEntity.setLessondate(LocalDate.parse("1970-01-01", TimeUtil.DATE_FORMATTER));
            lessonEntity.setId(0);
        }
        return lessonEntity;

    }
    public List<LessonEntity> list()  {
        return mapperFacade.mapAsList(lessonRepository.findAll(), LessonEntity.class);

    }

    public LessonEntity update(LessonEntity lessonEntity){
        lessonRepository.save(mapperFacade.map(lessonEntity, Lesson.class));
        return lessonEntity;
    }

    public void delete(int id){
        lessonRepository.delete(id);
    }

}
