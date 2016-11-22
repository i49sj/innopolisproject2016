package ru.innopolis.studentproject.web.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by User on 05.11.2016.
 */
@ComponentScan("ru.innopolis.studentproject.web.controllers")
@Configuration
public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppContextConfig.class);
        ctx.register(MVCConfig.class);
        ctx.register(SecurityConfig.class);
        ctx.register(RMIClient.class);
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(0);
    }
}
