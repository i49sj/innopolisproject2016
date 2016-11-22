package ru.innopolis.studentproject.server.dao;

import ru.innopolis.studentproject.server.dao.Exception.student.*;
import ru.innopolis.studentproject.server.db.DBConnection;
import ru.innopolis.studentproject.server.util.TimeUtil;

import ru.innopolis.studentproject.server.entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 31.10.2016.
 */

public class StudentDAOImpl implements StudentDAO {

    private Connection conn;

    public StudentDAOImpl(){
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

    public Student get(int id) throws GetStudentException {
        String sql = "select * from studentstorage.students where id =" + id;
        Student student = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            student = new Student();
            if (rs.next()) {
                int studentId = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                LocalDate birthdate = LocalDate.parse(rs.getString("birthdate"), TimeUtil.DATE_FORMATTER);
                student.setId(studentId);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setGender(gender);
                student.setBirthDate(birthdate);
            }
        } catch(SQLException e){
            throw new GetStudentException(e);
        }
        return student;

    }

    public Student add(Student student)throws AddStudentException {
        String sql = "insert into studentstorage.students ( firstname, lastname, birthdate, gender) values(?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setString(3, TimeUtil.toString(student.getBirthDate()));
            pstm.setString(4, student.getGender());
            pstm.executeUpdate();
        } catch(SQLException e){
            throw new AddStudentException(e);
        }
        return student;
    }

    public List<Student> list() throws GetStudentListException {
        List<Student> list;
        String sql = "select  id, firstname, lastname,  birthdate, gender from studentstorage.students";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                int studentId = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                LocalDate birthdate = LocalDate.parse(rs.getString("birthdate"), TimeUtil.DATE_FORMATTER);
                student.setId(studentId);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setGender(gender);
                student.setBirthDate(birthdate);
                list.add(student);
            }
        } catch(SQLException e){
            throw new GetStudentListException(e);
        }
        return list;
    }


    public void delete(int id) throws DeleteStudentException {
        String sql = "delete from studentstorage.students where id =" + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch(SQLException e){
            throw new DeleteStudentException(e);
        }
    }

    public Student update(Student student) throws UpdateStudentException, GetStudentException{
        String sql = "update studentstorage.students set firstname=?, lastname=?, birthdate=?, gender=? where id =" +
                student.getId();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setString(3, TimeUtil.toString(student.getBirthDate()));
            pstm.setString(4, student.getGender());
            pstm.executeUpdate();
        } catch(SQLException e){
            throw new UpdateStudentException(e);
        }
        return get(student.getId());
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
