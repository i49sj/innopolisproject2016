package server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by User on 01.11.2016.
 */
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(generator ="increment")
    @GenericGenerator(name ="increment", strategy = "increment")
    int id;
    @Column(name = "topic")
    String topic;
    @Column(name = "description")
    String description;
    @Column(name = "duration")
    int duration;
    @Column(name = "lessondate")
    LocalDate lessondate;

    public Lesson(){}

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
