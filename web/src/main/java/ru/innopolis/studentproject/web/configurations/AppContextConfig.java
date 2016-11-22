package ru.innopolis.studentproject.web.configurations;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ru.innopolis.studentproject.common.service.LessonService;
import ru.innopolis.studentproject.common.service.StudentService;


/**
 * Created by User on 05.11.2016.
 */
@Configuration
//@EnableJpaRepositories(basePackages = "server.server.repository")
public class AppContextConfig {
/*
    @Bean(name = "studentDAO",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public StudentDAO studentDAO() {
        return new StudentDAOImplEMF();
    }

    @Bean(name = "lessonDAO",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public LessonDAO lessonDAO() {
        return new LessonDAOImplEMF();
    }
*/

 /*   @Bean(name = "lessonService",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public LessonService lessonService(){
        return new LessonServiceImpl();
    }

    @Bean(name = "studentService",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public StudentService studentService(){
        return new StudentServiceImpl();
    }*/
}
