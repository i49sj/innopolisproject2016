package ru.innopolis.studentproject.server.service;



import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.innopolis.studentproject.common.entity.LessonEntity;
import ru.innopolis.studentproject.common.entity.StudentEntity;
import ru.innopolis.studentproject.common.factory.MapperFactoryInterface;
import ru.innopolis.studentproject.common.service.StudentService;


import ru.innopolis.studentproject.server.entity.Student;
import ru.innopolis.studentproject.server.repository.StudentRepository;
import ru.innopolis.studentproject.server.util.TimeUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 05.11.2016.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    MapperFactoryInterface mapperFactory;
    MapperFacade mapperFacade;


    public void setMapperFactory(MapperFactoryInterface mapperFactory){
        this.mapperFactory = mapperFactory;
        MapperFactory mf = mapperFactory.getFactory();
        mf.classMap(StudentEntity.class, Student.class)
                .byDefault()
                .register();
        mf.classMap(Student.class, StudentEntity.class)
                .byDefault()
                .register();
        mapperFacade = mf.getMapperFacade();
    }

    public StudentEntity add(StudentEntity studentEntity){
        studentRepository.save(mapperFacade.map(studentEntity, Student.class));
        return studentEntity;
    }
    public StudentEntity get(int id){
        StudentEntity studentEntity = mapperFacade.map(studentRepository.findOne(id), StudentEntity.class);
        if(studentEntity == null){
            studentEntity = new StudentEntity();
            studentEntity.setFirstName("");
            studentEntity.setLastName("");
            studentEntity.setGender("");
            studentEntity.setBirthDate(LocalDate.parse("1970-01-01", TimeUtil.DATE_FORMATTER));
            studentEntity.setId(0);
        }
        return studentEntity;
    }
    public List<StudentEntity> list()  {
        return mapperFacade.mapAsList(studentRepository.findAll(), StudentEntity.class);
    }
    public StudentEntity update(StudentEntity studentEntity){
        studentRepository.save(mapperFacade.map(studentEntity, Student.class));
        return studentEntity;
    }
    public void delete(int id){
             studentRepository.delete(id);
    }

}
