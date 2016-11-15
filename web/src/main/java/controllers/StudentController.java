package web.src.main.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import server.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import common.StudentService;
import server.service.StudentServiceImpl;
import server.util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 31.10.2016.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController() {

    }

    @RequestMapping("")
    public String index() {
        return "redirect:/studentlist";
    }

    @RequestMapping("studentlist")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.list();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "studentedit/{id}", method = RequestMethod.GET)
    public ModelAndView getStudent(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", studentService.get(id));
        modelAndView.setViewName("studentedit");
        return modelAndView;
    }

    @RequestMapping(value = "studentedit/{id}", method = RequestMethod.POST)
    public String updateStudent(HttpServletRequest req, @PathVariable int id) {
        studentService.update(getRequestStudent(req));
        return "redirect:/studentedit/" + id;
    }

    @RequestMapping(value = "studentedit/del/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/studentlist";
    }

    @RequestMapping(value = "studentedit/add/", method = RequestMethod.GET)
    public ModelAndView addStudentEmptyForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentedit");
        return modelAndView;
    }

    @RequestMapping(value = "studentedit/add/", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest req) {
        studentService.add(getRequestStudent(req));
        return "redirect:/studentlist";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;

    }

    private Student getRequestStudent(HttpServletRequest req) {
        Student s = new Student();
        s.setId(Integer.parseInt(req.getParameter("id")));
        s.setFirstName(req.getParameter("firstName"));
        s.setLastName(req.getParameter("lastName"));
        s.setGender(req.getParameter("gender"));
        s.setBirthDate(LocalDate.parse(req.getParameter("birthDate"), TimeUtil.DATE_FORMATTER));
        return s;
    }

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
}
