package ru.innopolis.studentproject.web.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ru.innopolis.studentproject.common.service.LessonService;
import ru.innopolis.studentproject.common.service.StudentService;

/**
 * Created by innopolis on 17.11.16.
 */
@Configuration
public class RMIClient {

    @Bean
    public StudentService createStudentServiceLink() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:2000/StudentService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (StudentService) rmiProxyFactoryBean.getObject();
    }

    @Bean
    public LessonService createLessionServiceLink() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:2000/LessionService");
        rmiProxyFactoryBean.setServiceInterface(LessonService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (LessonService) rmiProxyFactoryBean.getObject();
    }
}
