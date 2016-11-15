package web.src.main.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import server.entity.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import common.LessonService;
import server.util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 01.11.2016.
 */
@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @RequestMapping("lessonlist")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        List<Lesson> list = lessonService.list();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("lessons");
        return modelAndView;
    }

    @RequestMapping(value = "lessonlist/{id}", method = RequestMethod.GET)
    public ModelAndView getLesson(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lesson", lessonService.get(id));
        modelAndView.setViewName("lessonedit");
        return modelAndView;
    }

    @RequestMapping(value = "lessonedit/{id}", method = RequestMethod.POST)
    public String updateLesson(HttpServletRequest req, @PathVariable int id) {
        lessonService.update(getRequestLesson(req));
        return "redirect:/lessonedit/" + id;
    }

    @RequestMapping(value = "lessonedit/del/{id}")
    public String deleteLesson(@PathVariable int id) {
        lessonService.delete(id);
        return "redirect:/lessonlist";
    }

    @RequestMapping(value = "lessonedit/add/", method = RequestMethod.GET)
    public ModelAndView addLessonEmptyForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lessonedit");
        return modelAndView;
    }

    @RequestMapping(value = "lessonedit/add/", method = RequestMethod.POST)
    public String addLesson(HttpServletRequest req) {
        lessonService.add(getRequestLesson(req));
        return "redirect:/lessonedit";
    }

    private Lesson getRequestLesson(HttpServletRequest req) {
        Lesson l = new Lesson();
        l.setId(Integer.parseInt(req.getParameter("id")));
        l.setTopic(req.getParameter("topic"));
        l.setDescription(req.getParameter("description"));
        l.setDuration(Integer.parseInt(req.getParameter("duration")));
        l.setLessondate(LocalDate.parse(req.getParameter("lessondate"), TimeUtil.DATE_FORMATTER));
        return l;
    }
}
