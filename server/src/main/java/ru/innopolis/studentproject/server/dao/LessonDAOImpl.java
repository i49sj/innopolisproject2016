package ru.innopolis.studentproject.server.dao;


import ru.innopolis.studentproject.server.dao.Exception.lesson.*;
import ru.innopolis.studentproject.server.db.DBConnection;
import ru.innopolis.studentproject.server.entity.Lesson;
import ru.innopolis.studentproject.server.util.TimeUtil;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 01.11.2016.
 */
public class LessonDAOImpl implements LessonDAO {
    private Connection conn;

    public LessonDAOImpl(){
        try {
            conn = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Lesson get(int id) throws GetLessonException {
        String sql = "select * from studentstorage.lessons where id =" + id;
        Lesson lesson;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            lesson = new Lesson();
            if (rs.next()) {
                int lessonId = rs.getInt("id");
                String topic = rs.getString("topic");
                String description = rs.getString("description");
                Integer duration = rs.getInt("duration");
                LocalDate date = LocalDate.parse(rs.getString("date"), TimeUtil.DATE_FORMATTER);
                lesson.setId(lessonId);
                lesson.setTopic(topic);
                lesson.setDescription(description);
                lesson.setDuration(duration);
                lesson.setLessondate(date);
            }
        } catch (SQLException e) {
            throw new GetLessonException(e);
        }
        return lesson;

    }

    public Lesson add(Lesson lesson) throws AddLessonException {
        String sql = "insert into studentstorage.lessons ( topic, description, duration, lessondate) values(?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, lesson.getTopic());
            pstm.setString(2, lesson.getDescription());
            pstm.setInt(3, lesson.getDuration());
            pstm.setString(4, TimeUtil.toString(lesson.getLessondate()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new AddLessonException(e);
        }
        return lesson;
    }

    public List<Lesson> list() throws GetLessonListException {
        List<Lesson> list;
        String sql = "select  id, topic, description, duration, lessondate from studentstorage.lessons";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                int lessonId = rs.getInt("id");
                String topic = rs.getString("topic");
                String description = rs.getString("description");
                Integer duration = rs.getInt("duration");
                LocalDate lessondate = LocalDate.parse(rs.getString("lessondate"), TimeUtil.DATE_FORMATTER);
                lesson.setId(lessonId);
                lesson.setTopic(topic);
                lesson.setDescription(description);
                lesson.setDuration(duration);
                lesson.setLessondate(lessondate);
                list.add(lesson);
            }
        } catch (SQLException e) {
            throw new GetLessonListException(e);
        }
        return list;
    }


    public void delete(int id) throws DeleteLessonException {
        String sql = "delete from studentstorage.lessons where id =" + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteLessonException(e);
        }
    }

    public Lesson update(Lesson lesson) throws UpdateLessonException, GetLessonException {
        String sql = "update studentstorage.students set topic=?, description=?, duration=?, lessondate=? where id =" +
                lesson.getId();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, lesson.getTopic());
            pstm.setString(2, lesson.getDescription());
            pstm.setInt(3, lesson.getDuration());
            pstm.setString(4, TimeUtil.toString(lesson.getLessondate()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateLessonException(e);
        }
        return get(lesson.getId());
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
