package ru.innopolis.web.configurations;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.innopolis.server.service.LessonService;
import ru.innopolis.server.service.LessonServiceImpl;
import ru.innopolis.server.service.StudentService;
import ru.innopolis.server.service.StudentServiceImpl;

/**
 * Created by User on 05.11.2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ru.innopolis.server.repository")
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

    @Bean(name = "lessonService",
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
    }
}
