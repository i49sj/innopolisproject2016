package web.configurations;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import server.dao.*;
import server.repository.StudentRepository;
import server.service.LessonService;
import server.service.StudentService;

/**
 * Created by User on 05.11.2016.
 */
@Configuration
public class AppContextConfig {
/*    @Bean(name = "studentDAO",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public StudentDAO studentDAO() {
        return new StudentDAOImpl();
    }*/

    @Bean(name = "lessonDAO",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public LessonDAO lessonDAO() {
        return new LessonDAOImplEMF();
    }

    @Bean(name = "lessonService",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public LessonService lessonService(){
        return new LessonService();
    }

    @Bean(name = "studentService",
            autowire = Autowire.BY_NAME)
    @Scope("singleton")
    public StudentService studentService(){
        return new StudentService();
    }
}
