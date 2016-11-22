package ru.innopolis.studentproject.common.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by innopolis on 17.11.16.
 */
public class LessonEntity implements Serializable {
    private int id;
    private String topic;
    private String description;
    private int duration;
    private LocalDate lessondate;

    public LessonEntity(){}

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getLessondate() {
        return lessondate;
    }

    public void setLessondate(LocalDate lessondate) {
        this.lessondate = lessondate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
