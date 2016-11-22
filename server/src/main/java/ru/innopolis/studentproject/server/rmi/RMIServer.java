package ru.innopolis.studentproject.server.rmi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import ru.innopolis.studentproject.server.service.LessonServiceImpl;
import ru.innopolis.studentproject.server.service.StudentServiceImpl;

/**
 * Created by innopolis on 17.11.16.
 */
@Configuration
@ComponentScan("ru.innopolis.studentproject.server.service")
public class RMIServer {
    @Bean
    public RmiServiceExporter registerLessionService(@Autowired LessonServiceImpl lessionService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        //rmiServiceExporter.setRegistryHost("127.0.0.1");
        rmiServiceExporter.setServiceName("LessionService");
        rmiServiceExporter.setService(lessionService);
        rmiServiceExporter.setServiceInterface(ru.innopolis.studentproject.common.service.LessonService.class);
        rmiServiceExporter.setRegistryPort(2000);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter registerStudentService(@Autowired StudentServiceImpl studentService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("StudentService");
        rmiServiceExporter.setService(studentService);
        rmiServiceExporter.setServiceInterface(ru.innopolis.studentproject.common.service.StudentService.class);
        rmiServiceExporter.setRegistryPort(2000);
        return rmiServiceExporter;
    }


}
